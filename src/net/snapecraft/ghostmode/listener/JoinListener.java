package net.snapecraft.ghostmode.listener;

import net.snapecraft.ghostmode.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("snapecraft.see"))
        for (int i = 0; Main.ghost.size() > i; i++) {
            p.hidePlayer(Main.ghost.get(i));

        }
    }
}
