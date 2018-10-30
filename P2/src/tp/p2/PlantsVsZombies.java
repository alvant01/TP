package tp.p2;

import tp.p2.Controladores.Controller;
import tp.p2.Game.Game;

public class PlantsVsZombies
{
	private Game gameMaster;
	private Controller controllerMaster; 
	public PlantsVsZombies()
	{
		this.gameMaster = new Game();
		this.controllerMaster = new Controller(gameMaster);
	}

	public static void main(String args[])
	{
		PlantsVsZombies pvz = new PlantsVsZombies();
		if(args.length == 1)
		{
			pvz.gameMaster.setLevel(args[0]);
		}
		else if(args.length == 2)
		{
			pvz.gameMaster.setLevel(args[0]);
			pvz.gameMaster.setSemilla(Integer.parseInt(args[1]));
		}
		else
		{
			pvz.controllerMaster.menuSemLevel();
		}
		pvz.controllerMaster.run();
	}
}