package net.snapecraft.ghostmode;

import net.snapecraft.ghostmode.commands.command;
import net.snapecraft.ghostmode.listener.JoinListener;
import net.snapecraft.ghostmode.listener.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {


    public static ArrayList<Player> ghost = new ArrayList<>();

    public void onEnable() {
         System.out.println("GhsotMode");
         System.out.println("Version:1.0");
         System.out.println("Ghostmode wird geladen...");


        //Events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new LeaveListener(), this);

        //commands
        getCommand("ghost").setExecutor(new command());

        System.out.println("Ghostmode Geladen!");
    }
}
