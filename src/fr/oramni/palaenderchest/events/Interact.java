package fr.oramni.palaenderchest.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Interact implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		Player p = (Player) e.getPlayer();
		
	if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
		
	if (e.getClickedBlock().getType() == Material.ENDER_CHEST){
		
		Inventory inv = Bukkit.createInventory(null, 9, "§cPalaEnderChest (§6"+p.getName()+"§c)");
		
		p.updateInventory();
		p.openInventory(inv);
		
		
	}
	
	}
	
	}
}
