package tp.p2.List;

import tp.p2.Controladores.SunCoinsManager;
import tp.p2.Plants.*;
import tp.p2.Zombies.*;

public class GameObject {
	private static int posX;
	private static int posY;
	
	private Plant planta;
	private Zombie zombie;
	//private GameObject o;
	
	public GameObject() {
	}
	public GameObject(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	public void setPosX(int posX) { 
		if(this.planta != null)
			this.planta.setPosX(posX);
		else
			this.zombie.setPosX(posX);
	}
	public int getPosX()
	{
		if(this.planta != null)
			return this.planta.getPosX();
		else
			return this.zombie.getPosX();
	}
	public void setCicloI(int ciclo) {
		if(this.planta != null)
			this.planta.setCicloI(ciclo);
		else
			this.zombie.setCicloZom(ciclo);
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
		if(this.planta.update(ciclo))
			scm.addSunCoins(planta.getSunGenerator());
	}
	public boolean updatePlant(int ciclo)
	{
		if(this.planta.update(ciclo))
			return true;
		return false;
	}
	public boolean updateZombie(int ciclos) {
		return this.zombie.updateZombie(ciclos);
	}
	private void damageZombie() {
		
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
	public String getString() {
		if (this.isPlant()){
			return " " + this.planta.getTipoPlanta() + "[" + this.planta.getHealth() + "]";
		}
		else{
			return this.zombie.getTipoZombie() + "[" + this.zombie.getHealth() + "]";
		}
 		
	}
	public int getCost() {
		return this.planta.getCost();
	}
}
