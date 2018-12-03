package tp.p2.Zombies;

import tp.p2.Game.Game;

public class CommonZombie extends Zombie {
	private int health;
	private String behaviour;
	private int damage;
	private int velocity;
	private int posX;
	private int posY;
	private int frecuency;
	private int cicloZom;
	private String tipoZombie;
	
	public CommonZombie(int posX, int posY)
	{
		this.health= 5;
		this.behaviour = "Avanza y come plantas";
		this.damage = 1;
		this.velocity = 1;
		this.frecuency = 2;
		this.posX = posX;
		this.posY = posY;
		this.tipoZombie = "Z";
	}


	public CommonZombie() {
		this.health= 5;
		this.behaviour = "Avanza y come plantas";
		this.damage = 1;
		this.velocity = 1;
		this.frecuency = 2;
		this.tipoZombie = "Z";
	}
	public Zombie parse(int zombie) {
		if(zombie == 0)
			return this;
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
	
	
	
	
	
	
	//Getters and Setters
	public int getCicloZom() {
		return this.cicloZom;
	}


	public void setCicloZom(int ciclo) {
		this.cicloZom = ciclo;
	}


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


	public String getTipoZombie() {
		return tipoZombie;
	}


	public void setTipoZombie(String tipoZombie) {
		this.tipoZombie = tipoZombie;
	}

	
}
