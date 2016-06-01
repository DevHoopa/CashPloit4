package de.Garkolym.utils;

import org.bukkit.entity.Player;

import de.Garkolym.Start;

public class HelpManager {

	public int contentProSeite = 5;
	
	public static void SendHelp(int Seite, Player p)
	{
		if(Seite == 0)
		{
			Seite = 1;
		}
		
		int max = Start.instance.getCommandManager().getCommandList().size() / 5 + 1;
		if(Seite > max)
		{
			p.sendMessage(Start.instance.prefix + "§cSo viele Seiten gibt es nicht!");
			return;
		}
		for(int i = 0; i < 40; i++)
		{
			p.sendMessage("");
		}
		
		p.sendMessage(Start.instance.prefix + "§cFunktionen: §d" + Start.instance.getCommandManager().getCommandList().size());
		p.sendMessage(Start.instance.prefix + "§cSeite : §d" + Seite + " §avon: " + String.valueOf(Start.instance.getCommandManager().getCommandList().size() / 5 +1));
		for(int i = (Seite - 1) * 5; i < (Seite - 1) * 5+ 5; i++)
		{
			p.sendMessage(Start.instance.prefix + Start.instance.getCommandManager().getCommandList().get(i).getCommand() + " §d| §b" + Start.instance.getCommandManager().getCommandList().get(i).getBeschreibung());
		}
		
	}
	
}
