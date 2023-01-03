package net.army.fabrichax.module.modules.render;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_L;

public class Fulbright extends Module{
    private Double gamma;
    public Fulbright() {
        super("Fulbright", "Allows the player to see in the dark", Category.RENDER);
        this.setKey(GLFW_KEY_L);
    }

    @Override
    public void onEnable() {
        gamma = mc.options.getGamma().getValue();
        mc.options.getGamma().setValue(1.0);
    }

    @Override
    public void onDisable() {
        mc.options.getGamma().setValue(gamma);
    }
}
