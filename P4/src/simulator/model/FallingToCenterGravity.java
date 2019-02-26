package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class FallingToCenterGravity implements GravityLaws {

	private Vector fuerza;
	private double g; //gravedad
	
	public FallingToCenterGravity(){
		
		 this.fuerza = null;
		 this.g = (-9.81);
	}
	
	@Override
	public void apply(List<Body> bodies) {
		
		for (int i = 0; i < bodies.size(); i++)
		{	
			
			FuerzaAplicadaSobreElObjeto(bodies.get(i));
		
		}
	}
	
	//private double g = (-9.81); //gravedad
	
	public Vector FuerzaAplicadaSobreElObjeto(Body cuerpo){
		//Vector fuerza1;
		//Vector Origin = new Vector(0);
		
		fuerza = cuerpo.getAcceleration().scale(g);
		AplicaAceleracion(cuerpo);
		
		//fuerza1 = cuerpo.getPosition().scale(g);
		//fuerza1 = fuerza.distanceTo(Origin);
		
		return fuerza;
	}
	
	public void AplicaAceleracion(Body cuerpo) {
		
		cuerpo.setAcceleration(fuerza);
		
	}
	
	/*
	double g = -9.81;
	Vector coordenadas;
	
	public Vector cayendo (double _data[], int i, Vector d1) {
		
		coordenadas = d1.scale(g);
		
		return coordenadas;
		
	}
	*/
}