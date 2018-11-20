package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class PrintModeCommand extends Command {

	public PrintModeCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game, Controller controller) {
		controller.printMode();
		return false;
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("p") ||commandWords[0].toLowerCase().equals("printMode") )
			return this;
		return null;
	}

}
