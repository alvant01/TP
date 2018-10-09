package tp.p1.PlantsVsZombies;

import java.util.Scanner;

import tp.p1.Controladores.Commands;
import tp.p1.Controladores.UserCommand;
import tp.p1.List.PeaShooterList;
import tp.p1.List.SunflowerList;
import tp.p1.List.ZombieList;

public class PlantsVsZombies {

	private UserCommand uCommand;
	private PeaShooterList psList;
	private SunflowerList sfList;
	private ZombieList zList;
	
	public PlantsVsZombies()
	{
		this.psList  = new PeaShooterList();
		this.sfList = new SunflowerList();
		this.zList = new ZombieList();
		
		this.uCommand = new UserCommand(this.sfList, this.psList, this.zList);
	}
	public static void main(String args[])
	{
		
	}
	
	public void menuCommands()
	{
		String comando;
		Scanner sc = new Scanner(System.in);
		System.out.print("Command > ");
		comando = sc.nextLine();
		if (comando.toLowerCase() == "exit")
		{}
		else
			while(!this.uCommand.reconocedor(comando))
				comando = sc.nextLine();
	}
}
