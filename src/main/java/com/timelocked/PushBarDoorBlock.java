package com.timelocked;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Manual, unlocked egress door. Paired leaves move together; no proximity sensor spoils the reveal.
 */
public final class PushBarDoorBlock extends AnimatedSarcDoorBlock {
  public static final MapCodec<PushBarDoorBlock> CODEC = simpleCodec(PushBarDoorBlock::new);

  public PushBarDoorBlock(Properties properties) {
    super(BlockSetType.COPPER, properties);
  }

  @Override
  public MapCodec<? extends AnimatedSarcDoorBlock> codec() {
    return CODEC;
  }

  static BlockPos mate(Level level, BlockPos lower, BlockState state) {
    Direction facing = state.getValue(FACING);
    for (Direction side : new Direction[] {facing.getClockWise(), facing.getCounterClockWise()}) {
      BlockPos position = lower.relative(side);
      if (!level.hasChunkAt(position)) continue;
      BlockState other = level.getBlockState(position);
      if (other.is(state.getBlock())
          && other.getValue(HALF) == DoubleBlockHalf.LOWER
          && other.getValue(FACING) == facing
          && other.getValue(HINGE) != state.getValue(HINGE)) return position;
    }
    return null;
  }

  @Override
  protected InteractionResult useWithoutItem(
      BlockState state, Level level, BlockPos position, Player player, BlockHitResult hit) {
    if (level.isClientSide) return InteractionResult.SUCCESS;
    BlockPos lower = state.getValue(HALF) == DoubleBlockHalf.UPPER ? position.below() : position;
    BlockState bottom = level.getBlockState(lower);
    if (!bottom.is(this) || bottom.getValue(HALF) != DoubleBlockHalf.LOWER)
      return InteractionResult.PASS;
    boolean open = !bottom.getValue(OPEN);
    BlockPos other = mate(level, lower, bottom);
    setOpen(player, level, bottom, lower, open);
    if (other != null) setOpen(player, level, level.getBlockState(other), other, open);
    return InteractionResult.CONSUME;
  }
}
