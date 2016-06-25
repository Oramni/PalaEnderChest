package fr.oramni.palaenderchest;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PalaEnderChest extends JavaPlugin {
	
	@Override
	public void onEnable(){
		
		EventManager.registerEvents(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(label.equalsIgnoreCase("enderchest")){
			Player p = (Player) sender;
			if(p.hasPermission("palaenderchest.cmd")){
			PalaInv.openEnder(p);
			return true;
			} else {
				p.sendMessage("§cVous n'avez pas les droits de faire cette commande.");
				return true;
			}
		}
		
		
		return false;
	}

}
