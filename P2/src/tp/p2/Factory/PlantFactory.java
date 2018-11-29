package tp.p2.Factory;

import tp.p2.List.GameObject;
import tp.p2.Plants.*;

public class PlantFactory {
	

	public static Plant[] plantas = {
			new Sunflower(),
			new PeaShooter(),
			new Nuez(),
			new Petacereza(),
	};
	
	
	private int numPlantas;
	public PlantFactory()
	{
		this.numPlantas = 4;
	}
	//modificar
	public GameObject creaPlanta(String planta, int posX, int posY){

		return parsePlant(planta, posX, posY);
		
	}
	public GameObject parsePlant(String planta, int posX, int posY) {
		GameObject obj = null;
		
		for(int i  =0; i < this.numPlantas; i++)
		{
			obj.setPlanta(plantas[i].parse(planta));
			if(obj.getPlanta() != null)
			{
				obj.setPosX(posX);
				obj.setPosY(posY);
				return obj;
			}
		}
	/*	if(plantas[0].parse(planta) != null)
		{
			obj.setPlanta(new Sunflower(posX, posY));
			return obj;
		}
		else if (plantas[1].parse(planta) != null)
		{
			obj.setPlanta(new PeaShooter(posX, posY));
			return obj;
		}
		else if (plantas[2].parse(planta) != null)
		{
			obj.setPlanta(new Nuez(posX, posY));
			return obj;
		}
		else if (plantas[3].parse(planta) != null)
		{
			obj.setPlanta(new Petacereza(posX, posY));
			return obj;
		}*/
		return null;
	}
	public static Plant[] getPlantas() {
		return plantas;
	}
	public static void setPlantas(Plant[] plantas) {
		PlantFactory.plantas = plantas;
	}
}
