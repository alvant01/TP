package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class CatchCommand extends Command {

	private int posX;
	
	private int posY;
	
	public CatchCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game, Controller controller) {
		game.catchSun(this.posX, this.posY);
		return false;
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("catch") || commandWords[0].toLowerCase().equals("c"))
		{
			this.posX = Integer.parseInt(commandWords[1]);
			this.posY = Integer.parseInt(commandWords[2]);
			return this;
		}
		return null;
	}

}
