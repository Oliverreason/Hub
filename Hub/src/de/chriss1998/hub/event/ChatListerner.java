package de.chriss1998.hub.event;



import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListerner implements Listener 
{
	@EventHandler
	public void onPlayerChat (AsyncPlayerChatEvent event) {
	
		Player p = event.getPlayer();
		String message = event.getMessage();
		String message_lower = message.toLowerCase();
		ChatColor YELLOW = ChatColor.YELLOW;
		ChatColor Gold = ChatColor.GOLD;
		if(message_lower.contains("Hi") && message_lower.contains("Server")){
			p.sendMessage(YELLOW + "[Server]" + Gold + "Hello nice the you are hire!" + p.getName());
			event.setCancelled(true);
		}
	}


}


