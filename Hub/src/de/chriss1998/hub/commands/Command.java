package de.chriss1998.hub.commands;

import org.bukkit.entity.Player;

public abstract class Command 
{
  private int minarg;
  private int maxarg;
  
  public Command(int minargs,int maxargs)
  {
	  //The minimal and max arguments.
	  this.minarg = minargs;
	  this.maxarg = maxargs;
  }
  
  /**
   * 
   * @return The minimal argument.
   */
  public int getMinArgs()
  {
	  return minarg;
  }
  
  public int getMaxArgs()
  {
	  return maxarg;
  }
  
  /**
   * Get the Permission for that command.
   * @return
   */
  public abstract String getPermission();
  
  /**
   * 
   * @param args - The parameter how get transfer .
   */
  public abstract void onCommandUse(Player p,String args[]);
  
  /**
   * Gibt den Commandstring zurck, der bei der Klasse eingetragen wurde.
   * @return
   */
  public abstract String getCommand();
  
  
  
}