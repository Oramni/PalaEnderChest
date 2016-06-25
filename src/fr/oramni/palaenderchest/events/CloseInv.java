package fr.oramni.palaenderchest.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class CloseInv implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		
		Player p = (Player) e.getPlayer();
		
		if(e.getInventory().getTitle() == "§cPalaEnderChest (§6"+p.getName()+"§c)"){
			for (Player ps : Bukkit.getOnlinePlayers()) {
			p.playNote(ps.getLocation(), (byte) 1, (byte) 1);
			}
		} else {
			return;
		}
		
	}
	
	
}
