package fr.oramni.palaenderchest;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class PalaInv {

	public static void openEnder(Player p){
		Inventory inv = ItemSerialization.fromBase64(PalaEnderChest.api.getEnderchest(p.getName()), p);
		p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);
		p.updateInventory();
		p.openInventory(inv);
		
		}
	
	
	
}
