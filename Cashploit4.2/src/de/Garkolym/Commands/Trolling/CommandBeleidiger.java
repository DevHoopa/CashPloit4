package de.Garkolym.Commands.Trolling;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.Garkolym.Start;
import de.Garkolym.Commands.Command;
import de.Garkolym.Commands.CommandCategory;

public class CommandBeleidiger extends Command{
	//Von DevHoopa
	private ArrayList<Player> Beleidiger = new ArrayList<Player>();
	private ArrayList<String> Beleidigungen = new ArrayList<String>();
	
	private void init()
	{
		addBeleidigung("Scheiﬂ Server!");
		addBeleidigung("Ihr Seid zu dumm um NCP Drauf zu machen :D");
		addBeleidigung("Doofer Server");
		addBeleidigung("7br sphere lava 5");
	}
	
	public CommandBeleidiger() {
		super("beleidiger", "<Spieler>", CommandCategory.TROLLING);
		init();
		Bukkit.getScheduler().runTaskTimer(Start.instance, new runner(), 20L*6, 20*6);
	}

	private void addBeleidigung(String beleidigung)
	{
		this.Beleidigungen.add(beleidigung);
	}
	
	@Override
	public void onCommand(Player p, ArrayList<String> args) {

		if(args.size() == 2)
		{
			try
			{
				Player vic = Bukkit.getPlayer(args.get(1));
				
				if(!Beleidiger.contains(vic))
				{
					Beleidiger.add(vic);
					p.sendMessage(Start.instance.prefix + "ßcDieser Spieler Beleidigt nun den Server!");

				}
				else
				{
					Beleidiger.remove(vic);
					p.sendMessage(Start.instance.prefix + "ßcDieser Spieler Beleidigt den Server Jetzt nicht mehr!");

				}
			}
			catch (Exception e)
			{}
		}
		
		
	}

	class runner implements Runnable
	{
		public void run()
		{
			for(Player user : Beleidiger)
			{
				user.chat(Beleidigungen.get(new Random().nextInt(Beleidigungen.size())));
			}
		}
	}
	
}
