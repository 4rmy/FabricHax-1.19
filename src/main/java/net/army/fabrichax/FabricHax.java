package net.army.fabrichax;

import net.army.fabrichax.module.Module;
import net.army.fabrichax.module.ModuleManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

public class FabricHax implements ModInitializer {
	public static final String MOD_ID = "FabricHax", VERSION = "0.0.1 [BETA]";
	public static final FabricHax instance = new FabricHax();
	public static final Logger logger = LoggerFactory.getLogger(MOD_ID);
	public MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {
		logger.info("Client Initialized!");
	}

	public void onKeyPress(int key, int action) {
		if (action == GLFW_PRESS) {
			for (Module m : ModuleManager.instance.getModules()) {
				if (m.getKey() == key) {
					m.toggle();
				}
			}
		}
	}

	public void onTick() {
		if (mc.player != null) {
			for (Module m : ModuleManager.instance.getActiveModules()) {
				m.onTick();
			}
		}
		if (mc.getWindow() != null)
			mc.getWindow().setTitle(MOD_ID + " v" + VERSION);
	}
}
