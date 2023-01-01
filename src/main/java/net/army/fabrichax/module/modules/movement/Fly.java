package net.army.fabrichax.module.modules.movement;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_F;

public class Fly extends Module{

    public Fly() {
        super("Fly", "Allows the player to fly", Category.MOVEMENT);
        this.setKey(GLFW_KEY_F);
    }

    @Override
    public void onDisable() {
        assert mc.player != null;
        mc.player.getAbilities().flying = false;
    }

    @Override
    public void onTick() {
        if (mc.player != null)
            mc.player.getAbilities().flying = true;
    }
}
