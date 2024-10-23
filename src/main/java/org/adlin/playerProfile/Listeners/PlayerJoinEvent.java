package org.adlin.playerProfile.Listeners;

import org.adlin.playerProfile.Main;
import org.adlin.playerProfile.Profile.PlayerProfile;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    private final Main plugin;

    public PlayerJoinEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event){
        plugin.addPlayerProfile(event.getPlayer(), new PlayerProfile(event.getPlayer().getName(),
                event.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                event.getPlayer().getStatistic(Statistic.DEATHS),
                event.getPlayer().getFirstPlayed(),
                event.getPlayer().getLastLogin()));
    }
}
