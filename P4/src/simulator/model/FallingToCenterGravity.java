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
		
		 this.g = -9.81;
		 this.dirX = 1;
		 this.dirY = 1;
	}
	
	@Override
	public void apply(List<Body> cuerpo) {
		
		for (int i = 0; i < cuerpo.size(); i++)
		{	
			if(!AlreadyCenter(cuerpo.get(i)))
			{
				//Calculo la direccion
				forceDirection(cuerpo.get(i));
				
				//Calculo la aceleracion
				forceAceleration(cuerpo.get(i));
				
				//Calculo la fuerza
				//forceCalculation(cuerpo.get(i));
				
				//Aplico Fuerza
				AplicaAceleracion(cuerpo.get(i));
			}
			else
			{
				cuerpo.get(i).setAcceleration(new Vector(2));
				AplicaAceleracion(cuerpo.get(i));
			}
		}
	}
	
	//private double g = (-9.81); //gravedad
	
	private boolean AlreadyCenter(Body body) {
		
		Vector vacio = new Vector(2);
		


		if(body.getPosition().distanceTo(vacio) == 0)
		{
			System.out.println("Hola");
			return true;
		}
		return false;
	}

	private void forceCalculation(Body body) {
		//F = m*a
		this.fuerza = body.getAcceleration().scale(body.getMass());
		
	}

	private void forceAceleration(Body body) {
		
		//Calculo el angulo
		double angulo = Math.atan(body.getPosition().coordinate(0)/body.getPosition().coordinate(1));
		double aPos[]  = new double[2];
		double anguloX;
		double anguloY;
		
		if(body.getPosition().coordinate(0) == 0)
			anguloX = 0;
		else
			anguloX = Math.cos(0);
		if(body.getPosition().coordinate(1) == 0)
			anguloY = 0;
		else
			anguloY = Math.cos(angulo);
		
		double angulo2 = Math.atan(3/3);
		double p = Math.cos(angulo2);
		
		if (Double.isNaN(angulo))
			angulo  =0.0;
		//Calculo la acceleracion respecto a su aceleracion inicial y su grado
		//pos*(g+a)*cos(direccion)
		double b = Math.toRadians(Math.PI/2);
		double o = Math.cos(Math.toRadians(Math.PI/2));
		double y = Math.cos(Math.PI/2);
		aPos[0] = this.dirX*((this.g) * anguloX);
		//pos*(g+a)*sin(direccion)
		aPos[1] = this.dirY*((this.g) * anguloY);
		
		
		body.setAcceleration(new Vector(aPos));
	}

	private void forceDirection(Body body) {
		
		if(body.getPosition().coordinate(0) < 0)
			this.dirX = -1;
		else
			this.dirX = 1;
		if(body.getPosition().coordinate(1) < 0)
			this.dirY = -1;
		else
			this.dirY = 1;
	}
	public void AplicaAceleracion(Body cuerpo) {
		
		//V = F
		cuerpo.setVelocity(cuerpo.getAcceleration());
	}
}