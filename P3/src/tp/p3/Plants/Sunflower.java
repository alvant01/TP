package tp.p3.Plants;

import tp.p3.Game.Game;

public class Sunflower extends Plant
{
	
	private int health;
	private int cost;
	private String behaviour;
	private int damage;
	private int frecuency;
	private int posX;
	private int posY;
	private int cicloI;
	private int sunGenerator;
	private String tipoPlanta;
	
	public Sunflower(int posX, int posY)
	{
		this.health= 1;
		this.cost = 20;
		this.behaviour = "Genera soles";
		this.damage = 0;
		this.frecuency = 2;
		this.sunGenerator = 10;
		this.posX = posX;
		this.posY = posY;
		this.tipoPlanta = "S";
	}
	public Sunflower()
	{
		this.health= 1;
		this.cost = 20;
		this.behaviour = "Genera soles";
		this.damage = 0;
		this.frecuency = 2;
		this.sunGenerator = 10;
		this.tipoPlanta = "S";
	}
	
	public Plant parse(String planta) {
		if(planta.toLowerCase().equals("s") ||planta.toLowerCase().equals("sunflower"))
		{
			return new Sunflower();
		}
		return null;
	}
	
	public void update(int ciclo, Game game)
	{
		if(this.cicloI%this.frecuency - ciclo%this.frecuency == 0 && this.cicloI != ciclo)
			game.addSun(this.posX, this.posY);
	}
	
	public String externalise() {
		String cadena;
		cadena = this.tipoPlanta;
		cadena += ':';
		cadena += this.health;
		cadena += ":";
		cadena += this.posX;
		cadena += ":";
		cadena += this.posY;
		cadena += ":";
		cadena += this.cicloI;
		
		return cadena;
	}
	
	
	
	//Getters and Setters
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


	public int getSunGenerator() {
		return sunGenerator;
	}


	public void setSunGenerator(int sunGenerator) {
		this.sunGenerator = sunGenerator;
	}
	public String getTipoPlanta() {
		return tipoPlanta;
	}
}
