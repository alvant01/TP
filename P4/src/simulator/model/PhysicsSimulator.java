package simulator.model;

public class PhysicsSimulator {
	
	//tiempoRealPorPaso es un numero de tipo double que representa el tiempo (en segundos)
	//gl es un objeto del tipo GravityLaws que representa las leyes de la gravedad que el simulador aplicara a los cuerpos
	
	public PhysicsSimulator(double tiempoRealPorPaso, GravityLaws gl ){
		try
		{
			//codigo: valor valido
		}
		catch (IllegalArgumentException exceptions)
		{
			System.out.println("Ha insertado un valor no valido o nulo");
		}
	}

	public void advance(){
		
		//aplica un paso a la simulacion
	}
	public void addBody(Body b){
		
		//anhade el cuerpo b al simulador
		
		try
		{
			
		}
		catch (IllegalArgumentException exceptions)
		{
			
		}
	}
	
	public String toString(){
		
		//devuelve un string que representa un estado del simulador
		
		return null;
		
	}
}
