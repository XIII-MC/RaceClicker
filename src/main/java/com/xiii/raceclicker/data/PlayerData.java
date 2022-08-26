package com.xiii.raceclicker.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

// MADE BY DukeinPro

public class PlayerData implements java.io.Serializable {

    public UUID uuid;
    public String name;
    public double speed = 1;
    public int level = 1;
    public boolean one;
    public boolean two;
    public boolean three;
    public boolean four;
    public boolean five;
    public boolean ten;
    public boolean twentyFive;
    public boolean fifty;
    public boolean hundred;
    public boolean fiveHundred;
    public boolean oneK;
    public boolean fiveK;
    public boolean tenK;
    public boolean twentyFiveK;
    public boolean fiftyK;
    public boolean hundredK;




    public PlayerData(String name, UUID uuid) {
        this.uuid = uuid;
        this.name = name;
        //AttributeModifier modifier = new AttributeModifier(uuid, Attribute.GENERIC_ATTACK_SPEED.name(), 2, AttributeModifier.Operation.ADD_NUMBER);
        //player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.7);
    }

    public UUID getUuid() {
        return uuid;
    }

}
