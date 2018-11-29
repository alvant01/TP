package tp.p2.Plants;

import tp.p2.Game.Game;

public class Nuez extends Plant {

	private int health;
	private int cost;
	private String behaviour;
	private int damage;
	private int frecuency;
	private int posX;
	private int posY;
	private int cicloI;
	private String tipoPlanta;
	
	public Nuez(int posX, int posY) {
		this.health = 10;
		this.cost = 50;
		this.behaviour = "Planta resistente ideal para proteger";
		this.damage = 0;
		this.frecuency = 0;
		this.posX = posX;
		this.posY = posY;
		this.tipoPlanta = "N";
	}

	
	public Nuez() {
		this.health = 10;
		this.cost = 50;
		this.behaviour = "Planta resistente ideal para proteger";
		this.damage = 0;
		this.frecuency = 0;
		this.tipoPlanta = "N";
	}
	@Override
	public Plant parse(String planta) {
		if(planta.toLowerCase().equals("n")|| planta.toLowerCase().equals("nuez"))
				return this;
		return null;
	}
	public void update(int ciclo, Game game) {
		//do nothing
	}
	
	
	
	
	
	
	//Getters y Setters


	@Override
	public int getSunGenerator() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSunGenerator(int sunGenerator) {
		// TODO Auto-generated method stub
		
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

	public int getCicloI() {
		return cicloI;
	}

	public void setCicloI(int cicloI) {
		this.cicloI = cicloI;
	}


	@Override
	public String getTipoPlanta() {
		return this.tipoPlanta;
	}


}
