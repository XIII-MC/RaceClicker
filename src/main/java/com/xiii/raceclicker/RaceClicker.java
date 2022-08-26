package com.xiii.raceclicker;

import com.xiii.raceclicker.command.SetSpeedCommand;
import com.xiii.raceclicker.data.ServerData;
import com.xiii.raceclicker.data.TempServerData;
import com.xiii.raceclicker.listener.BukkitEvents;
import com.xiii.raceclicker.listener.PacketListener;
import com.xiii.raceclicker.runnables.RunnableCheckOnline;
import com.xiii.raceclicker.runnables.RunnableTick;
import com.xiii.raceclicker.utils.FileUtils;
import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.event.PacketListenerDynamic;
import io.github.retrooper.packetevents.settings.PacketEventsSettings;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class RaceClicker extends JavaPlugin {

    public static RaceClicker INSTANCE;
    public PacketListener LISTENER;
    public TempServerData serverData;


    @Override
    public void onLoad() {
        PacketEvents.create(this);
        PacketEventsSettings settings = PacketEvents.get().getSettings();
        settings
                .fallbackServerVersion(ServerVersion.v_1_7_10)
                .compatInjector(false)
                .checkForUpdates(false);
        PacketEvents.get().load();
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        serverData = new TempServerData();
        LISTENER = new PacketListener();
        Bukkit.getPluginCommand("setRaceSpeed").setExecutor(new SetSpeedCommand());
        Bukkit.getPluginManager().registerEvents(new BukkitEvents(), this);
        FileUtils.readPlayerData();
        PacketEvents.get().init();
        PacketEvents.get().registerListener(RaceClicker.INSTANCE.LISTENER);
        RunnableCheckOnline onlineChecker = new RunnableCheckOnline();
        onlineChecker.runTaskTimerAsynchronously(this, 1, 1);
        RunnableTick tick = new RunnableTick();
        tick.runTaskTimerAsynchronously(this, 1, 1);
    }

    @Override
    public void onDisable() {
        PacketEvents.get().terminate();
        Bukkit.getScheduler().cancelTasks(this);
    }

    public void log(Level level, String message) {
        Bukkit.getLogger().log(level, message);
    }


}
