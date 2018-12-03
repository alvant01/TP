package tp.p3.Command;

import tp.p3.Controladores.Controller;
import tp.p3.Game.Game;

public class UpdateCommand extends Command {



	public UpdateCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game) {
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
