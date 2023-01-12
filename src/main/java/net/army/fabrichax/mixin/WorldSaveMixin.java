package net.army.fabrichax.mixin;

import net.army.fabrichax.module.ModuleManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.WorldSaveHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldSaveHandler.class)
public class WorldSaveMixin {
    @Inject(method = "savePlayerData", at = @At("HEAD"), cancellable = true)
    public void onSave(PlayerEntity player, CallbackInfo ci) {
        if (ModuleManager.instance.getModuleByName("PlayerSave").isToggled()) {
            ci.cancel();
        }
    }
}
