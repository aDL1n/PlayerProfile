package org.adlin.playerProfile.Profile;

import java.time.LocalDateTime;
import java.util.UUID;

public class PlayerProfile {

    private String playerName;
    private int kills;
    private int deaths;
    private long firstLoginTime;
    private long lastLoginTime;

    public PlayerProfile(String playerName, int kills, int deaths, long firstLoginTime, long lastLoginTime){
        this.playerName = playerName;
        this.kills = kills;
        this.deaths = deaths;
        this.firstLoginTime = firstLoginTime;
        this.lastLoginTime = lastLoginTime;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public long getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(long firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
