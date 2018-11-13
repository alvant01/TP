package tp.p2.List;

import tp.p2.Controladores.SunCoinsManager;
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
			return this;
		}
		else if(zombies[1].parse(zombie) != null)
		{
			this.zombie = zombies[1];
			return this;
		}
		else if(zombies[2].parse(zombie) != null)
		{
			this.zombie = zombies[2];
			return this;
		}
		return null;
	}
	
	public GameObject parsePlant(String planta) {
		if(plantas[0].parse(planta) != null)
		{
			this.planta = plantas[0];
			return this;
		}
		else if (plantas[1].parse(planta) != null)
		{
			this.planta = plantas[1];
			return this;
		}
		else if (plantas[2].parse(planta) != null)
		{
			this.planta = plantas[2];
			return this;
		}
		else if (plantas[3].parse(planta) != null)
		{
			this.planta = plantas[3];
			return this;
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
	public void setPosY(int posY) {
		if(planta != null)
			planta.setPosY(posY);
		else
			zombie.setPosY(posY);
	}
	public int getHealth() {
		if(planta != null)
			return planta.getHealth();
		else
			return zombie.getHealth();
	}

	public int getDamage() {
		if(planta != null)
			return planta.getDamage();
		else
			return zombie.getDamage();
	}
	public void damage(int damage) {
		if(planta != null)
			planta.setHealth(planta.getHealth()-damage);
		else
			zombie.setHealth(planta.getHealth()-damage);
		
	}
	public void updateSunflower(SunCoinsManager scm, int ciclo) {
		if(planta.update(ciclo))
			scm.addSunCoins(planta.getSunGenerator());
	}
	public boolean updateZombie(int ciclos) {
		return this.zombie.updateZombie(ciclos);
	}
	private void damageZombie() {
		
	}
	public static Zombie[] getZombies() {
		return zombies;
	}
	public static void setZombies(Zombie[] zombies) {
		GameObject.zombies = zombies;
	}
	public Plant getPlanta() {
		return planta;
	}
	public void setPlanta(Plant planta) {
		this.planta = planta;
	}
	public Zombie getZombie() {
		return zombie;
	}
	public void setZombie(Zombie zombie) {
		this.zombie = zombie;
	}
	public boolean isPlant() {
		return this.planta != null;
	}
	public boolean isZombie() {
		return this.zombie != null;
	}
}
