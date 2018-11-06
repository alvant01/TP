package tp.p2.Command;

import tp.p2.Controladores.Controller;

public class CommandParser {

	private static Command[] availableCommands = {
			new AddCommand("ADD","añade", "añade"),
			new HelpCommand("add","añade", "help"),
			new ResetCommand("add","añade", "help"),
			new ExitCommand("add","añade", "help"),
			new ListCommand("add","añade", "help"),
			new UpdateCommand("add","añade", "help"),
			};

	public CommandParser() 
	{
		CommandParser.availableCommands = new Command[6];
	}
	public static Command parseCommand(String[ ] commandWords, Controller controller) 
	{
		if (availableCommands[0].parse(commandWords, controller) != null)
		{
			return availableCommands[0];
		}
		else if(availableCommands[1].parse(commandWords, controller) != null)
		{
			return availableCommands[1];
		}
		else if(availableCommands[2].parse(commandWords, controller) != null)
		{
			return availableCommands[2];
		}
		else if(availableCommands[3].parse(commandWords, controller) != null)
		{
			return availableCommands[3];
		}
		else if(availableCommands[4].parse(commandWords, controller) != null)
		{
			return availableCommands[4];
		}
		else if(availableCommands[5].parse(commandWords, controller) != null)
		{
			return availableCommands[5];
		}
		return null;
	}
	
	public static String commandHelp() {
		return null;
	}
}
