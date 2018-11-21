package tp.p2.Command;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;


public class ListZombieCommand extends Command {

	public ListZombieCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game, Controller controller) {
		System.out.print("[Z]ombie Comun: ");
		System.out.print("   ");
		System.out.print("Speed: " + game.getZombieFrecuency(0));
		System.out.print("   ");
		System.out.print("Harm: " + game.getZombieDamage(0));
		System.out.print("   ");
		System.out.print("Life: " + game.getZombienHealth(0));
		System.out.print("   ");
		System.out.println("Descripcion: " + game.getZombieBehaviour(0));
		
		System.out.print("[Z]ombie Deportista: ");
		System.out.print("Speed: " + game.getZombieFrecuency(2));
		System.out.print("   ");
		System.out.print("Harm: " + game.getZombieDamage(2));
		System.out.print("   ");
		System.out.print("Life: " + game.getZombienHealth(2));
		System.out.print("   ");
		System.out.println("Descripcion: " + game.getZombieBehaviour(2));
		
		System.out.print("[Z]ombie Caracubo: ");
		System.out.print("Speed: " + game.getZombieFrecuency(1));
		System.out.print("   ");
		System.out.print("Harm: " + game.getZombieDamage(1));
		System.out.print("   ");
		System.out.print("Life: " + game.getZombienHealth(1));
		System.out.print("   ");
		System.out.println("Descripcion: " + game.getZombieBehaviour(1));
	
		return false;
	}

	@Override
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].toLowerCase().equals("zombielist") || commandWords[0].toLowerCase().equals("zl"))
			return this;
		return null;
	}

}
