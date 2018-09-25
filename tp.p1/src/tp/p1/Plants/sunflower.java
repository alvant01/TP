package tp.p1.Plants;

import java.lang.*;

public class sunflower 
{
	
	private int health;
	private int cost;
	private String behaviour;
	private int damage;
	private int frecuency;
	
	
	public sunflower()
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
	
}
