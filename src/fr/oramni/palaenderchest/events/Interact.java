package fr.oramni.palaenderchest.events;

import net.minecraft.server.v1_7_R4.Blocks;
import net.minecraft.server.v1_7_R4.PacketPlayOutBlockAction;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Interact implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
		Player p = (Player) e.getPlayer();
		
	if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
		
	if (e.getClickedBlock().getType() == Material.ENDER_CHEST){
		
		Inventory inv = Bukkit.createInventory(null, 9, "§cPalaEnderChest (§6"+p.getName()+"§c)");
		for(Player ps : Bukkit.getOnlinePlayers()){
			ps.playSound(e.getClickedBlock().getLocation(), Sound.CHEST_OPEN, 1, 1);
		Block block = e.getClickedBlock();
		CraftPlayer cp = (CraftPlayer) ps;
		PacketPlayOutBlockAction packet = new PacketPlayOutBlockAction((int)block.getLocation().getX(),(int)block.getLocation().getY(),(int)block.getLocation().getZ(), Blocks.ENDER_CHEST, 1 ,2);
		cp.getHandle().playerConnection.sendPacket(packet); 
		}
		p.updateInventory();
		p.openInventory(inv);
		e.setCancelled(true);
		
	}
	
	}
	
	}
}
