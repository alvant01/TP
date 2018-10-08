package tp.p1.Plants;


public class Sunflower 
{
	
	private int health;
	private int cost;
	private String behaviour;
	private int damage;
	private int frecuency;
	private int posX;
	private int posY;
	
	public Sunflower()
	{
		this.health= 1;
		this.cost = 20;
		this.behaviour = "Genera soles";
		this.damage = 0;
		this.frecuency = 2;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
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


	public int getFrecuency() {
		return frecuency;
	}


	public void setFrecuency(int frecuency) {
		this.frecuency = frecuency;
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
	
}
