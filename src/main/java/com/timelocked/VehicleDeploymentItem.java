package com.timelocked;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.phys.Vec3;

public final class VehicleDeploymentItem extends Item {
  private final Supplier<? extends EntityType<?>> type;

  public VehicleDeploymentItem(Properties p, Supplier<? extends EntityType<?>> t) {
    super(p);
    this.type = t;
  }

  public boolean deploy(ServerLevel l, Vec3 feet, Player player, ItemStack stack, float yaw) {
    if (!stack.isEmpty() && l.hasChunkAt(BlockPos.containing(feet))) {
      Entity e = this.type.get().create(l);
      if (e == null) {
        return false;
      }

      if (e instanceof SarcTramEntity) {
        BlockState railState = l.getBlockState(BlockPos.containing(feet));
        if (railState.getBlock() instanceof BaseRailBlock rail) {
          String shape =
              ((RailShape) railState.getValue(rail.getShapeProperty())).getSerializedName();
          yaw = shape.equals("east_west") ? 0.0F : 90.0F;
        }
      }

      e.moveTo(feet.x, feet.y, feet.z, yaw, 0.0F);
      if (e instanceof AbstractMinecart) {
        BlockPos rail = BlockPos.containing(feet);
        if (!BaseRailBlock.isRail(l, rail)
            || !VehicleSafety.loaded(l, e.getBoundingBox())
            || !l.noCollision(e, e.getBoundingBox())
            || l.containsAnyLiquid(e.getBoundingBox())) {
          return false;
        }
      } else if (!VehicleSafety.deployment(e)) {
        return false;
      }

      if (e instanceof SarcTramEntity tram) {
        tram.siteOrigin = SitePlanner.containing(l, e.blockPosition()).orElse(null);
      }

      if (l.addFreshEntity(e) && !e.isRemoved()) {
        if (!player.getAbilities().instabuild) {
          stack.shrink(1);
        }

        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public InteractionResult useOn(UseOnContext c) {
    if (c.getPlayer() == null) {
      return InteractionResult.FAIL;
    }

    if (c.getLevel().isClientSide) {
      return InteractionResult.SUCCESS;
    }

    BlockPos block = c.getClickedPos();
    boolean tram = this.type.get() == Content.TRAM_VEHICLE.get();
    Vec3 feet =
        tram
            ? new Vec3(block.getX() + 0.5, block.getY() + 0.1, block.getZ() + 0.5)
            : new Vec3(block.getX() + 0.5, block.getY() + 1, block.getZ() + 0.5);
    if (!tram && c.getClickedFace() != Direction.UP) {
      return InteractionResult.FAIL;
    }

    boolean ok =
        this.deploy(
            (ServerLevel) c.getLevel(),
            feet,
            c.getPlayer(),
            c.getItemInHand(),
            c.getPlayer().getYRot());
    if (!ok) {
      c.getPlayer()
          .displayClientMessage(Component.translatable("message.timelocked.vehicle_blocked"), true);
    }

    return ok ? InteractionResult.CONSUME : InteractionResult.FAIL;
  }

  public void appendHoverText(ItemStack s, TooltipContext c, List<Component> tips, TooltipFlag f) {
    tips.add(
        Component.translatable(
            this.type.get() == Content.TRAM_VEHICLE.get()
                ? "tooltip.timelocked.tram_deployment"
                : "tooltip.timelocked.vehicle_deployment"));
    tips.add(Component.translatable("tooltip.timelocked.vehicle_controls"));
  }
}
