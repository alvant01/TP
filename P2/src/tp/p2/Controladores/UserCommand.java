/*package tp.p2.Controladores;

import tp.p2.Game.Game;

public class UserCommand {
	

	
	private Game game;
	
	
	public UserCommand(Game g)
	{
		this.game = g;
	}
	
	
	/*public boolean reconocedor(String command)
	{
		String comUser[] = command.split(" ");

		
		
		
		if (comUser[0].toUpperCase().equals(Commands.ADD.toString()) || comUser[0].toUpperCase().equals("A") )
		{
			int posX = Integer.parseInt(comUser[2]);
			int posY = Integer.parseInt(comUser[3]);
			if (((posX >= 0) && (posX < this.game.getDraw().getNumFilas())) && ((posY >= 0) && (posY <this.game.getDraw().getNumColum())))
			{
				if (!ReconocedorPlanta(comUser[1], posX, posY))
				{
					return false;
				}
			}
			else
			{
				System.out.println("Fuera del tablero");
			}
		}
		else if(comUser[0].toUpperCase().equals(Commands.LIST.toString()))
		{
			this.list();
		}
		else if(comUser[0].toUpperCase().equals(Commands.NONE.toString()) || command.isEmpty())
		{
			//Do nothing
		}
		else if(comUser[0].toUpperCase().equals(Commands.HELP.toString()))
		{
			this.help();
		}
		else
		{
			System.out.println("Comando no reconocido");
			return false;
		}
		return true;
		
	}
	public void list()
	{
		System.out.print("[S]unflower: ");
		System.out.print(" Cost: " + this.game.getSfList().getSfAux().getCost() + " suncoins ");
		System.out.println(" Damage: " + this.game.getSfList().getSfAux().getDamage());
		
		System.out.print("[P]eaShooter: ");
		System.out.print(" Cost: " + this.game.getPsList().getPsAux().getCost() + " suncoins ");
		System.out.println(" Damage: " + this.game.getPsList().getPsAux().getDamage());
	}
	
	public void help()
	{
		System.out.println("Add <plant> <x> <y>: Adds a plant in position x, y.\r\n" + 
				"List: Prints the list of available plants.\r\n" + 
				"Reset: Starts a new game.\r\n" + 
				"Help: Prints this help message.\r\n" + 
				"Exit: Terminates the program.\r\n" + 
				"none: Skips cycle.");
	}



	public boolean ReconocedorPlanta(String Planta, int posX, int posY)
	{
		if (Planta.toLowerCase().equals("sunflower") || Planta.toLowerCase().equals("s"))
		{
			if(this.game.addSunflower(posX, posY))
			{
				return true;
			}
		}
		
		else if(Planta.toLowerCase().equals("peashooter") || Planta.toLowerCase().equals("p"))
		{
			if(this.game.addPeaShooter(posX, posY))
			{
				return true;
			}
		}
		else 
			System.out.println("No se reconoce la planta");
		
		
		return false;
	}
	public String StringToPlanta(String Planta)
	{
		String p = null;
		if(Planta.toLowerCase().equals("sunflower") || Planta.toLowerCase().equals("s"))
		{
			p = "SUNFLOWER";
		}
		else if(Planta.toLowerCase().equals("peashooter") || Planta.toLowerCase().equals("p"))
		{
			p = "PEASHOOTER";
		}
		return p;
		
	}
}*/
