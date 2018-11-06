package tp.p2.Factory;

import tp.p2.Zombies.CommonZombie;
import tp.p2.Zombies.*;

public class ZombieFactory {
	
	//Modificar
	public Zombie creaZombie(TipoZombies zombie, int posx, int posy){
		
		if (zombie == TipoZombies.CommonZombie){
			return new CommonZombie();
		}
		
		else if (zombie == TipoZombies.Caracubo){
			return new Caracubo();
		}
		
		else if (zombie == TipoZombies.Deportista){
			return new Deportista();
		}
		
		return null;
		
	}
}
