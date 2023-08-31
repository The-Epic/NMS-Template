package xyz.epicebic.CHANGEME.nms;

import org.bukkit.Bukkit;

public class NMSManager {
    private static final String CLASS_NAME = "xyz.epicebic.CHANGEME.nms.%version%.NMSAdapter";
    private static INMSAdapter instance;

    public static INMSAdapter getInstance() {
        if (instance == null) {
            try {
                instance = (INMSAdapter) Class.forName(CLASS_NAME.replace("%version%", getServerVersion())).getDeclaredConstructor().newInstance();
            } catch (ReflectiveOperationException ex) {
                ex.printStackTrace();
            }
        }
        return instance;
    }

    private static String getServerVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].toLowerCase();
    }
}
