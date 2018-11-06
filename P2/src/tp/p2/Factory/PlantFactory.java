package tp.p2.Factory;

import tp.p2.Plants.*;

public class PlantFactory {
	
	//modificar
	public Plant creaPlanta(TipoPlantas planta){
		
		if (planta == TipoPlantas.Nuez){
			return new Nuez();
		}
		
		else if (planta == TipoPlantas.PeaShooter){
			return new PeaShooter();
		}
		
		else if (planta == TipoPlantas.Petacereza){
			return new Petacereza();
		}
		
		else if (planta == TipoPlantas.Sunflower){
			return new Sunflower();
		}
		
		return null;
		
	}
	
}
