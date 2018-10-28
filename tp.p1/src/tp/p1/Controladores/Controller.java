package tp.p1.Controladores;

import java.util.Scanner;

import tp.p1.PlantsVsZombies.Game;

public class Controller {

	private Game game;
	
	private Scanner in;
	
	public Controller(Game g)
	{
		this.game = g;
		this.in = new Scanner(System.in);
	}
	
	
	
	public void run()
	{
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
				System.out.println("Victoria");
				end = true;
			}
			else if (this.game.lose())
			{
				System.out.println("Has Perdido");
				end = true;
			}
			else
			{
				System.out.print("Command > ");
				this.in.reset();
				comando = this.in.nextLine();
				com = comando.split(" ");
			}	
		}
	}
	
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
