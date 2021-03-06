package tp.p2.Factory;

import tp.p2.List.GameObject;
import tp.p2.Zombies.BucketZombie;
import tp.p2.Zombies.CommonZombie;
import tp.p2.Zombies.FastZombie;
import tp.p2.Zombies.Zombie;

public class ZombieFactory {
	
	
	public static Zombie[] zombies = {
			new CommonZombie(),
			new BucketZombie(),
			new FastZombie(),
	};
	
	private int numZombies;
	public ZombieFactory()
	{
		this.numZombies = 3;
	}
	
	//Modificar
	public GameObject creaZombie(int zombie, int posX, int posY){

		return parseZombie(zombie, posX, posY);
	}
	
	public GameObject parseZombie(int zombie, int posX, int posY)
	{
		GameObject obj = null;
		
		for(int i  =0; i < this.numZombies; i++)
		{
			obj.setZombie(zombies[i].parse(zombie));
			if(obj.getPlanta() != null)
			{
				obj.setPosX(posX);
				obj.setPosY(posY);
				return obj;
			}
		}
		return null;
	}

	public static Zombie[] getZombies() {
		return zombies;
	}
	public static void setZombies(Zombie[] zombies) {
		ZombieFactory.zombies = zombies;
	}
}
