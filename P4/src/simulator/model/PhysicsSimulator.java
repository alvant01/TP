package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class PhysicsSimulator {
	
	private List<Body> listBodies; //Lista de cuerpos
	private double tiempoRealPorPaso;
	private GravityLaws leyesGravedad;
	private double tiempoActual;
	
	
	//tiempoRealPorPaso es un numero de tipo double que representa el tiempo (en segundos)
	//gl es un objeto del tipo GravityLaws que representa las leyes de la gravedad que el simulador aplicara a los cuerpos
	
	
	//Constructora que recibe los siguientes parametros, si alguno de los parametros no es valido o es nulo
	// se debe de lanzar una excepcion
	
	public PhysicsSimulator(double tiempoRealPorPaso, GravityLaws leyesGravedad ) throws IllegalArgumentException{
		this.tiempoActual = 0.0;
		this.tiempoRealPorPaso = tiempoRealPorPaso;
		this.leyesGravedad = leyesGravedad;
		this.listBodies = new ArrayList<Body>();
		try
		{
			this.tiempoRealPorPaso = tiempoRealPorPaso;			
		}
		catch (IllegalArgumentException exceptions)
		{
			//throw new IllegalArgumentException();
			System.out.println("Ha insertado un valor no valido");
		}
		
		
		try
		{
			this.leyesGravedad = leyesGravedad;
		}
		catch (IllegalArgumentException exceptions)
		{
			System.out.println("Ha insertado un valor no valido o nulo");
		}
	}
	
	//Lista de Objetos
	//private List<Body> listbo;

	public void advance(){
		
		//aplica un paso a la simulacion
		

		
		this.leyesGravedad.apply(this.listBodies);
		
		for (int i = 0; i < this.listBodies.size(); i++){
			this.listBodies.get(i).move(this.tiempoRealPorPaso);
		}
		
		this.tiempoActual += this.tiempoRealPorPaso;
	}
	public void addBody(Body cuerpob){
		
		//a�ade el cuerpo b al simulador
		try
		{
			if(this.listBodies.isEmpty())
			{
				listBodies.add(cuerpob);
			}
			else
			{
				this.listBodies.add(cuerpob);
			}
		}
		catch (IllegalArgumentException exceptions)
		{
			System.out.println("El objeto ya se encuentra en el simulador");
		}
	}
	public String toString2() {
		return "{ \"time\": " + this.tiempoActual + ", \"bodies\": " + listBodies.toString() + "}";
		
	}
}

// 4 gatos
//bringmebackhansolo
//pirar
//kafka
//principito boa y elefante