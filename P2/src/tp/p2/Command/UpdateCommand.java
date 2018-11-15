package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class UpdateCommand extends Command {



	public UpdateCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}

	@Override
	public void execute(Game game, Controller controller) {
		game.updateGame();
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("update") || commandWords[0].toLowerCase().equals("u"))
			return this;
		return null;
	}

}
