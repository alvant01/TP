package tp.p2.Plants;

public class GameObject {
	
	public static Plant[] plantas = {
			new PeaShooter(),
			new Sunflower(),
	};
	public GameObject() {
		
	}
	public void setPosX(int posX) {
	}
	public void setCicloI(int ciclo) {
	}
	public GameObject parsePlant(String planta) {
		if(plantas[0].parse(planta) != null)
		{
			return plantas[0];
		}
		else if (plantas[1].parse(planta) != null)
		{
			return plantas[1];
		}
		return null;
	}

}
