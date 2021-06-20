package eu.dkcode.discordawards;

import eu.dkcode.discordawards.spark.WebServer;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @Author: Kacper 'DeeKaPPy' Horbacz
 * @Created 20.06.2021
 * @Class: AwardsPlugin
 **/

public class AwardsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new WebServer().start();
    }

}
