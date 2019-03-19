package simulator.model;

import java.util.ArrayList;
import java.util.List;

import simulator.misc.Vector;

public class NewtonUniversalGravitation implements GravityLaws {

	private Vector fuerza;
	private double G;
	private double distancia;
	private Vector fuerzaAcumulada;
	private int dirX;
	private int dirY;
	
	
	
	//Se debe calcular la fuerza del eje X e Y
	
	public NewtonUniversalGravitation(){
		

		this.fuerza = new Vector(2);
		this.G = 6.67384E-11;
		this.distancia = 0;
		this.fuerzaAcumulada = new Vector(2);
		
	}
	//Considero que la gravitacion universal solo puede darsse entre dos cuepros
	@Override
	public void apply(List<Body> bodies) {
		for (int i = 0; i < bodies.size(); i++)
		{	
			this.fuerzaAcumulada = new Vector(2);
			//Calculo la fuerza total
			forceCalculator(bodies.get(i), bodies);
			this.fuerzaAcumulada = this.fuerzaAcumulada.plus(this.fuerza);
			bodies.get(i).setAcceleration(fuerzaAcumulada.scale(1/bodies.get(i).getMass()));
		}
		
	}
	
	private void forceCalculator(Body body, List<Body> bodies) {
		for (int i = 0; i < bodies.size(); i++)
		{	
			if(!body.equals(bodies.get(i)))
			{
				this.fuerza = new Vector(2);
				if(!dontMove(body,bodies.get(i)))
				{
					//Calculo la direccion
					forceDirection(body,bodies.get(i));
					//Calcular distancia
					distanceCalculator(body, bodies.get(i));
					//Calculo la fuerza individual
					individualForceCalculator(body, bodies.get(i));
				}
			}
		}
		
	}
	private boolean dontMove(Body body, Body body2) {
		
		if(body.getPosition().coordinate(0) == 0.0 && body.getPosition().coordinate(1) == 0.0  )
			System.out.println("hola");
		if (body.getPosition().coordinate(0) == 1.0056565495183438E7)
			System.out.println("hola");
		
		if(body.getPosition().distanceTo(body2.getPosition()) == 0.0)
		{
			body.setVelocity(new Vector(2));
			body.setAcceleration(new Vector(2));
			return true;
		}
		return false;
	}
	private void forceDirection(Body body, Body body2) 
	{
		if(body.getPosition().coordinate(0) < body2.getPosition().coordinate(0))
			this.dirX = -1;
		else
			this.dirX = 1;
		if(body.getPosition().coordinate(1) < body2.getPosition().coordinate(1))
			this.dirY = -1;
		else
			this.dirY = 1;
	}
	private void distanceCalculator(Body body, Body body2) {
		this.distancia = body.getPosition().distanceTo(body2.getPosition());
	}
	private void individualForceCalculator(Body body, Body body2) {
		
		double angulo = Math.toDegrees(Math.atan((body2.getPosition().coordinate(0) - body.getPosition().coordinate(0) )/(body2.getPosition().coordinate(1) - body.getPosition().coordinate(1))));
		double aPos[]  = new double[2];
		double anguloX;
		double anguloY;
		
		
		//Correcion debido al mal calculo de los angulos
		if(body.getPosition().coordinate(0) == 0)
		{
			anguloX = 0;
			anguloY = 1;
		}
		else if(body.getPosition().coordinate(1) == 0)
		{
			anguloY = 0;
			anguloX = 1;
		}
		else
		{
			anguloY = Math.cos(angulo);
			anguloX = Math.cos(angulo);
		}
		double magnitud = body.getPosition().distanceTo(body2.getPosition());
		aPos[0] = this.dirX * this.G * ((body.getMass()* body2.getMass())/Math.pow(magnitud, 2))* anguloX;
		aPos[1] = this.dirY * this.G * ((body.getMass()* body2.getMass())/Math.pow(magnitud, 2))*anguloY;
		
		this.fuerza = new Vector(aPos);
	}
	public String toString()
	{
		return "Dos o mas cuerpo se atraten mediante las fuerzas de la gravedad";
	}
}