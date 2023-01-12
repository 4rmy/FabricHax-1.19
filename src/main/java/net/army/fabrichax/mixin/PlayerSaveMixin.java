package net.army.fabrichax.mixin;

import net.army.fabrichax.module.ModuleManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.WorldSaveHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerSaveMixin {
    @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"), cancellable = true)
    public void onSave(NbtCompound nbt, CallbackInfo ci) {
        if (ModuleManager.instance.getModuleByName("PlayerSave").isToggled()) {
            ci.cancel();
        }
    }
}
