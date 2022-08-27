package com.xiii.raceclicker.utils;

import com.xiii.raceclicker.RaceClicker;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtils {

    public static void customSound(Player p, Sound sound, int volume, int pitch) {
        Bukkit.getScheduler().runTaskAsynchronously(RaceClicker.INSTANCE, () -> {
            if (p.isOnline()) p.playSound(p.getLocation(), sound, volume, pitch);
        });
    }

    public static void playSound(Player p, int sID) {
        Bukkit.getScheduler().runTaskAsynchronously(RaceClicker.INSTANCE, () -> {
            if (p.isOnline()) {
                switch(sID) {
                    // when exp up
                    case 0: p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                    // when level up
                    case 1: p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 1);
                    // when die
                    case 2: p.playSound(p.getLocation(), Sound.ENTITY_SKELETON_DEATH, 10, 1);
                    // when Progress Saver saves you
                    case 3: p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 10, 1);
                    // fr idk
                    case 4: p.playSound(p.getLocation(), Sound.BLOCK_END_PORTAL_SPAWN, 10, 1);
                    // when /join
                    case 5: p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRIGGER, 10, 1);
                    // lagback/no enough money
                    case 6: p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10, 1);
                    // purchase done
                    case 7: p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 10, 1);
                    // gui shop open
                    case 8: p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 10, 1);
                    // purchase fail
                    case 9: p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 1);
                    // Dong (Idk)
                    case 10: p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    // Click | Hypixel game start sound (Idk)
                    case 11: p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 1);
                    // Ding (Idk)
                    case 12: p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 1);
                    // PLING | Notification (Message)
                    case 13: p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                }
            }
        });
    }
}
