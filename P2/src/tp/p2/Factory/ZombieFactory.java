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
	
	
private GameObject gObject;
	
	public ZombieFactory(GameObject o)
	{
		this.gObject = o;
	}
	
	//Modificar
	public GameObject creaZombie(int zombie, int posX, int posY){

		return parseZombie(zombie, posX, posY);
	}
	
	public GameObject parseZombie(int zombie, int posX, int posY)
	{
		GameObject obj = new GameObject();
		if(zombies[0].parse(zombie) != null)
		{
			obj.setZombie(new CommonZombie(posX, posY));
			return obj;
		}
		else if(zombies[1].parse(zombie) != null)
		{
			obj.setZombie(new BucketZombie(posX, posY));
			return obj;
		}
		else if(zombies[2].parse(zombie) != null)
		{
			obj.setZombie(new FastZombie(posX, posY));
			return obj;
		}
		return null;
	}
}
