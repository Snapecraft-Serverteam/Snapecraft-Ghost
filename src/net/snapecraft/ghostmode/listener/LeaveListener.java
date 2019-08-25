package net.snapecraft.ghostmode.listener;

import net.snapecraft.ghostmode.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("snapecraft.ghost")) {
            for (int i = 0; Main.ghost.size() > i; i++) {
                if (Main.ghost.get(i) == p) {
                    Main.ghost.remove(p);
                }
            }
        }
    }

}
