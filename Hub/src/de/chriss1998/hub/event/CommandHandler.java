package de.chriss1998.hub.event;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.chriss1998.hub.commands.Command;
import de.chriss1998.hub.commands.CommandSpawn;
import de.chriss1998.hub.commands.CommandTest;

public class CommandHandler implements Listener{
	
	private ArrayList<Command> commandlist = new ArrayList<Command>();
	
	public CommandHandler()
	{
		registerCommand(new CommandTest());
		registerCommand(new CommandSpawn());
	}
	
	private void registerCommand(Command c)
	{
		commandlist.add(c);
	}
	
	@EventHandler
	void onCommand(PlayerCommandPreprocessEvent e)
	{
	 Player p = e.getPlayer();
	 String s = e.getMessage();
	 String[]args = s.split(" ");
	 
	 String command = args[0];
	 String[]argm = new String[args.length -1];
	 
	 for(int i = 1; i< args.length;i++)
	 {
		 argm[i-1] = args[i];
	 }
	 
	 if(command.startsWith("/"))
	 {
		 Command com = null;
		 
		 for(Command comm : this.commandlist)
		 {
			 if(comm.getCommand().equalsIgnoreCase(command))
			 {
				 com = comm;
			 }
		 }
		 
		 if(com != null)
		 {
			 if(com.getPermission() == null || e.getPlayer().hasPermission(com.getPermission()))
			 {
			 int arglength = argm.length;
			 
			 if(arglength < com.getMinArgs() )
			 {
				 e.getPlayer().sendMessage(ChatColor.RED + "There are not enough arguments!");
			 }
			 
			 else if(arglength > com.getMaxArgs() )
			 {
				 e.getPlayer().sendMessage(ChatColor.RED  + "There are tomany arguments!");
			 }
			 else
			 {
				 com.onCommandUse(p, argm);
			 }
			 }
			 else
				 e.getPlayer().sendMessage(ChatColor.RED  + "You Downt haf the required permisons for this Command!");
		 }
		 else
			 e.getPlayer().sendMessage(ChatColor.RED + "This command dose not exist!");
	 }
		 
	}
	

}