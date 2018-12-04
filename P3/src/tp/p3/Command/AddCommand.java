package tp.p3.Command;

import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Exceptions.CommandParseException;
import tp.p3.Game.Game;

public class AddCommand extends Command 
{
	private String planta;
	
	private int posX;
	
	private int posY;
	
	public AddCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		return game.addPlant(this.planta, this.posX, this.posY);
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException 
	{
		try
		{
			if(commandWords[0].toUpperCase().equals("ADD") || commandWords[0].toUpperCase().equals("A"))
			{
				this.planta = commandWords[1];
				this.posX = Integer.parseInt(commandWords[2]);
				this.posY = Integer.parseInt(commandWords[3]);					
				return this;
			}
		}
		catch(NumberFormatException e)
		{
			throw new CommandParseException("Comando no reconocido");
		}
		return null;
	}
}
