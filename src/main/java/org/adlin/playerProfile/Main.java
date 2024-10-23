package org.adlin.playerProfile;

import org.adlin.playerProfile.Commands.OpenProfileGUI;
import org.adlin.playerProfile.Listeners.PlayerJoinEvent;
import org.adlin.playerProfile.Profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.xenondevs.invui.InvUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class Main extends JavaPlugin {

    private ConsoleCommandSender consoleSender;
    private final HashMap<Player ,PlayerProfile> playerProfiles = new HashMap<>();

    @Override
    public void onEnable() {
        consoleSender = Bukkit.getConsoleSender();
        InvUI.getInstance().setPlugin(this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(this), this);

        getCommand("profile").setExecutor(new OpenProfileGUI(this));
    }

    @Override
    public void onDisable() {
    }

    public ConsoleCommandSender getConsole() {
        return consoleSender;
    }

    public HashMap<Player, PlayerProfile> getPlayerProfileList() {
        return playerProfiles;
    }

    public void addPlayerProfile(Player player,PlayerProfile playerProfile){
        if (playerProfiles.containsKey(player)){
            playerProfiles.replace(player, playerProfile);
        }else{
            playerProfiles.put(player, playerProfile);
        }
    }

    public PlayerProfile getPlayerProfile(Player player){
        return playerProfiles.get(player);
    }
}
