package tp.p2.Plants;

import tp.p2.List.GameObject;

public abstract class Plant extends GameObject {	
	
	private int health;
	private int cost;
	private String behaviour;
	private int damage;
	private int frecuency;
	private int posX;
	private int posY;
	private int cicloI;
	private int sunGenerator;

	public Plant() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Plant parse(String planta);

	public boolean update(int ciclo)
	{
		if(this.cicloI%this.frecuency - ciclo%this.frecuency == 0 && this.cicloI != ciclo)
			return true;
		return false;
	}
	
	public abstract void setPosX(int posX);
	
	public abstract int getPosX();
	
	public abstract int getHealth();


	public abstract void setHealth(int health);


	public abstract int getCost();


	public abstract void setCost(int cost);


	public abstract String getBehaviour();


	public abstract void setBehaviour(String behaviour);


	public abstract int getDamage();


	public abstract void setDamage(int damage);


	public abstract int getFrecuency();


	public abstract void setFrecuency(int frecuency);

	
	public abstract int getPosY();


	public abstract void setPosY(int posY);


	public abstract int getCicloI();


	public abstract void setCicloI(int cicloI);

	
	public abstract int getSunGenerator();


	public abstract void setSunGenerator(int sunGenerator);
}
