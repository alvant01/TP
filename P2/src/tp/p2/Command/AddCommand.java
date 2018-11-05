package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class AddCommand extends Command 
{
	private String planta;
	
	private int posX;
	
	private int posY;
	
	public AddCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}

	@Override
	public void execute(Game game, Controller controller) {
		game.reconocedorPlantas(this.planta, this.posX, this.posY);
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) 
	{
		if(commandWords[0].toUpperCase().equals("ADD") || commandWords[0].toUpperCase().equals("A"))
		{
			this.planta = commandWords[1];
			this.posX = Integer.parseInt(commandWords[2]);
			this.posY = Integer.parseInt(commandWords[3]);					
			return this;
		}
		return null;
	}
}
