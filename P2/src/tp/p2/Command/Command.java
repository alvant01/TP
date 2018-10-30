package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public abstract class Command {
	private String helpText;
	private String commandText;
	protected final String commandName;
	public Command(String commandText, String commandInfo, String helpInfo)
	{
		this.commandText = commandInfo;
		helpText = helpInfo;
		String[] commandInfoWords = commandText.split("\\s+");
		commandName = commandInfoWords[0];
	}
	/*
	Some commands may generate an error in the execute or parse methods.
	In the absence of exceptions , they must the tell the controller not to print the board
	*/
	public abstract void execute(Game game, Controller controller);
	public abstract Command parse(String[] commandWords, Controller controller);
	public String helpText()
	{
		return " " + commandText + ": " + helpText;
	}
}
