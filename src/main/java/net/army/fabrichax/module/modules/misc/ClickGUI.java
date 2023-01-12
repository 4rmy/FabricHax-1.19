package net.army.fabrichax.module.modules.misc;

import net.army.fabrichax.module.Category;
import net.army.fabrichax.module.Module;
import net.army.fabrichax.ui.screens.ClickGUIScreen;
import net.army.fabrichax.ui.screens.Frame;

import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends Module {
    ClickGUIScreen screen;
    public List<Frame> frames;

    public ClickGUI() {
        super("ClickGUI", "Shows the Mod Menu", Category.MISC);
        this.setKey(-1);
        screen = ClickGUIScreen.instance;

        frames = new ArrayList<>();
        int offset = 0;
        for (Category c : Category.values()) {
            frames.add(new Frame(c, offset, 20, 60, 15));
            offset += 85;
        }
    }

    @Override
    public void onEnable() {
        mc.setScreen(screen);
    }

    @Override
    public void onDisable() {
    }
}
