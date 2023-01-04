package net.army.fabrichax.module.modules.render;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;
import net.minecraft.block.Blocks;

import java.util.ArrayList;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_X;

public class XRay extends Module{
    public static ArrayList<String> interrestingBlocks = new ArrayList<>();
    public XRay() {
        super("X-Ray", "Allows the player to see through blocks", Category.RENDER);
        this.setKey(GLFW_KEY_X);
        /* ADD BLOCKS */
        interrestingBlocks.add(Blocks.COAL_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.COPPER_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.IRON_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.GOLD_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DIAMOND_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.EMERALD_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.REDSTONE_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.LAPIS_ORE.getTranslationKey());

        interrestingBlocks.add(Blocks.DEEPSLATE_COAL_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DEEPSLATE_COPPER_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DEEPSLATE_IRON_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DEEPSLATE_GOLD_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DEEPSLATE_DIAMOND_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DEEPSLATE_EMERALD_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DEEPSLATE_REDSTONE_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.DEEPSLATE_LAPIS_ORE.getTranslationKey());

        interrestingBlocks.add(Blocks.ANCIENT_DEBRIS.getTranslationKey());
        interrestingBlocks.add(Blocks.NETHER_GOLD_ORE.getTranslationKey());
        interrestingBlocks.add(Blocks.NETHER_QUARTZ_ORE.getTranslationKey());

        interrestingBlocks.add(Blocks.LAVA.getTranslationKey());
        interrestingBlocks.add(Blocks.WATER.getTranslationKey());

        interrestingBlocks.add(Blocks.END_PORTAL_FRAME.getTranslationKey());
        interrestingBlocks.add(Blocks.NETHER_PORTAL.getTranslationKey());
        interrestingBlocks.add(Blocks.SPAWNER.getTranslationKey());
        /* ADD BLOCKS */
    }

    @Override
    public void onEnable() {
        mc.worldRenderer.reload();
    }

    @Override
    public void onDisable() {
        mc.worldRenderer.reload();
    }

    public ArrayList<String> getInterrestingBlocks() {
        return interrestingBlocks;
    }
}
