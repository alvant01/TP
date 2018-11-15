package tp.p2.Controladores;

import java.util.Scanner;

import tp.p2.Command.Command;
import tp.p2.Command.CommandParser;
import tp.p2.Game.Game;
import tp.p2.Printers.*;

public class Controller {

	private Game game;
	
	private Scanner scanner;
	
	private ReleasePrinter gPrinter;
	
	public Controller(Game g)
	{
		this.game = g;
		this.scanner = new Scanner(System.in);
		this.gPrinter = new ReleasePrinter(this.game);
	}
	
	
	
	public void run()
	{
		boolean noPrint = true;
		boolean exit = false;

		while(!game.InicializarZombies())
		{
			System.out.println("Nivel erroneo");
			menuSemLevel();
			
		}
			
			
		printGame();
		while (!game.isFinished() && !exit) 
		{
			noPrint = false;
			System.out.print("Comando> ");
			String[] words = scanner.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParser.parseCommand(words, this);
			if (command != null) {
				if(command.execute(game, this))
				{
					update();
				}
			}
			else if(words[0].isEmpty())
			{
				update();
			}
			else {
				System.err.println("Comando no reconocido");
				setNoPrintGameState();
			}
			printGame();
		}
	}
	
	private void update() {
		String words[0] = "update";
		Command command = CommandParser.parseCommand(words, this);
		command.execute(game, this);
		
	}



	public void setNoPrintGameState() {
		// TODO Auto-generated method stub
		
	}

	public void printGame()
	{
		this.gPrinter.ReleasePrinter();
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
		}
		else
		{
			this.game.genSemRandom();
		}
		//this.in.reset();
	}
}
