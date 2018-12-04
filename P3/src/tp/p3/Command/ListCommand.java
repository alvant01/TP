package tp.p3.Command;

import tp.p3.Controladores.Controller;
import tp.p3.Game.Game;

public class ListCommand extends Command {

	public ListCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		System.out.print("[S]unflower: ");
		System.out.print("   ");
		System.out.print(" Cost: " + game.getPlantaCost(0) + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + game.getPlantaHealth(0));
		System.out.print("   ");
		System.out.println(" Damage: " + game.getPlantaDamage(0));
		System.out.println("Descripcion: " + game.getPlantaBehaviour(0));
		
		System.out.print("[P]eaShooter: ");
		System.out.print("   ");
		System.out.print(" Cost: " + game.getPlantaCost(1) + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + game.getPlantaHealth(1));
		System.out.print("   ");
		System.out.println(" Damage: " + game.getPlantaDamage(1));
		System.out.println("Descripcion: " + game.getPlantaBehaviour(1));
		
		System.out.print("[N]uez: ");
		System.out.print("   ");
		System.out.print(" Cost: " + game.getPlantaCost(2) + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + game.getPlantaHealth(2));
		System.out.print("   ");
		System.out.println(" Damage: " + game.getPlantaDamage(2));
		System.out.println("Descripcion: " + game.getPlantaBehaviour(2));
		
		System.out.print("Peta[C]ereza: ");
		System.out.print("   ");
		System.out.print(" Cost: " + game.getPlantaCost(3) + " suncoins ");
		System.out.print("   ");
		System.out.print("Health: " + game.getPlantaHealth(3));
		System.out.print("   ");
		System.out.println(" Damage: " + game.getPlantaDamage(3));
		System.out.println("Descripcion: " + game.getPlantaBehaviour(3));
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].toLowerCase().equals("list") || commandWords[0].toLowerCase().equals("l"))
			return this;
		return null;
	}

}
