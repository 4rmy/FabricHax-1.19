package net.army.fabrichax.module.modules.render;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.Objects;

public class Fulbright extends Module{
    private Double gamma;
    public Fulbright() {
        super("Fulbright", "Allows the player to see in the dark", Category.RENDER);
        this.setKey(-1);
    }

    @Override
    public void onEnable() {
        gamma = mc.options.getGamma().getValue();
        mc.options.getGamma().setValue(1.0);
    }

    @Override
    public void onDisable() {
        mc.options.getGamma().setValue(gamma);
        assert mc.player != null;
        mc.player.removeStatusEffect(StatusEffect.byRawId(16));
    }

    @Override
    public void onTick() {
        assert mc.player != null;
        mc.player.setStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffect.byRawId(16)), 100, 9), mc.player);
    }
}
