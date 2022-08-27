package com.xiii.raceclicker.listener;

import com.xiii.raceclicker.data.Data;
import com.xiii.raceclicker.data.PlayerData;
import com.xiii.raceclicker.runnables.RunnableTick;
import com.xiii.raceclicker.utils.FileUtils;
import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ConcurrentModificationException;

// MADE BY DukeinPro

public class BukkitEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        boolean exists = Data.data.isAlreadyRegistered(p);
        if(!exists) {
            Data.data.registerUser(p);
            PlayerData pd = Data.data.getUserData(p);
            p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.010000000149011612 * pd.speed);
        } else {
            PlayerData pd = Data.data.getUserData(p);
            p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.010000000149011612 * pd.speed);
        }
        p.setGameMode(GameMode.ADVENTURE);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        boolean exists = Data.data.isAlreadyRegistered(p);
        if (exists) {
            try {
                RunnableTick.addedPlayersToBar.remove(p);
            } catch (ConcurrentModificationException e35) {

            }
            FileUtils.savePlayerData(Data.data.getUserData(p));
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        boolean exists = Data.data.isAlreadyRegistered(p);
        if (exists) {
            try {
                RunnableTick.addedPlayersToBar.remove(p);
            } catch (ConcurrentModificationException e35) {

            }
            FileUtils.savePlayerData(Data.data.getUserData(p));
        }
    }

}
