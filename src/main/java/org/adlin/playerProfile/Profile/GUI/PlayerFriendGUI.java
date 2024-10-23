package org.adlin.playerProfile.Profile.GUI;

import org.adlin.playerProfile.Main;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;

public class PlayerFriendGUI{

    private final Gui gui;

    public PlayerFriendGUI(Player targetPlayer){
        ItemStack playerHeadItem = new ItemStack(Material.PLAYER_HEAD,1);
        SkullMeta playerHeadMeta = (SkullMeta) playerHeadItem.getItemMeta();
        playerHeadMeta.setOwner(targetPlayer.getName());
        playerHeadMeta.setItemName(targetPlayer.getName());
        playerHeadItem.setItemMeta(playerHeadMeta);

        gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        ". . . . p . . . .",
                        ". . . a r b . . .",
                        ". . . . . . . . .")
                .addIngredient('a', new SimpleItem(new ItemBuilder(Material.GREEN_CONCRETE).setDisplayName("Add to friends")))
                .addIngredient('r', new SimpleItem(new ItemBuilder(Material.BARRIER).setDisplayName("Report this player")))
                .addIngredient('b', new SimpleItem(new ItemBuilder(Material.RED_CONCRETE).setDisplayName("Block this player")))
                .addIngredient('p', playerHeadItem)
                .build();
    }

    public Gui getGui() {
        return gui;
    }
}
