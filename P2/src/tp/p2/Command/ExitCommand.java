package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class ExitCommand extends Command {

	public ExitCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controller) {
		//game.get

	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		// TODO Auto-generated method stub
		return null;
	}

}