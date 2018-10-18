package tp.p1.Controladores;

import java.util.Scanner;

import tp.p1.Game.ContCasillas;
import tp.p1.Game.Tablero;
import tp.p1.List.PeaShooterList;
import tp.p1.List.SunflowerList;
import tp.p1.List.ZombieList;
import tp.p1.Plants.PeaShooter;
import tp.p1.Plants.Sunflower;

public class UserCommand {
	

	

	private SunflowerList sfList;
	
	private PeaShooterList psList;
	
	private ZombieList zList;
	
	
	public UserCommand(SunflowerList sfList, PeaShooterList psList, ZombieList zList)
	{
		this.sfList = sfList;
		this.psList = psList;
		this.zList = zList;
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
	public boolean reconocedor(Tablero tabl, String Command, Scanner sc, SunCoinsManager scm)
	{
		String planta;
		int posX;
		int posY;
		
		
		if (Command.toUpperCase().equals(Commands.ADD.toString()) || Command.toUpperCase().equals("A"))
		{
			planta = sc.next();
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
			}
		}
		else if(Command.toUpperCase().equals(Commands.LIST.toString()))
		{
			this.list();
		}
		else if(Command.toUpperCase().equals(Commands.NONE.toString()))
		{
			//Do nothing
		}
		else if(Command.toUpperCase().equals(Commands.HELP.toString()))
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
	public boolean ReconocedorPlanta(SunCoinsManager scm, String Planta, int posX, int posY)
	{
		if (Planta.toLowerCase().equals("sunflower") || Planta.toLowerCase().equals("s"))
		{
			if (scm.getSunCoins() < 20)
			{
				System.out.println("No tienes suficientes soles");
			}
			else
			{
				if(!this.addS(posX, posY))
					System.out.println("La posicion esta ocupada");
				else
					scm.setSunCoins(scm.getSunCoins() - 20);
					return true;
			}
		}
		
		else if(Planta.toLowerCase().equals("peashooter") || Planta.toLowerCase().equals("p"))
		{
			if (scm.getSunCoins() < 100)
			{
				System.out.println("No tienes suficientes soles");
			}
			else
			{
				if (!this.addP(posX, posY))
					System.out.println("La posicion esta ocupada");
				else
					scm.setSunCoins(scm.getSunCoins() - 100);
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
}
