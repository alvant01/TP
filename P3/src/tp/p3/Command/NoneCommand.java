package tp.p3.Command;

import tp.p3.Controladores.Controller;
import tp.p3.Game.Game;

public class NoneCommand extends Command {

	public NoneCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("None");
		//Game.this.setCiclos(ciclos+1);
		return true;
	}
	
	public Command parse(String[] commandWords) {
		if(commandWords[0].toLowerCase().equals("none") || commandWords[0].toLowerCase().equals("n") || commandWords[0].isEmpty())
			return this;
		return null;
	}

}
