package com.xiii.raceclicker.command;

import com.xiii.raceclicker.RaceClicker;
import com.xiii.raceclicker.data.Data;
import com.xiii.raceclicker.data.PlayerData;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// MADE BY DukeinPro

public class SetSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(Data.data.isAlreadyRegistered(p) && p.hasPermission("raceclicker.setspeed")) {
                PlayerData pd = Data.data.getUserData(p);
                pd.level = (int) (Double.parseDouble(args[0]) / 0.01);
                if(pd.level <= 0) {
                    pd.level = 1;
                    p.sendMessage("Set Speed to 1");
                } else {
                    p.sendMessage("Set Speed to " + Double.parseDouble(args[0]));
                }
               // p.sendMessage("" + p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue());
                //p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.10000000149011612 * (pd.speed / 10.0));

            }

        } else {
            return false;
        }
        return true;
    }
}
