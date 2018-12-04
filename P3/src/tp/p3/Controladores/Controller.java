package tp.p3.Controladores;

import java.util.Scanner;

import tp.p3.Command.Command;
import tp.p3.Command.CommandParser;
import tp.p3.Game.Game;
import tp.p3.Printers.*;
import tp.p3.Exceptions.*;

public class Controller {

	private Game game;
	
	private Scanner scanner;
	
	private GamePrinter gPrinter;

	private boolean printDebug;
	
	private boolean exit;
	
	private boolean noPrint;
	
	public Controller(Game g)
	{
		this.game = g;
		this.scanner = new Scanner(System.in);
		this.gPrinter = new ReleasePrinter(this.game);
		this.exit = false;
		this.printDebug = false;
	}
	
	
	
	public void run()
	{
		boolean noPrint = true;

		while(!game.InicializarZombies())
		{
			System.out.println("Nivel erroneo");
			menuSemLevel();
			
		}			
	
		printGame();
		
		
		while (!game.isFinished()){
			System.out.print("Comando> ");
			String[] words = scanner.nextLine().trim().split ("\\s+");
			try {
				Command command = CommandParser.parseCommand(words);
				if (command != null) 
				{
					if (command.execute(game)) 
						printGame();
				} 
				else
					throw new CommandParseException("Comando no reconocido");
				} 
			catch (CommandParseException | CommandExecuteException ex) 
			{
				System.out.format(ex.getMessage() + " %n %n");
			}
		}

		/*while (!game.isFinished() && !this.exit) 
		{
			noPrint = true;
			System.out.print("Comando> ");
			String[] words = scanner.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParser.parseCommand(words, this);
			if (command != null) {
				if(command.execute(game, this))
				{
					update(words);
					this.game.updateSuns();
					noPrint = false;
					this.game.setAlreadyCatch(false);
				}
			}
			else if(words[0].isEmpty())
			{
				update(words);
				this.game.updateSuns();
				noPrint = false;
				this.game.setAlreadyCatch(false);
			}
			else {
				System.err.println("Comando no reconocido");
				//setNoPrintGameState();
			}
			if(!noPrint)
				printGame();
		}*/
	}
	
	private void update(String[] words) throws CommandExecuteException {
		words[0] = "update";
		Command command = CommandParser.parseCommand(words);
		command.execute(game);
		
	}



	public void setNoPrintGameState() {
	}

	public void printGame()
	{		
		this.gPrinter.printGame();
	}
	
	public String menuCommands()
	{
		String comando;
		System.out.print("Command > ");
		comando = this.scanner.nextLine();
		//this.in.reset();
		return comando;
		
	}
	
	public Scanner getScanner() {
		return this.scanner;
	}



	public void setScanner(Scanner in) {
		this.scanner = in;
	}



	public void menuSemLevel() {
		String level;
		
		System.out.print("Nivel: ");
		level = this.scanner.nextLine();
		this.game.setLevel(level);
		System.out.print("Semilla?(y/n):");
		String response = this.scanner.nextLine().toLowerCase();
		if(response.equals("y"))
		{
			System.out.print("Semilla: ");
			this.game.setSemilla(this.scanner.nextInt());
			this.scanner.nextLine();
		}
		else
		{
			this.game.genSemRandom();
		}
	}
	public void menuSem() {

		System.out.print("Semilla?(y/n):");
		String response = this.scanner.nextLine().toLowerCase();
		if(response.equals("y"))
		{
			System.out.print("Semilla: ");
			this.game.setSemilla(this.scanner.nextInt());
			this.scanner.nextLine();
		}
		else
		{
			this.game.genSemRandom();
		}
	}



	public void setExit(boolean exit) {
		this.exit = exit;
	}



	public void printMode() {
		if(!this.printDebug)
		{
			this.gPrinter = new DebugPrinter(this.game);
			this.printDebug =true;
		}
		else
		{
			this.gPrinter = new ReleasePrinter(this.game);
			this.printDebug =false;
		}
		
	}
}
