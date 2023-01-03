package net.army.fabrichax.module.modules.render;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_X;

public class XRay extends Module{
    public XRay() {
        super("X-Ray", "Allows the player to see through blocks", Category.RENDER);
        this.setKey(GLFW_KEY_X);
    }

    @Override
    public void onEnable() {
        mc.worldRenderer.reload();
    }

    @Override
    public void onDisable() {
        mc.worldRenderer.reload();
    }
}
