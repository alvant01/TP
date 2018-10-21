package tp.p1.Interface;

import tp.p1.Game.ContCasillas;
import tp.p1.Game.Tablero;
import tp.p1.Plants.PeaShooter;
import tp.p1.Plants.Sunflower;
import tp.p1.PlantsVsZombies.PlantsVsZombies;

public class Update {
	private Tablero tabl;
	private int ciclo;
	
	private int[] cicloZ;
	
	private String RondasZ;
	
	public Update(Tablero t)
	{
		this.tabl = t;
		cicloZ = new int[20];
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
					for(int x = 0; x < pz.getTablero().getColumnas(); x++)
					{
						if (pz.getTablero().getEstadoCasilla(i, x) == ContCasillas.ZOMBIE)
						{
							pz.getzList().setZombieHP(i, x, pz.getzList().getZombieHP(i, x)-1);
							if (pz.getzList().getZombieHP(i, x) == 0)
							{
								pz.getzList().eliminar(i, x);
								this.tabl.change(ContCasillas.VACIO, i, x);
							}
						}
					}
				}
				if(this.tabl.getEstadoCasilla(i, j).toString() == "ZOMBIE" && this.ciclo%pz.getzList().getFrecuency() == 0)
				{
					if (this.tabl.getEstadoCasilla(i, j-1) == ContCasillas.PEASHOOTER)
					{
						pz.getPsList().setPlantHP(i, j-1, pz.getPsList().getPlantHP(i, j-1)-1);
						if (pz.getPsList().getPlantHP(i, j-1) == 0)
						{
							pz.getPsList().eliminar(i, j-1);
							this.tabl.change(ContCasillas.VACIO, i, j-1);
						}
					}
					else if (this.tabl.getEstadoCasilla(i, j-1)== ContCasillas.SUNFLOWER)
					{
						pz.getSfList().setPlantHP(i, j-1, pz.getSfList().getPlantHP(i, j-1)-1);
						if (pz.getSfList().getPlantHP(i, j-1) == 0)
						{
							pz.getSfList().eliminar(i, j-1);
							this.tabl.change(ContCasillas.VACIO, i, j-1);
						}
					}
					else if (this.tabl.getEstadoCasilla(i, j-1)== ContCasillas.ZOMBIE)
					{
						//do nothing
					}	
					else
					{		
						pz.getzList().avanzar(i, j);
						this.tabl.change(ContCasillas.VACIO, i, j);
						this.tabl.change(ContCasillas.ZOMBIE, i, j-1);
						if (j == 1)
						{
							pz.setFin(true);
						}
					}
				}
			}
		}
		pz.getComputerAction().Insertar(ciclo, tabl);
		
		
		
		this.ciclo++;
	}
	
}
