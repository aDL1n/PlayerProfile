package org.adlin.playerProfile.Profile.GUI;

import org.adlin.playerProfile.Main;
import org.adlin.playerProfile.Profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.invui.InvUI;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

public class PageChangeItem extends AbstractItem {

    private final PlayerProfile playerProfile;

    public PageChangeItem(PlayerProfile playerProfile){
        this.playerProfile = playerProfile;
    }
    @Override
    public ItemProvider getItemProvider() {
        return new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName("Statistic")
                .addLoreLines("Player name: " + playerProfile.getPlayerName())
                .addLoreLines("Kills: " + playerProfile.getKills())
                .addLoreLines("Deaths: " + playerProfile.getDeaths())
                .addLoreLines("First login time: " + playerProfile.getFirstLoginTime());
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
        Player targetPlayer = Bukkit.getPlayer(playerProfile.getPlayerName());
        Window.single()
                .setViewer(player).setGui(new PlayerFriendGUI(targetPlayer).getGui())
                .setTitle("Friends")
                .open(player);
    }
}
