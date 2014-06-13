package de.chriss1998.hub.commands;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.tsh.tutorials.TutorialBukkit;

import de.chriss1998.hub.Hub;
import de.chriss1998.hub.event.YamlHandler;


public class CommandSpawn  extends Command
{

	public CommandSpawn() {
		super(0, 0);
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public void onCommandUse(Player p, String[] args) 
	{
		FileConfiguration c = Hub.getSpawnFile();
		Location l = p.getLocation();
		c.set("spawns.x", l.getBlockX());
		c.set("spawns.y", l.getBlockY());
		c.set("spawns.z", l.getBlockZ());
	    YamlHandler.saveYamlFile(c, YamlHandler.getRawSpawnFile());
	    p.sendMessage("Spawn erfolgreich gesetzt.");
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return "/setspawn";
	}

}