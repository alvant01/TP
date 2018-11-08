package tp.p2.List;

import tp.p2.Plants.*;
import tp.p2.Zombies.*;

public class GameObject {
	
	public static Plant[] plantas = {
			new Sunflower(),
			new PeaShooter(),
			new Nuez(),
			new Petacereza(),
	};
	
	public static Zombie[] zombies = {
			new CommonZombie(),
			new BucketZombie(),
			new FastZombie(),
	};
	private Plant planta;
	private Zombie zombie;
	//private GameObject o;
	
	public GameObject() {
		this.planta = null;
	}
	public void setPosX(int posX) { 
		this.planta.setPosX(posX);
	}
	public int getPosX()
	{
		if(this.planta != null)
			return this.planta.getPosX();
		else
			return this.zombie.getPosX();
	}
	public void setCicloI(int ciclo) {
	}
	public GameObject parseZombie(int zombie)
	{
		if(zombies[0].parse(zombie) != null)
		{
			this.zombie = zombies[0];
			return zombies[0];
		}
		return null;
	}
	
	public GameObject parsePlant(String planta) {
		if(plantas[0].parse(planta) != null)
		{
			this.planta = plantas[0];
			return plantas[0];
		}
		else if (plantas[1].parse(planta) != null)
		{
			this.planta = plantas[1];
			return plantas[1];
		}
		return null;
	}
	public static Plant[] getPlantas() {
		return plantas;
	}
	public static void setPlantas(Plant[] plantas) {
		GameObject.plantas = plantas;
	}
	public int getPosY() {
		if(planta != null)
			return planta.getPosY();
		else
			return zombie.getPosY();
	}
}
