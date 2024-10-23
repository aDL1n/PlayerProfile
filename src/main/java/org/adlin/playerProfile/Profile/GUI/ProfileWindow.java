package org.adlin.playerProfile.Profile.GUI;

import org.bukkit.entity.Player;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public class ProfileWindow {

    private final Window profileWindow;

    public ProfileWindow(Gui profileGui, Player viewer){
        profileWindow = Window.single()
                .setGui(profileGui)
                .setViewer(viewer)
                .setTitle("Player profile")
                .build();
    }

    public void open(){
        profileWindow.open();

    }

    public void close(){
        profileWindow.close();
    }

}
