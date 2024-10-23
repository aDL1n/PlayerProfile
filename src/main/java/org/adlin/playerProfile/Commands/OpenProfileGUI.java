package org.adlin.playerProfile.Commands;

import org.adlin.playerProfile.Main;
import org.adlin.playerProfile.Profile.GUI.ProfileGUI;
import org.adlin.playerProfile.Profile.GUI.ProfileWindow;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenProfileGUI implements CommandExecutor {
    private final Main plugin;
    private ProfileGUI profileGUI;
    private ProfileWindow profileWindow;

    public OpenProfileGUI(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;

        profileGUI = new ProfileGUI(plugin.getPlayerProfile(player));
        profileWindow = new ProfileWindow(profileGUI.getGui(), player);
        profileWindow.open();
        return true;
    }
}
