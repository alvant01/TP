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
		
		
	}
	
	public boolean menuCommands()
	{
		String comando;
		System.out.print("Command > ");
		comando = this.in.next();
		
		while (!(comando.toLowerCase().equals("exit")) && !(comando.toUpperCase().equals("E")))
		{
			if (comando.toLowerCase().equals("reset") || comando.toUpperCase().equals("R"))
			{
				this.game.reiniciar();
				this.game.pintarTablero();
				System.out.print("Command > ");
				comando = this.in.next();
			}
			while(!this.game.reconocedorComandos(comando))
				comando = this.in.next();
			/*
			if (this.game.win())
			{
				System.out.println("Victoria");
				return true;
			}
			else if (this.fin)
			{
				System.out.println("Has Perdido");
				return true;
			}*/
			this.in.reset();
			this.game.updateGame();
			this.game.pintarTablero();
			System.out.print("Command > ");
			comando = this.in.next();
			
		}
		this.in.close();
		return false;
		
	}



	public Scanner getIn() {
		return in;
	}



	public void setIn(Scanner in) {
		this.in = in;
	}
}
