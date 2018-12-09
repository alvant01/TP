package tp.p3.Command;

import java.io.IOException;

import tp.p3.Controladores.Controller;
import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Exceptions.CommandParseException;
import tp.p3.Exceptions.FileContentsException;
import tp.p3.Game.Game;

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
	public abstract boolean execute(Game game) throws CommandExecuteException, IOException, FileContentsException;
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	public String helpText()
	{
		return " " + commandText + ": " + helpText;
	}
	
	
	
	
	
	
	public String getHelpText() {
		return helpText;
	}
	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}
	public String getCommandText() {
		return commandText;
	}
	public void setCommandText(String commandText) {
		this.commandText = commandText;
	}
	public String getCommandName() {
		return commandName;
	}
}
