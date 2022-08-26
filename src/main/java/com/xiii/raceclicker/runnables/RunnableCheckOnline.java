package com.xiii.raceclicker.runnables;

import com.xiii.raceclicker.data.Data;
import com.xiii.raceclicker.data.PlayerData;
import com.xiii.raceclicker.utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

// MADE BY DukeinPro

public class RunnableCheckOnline extends BukkitRunnable {

    @Override
    public void run() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            boolean exists = Data.data.isAlreadyRegistered(p);
            if(!exists) {
                Data.data.registerUser(p);
            }
        }
    }
}