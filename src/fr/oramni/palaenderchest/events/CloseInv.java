package fr.oramni.palaenderchest.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import fr.oramni.palaenderchest.ItemSerialization;
import fr.oramni.palaenderchest.PalaEnderChest;

public class CloseInv implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		PalaEnderChest.api.connection();
		PalaEnderChest.api.createAccount(p);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		
		Player p = (Player) e.getPlayer();
		Inventory inv = e.getInventory();
		
		
		if(inv.getTitle().equals("§cPalaEnderChest (§6"+p.getName()+"§c)")){
			for(Player ps : Bukkit.getOnlinePlayers()){
				ps.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
			}
			PalaEnderChest.api.setEnderchest(p.getName(), ItemSerialization.toBase64(inv));
		} else {
			return;
		}
		
	}
	
	
}
