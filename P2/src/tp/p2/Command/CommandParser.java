package tp.p2.Command;

import tp.p2.Controladores.Controller;

public class CommandParser {

	
	private static Command[] availableCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ListCommand(),
			new UpdateCommand(),
			};

	public CommandParser() {
		// TODO Auto-generated constructor stub
	}
	public static Command parseCommand(String[ ] commandWords, Controller controller) {
		return null;
	}
	
	public static String commandHelp() {
		return null;
	}
}
