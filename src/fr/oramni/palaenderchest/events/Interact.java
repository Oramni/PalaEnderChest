package fr.oramni.palaenderchest.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
		      return;
		    }
		    if (e.getClickedBlock().getType() != Material.ENDER_CHEST) {
		    	e.setCancelled(true);
		      return;
		  }
	}
}
