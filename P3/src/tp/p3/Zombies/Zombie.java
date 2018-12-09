package tp.p3.Zombies;

import tp.p3.Game.Game;
import tp.p3.List.GameObject;

public abstract class Zombie extends GameObject {

	public Zombie() {
	}
	
		public abstract Zombie parse(int zombie);
		
		public abstract void updateZombie(int ciclo, Game game);

		
		public abstract void setPosX(int posX);
		
		public abstract int getPosX();
		
		public abstract int getCicloZom();


		public abstract void setCicloZom(int ciclo);


		public abstract int getHealth();


		public abstract void setHealth(int health);


		public abstract String getBehaviour();

		public abstract void setBehaviour(String behaviour);


		public abstract int getDamage();


		public abstract void setDamage(int damage);


		public abstract int getVelocity();


		public abstract void setVelocity(int velocity);


		public abstract int getPosY();


		public abstract void setPosY(int posY);


		public abstract int getFrecuency();


		public abstract void setFrecuency(int frecuency);

		public abstract String getTipoZombie();
		
		public abstract String externalise();


}
