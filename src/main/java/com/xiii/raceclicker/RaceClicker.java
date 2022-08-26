package com.xiii.raceclicker;

import com.xiii.raceclicker.listener.PacketListener;
import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.event.PacketListenerDynamic;
import io.github.retrooper.packetevents.settings.PacketEventsSettings;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RaceClicker extends JavaPlugin {

    public static RaceClicker INSTANCE;
    public PacketListener LISTENER;

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
        LISTENER = new PacketListener();

        PacketEvents.get().init();
        PacketEvents.get().registerListener(RaceClicker.INSTANCE.LISTENER);

    }

    @Override
    public void onDisable() {
        PacketEvents.get().terminate();
        Bukkit.getScheduler().cancelTasks(this);
    }
}
