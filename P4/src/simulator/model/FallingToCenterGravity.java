package simulator.model;

import java.util.List;
import java.lang.Math;

import simulator.misc.Vector;

public class FallingToCenterGravity implements GravityLaws {

	private Vector fuerza;
	private double g; //gravedad
	private int dirX;
	private int dirY;
	
	public FallingToCenterGravity(){
		
		 this.g = (-9.81);
		 this.dirX = 1;
		 this.dirY = 1;
	}
	
	@Override
	public void apply(List<Body> cuerpo) {
		
		for (int i = 0; i < cuerpo.size(); i++)
		{	
			//Calculo la direccion
			forceDirection(cuerpo.get(i));
			
			//Calculo la aceleracion
			forceAceleration(cuerpo.get(i));
			
			//Calculo la fuerza
			forceCalculation(cuerpo.get(i));
			
			//Aplico Fuerza
			AplicaAceleracion(cuerpo.get(i));
		
		}
	}
	
	//private double g = (-9.81); //gravedad
	
	private void forceCalculation(Body body) {
		
		
		//F = m*a
		this.fuerza = body.getAcceleration().scale(body.getMass());
		
	}

	private void forceAceleration(Body body) {
		
		//Calculo el angulo
		double direction = Math.atan(body.getAcceleration().coordinate(0)/body.getAcceleration().coordinate(1));
		double aPos[]  = new double[2];
		
		//Calculo la acceleracion respecto a su aceleracion inicial y su grado
		//pos*(g+a)*cos(direccion)
		aPos[0] = this.dirX*((body.getAcceleration().coordinate(0) + this.g) * Math.cos(direction));
		//pos*(g+a)*sin(direccion)
		aPos[1] = this.dirY*((body.getAcceleration().coordinate(1) + this.g) * Math.sin(direction));
		
		
		body.setAcceleration(new Vector(aPos));
	}

	private void forceDirection(Body body) {
		
		if(body.getPosition().coordinate(0) < 0)
		{
			this.dirX = -1;
		}
		if(body.getPosition().coordinate(1) < 0)
		{
			this.dirY = -1;
		}
	}
	public void AplicaAceleracion(Body cuerpo) {
		
		//V = F
		cuerpo.setVelocity(this.fuerza);
	}
}