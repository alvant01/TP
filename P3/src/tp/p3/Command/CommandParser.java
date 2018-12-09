package tp.p3.Command;

import tp.p3.Controladores.Controller;

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
			new LoadCommand("LOAD", "Carga la partida", "Carga la partida")
			};

	public CommandParser() 
	{
		numComandos = 10;
		CommandParser.availableCommands = new Command[numComandos];
	}
	public static Command parseCommand(String[ ] commandWords) 
	{
		for(int i = 0; i <= 10; i++)
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
