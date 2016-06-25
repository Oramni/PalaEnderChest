package fr.oramni.palaenderchest.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import fr.oramni.palaenderchest.ItemSerialization;

public class OpenInv implements Listener {

	@EventHandler
	public void onOpen(InventoryOpenEvent e){
		
		Player p = (Player) e.getPlayer();
		Inventory inv = e.getInventory();
		if(inv.getTitle().equals("§cPalaEnderChest (§6"+p.getName()+"§c)")){
			//ItemSerialization.fromBase64("gfgfdgf", p);
			
			
		}else {
			return;
		}
		
	}
	
}
