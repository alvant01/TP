package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class HelpCommand extends Command {

	public HelpCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.println("Add <plant> <x> <y>: Adds a plant in position x, y.\r\n" + 
				"List: Prints the list of available plants.\r\n" + 
				"Reset: Starts a new game.\r\n" + 
				"Help: Prints this help message.\r\n" + 
				"Exit: Terminates the program.\r\n" + 
				"none: Skips cycle.");
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("help") || commandWords[0].toLowerCase().equals("h"))
			return this;
		return null;
	}

}
