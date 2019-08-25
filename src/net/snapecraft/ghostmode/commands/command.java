package net.snapecraft.ghostmode.commands;

import net.snapecraft.ghostmode.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("snapecraft.ghost")) {

                boolean isGhost = false;
                for (int i = 0; Main.ghost.size() > i; i++) {
                    if (Main.ghost.get(i) == p) {
                        isGhost = true;
                    }
                }
                for (Player all : Bukkit.getOnlinePlayers()) {

                    if (!isGhost) {
                        if (!all.hasPermission("snapecraft.see")) {
                            all.hidePlayer(p);
                            p.setAllowFlight(true);
                            Main.ghost.add(p);
                            p.setPlayerListName(p.getPlayerListName() + "§8[§6Ghost§8]");
                            p.sendMessage("§8[§5System§8]§7>§2Du bist nun im §6Ghost §2mode!");

                        }
                    } else {
                        all.showPlayer(p);
                        p.setAllowFlight(false);
                        Main.ghost.remove(p);
                        p.setPlayerListName(p.getPlayerListName().replace("§8[§6Ghost§8]", ""));
                        p.sendMessage("§8[§5System§8]§7>§2Du bist nun §4nichtmehr §2im §6Ghost §2mode!");

                    }
                }
            }


        } else {
            System.out.println("Dieser Befehl kann nicht in der konsole ausgeführ werden");
        }

        return false;
    }
}