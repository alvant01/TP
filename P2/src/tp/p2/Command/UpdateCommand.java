package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class UpdateCommand extends Command {



	public UpdateCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game, Controller controller) {
		game.updateGame();
		return true;
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("update") || commandWords[0].toLowerCase().equals("u"))
			return this;
		return null;
	}

}
