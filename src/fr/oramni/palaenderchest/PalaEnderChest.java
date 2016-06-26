package fr.oramni.palaenderchest;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PalaEnderChest extends JavaPlugin {
	
	public static MySQL api;
	
	@Override
	public void onEnable(){
		api = new MySQL("jdbc:mysql://", "localhost", "****", "root", "*******", "users");
		api.connection();
		EventManager.registerEvents(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(label.equalsIgnoreCase("enderchest")){
			Player p = (Player) sender;
			if(p.hasPermission("palaenderchest.cmd")){
			PalaInv.openEnder(p);
			return true;
			} else {
				p.sendMessage("§cVous n'avez pas les droits pour cette commande.");
				return true;
			}
		}
		
		if(label.equalsIgnoreCase("ec")){
			Player p = (Player) sender;
			if(p.hasPermission("palaenderchest.cmd")){
			PalaInv.openEnder(p);
			return true;
			} else {
				p.sendMessage("§cVous n'avez pas les droits pour cette commande.");
				return true;
			}
		}
		return false;
		
		
		
	}

}
