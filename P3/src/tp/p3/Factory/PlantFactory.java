package tp.p3.Factory;

import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.List.GameObject;
import tp.p3.Plants.*;

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
	public GameObject creaPlanta(String planta, int posX, int posY) throws CommandExecuteException{

		return parsePlant(planta, posX, posY);
		
	}
	public GameObject parsePlant(String planta, int posX, int posY) throws CommandExecuteException {
		GameObject obj = new GameObject();
		
		for(int i  =0; i < this.numPlantas; i++)
		{
			//Plant p = new plantas[i].parse(planta);
			obj.setPlanta(plantas[i].parse(planta));
			if(obj.getPlanta() != null)
			{
				obj.setPosX(posX);
				obj.setPosY(posY);
				return obj;
			}
		}
		if (obj.getPlanta() == null){
			throw new CommandExecuteException("Ha introducido una planta inexistente: Utilice [L]ist para saber las plantas existentes.");
		}
		return null;
	}
	public static Plant[] getPlantas() {
		return plantas;
	}
	public static void setPlantas(Plant[] plantas) {
		PlantFactory.plantas = plantas;
	}
}
