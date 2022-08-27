package com.xiii.raceclicker.runnables;

import com.xiii.raceclicker.RaceClicker;
import com.xiii.raceclicker.data.Data;
import com.xiii.raceclicker.data.PlayerData;
import com.xiii.raceclicker.data.TempServerData;
import com.xiii.raceclicker.utils.SoundUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

// MADE BY DukeinPro

public class RunnableTick extends BukkitRunnable {
    BossBar bar = Bukkit.createBossBar(ChatColor.GREEN + "", BarColor.GREEN, BarStyle.SOLID);
    public static List<Player> addedPlayersToBar = new ArrayList<>();
    public static List<Player> toRemoveFromBar = new ArrayList<>();
    @Override
    public void run() {
        TempServerData data = RaceClicker.INSTANCE.serverData;

        data.changePhase();

        if(data.timeLeft == 0) {
            RunnableChangePhase phaseChanger = new RunnableChangePhase();
            phaseChanger.runTaskLaterAsynchronously(RaceClicker.INSTANCE, data.isClickingPhase ? 20*20 : data.isRacePhase ? 2*60*20 : data.isWaitingAfterClickPhase ? 5*20 : 60*20 );
            data.timeLeft = data.isClickingPhase ? 20*20 : data.isRacePhase ? 2*60*20 : data.isWaitingAfterClickPhase ? 5*20 : 60*20;
        } else {
            data.timeLeft--;
        }

        double seconds = data.timeLeft / 20.0;
        double minutes2 = seconds / 60;
        minutes2 = Math.floor(minutes2);
        int minutes = (int) minutes2;
        seconds -= minutes * 60;

        bar.setColor((data.isClickingPhase ? BarColor.PINK : data.isRacePhase ? BarColor.GREEN : data.isWaitingAfterClickPhase ? BarColor.RED : BarColor.YELLOW));

        //bar.setTitle((data.isClickingPhase ? ChatColor.LIGHT_PURPLE : data.isRacePhase ? ChatColor.GREEN : data.isWaitingAfterClickPhase ? ChatColor.RED : ChatColor.YELLOW) + "Current Phase: " + (data.isClickingPhase ? "Clicking" : data.isRacePhase ? "Racing" : data.isWaitingAfterClickPhase ? "Starting soon" : "Starting new Race") + " Time Left: " + (minutes > 0 ? minutes + "m " + Math.round(seconds) + "s" : Math.round(seconds) + "s"));
        if(data.isClickingPhase) {
            bar.setTitle(ChatColor.LIGHT_PURPLE + (minutes > 0 ? minutes + "m " + Math.round(seconds) + "s" : Math.round(seconds) + "s") + " left to click!");
        }
        if(data.isRacePhase) {
            bar.setTitle(ChatColor.GREEN + (minutes > 0 ? minutes + "m " + Math.round(seconds) + "s" : Math.round(seconds) + "s") + " left to race");
        }
        if(data.isWaitingAfterClickPhase) {
            bar.setTitle(ChatColor.RED + "Starting in " + (minutes > 0 ? minutes + "m " + Math.round(seconds) + "s" : Math.round(seconds) + "s"));
        }
        if(data.isWaitingBeforeClickPhase) {

            bar.setTitle(ChatColor.YELLOW + "New race in " + (minutes > 0 ? minutes + "m " + Math.round(seconds) + "s" : Math.round(seconds) + "s"));
        }
        double progress = data.timeLeft / (double)(data.isClickingPhase ? 20*20 : data.isRacePhase ? 2*60*20 : data.isWaitingAfterClickPhase ? 5*20 : 60*20);

        bar.setProgress(progress);

        for(Player p : toRemoveFromBar) {
            bar.removePlayer(p);
        }
        toRemoveFromBar.clear();

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(Data.data.isAlreadyRegistered(p)) {
                PlayerData pd = Data.data.getUserData(p);
                p.setLevel(pd.level);
                if(pd.level == 1) {
                    pd.speed = 1;
                } else {
                    pd.speed = pd.level * RaceClicker.INSTANCE.serverData.addSpeed + 1;
                }
                p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.020000000149011612 * pd.speed);
            }
            if(!addedPlayersToBar.contains(p)) {
                bar.addPlayer(p);
            }
        }


    }
}
