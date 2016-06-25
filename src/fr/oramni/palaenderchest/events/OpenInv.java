package fr.oramni.palaenderchest.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class OpenInv implements Listener {

	@EventHandler
	public void onOpen(InventoryOpenEvent e){
		
		Player p = (Player) e.getPlayer();
		
		if(e.getInventory().getTitle().equals("§cPalaEnderChest (§6"+p.getName()+"§c)")){
			p.sendMessage("Test");
			
			
		}else {
			return;
		}
		
	}
	
}
