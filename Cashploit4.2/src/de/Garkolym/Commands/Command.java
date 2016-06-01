/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Garkolym
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.Garkolym.Commands;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import de.Garkolym.Events.ITick;

public abstract class Command implements ITick {

	private String command, beschreibung;
	private CommandCategory category;
	
	public Command(String command, CommandCategory category) {
		this.command = command;
		this.beschreibung = "�cBeschreibung nicht Verf�gbar oder Keine eingestellt !";
		this.category = category;
	}
	// Optional for a Command Description.
	public Command(String command, String beschreibung, CommandCategory category)
	{
		this.command = command;
		this.beschreibung = beschreibung;
		this.category = category;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getBeschreibung()
	{
		return beschreibung;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public CommandCategory getCategory() {
		return category;
	}

	public void setCategory(CommandCategory category) {
		this.category = category;
	}
	
	public abstract void onCommand(Player p, ArrayList<String> args);
	
	@Override
	public void onTick() {}
}
