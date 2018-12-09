package tp.p3.Zombies;

import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Game.Game;

public class BucketZombie extends Zombie {

	private int health;
	private String behaviour;
	private int damage;
	private int velocity;
	private int posX;
	private int posY;
	private int frecuency;
	private int cicloZom;
	private String tipoZombie;
	
	public BucketZombie(int posX, int posY) {
		this.health    	= 8;
		this.behaviour 	= "Un zombie armado. Lento pero resistente";
		this.damage 	= 1;
		this.velocity 	= 1;
		this.frecuency 	= 4;
		this.posX = posX;
		this.posY = posY;
		this.tipoZombie = "W";
	}
	public BucketZombie() {
		this.health    	= 8;
		this.behaviour 	= "Un zombie armado. Lento pero resistente";
		this.damage 	= 1;
		this.velocity 	= 1;
		this.frecuency 	= 4;
		this.tipoZombie = "W";
		}

	public Zombie parse(int zombie) {
		if(zombie == 1)
			return new BucketZombie();
		return null;
	}
	
	public void updateZombie(int ciclo, Game game)
	{	
		if(game.contains(this.posX, this.posY-1))
		{
			game.damagePlant(this.posX, this.posY, this.damage);
		}
		else
		{
			if(this.cicloZom%this.frecuency - ciclo%this.frecuency == 0 && this.cicloZom != ciclo)
				this.posY -= 1;
		}
	}
	public String externalise() {
		String cadena;
		cadena = this.tipoZombie;
		cadena += ':';
		cadena += this.health;
		cadena += ":";
		cadena += this.posX;
		cadena += ":";
		cadena += this.posY;
		cadena += ":";
		cadena += this.cicloZom;
		
		return cadena;
	}
	
	
	
	
	
	//Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(int frecuency) {
		this.frecuency = frecuency;
	}

	public int getCicloZom() {
		return cicloZom;
	}

	public void setCicloZom(int cicloZom) {
		this.cicloZom = cicloZom;
	}
	public String getTipoZombie() {
		return tipoZombie;
	}
	public void setTipoZombie(String tipoZombie) {
		this.tipoZombie = tipoZombie;
	}

}