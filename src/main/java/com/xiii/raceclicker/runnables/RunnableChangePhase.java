package com.xiii.raceclicker.runnables;

import com.xiii.raceclicker.RaceClicker;
import com.xiii.raceclicker.data.Data;
import com.xiii.raceclicker.data.PlayerData;
import com.xiii.raceclicker.data.ServerData;
import com.xiii.raceclicker.data.TempServerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

// MADE BY DukeinPro

public class RunnableChangePhase extends BukkitRunnable {

    @Override
    public void run() {
        TempServerData data = RaceClicker.INSTANCE.serverData;
        if(data.racePhase == 3) {
            data.racePhase = 0;
        } else {
            data.racePhase++;
        }
        data.changePhase();
    }
}
