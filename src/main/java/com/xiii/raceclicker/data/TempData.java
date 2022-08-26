package com.xiii.raceclicker.data;

import org.bukkit.entity.Player;

import java.util.UUID;

public class TempData {

    public UUID uuid;
    public Player player;
    public String name;

    public TempData(String name, UUID uuid) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return player;
    }

}
