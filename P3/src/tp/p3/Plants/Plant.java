package tp.p3.Plants;

import tp.p3.Game.Game;
import tp.p3.List.GameObject;

public abstract class Plant extends GameObject {	

	
	public abstract Plant parse(String planta);

	public abstract void update(int ciclo, Game game);
	
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

	public abstract String getTipoPlanta();
}
