package tp.p3.Command;

import tp.p3.Controladores.Controller;
import tp.p3.Exceptions.CommandParseException;

public class CommandParser {
	private static int numComandos;
	
	private static Command[] availableCommands = {
			new AddCommand("ADD","A?ade una planta", "A?ade una planta"),
			new HelpCommand("HELP","Muestra los comandos", "Muestra los comandos"),
			new ResetCommand("RESET","Resetea", "Resetea"),
			new ExitCommand("EXIT","Sale", "Sale"),
			new ListCommand("LIST","Lista los objetos", "Lista los objetos"),
			new UpdateCommand("UPDATE","actualiza", "actualiza"),
			new PrintModeCommand("PRINTMODE", "Cambia el modo","Cambia el modo" ),
			new CatchCommand("CATCH", "Coje un sol", "Coje un sol"),
			new ListZombieCommand("LISTZOMBIE", "Lista los zombies", "Lista los zombies"),
			new SaveCommand("SAVE", "Guarda la partida", "Guarda la partida"),
			new LoadCommand("LOAD", "Carga la partida", "Carga la partida"),
			new NoneCommand("NONE", "None", "Nada")
			};

	public CommandParser() 
	{
		numComandos = 11;
		CommandParser.availableCommands = new Command[numComandos];
	}
	public static Command parseCommand(String[ ] commandWords) throws CommandParseException 
	{
		for(int i = 0; i <= 11; i++)
		{
			if (availableCommands[i].parse(commandWords) != null)
			{
				return availableCommands[i];
			}
		}
		return null;
	}
	
	public static String commandHelp() {
		return null;
	}
}
