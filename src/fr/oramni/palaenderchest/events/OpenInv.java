package fr.oramni.palaenderchest.events;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.server.v1_7_R4.NBTTagCompound;
import net.minecraft.server.v1_7_R4.NBTTagList;

import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import fr.oramni.palaenderchest.Fonction;

public class OpenInv implements Listener {

	@EventHandler
	public void onOpen(InventoryOpenEvent e){
		
		Player p = (Player) e.getPlayer();
		Inventory inv = e.getInventory();
		
		if(inv.getTitle().equals("§cPalaEnderChest (§6"+p.getName()+"§c)")){
			
			ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines("CQAACgAAAAkCAAJpZAA9AgAGRGFtYWdlAAABAAVDb3VudAEAAAAAAAAAAAA="));
	        NBTTagList itemList = (NBTTagList) Fonction.readNbt(new DataInputStream(inputStream), 0);

	        for (int i = 0; i < itemList.size(); i++) {
	            NBTTagCompound inputObject = (NBTTagCompound) itemList.get(i);
	            
	            if (!inputObject.isEmpty()) {
	                inv.setItem(i, CraftItemStack.asCraftMirror(
	                		net.minecraft.server.v1_7_R4.ItemStack.createStack(inputObject)));
	            }
	        }
			
		}else {
			return;
		}
		
	}
	
}
