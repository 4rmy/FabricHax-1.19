package net.army.fabrichax.mixin;

import net.army.fabrichax.module.Module;
import net.army.fabrichax.module.ModuleManager;
import net.army.fabrichax.module.modules.render.XRay;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class RenderBlockSideMixin {
    @Inject(method = "shouldDrawSide", at = @At("HEAD"), cancellable = true)
    private static void onShouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos otherPos, CallbackInfoReturnable<Boolean> cir) {
        XRay xray = (XRay) ModuleManager.instance.getModuleByName("X-Ray");
        if (xray.isToggled()) {
            if (xray.getInterrestingBlocks().contains(state.getBlock().getTranslationKey())) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        }
    }
}
