package net.army.fabrichax.module.modules.player;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_N;

public class NoFall extends Module{

    public NoFall() {
        super("NoFall", "Prevents the player from taking fall damage", Category.PLAYER);
        this.setKey(GLFW_KEY_N);
    }

    @Override
    public void onTick() {
        if (mc.player != null) {
            if (mc.player.fallDistance > 2) {
                mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
            }
        }
    }
}
