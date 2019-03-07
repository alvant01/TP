package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class FallingToCenterGravity implements GravityLaws {

	private double fuerza;
	private double g; //gravedad
	
	public FallingToCenterGravity(){
		
		 this.fuerza = 0;
		 this.g = (-9.81);
	}
	
	@Override
	public void apply(List<Body> cuerpo) {
		
		for (int i = 0; i < cuerpo.size(); i++)
		{	
			
			AplicaAceleracion(cuerpo.get(i));
		
		}
	}
	
	public double FuerzaAplicadaSobreElObjeto(Body cuerpo){
		
		this.fuerza = (cuerpo.getMass())*(this.g); // F = m.a
		//this.fuerza = cuerpo.getAcceleration().plus(new Vector(grav));
		//this.fuerza = cuerpo.getAcceleration().scale(g);

		return this.fuerza;
	}
	
	public void AplicaAceleracion(Body cuerpo) {
		
		this.fuerza = FuerzaAplicadaSobreElObjeto(cuerpo);
		
		double fuerzaAcumulada = this.fuerza;
		double grav[] = new double[1];
		grav[0] = this.fuerza;
		
		//this.fuerza = FuerzaAplicadaSobreElObjeto(cuerpo);
		cuerpo.setAcceleration(new Vector(grav));
		
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