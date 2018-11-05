package tp.p2.Plants;

public abstract class Plant extends GameObject {

	
	private int health;
	private int cost;
	private String behaviour;
	private int damage;
	private int frecuency;
	private int posX;
	private int posY;
	private int cicloI;
	
	
	public Plant() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Plant parse(String planta);

}
