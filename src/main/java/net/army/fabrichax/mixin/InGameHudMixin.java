package net.army.fabrichax.mixin;

import net.army.fabrichax.ui.Hud;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    @Inject(method = "render", at = @At("RETURN"))
    public void renderHud(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        Hud.render(matrices, tickDelta);
    }

    @Inject(method = "render", at = @At("HEAD"))
    public void renderLogo(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        int speed = 4;
        float hue = (System.currentTimeMillis() % (1000*speed)) / (1000f*speed);
        int color = Color.HSBtoRGB(hue, 1, 1);
        mc.textRenderer.drawWithShadow(
                matrices,
                "FabricHax",
                0,
                0,
                color
        );
    }
}
