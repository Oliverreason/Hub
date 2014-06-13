package de.chriss1998.hub.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class CommandTest extends Command{

	public CommandTest() {
		super(0, 0);
	}

	@Override
	public String getPermission() {
		return "command.test";
	}

	@Override
	public void onCommandUse(Player p, String[] args) {
		p.setGameMode(GameMode.CREATIVE);
		p.sendMessage("TEST ERFOLGREICH!");
		
	}

	@Override
	public String getCommand() {
		return "/testcommand";
	}

}