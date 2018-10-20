package tp.p1.Interface;

import tp.p1.Game.Tablero;
import tp.p1.Plants.PeaShooter;
import tp.p1.Plants.Sunflower;
import tp.p1.PlantsVsZombies.PlantsVsZombies;
import tp.p1.Zombies.CommonZombie;

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
		CommonZombie zo = new CommonZombie();
		
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
				else if(this.tabl.getEstadoCasilla(i, j).toString() == "ZOMBIE" && this.ciclo%zo.getFrecuency() == 0){
					
					//Revisa si tiene una SF por delante y la elimina, luego avanza
					if (this.tabl.getEstadoCasilla(i, j - 1).toString() == "SUNFLOWER"){
						pz.getSfList().eliminar(i, j - 1);
						zo.setPosX(zo.getPosX()-1);
						zo.setPosY(zo.getPosY()-1);
					}
					//Revisa si tiene un PS por delante, le baja vida, si su vida llega a 0 lo elimina
					else if (this.tabl.getEstadoCasilla(i, j - 1).toString() == "PEASHOOTER"){
						//ERROR
						//pz.getPsList().setHealth(pz.getPsList().getPlantHP(i, j-1)-1);
						if (pz.getPsList().getPlantHP(i, j - 1) == 0){
							zo.setPosX(zo.getPosX()-1);
							zo.setPosY(zo.getPosY()-1);
						}
					}
					//Si no tiene nada por delante, avanza
					else if (this.tabl.getEstadoCasilla(i, j - 1).toString() == null){
						zo.setPosX(zo.getPosX()-1);
						zo.setPosY(zo.getPosY()-1);
					}
				}
			}
		}
		
		pz.getComputerAction().Insertar(ciclo, tabl);
		int zombiesPorSalir;
		zombiesPorSalir = pz.getComputerAction().Insertar(ciclo, tabl);
		System.out.print("Faltan por salir: " + zombiesPorSalir + " Zombies " + "...Soles: ");
		
		ciclo++;
		
	}
}
