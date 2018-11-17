package tp.p2.Factory;

import tp.p2.List.GameObject;
import tp.p2.Plants.*;

public class PlantFactory {
	
	private GameObject gObject;
	
	public static Plant[] plantas = {
			new Sunflower(),
			new PeaShooter(),
			new Nuez(),
			new Petacereza(),
	};
	
	//private Plant planta;
	
	
	public PlantFactory(GameObject o)
	{
		this.gObject = o;
	}
	//modificar
	public GameObject creaPlanta(String planta, int posX, int posY){

		//this.gObject = new GameObject(posX, posY);
		return parsePlant(planta, posX, posY);
		
	}
	public GameObject parsePlant(String planta, int posX, int posY) {
		GameObject obj = new GameObject();
		//GameObject obj2 = new GameObject();
		if(plantas[0].parse(planta) != null)
		{
			obj.setPlanta(new Sunflower(posX, posY));
			//obj.setPlanta(plantas[0]);
			//obj.setPosX(posX);
			//obj.setPosY(posY);
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
		}
		return null;
	}
	public GameObject getgObject() {
		return gObject;
	}
	public void setgObject(GameObject gObject) {
		this.gObject = gObject;
	}
	public static Plant[] getPlantas() {
		return plantas;
	}
	public static void setPlantas(Plant[] plantas) {
		PlantFactory.plantas = plantas;
	}
}
