package com.xiii.raceclicker.utils;

import com.xiii.raceclicker.RaceClicker;
import com.xiii.raceclicker.data.Data;
import com.xiii.raceclicker.data.PlayerData;
import com.xiii.raceclicker.data.ServerData;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public class FileUtils {

    public static void saveServerData(ServerData data) {
        try {
            if (!RaceClicker.INSTANCE.getDataFolder().exists())
                RaceClicker.INSTANCE.getDataFolder().mkdir();
            File fileFolder = new File(RaceClicker.INSTANCE.getDataFolder() + "//server//");
            if (!fileFolder.exists()) fileFolder.mkdir();
            File file = new File(RaceClicker.INSTANCE.getDataFolder() + "//server//", "CONSOLE" + ".RC");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream(RaceClicker.INSTANCE.getDataFolder() + "//server//" + "CONSOLE" + ".RC");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void readServerData() {
        File configFolder = new File(RaceClicker.INSTANCE.getDataFolder() + "//server//");

        if (configFolder.listFiles() == null || Objects.requireNonNull(configFolder.listFiles()).length < 1) {
            System.out.println("§eWARN: No ServerData found");
            return;
        } else {
            for (final File file : Objects.requireNonNull(configFolder.listFiles())) {
                try {
                    FileInputStream fileIn = new FileInputStream(file.getPath());
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Data.data.servers.add((ServerData) in.readObject());
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("§eERROR: ServerData class not found");
                    c.printStackTrace();
                    return;
                }
            }
        }
    }

    public static void deletePlayerData(UUID uuid, Player p) {
        if(RaceClicker.INSTANCE.getDataFolder().exists()) {
            File fileFolder = new File(RaceClicker.INSTANCE.getDataFolder() + "//players//");
            if(fileFolder.exists()) {
                File file = new File(RaceClicker.INSTANCE.getDataFolder() + "//players//", uuid + ".RC");
                if(file.exists()) {
                    file.delete();
                    Data.data.deletePlayerData(p);
                }
            }
        }
    }

    public static void savePlayerData(PlayerData data) {
        try {
            if (!RaceClicker.INSTANCE.getDataFolder().exists())
                RaceClicker.INSTANCE.getDataFolder().mkdir();
            File fileFolder = new File(RaceClicker.INSTANCE.getDataFolder() + "//players//");
            if (!fileFolder.exists()) fileFolder.mkdir();
            File file = new File(RaceClicker.INSTANCE.getDataFolder() + "//players//", data.getUuid() + ".RC");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream(RaceClicker.INSTANCE.getDataFolder() + "//players//" + data.getUuid() + ".RC");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void readPlayerData() {
        File configFolder = new File(RaceClicker.INSTANCE.getDataFolder() + "//players//");

        if (configFolder.listFiles() == null || Objects.requireNonNull(configFolder.listFiles()).length < 1) {
            System.out.println("§eWARN: No PlayerData found");
        } else {
            for (final File file : Objects.requireNonNull(configFolder.listFiles())) {
                try {
                    FileInputStream fileIn = new FileInputStream(file.getPath());
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Data.data.users.add((PlayerData) in.readObject());
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("§cERROR: PlayerData class not found");
                    c.printStackTrace();
                    return;
                }
            }
        }
    }
}
