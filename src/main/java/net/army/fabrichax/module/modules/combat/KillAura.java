package net.army.fabrichax.module.modules.combat;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;
import net.army.fabrichax.util.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.util.math.Vec3d;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_B;

public class KillAura extends Module {
    public Timer timer = new Timer();

    public KillAura() {
        super("KillAura", "Auto attacks mobs around the player", Category.COMBAT);
        this.setKey(GLFW_KEY_B);
    }

    @Override
    public void onTick() {
        assert mc.world != null;
        assert mc.player != null;
        Iterable<Entity> entities = mc.world.getEntities();
        final Entity[] closest = {null};
        entities.forEach(entity -> {
            if (entity.getId() == mc.player.getId())
                return;
            if (entity.getType() == EntityType.ITEM)
                return;
            Vec3d pos = entity.getPos();
            Vec3d playerPos = mc.player.getPos();
            double distance = pos.distanceTo(playerPos);
            if (closest[0] != null){
                double cdis = closest[0].getPos().distanceTo(playerPos);
                if (distance < 4) {
                    if (distance < cdis) {
                        closest[0] = entity;
                    }
                }
            } else {
                closest[0] = entity;
            }
        });
        PlayerEntity player = (PlayerEntity) mc.world.getEntityById(mc.player.getId());
        assert player != null;
        if (timer.hasTimeElapsed(1000/10, true)) {
            if (closest[0] != null && closest[0].isAlive() && closest[0].isAttackable())
                mc.player.networkHandler.sendPacket(PlayerInteractEntityC2SPacket.attack(closest[0], mc.player.isSneaking()));
        }
    }
}
