/* Reconstructed from the user-provided 0.8.9.8 release with permission. */
package com.timelocked;

import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = "timelocked")
public final class HubArrival {
  // Delays before messages 1..7, in server ticks. First line is immediate.
  private static final int[] WELCOME_DELAYS = {0, 140, 180, 160, 200, 180, 140};

  private static boolean inside(ServerPlayer p, BlockPos o) {
    BlockPos q = p.blockPosition().subtract((Vec3i) o);
    return !p.isSpectator()
        && q.getX() > 3
        && q.getX() < 154
        && q.getY() >= 2
        && q.getY() < 19
        && q.getZ() > 185
        && q.getZ() < 337;
  }

  @SubscribeEvent
  public static void tick(ServerTickEvent.Post e) {
    ServerLevel l = e.getServer().overworld();
    if (l.getGameTime() % 20L != 0L) {
      return;
    }
    FacilityState data = FacilityState.get((MinecraftServer) e.getServer());
    for (Map.Entry entry : data.progress.entrySet()) {
      SiteProgress s = (SiteProgress) entry.getValue();
      if (s.geometryVersion != 5) continue;
      BlockPos o = BlockPos.of((long) ((Long) entry.getKey()));
      List<ServerPlayer> players =
          l.players().stream().filter(p -> HubArrival.inside(p, o)).toList();
      if (players.isEmpty()) continue;
      if (tickWelcome(s, players)) data.setDirty();
      if (!s.arrivalStarted) {
        boolean fresh = false;
        int[][] cells = DrawingArrivalIndex.CELLS;
        int n = cells.length;
        for (int i = 0; i < n; ++i) {
          BlockState b;
          int[] v = cells[i];
          BlockPos q = o.offset(v[0], v[1], v[2]);
          if (v[3] != 1
              || !l.hasChunkAt(q)
              || !((b = l.getBlockState(q)).getBlock() instanceof StationLightBlock)
              || ((Boolean) b.getValue((Property) StationLightBlock.LIT)).booleanValue()) continue;
          fresh = true;
          break;
        }
        if (!fresh) continue;
        s.arrivalStarted = true;
        data.setDirty();
        java.util.Iterator<ServerPlayer> object = players.iterator();
        while (object.hasNext()) {
          ServerPlayer p2 = (ServerPlayer) object.next();
          p2.playNotifySound(
              (SoundEvent) AlarmSounds.ARRIVAL_SWITCH.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
        }
      }
      if (s.arrivalStep < 5) {
        s.arrivalTicks += 20;
        if (s.arrivalTicks >= 40) {
          s.arrivalTicks = 0;
          ++s.arrivalStep;
          DeferredHolder<SoundEvent, SoundEvent> sound =
              s.arrivalStep == 5
                  ? AlarmSounds.ARRIVAL_01
                  : (s.arrivalStep == 1
                      ? AlarmSounds.ARRIVAL_02
                      : (s.arrivalStep == 2 ? AlarmSounds.ARRIVAL_03 : AlarmSounds.ARRIVAL_04));
          for (ServerPlayer p3 : players) {
            p3.playNotifySound((SoundEvent) sound.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
          }
        }
        data.setDirty();
      }
      boolean logoActivated = false;
      for (int[] v : DrawingArrivalIndex.CELLS) {
        BlockPos q;
        if (v[3] > s.arrivalStep || !l.hasChunkAt(q = o.offset(v[0], v[1], v[2]))) continue;
        BlockState b = l.getBlockState(q);
        // Existing facilities retain their placed geometry. An unfinished
        // pre-centering logo must still power on after upgrading.
        if (v[4] == 1 && !b.is(Content.HANGING_LOGO.get())) {
          // Support unfinished facilities from 0.8.9.12/.13 and older releases.
          // This powers old logos in place; it does not move existing builds.
          for (int legacyOffset : new int[] {-12, -17}) {
            BlockPos legacy = q.offset(0, 0, legacyOffset);
            if (l.hasChunkAt(legacy) && l.getBlockState(legacy).is(Content.HANGING_LOGO.get())) {
              q = legacy;
              b = l.getBlockState(q);
              break;
            }
          }
        }
        if (v[4] == 0
            && b.getBlock() instanceof StationLightBlock
            && !((Boolean) b.getValue((Property) StationLightBlock.LIT)).booleanValue()) {
          l.setBlock(
              q,
              (BlockState)
                  b.setValue((Property) StationLightBlock.LIT, (Comparable) Boolean.valueOf(true)),
              3);
          continue;
        }
        if (v[4] != 1
            || !b.is((Block) Content.HANGING_LOGO.get())
            || ((Boolean) b.getValue((Property) SarcHangingLogoBlock.LIT)).booleanValue()) continue;
        logoActivated |=
            l.setBlock(
                q,
                (BlockState)
                    b.setValue(
                        (Property) SarcHangingLogoBlock.LIT, (Comparable) Boolean.valueOf(true)),
                3);
      }
      if (logoActivated && announceLogoPower(s, players)) data.setDirty();
    }
  }

  /** Start one timed welcome and anthem per facility on the logo transition. */
  static boolean announceLogoPower(SiteProgress progress, List<ServerPlayer> players) {
    if (progress.arrivalLogoAnnounced || players.isEmpty()) return false;
    progress.arrivalLogoAnnounced = true;
    progress.arrivalWelcomeNext = 1;
    progress.arrivalWelcomeTicks = 0;
    for (ServerPlayer player : players) {
      player.sendSystemMessage(
          net.minecraft.network.chat.Component.translatable(
              "message.timelocked.arrival_welcome.1"));
      player.playNotifySound(AlarmSounds.NAU_ANTHEM_PA.get(), SoundSource.BLOCKS, 0.85F, 1.0F);
    }
    return true;
  }

  /** Called once per second; no catch-up burst or progress without a hub audience. */
  static boolean tickWelcome(SiteProgress progress, List<ServerPlayer> players) {
    int next = progress.arrivalWelcomeNext;
    if (!progress.arrivalLogoAnnounced
        || next < 1
        || next >= WELCOME_DELAYS.length
        || players.isEmpty()) return false;
    progress.arrivalWelcomeTicks += 20;
    if (progress.arrivalWelcomeTicks >= WELCOME_DELAYS[next]) {
      for (ServerPlayer player : players) {
        player.sendSystemMessage(
            net.minecraft.network.chat.Component.translatable(
                "message.timelocked.arrival_welcome." + (next + 1)));
      }
      progress.arrivalWelcomeNext = next + 1;
      progress.arrivalWelcomeTicks = 0;
    }
    return true;
  }

  private HubArrival() {}
}
