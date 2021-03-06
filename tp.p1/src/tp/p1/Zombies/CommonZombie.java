package tp.p1.Zombies;

public class CommonZombie {
	private int health;
	private String behaviour;
	private int damage;
	private int velocity;
	private int posX;
	private int posY;
	private int frecuency;
	private int cicloZom;
	
	
	public CommonZombie()
	{
		this.health= 5;
		this.behaviour = "Avanza y come plantas";
		this.damage = 1;
		this.velocity = 1;
		this.frecuency = 2;
		
	}


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
}
