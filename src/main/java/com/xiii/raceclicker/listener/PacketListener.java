package com.xiii.raceclicker.listener;

import com.xiii.raceclicker.RaceClicker;
import com.xiii.raceclicker.data.Data;
import com.xiii.raceclicker.data.PlayerData;
import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.PacketListenerPriority;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import org.bukkit.entity.Player;

// MADE BY DukeinPro

public class PacketListener extends PacketListenerAbstract {

    public PacketListener() {
        super(PacketListenerPriority.HIGHEST);
    }

    @Override
    public void onPacketPlayReceive(PacketPlayReceiveEvent e) {
        Player p = e.getPlayer();
        if(Data.data.isAlreadyRegistered(p)) {
            PlayerData pd = Data.data.getUserData(p);

            switch (e.getPacketId()) {
                case PacketType.Play.Client.ARM_ANIMATION:
                    if(RaceClicker.INSTANCE.serverData.isClickingPhase) {
                      pd.level++;
                    }
                    break;
            }
        }

    }

}
