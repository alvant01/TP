package tp.p2.Plants;

public class PeaShooter extends Plant {

	
	private int health;
	private int cost;
	private String behaviour;
	private int damage;
	private int frecuency;
	private int posX;
	private int posY;
	private int cicloI;
	
	
	public PeaShooter(int posX, int posY)
	{
		this.health= 3;
		this.cost = 50;
		this.behaviour = "Dispara  proyectiles";
		this.damage = 1;
		this.frecuency = 1;
		this.posX = posX;
		this.posY = posY;
	}
	public PeaShooter()
	{
		this.health= 3;
		this.cost = 50;
		this.behaviour = "Dispara  proyectiles";
		this.damage = 1;
		this.frecuency = 1;
	}
	
	public Plant parse(String planta) {
		if(planta.toLowerCase().equals("p") ||planta.toLowerCase().equals("peashooter"))
		{
			return this;
		}
		return null;
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
	public int getSunGenerator() {
		// Do nothing herency fault
		return 0;
	}


	@Override
	public void setSunGenerator(int sunGenerator) {
		// Do nothing herency fault
	}
	@Override
	public boolean update(int ciclo) {
		if(this.cicloI%this.frecuency - ciclo%this.frecuency == 0 && this.cicloI != ciclo)
			return true;
		return false;
	}
	
}
