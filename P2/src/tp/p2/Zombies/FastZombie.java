package tp.p2.Zombies;

public class FastZombie extends Zombie {
	
	private int health;
	private String behaviour;
	private int damage;
	private int velocity;
	private int posX;
	private int posY;
	private int frecuency;
	private int cicloZom;
	private String tipoZombie;
	

	public FastZombie(int posX, int posY) {
		this.health 	= 2;
		this.behaviour 	= "Zombie mas rapido pero mas debil";
		this.damage 	= 1;
		this.velocity 	= 1;
		this.frecuency 	= 1;
		this.posX = posX;
		this.posY = posY;
		this.tipoZombie = "FZ";
	}
	public FastZombie() {
		this.health 	= 2;
		this.behaviour 	= "Zombie mas rapido pero mas debil";
		this.damage 	= 1;
		this.velocity 	= 1;
		this.frecuency 	= 1;
		this.tipoZombie = "FZ";
	}
	public Zombie parse(int zombie) {
		if(zombie == 2)
			return this;
		return null;
	}
	public boolean updateZombie(int ciclo)
	{
		if(this.cicloZom%this.frecuency - ciclo%this.frecuency == 0 && this.cicloZom != ciclo)
			return true;
		return false;
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

	public int getCicloZom() {
		return cicloZom;
	}

	public void setCicloZom(int cicloZom) {
		this.cicloZom = cicloZom;
	}

}
