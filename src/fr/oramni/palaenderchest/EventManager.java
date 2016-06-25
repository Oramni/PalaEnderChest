package fr.oramni.palaenderchest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.oramni.palaenderchest.events.CloseInv;
import fr.oramni.palaenderchest.events.Interact;
import fr.oramni.palaenderchest.events.OpenInv;


public class EventManager {

	public static void registerEvents(Plugin pl){
		PluginManager pm = (PluginManager) Bukkit.getPluginManager();
		
		pm.registerEvents(new Interact(), pl);
		pm.registerEvents(new OpenInv(), pl);
		pm.registerEvents(new CloseInv(), pl);
	}
	
}
