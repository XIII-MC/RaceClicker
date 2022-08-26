package com.xiii.raceclicker.listener;

import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.PacketListenerPriority;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import org.bukkit.entity.Player;

public class PacketListener extends PacketListenerAbstract {

    public PacketListener() {
        super(PacketListenerPriority.HIGHEST);
    }

    @Override
    public void onPacketPlayReceive(PacketPlayReceiveEvent e) {
        Player p = e.getPlayer();

        switch (e.getPacketId()) {
            case PacketType.Play.Client.POSITION:

        }

    }

}
