package de.chriss1998.hub.event;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.chriss1998.hub.Hub;

public class YamlHandler 
{
	public static File createFile(String filename)
	{
		File f = new File(Hub.getInstance().getDataFolder().getAbsolutePath() + File.separator + filename);
		if(!f.exists())
		{
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return f;
	}
	
	public static FileConfiguration createYamlFile(File f)
	{
		FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
		return fc;
	}
	
	public static void saveYamlFile(FileConfiguration c,File f)
	{
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}