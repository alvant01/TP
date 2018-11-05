package tp.p2.Controladores;

import java.util.Scanner;

import tp.p2.Command.Command;
import tp.p2.Command.CommandParser;
import tp.p2.Game.Game;

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
		boolean noPrint;
		boolean exit = false;
		//game.getcAction().setZombiesRestantes(4);
		while (!game.isFinished() && !exit) {
		//	printGame();
			noPrint = false;
			System.out.print("Comando> ");
			String[] words = scanner.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParser.parseCommand(words, this);
			if (command != null) {
				command.execute(game, this);
			}
			else {
			System.err.println("Comando no reconocido");
			setNoPrintGameState();
			}
		}
	}
	
	public void setNoPrintGameState() {
		// TODO Auto-generated method stub
		
	}

	/*public String obtenerPlanta()
	{
	}*/

	public void printGame()
	{
		this.game.pintarTablero();
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
