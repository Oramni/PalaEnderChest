package fr.oramni.palaenderchest.inv;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PalaInv {

public static void openMenu(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 9, "§4PalaEnderChest §c(§6" + p.getName() + "§c)");
	
		p.updateInventory();
		p.openInventory(inv);
	}
	
}
