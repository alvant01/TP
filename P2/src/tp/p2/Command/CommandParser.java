package tp.p2.Command;

import tp.p2.Controladores.Controller;

public class CommandParser {
	private int numComandos;
	
	private static Command[] availableCommands = {
			new AddCommand("ADD","A?ade una planta", "A?ade una planta"),
			new HelpCommand("HELP","Muestra los comandos", "Muestra los comandos"),
			new ResetCommand("RESET","Resetea", "Resetea"),
			new ExitCommand("EXIT","Sale", "Sale"),
			new ListCommand("LIST","Lista los objetos", "Lista los objetos"),
			new UpdateCommand("UPDATE","actualiza", "actualiza"),
			new PrintModeCommand("PRINTMODE", "Cambia el modo","Cambia el modo" ),
			new CatchCommand("CATCH", "Coje un sol", "Coje un sol"),
			new ListZombieCommand("LISTZOMBIE", "Lista los zombies", "Lista los zombies")
			};

	public CommandParser() 
	{
		this.numComandos = 8;
		CommandParser.availableCommands = new Command[this.numComandos];
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
		else if(availableCommands[6].parse(commandWords, controller) != null)
		{
			return availableCommands[6];
		}
		else if(availableCommands[7].parse(commandWords, controller) != null)
		{
			return availableCommands[7];
		}
		else if(availableCommands[8].parse(commandWords, controller) != null)
		{
			return availableCommands[8];
		}
		return null;
	}
	
	public static String commandHelp() {
		return null;
	}
}
