package de.chriss1998.hub;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import de.chriss1998.hub.event.ChatListerner;
import de.chriss1998.hub.event.CommandHandler;

public class Hub extends JavaPlugin {

	private static Hub plugin;
	

	public final Logger logger = Logger.getLogger("Minecraft");    
	
	
	
	//The End
	@Override
	public void onDisable() {
		PluginDescriptionFile pdFile = this.getDescription();
		this.logger.info(pdFile.getName() + " version" + pdFile.getVersion() + " is now disabled.");
		this.logger.info("The Hub Plugin was ritten by machen456 and chriss1998_15.");
	}
	//The Start
	@Override 
	public void onEnable() {
		PluginDescriptionFile pdFile = this.getDescription();
		this.logger.info(pdFile.getName() + " version" + pdFile.getVersion() + " is now enabled.");
		plugin = this;
		
		//Listener
		Bukkit.getServer().getPluginManager().registerEvents(new CommandHandler(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChatListerner(), this);

	}

	  public static Hub getInstance()
	  {
		  return plugin;
	  }
}

