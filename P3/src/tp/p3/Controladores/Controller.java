package tp.p3.Controladores;

import java.io.IOException;
import java.util.Scanner;

import tp.p3.Command.Command;
import tp.p3.Command.CommandParser;
import tp.p3.Game.Game;
import tp.p3.Exceptions.*;

public class Controller {

	private Game game;
	
	private Scanner scanner;
	
	public Controller(Game g)
	{
		this.game = g;
		this.scanner = new Scanner(System.in);
	}
	
	
	
	public void run()
	{

		while(!game.InicializarZombies())
		{
			System.out.println("Nivel erroneo");
			menuSemLevel();
			
		}			
	
		game.printGame();
		
		this.game.getScm().addSunCoins(100000); //Debug
		while (!game.isFinished()){
			System.out.print("Comando> ");
			String[] words = scanner.nextLine().trim().split ("\\s+");
			try {
				Command command = CommandParser.parseCommand(words);
				if (command != null) 
				{
					if (command.execute(game))
					{
						update(words);
						game.printGame();	
					}
				} 
				else if(words[0].isEmpty())
				{
					update(words);
					this.game.updateSuns();
					this.game.setAlreadyCatch(false);
					game.printGame();
				}
				else
					throw new CommandParseException("Comando no reconocido");
				} 
			catch (CommandParseException | CommandExecuteException | IOException ex) 
			{
				System.out.format(ex.getMessage() + " %n %n");
			} catch (FileContentsException e) {
				System.out.format(e.getMessage() + " %n %n");
				//e.printStackTrace();
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
	
	private void update(String[] words) throws CommandExecuteException, IOException, FileContentsException, CommandParseException {
		words[0] = "update";
		Command command = CommandParser.parseCommand(words);
		command.execute(game);
		
	}



	public void setNoPrintGameState() {
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
}
