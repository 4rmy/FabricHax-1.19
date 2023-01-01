package net.army.fabrichax.ui;

import net.army.fabrichax.module.Module;
import net.army.fabrichax.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Hud {
    private static class ModuleComparator implements Comparator<Module> {
        @Override
        public int compare(Module a, Module b) {
            return Integer.compare(mc.textRenderer.getWidth(b.getName()), mc.textRenderer.getWidth(a.getName()));
        }
    }

    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static void render(MatrixStack matrices, float tickDelta) {

        float Y = 2;

        ArrayList<Module> mods = ModuleManager.instance.getActiveModules();
        mods.sort(new ModuleComparator());

        int speed = 4;
        float hue = (System.currentTimeMillis() % (1000*speed)) / (1000f*speed);
        int color = Color.HSBtoRGB(hue, 1, 1);

        for (Module m : mods){
            mc.textRenderer.drawWithShadow(
                    matrices,
                    m.getName(),
                    mc.getWindow().getScaledWidth() - (mc.textRenderer.getWidth(m.getName()) + 2),
                    Y,
                    color
            );
            Y += mc.textRenderer.fontHeight;
        }
    }
}
