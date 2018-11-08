package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;
import tp.p2.List.GameObject;

public class ListCommand extends Command {

	public ListCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.print("[S]unflower: ");
		System.out.print("   ");
		System.out.print(" Cost: " + GameObject.getPlantas()[0].getCost() + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + GameObject.getPlantas()[0].getHealth());
		System.out.print("   ");
		System.out.println(" Damage: " + GameObject.getPlantas()[0].getDamage());
		System.out.println("Descripcion: " + GameObject.getPlantas()[0].getBehaviour());
		
		System.out.print("[P]eaShooter: ");
		System.out.print("   ");
		System.out.print(" Cost: " + GameObject.getPlantas()[1].getCost() + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + GameObject.getPlantas()[1].getHealth());
		System.out.print("   ");
		System.out.println(" Damage: " + GameObject.getPlantas()[1].getDamage());
		System.out.println("Descripcion: " + GameObject.getPlantas()[1].getBehaviour());
		
		System.out.print("[N]uez: ");
		System.out.print("   ");
		System.out.print(" Cost: " + GameObject.getPlantas()[2].getCost() + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + GameObject.getPlantas()[2].getHealth());
		System.out.print("   ");
		System.out.println(" Damage: " + GameObject.getPlantas()[2].getDamage());
		System.out.println("Descripcion: " + GameObject.getPlantas()[2].getBehaviour());
		
		System.out.print("Peta[C]ereza: ");
		System.out.print("   ");
		System.out.print(" Cost: " + GameObject.getPlantas()[3].getCost() + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + GameObject.getPlantas()[3].getHealth());
		System.out.print("   ");
		System.out.println(" Damage: " + GameObject.getPlantas()[3].getDamage());
		System.out.println("Descripcion: " + GameObject.getPlantas()[3].getBehaviour());
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("list") || commandWords[0].toLowerCase().equals("l"))
			return this;
		return null;
	}

}
