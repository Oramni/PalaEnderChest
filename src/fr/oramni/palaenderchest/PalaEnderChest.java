package fr.oramni.palaenderchest;


import org.bukkit.plugin.java.JavaPlugin;

public class PalaEnderChest extends JavaPlugin {
	
	@Override
	public void onEnable(){
	
		EventManager.registerEvents(this);
	}
	
	

}
