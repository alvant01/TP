package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class ResetCommand extends Command {

	public ResetCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game, Controller controller) {
		game.reiniciar();
		return false;
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("reset") || commandWords[0].toLowerCase().equals("r"))
			return this;
		return null;
	}

}
