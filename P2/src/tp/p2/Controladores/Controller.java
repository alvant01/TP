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
		while (!game.isFinished() && !exit) {
			printGame();
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

		/*
		boolean end = false;
		this.game.InicializarZombies();
		this.game.pintarTablero();
		String comando = menuCommands();
		String com[] = comando.split(" ");
		
		while (!(com[0].toLowerCase().equals("exit")) && !(com[0].toUpperCase().equals("E")) && !end)
		{
			if (com[0].toLowerCase().equals("reset") || com[0].toUpperCase().equals("R"))
			{
				this.game.reiniciar();
				this.game.pintarTablero();
				System.out.print("Command > ");
				comando = this.in.next();
			}
			while(!this.game.reconocedorComandos(comando))
			{
				this.in.reset();
				comando = this.in.nextLine();
			}  
			this.game.updateGame();
			this.game.pintarTablero();
			if (this.game.win())
			{
				System.out.println("Player wins");
				end = true;
			}
			else if (this.game.lose())
			{
				System.out.println("Zombies win");
				end = true;
			}
			else
			{
				System.out.print("Command > ");
				this.in.reset();
				comando = this.in.nextLine();
				com = comando.split(" ");
			}	
		}*/
	}
	
	private void setNoPrintGameState() {
		// TODO Auto-generated method stub
		
	}



	public void printGame()
	{}
	
	public String menuCommands()
	{
		String comando;
		System.out.print("Command > ");
		comando = this.in.nextLine();
		//this.in.reset();
		return comando;
		
	}
	
	public Scanner getIn() {
		return in;
	}



	public void setIn(Scanner in) {
		this.in = in;
	}



	public void menuSemLevel() {
		String level;
		
		System.out.print("Nivel: ");
		level = this.in.nextLine();
		this.game.setLevel(level);
		System.out.print("Semilla?(y/n):");
		String response = this.in.nextLine().toLowerCase();
		if(response.equals("y"))
		{
			System.out.print("Semilla: ");
			this.game.setSemilla(this.in.nextInt());
		}
		else
		{
			this.game.genSemRandom();
		}
		//this.in.reset();
	}
}
