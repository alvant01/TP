package tp.p3.Command;

import tp.p3.Game.Game;

public class ResetCommand extends Command {

	public ResetCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game) {
		game.reiniciar();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].toLowerCase().equals("reset") || commandWords[0].toLowerCase().equals("r"))
			return this;
		return null;
	}

}
