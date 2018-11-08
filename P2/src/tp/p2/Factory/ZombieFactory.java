package tp.p2.Factory;

import tp.p2.Zombies.CommonZombie;
import tp.p2.Zombies.*;

public class ZombieFactory {
	
	//Modificar
	public Zombie creaZombie(int zombie, int posX, int posY){
		
		if (zombie == 1){
			return new CommonZombie(posX, posY);
		}
		
		else if (zombie == 2){
			return new BucketZombie(posX, posY);
		}
		
		else if (zombie == 3){
			return new FastZombie(posX, posY);
		}
		
		return null;
		
	}
}
