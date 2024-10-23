package org.adlin.playerProfile.Profile.GUI;

import org.adlin.playerProfile.Main;
import org.adlin.playerProfile.Profile.PlayerProfile;
import org.bukkit.Material;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.gui.TabGui;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;

public class ProfileGUI {

    private final Gui gui;

    public ProfileGUI(PlayerProfile playerProfile){
        Item background = new SimpleItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName(" "));

        gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        ". . x x p x x . .",
                        ". . x x x x x . .",
                        ". . . . . . . . .")
                .addIngredient('p', new PageChangeItem(playerProfile))
                .addIngredient('x', background)
                .build();

    }
    

    public Gui getGui() {
        return gui;
    }
}
