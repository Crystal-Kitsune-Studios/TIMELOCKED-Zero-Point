package com.timelocked.client.mixin;

import com.timelocked.client.StartupBranding;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.neoforge.client.loading.NeoForgeLoadingOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Branding only. Original reload completion, exception handling and screen transitions always run.
 */
@Mixin(value = NeoForgeLoadingOverlay.class, remap = false)
public abstract class StartupOverlayMixin {
  @Shadow(remap = false)
  private float currentProgress;

  @Shadow(remap = false)
  private long fadeOutStart;

  @Inject(method = "render", at = @At("TAIL"), remap = false)
  private void timelocked$brand(
      GuiGraphics graphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
    float opacity =
        fadeOutStart == -1L
            ? 1F
            : 1F
                - net.minecraft.util.Mth.clamp(
                    (net.minecraft.Util.getMillis() - fadeOutStart - 1000L) / 1000F, 0F, 1F);
    StartupBranding.markOverlayFrame();
    StartupBranding.draw(currentProgress, opacity);
  }
}
