package net.army.fabrichax.ui.screens;

import net.army.fabrichax.module.Category;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public class Frame {
    public int x, y, width, height;
    public Category category;
    public boolean dragging;
    private final MinecraftClient mc = MinecraftClient.getInstance();
    public Frame(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dragging = false;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, x, y, x+width, y+height, 0x1010FF);
        DrawableHelper.drawCenteredText(matrices, mc.textRenderer, category.name(), x+(width/2), 20, 0xFFFFFF);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
    }
}
