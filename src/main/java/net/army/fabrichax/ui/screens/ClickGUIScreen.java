package net.army.fabrichax.ui.screens;

import net.army.fabrichax.module.ModuleManager;
import net.army.fabrichax.module.modules.misc.ClickGUI;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class ClickGUIScreen extends Screen {
    protected ClickGUIScreen() {
        super(Text.literal("ClickGUI"));
    }

    public static final ClickGUIScreen instance = new ClickGUIScreen();

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        ClickGUI gui = (ClickGUI) ModuleManager.instance.getModuleByName("ClickGUI");
        if (gui.isToggled()) {
            for (Frame frame : gui.frames) {
                frame.render(matrices, mouseX, mouseY, delta);
            }
        }
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        ClickGUI gui = (ClickGUI) ModuleManager.instance.getModuleByName("ClickGUI");
        if (gui.isToggled()) {
            for (Frame frame : gui.frames) {
                frame.mouseClicked(mouseX, mouseY, button);
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
