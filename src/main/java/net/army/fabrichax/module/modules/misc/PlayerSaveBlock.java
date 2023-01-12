package net.army.fabrichax.module.modules.misc;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;
import net.army.fabrichax.util.Timer;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_U;

public class PlayerSaveBlock extends Module {

    public PlayerSaveBlock() {
        super("PlayerSave", "Prevent The Player from saving (SINGLE PLAYER)", Category.COMBAT);
        this.setKey(GLFW_KEY_U);
    }
}
