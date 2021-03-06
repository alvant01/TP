package tp.p3.Command;

import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Exceptions.CommandParseException;
import tp.p3.Game.Game;

public class CatchCommand extends Command {

	private int posX;
	
	private int posY;
	
	public CatchCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.catchSun(this.posX, this.posY);
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].toLowerCase().equals("catch") || commandWords[0].toLowerCase().equals("c"))
		{
			try 
			{
			this.posX = Integer.parseInt(commandWords[1]);
			this.posY = Integer.parseInt(commandWords[2]);
			return this;
		}
			catch(ArrayIndexOutOfBoundsException | NumberFormatException es){
				throw new CommandParseException("Ha escrito mal el comando");
			}
		}
		return null;
	}

}
