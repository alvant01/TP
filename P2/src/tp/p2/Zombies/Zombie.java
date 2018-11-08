package tp.p2.Zombies;

import tp.p2.List.GameObject;

public abstract class Zombie extends GameObject {

	public Zombie() {
	}
	
		public abstract Zombie parse(int zombie);

		
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


}
