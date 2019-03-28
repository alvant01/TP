package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class NewtonUniversalGravitation implements GravityLaws {

	private Vector fuerza;
	private double G;
	private Vector fuerzaAcumulada;
	
	
	
	//Se debe calcular la fuerza del eje X e Y
	
	public NewtonUniversalGravitation(){
		
		this.G = 6.67384E-11;
		this.fuerzaAcumulada = new Vector(2);
		
	}
	public void apply(List<Body> bodies) {
		for (int i = 0; i < bodies.size(); i++)
		{	
			
			Body cuerpo = bodies.get(i);
			//Calculo la fuerza total
			forceCalculator(cuerpo, bodies);
			
			cuerpo.setAcceleration(this.fuerzaAcumulada.scale(1/cuerpo.getMass()));
		}
		
	}
	
	private void forceCalculator(Body body, List<Body> bodies) {
		double f;
		Body cuerpo2;
		Vector F = new Vector(2);
		for (int i = 0; i < bodies.size(); i++)
		{	
			cuerpo2 = bodies.get(i);
			if(!body.equals(cuerpo2))
			{
				
				f = this.G * ((body.m * cuerpo2.m)/Math.pow(body.getPosition().distanceTo(cuerpo2.getPosition()), 2));
				
				Vector direction = cuerpo2.getPosition().minus(body.getPosition());
				this.fuerza = direction.direction().scale(f);
				
				F = F.plus(this.fuerza);
			}
			
			
		}
		this.fuerzaAcumulada = F;
	}
}