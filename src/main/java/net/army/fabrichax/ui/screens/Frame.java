package net.army.fabrichax.ui.screens;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;
import net.army.fabrichax.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.army.fabrichax.util.Colors;

import java.util.ArrayList;

public class Frame {
    public int x, y, width, height;
    public Category category;
    public boolean dragging, open;
    private final MinecraftClient mc = MinecraftClient.getInstance();
    public Frame(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dragging = false;
        this.open = true;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, x, y, x+width, y+height, Colors.Primary);
        DrawableHelper.drawCenteredText(matrices, mc.textRenderer, category.name(), x+(width/2), y+2, 0xFFFFFF);

        if (this.open) {
            int yOff = height;
            ArrayList<Module> mods = ModuleManager.instance.getModulesByCategory(this.category);
            for (Module m : mods) {
                DrawableHelper.fill(matrices, x, y+yOff, x+width, y+yOff+13, m.isToggled() ? Colors.Primary : Colors.Secondary);
                DrawableHelper.drawCenteredText(matrices, mc.textRenderer, m.getName(), x+(width/2), y+yOff+2, m.isToggled() ? 0x000000 : 0xFFFFFF);
                yOff += 13;
            }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
    }
}
