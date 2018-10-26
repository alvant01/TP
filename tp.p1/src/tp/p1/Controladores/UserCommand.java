package tp.p1.Controladores;

import tp.p1.PlantsVsZombies.Game;

public class UserCommand {
	

	
	private Game game;
	
	
	public UserCommand(Game g)
	{
		this.game = g;
	}
	
	
	public boolean addS(int posX, int posY)
	{
		if (this.sfList.contains(posX, posY) || this.psList.contains(posX, posY) || this.zList.contains(posX, posY))
			return false;
		
		this.sfList.insert(posX, posY);
		return true;
	}
	public boolean addP(int posX, int posY)
	{
		if (this.sfList.contains(posX, posY) || this.psList.contains(posX, posY) || this.zList.contains(posX, posY))
			return false;
		
		psList.insert(posX, posY);
		return true;
	}
	
	public void list()
	{
		Sunflower sf = new Sunflower();
		PeaShooter ps = new PeaShooter();
		System.out.print("[S]unflower: ");
		System.out.print(" Cost: " + sf.getCost() + " suncoins ");
		System.out.println(" Damage: " + sf.getDamage());
		
		System.out.print("[P]eaShooter: ");
		System.out.print(" Cost: " + ps.getCost() + " suncoins ");
		System.out.println(" Damage: " + ps.getDamage());
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
	public boolean reconocedor(String command)
	{
		String planta;
		String comUser[] = command.split(" ");
		int posX = Integer.parseInt(comUser[2]);
		int posY = Integer.parseInt(comUser[3]);
		
		
		
		if (comUser[0].toUpperCase().equals(Commands.ADD.toString()) || comUser[0].toUpperCase().equals("A"))
		{
			if (((posX >= 0) && (posX < this.game.getDraw().getNumFilas())) && ((posY >= 0) && (posY <this.game.getDraw().getNumColum())))
			{
				if (!ReconocedorPlanta(comUser[1], posX, posY))
				{
					return false;
				}
			}
			/*planta = sc.next();
			posX = sc.nextInt();
			posY = sc.nextInt();
			if (((posX >= 0) && (posX < tabl.getFilas())) && ((posY >= 0) && (posY < tabl.getColumnas())))
			{
				planta = StringToPlanta(planta);
				
				//Comprobar monedas
				if (!ReconocedorPlanta(scm,planta, posX, posY))
				{
					return false;
				}
				tabl.change(ContCasillas.valueOf(planta), posX, posY);
			}
			else
			{
				System.out.println("Fuera del tablero");
				return false;
			}*/
		}
		else if(comUser[1].toUpperCase().equals(Commands.LIST.toString()))
		{
			this.list();
		}
		else if(comUser[1].toUpperCase().equals(Commands.NONE.toString()))
		{
			//Do nothing
		}
		else if(comUser[1].toUpperCase().equals(Commands.HELP.toString()))
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
			if (scm.getSunCoins() < 50)
			{
				System.out.println("No tienes suficientes soles");
			}
			else
			{
				if (!this.addP(posX, posY))
					System.out.println("La posicion esta ocupada");
				else
				{
					scm.setSunCoins(scm.getSunCoins() - 100);
					return true;
				}
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
}
