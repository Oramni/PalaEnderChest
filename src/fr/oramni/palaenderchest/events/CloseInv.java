package fr.oramni.palaenderchest.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import fr.oramni.palaenderchest.ItemSerialization;

public class CloseInv implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		
		Player p = (Player) e.getPlayer();
		Inventory inv = e.getInventory();
		
		
		if(inv.getTitle().equals("§cPalaEnderChest (§6"+p.getName()+"§c)")){
			Bukkit.broadcastMessage(ItemSerialization.toBase64(inv));
			for(Player ps : Bukkit.getOnlinePlayers()){
				ps.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
			}
		} else {
			return;
		}
		
	}
	
	
}
