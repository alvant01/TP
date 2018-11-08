package tp.p2.Factory;

import tp.p2.Plants.*;

public class PlantFactory {
	
	//modificar
	public Plant creaPlanta(String planta, int posX, int posY){
		
		if (planta.toLowerCase().equals("n")){
			return new Nuez(posX, posY);
		}
		
		else if (planta.toLowerCase().equals("p")){
			return new PeaShooter(posX, posY);
		}
		
		else if (planta.toLowerCase().equals("c")){
			return new Petacereza(posX, posY);
		}
		
		else if (planta.toLowerCase().equals("s")){
			return new Sunflower(posX, posY);
		}
		
		return null;
		
	}
	
}
