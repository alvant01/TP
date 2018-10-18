package tp.p1.Interface;

import tp.p1.Game.Tablero;
import tp.p1.Plants.PeaShooter;
import tp.p1.Plants.Sunflower;
import tp.p1.PlantsVsZombies.PlantsVsZombies;

public class Update {
	private Tablero tabl;
	private int ciclo;
	
	private int cicloZ;
	
	private String RondasZ;
	
	public Update(Tablero t)
	{
		this.tabl = t;
	}
	
	public void actualizarTablero(PlantsVsZombies pz)
	{
		Sunflower sf = new Sunflower();
		PeaShooter ps = new PeaShooter();
		for(int i = 0; i< this.tabl.getFilas(); i++)
		{
			for(int j = 0; j< this.tabl.getColumnas();j++)
			{
				if(this.tabl.getEstadoCasilla(i, j).toString() == "SUNFLOWER" && this.ciclo%sf.getFrecuency() == 0)
				{

					//pz.setSunCoins(pz.getSunCoins()+25);
					pz.getSunCoins().setSunCoins(pz.getSunCoins().getSunCoins() + 10);
				}
				else if(this.tabl.getEstadoCasilla(i, j).toString() == "PEASHOOTER" && this.ciclo%ps.getFrecuency() == 0)
				{
					//Busca un zombie el la fila, si lo encuentra llamara a una funcion de ZombieList
					//encargada de bajarle la vida o borrarlo si llega a 0
				}
				//else if reservado para la actualizacion del zombie
				pz.getComputerAction().Insertar(ciclo, tabl);
			}
		}
		
		
		
		
	}
	
}
