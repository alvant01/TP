package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class PhysicsSimulator {
	
	private Body cuerpo;
	private List<Body> listBodies; //Lista de cuerpos
	private double tiempoRealPorPaso;
	private GravityLaws leyesGravedad;
	private NewtonUniversalGravitation newtonUGravitation;
	private FallingToCenterGravity fallingTCenter;
	private NoGravity nGavity;
	
	
	//tiempoRealPorPaso es un numero de tipo double que representa el tiempo (en segundos)
	//gl es un objeto del tipo GravityLaws que representa las leyes de la gravedad que el simulador aplicara a los cuerpos
	
	
	//Constructora que recibe los siguientes parametros, si alguno de los parametros no es valido o es nulo
	// se debe de lanzar una excepcion
	
	public PhysicsSimulator(double tiempoRealPorPaso, GravityLaws leyesGravedad ) throws IllegalArgumentException{
		
		/*NewtonUniversalGravitation newtonUGravitation = null;
		FallingToCenterGravity fallingTCenter = null;
		NoGravity nGavity = null;*/
		
		this.tiempoRealPorPaso = tiempoRealPorPaso;
		this.leyesGravedad = leyesGravedad;
		
		try
		{
			this.tiempoRealPorPaso = tiempoRealPorPaso;
		//	cuerpo.move(this.tiempoRealPorPaso);  Que cuerpo mueve? es un constructor
			//this.leyesGravedad = leyesGravedad;
			
			/*
			Vector vel = null;
			Vector acc = null;
			Body bo = new Body(vel, vel, acc, tiempoRealPorPaso);
			
			bo.move(tiempoRealPorPaso);
			*/
			

			
			//codigo: valor valido
		}
		catch (IllegalArgumentException exceptions)
		{
			//throw new IllegalArgumentException();
			System.out.println("Ha insertado un valor no valido");
		}
		
		
		try
		{
			this.leyesGravedad = leyesGravedad;
			
			/*
			Vector vel = null;
			Vector acc = null;
			Body bo = new Body(vel, vel, acc, tiempoRealPorPaso);
			
			bo.move(tiempoRealPorPaso);
			*/
			
			//bo.move(tiempoRealPorPaso);
			
			//codigo: valor valido
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
		
		/*
		NewtonUniversalGravitation newtonUGravitation = null;
		FallingToCenterGravity fallingTCenter = null;
		NoGravity nGavity = null;
		*/
		
		newtonUGravitation.apply(this.listBodies);
		fallingTCenter.apply(this.listBodies);
		nGavity.apply(this.listBodies);
		
		//double tiempoRealPorPaso = 0;
		//cuerpo.move(this.tiempoRealPorPaso);
		
		for (int i = 0; i < this.listBodies.size(); i++){
			
			this.listBodies.get(i).move(this.tiempoRealPorPaso);
		}
		

		
	}
	public void addBody(Body cuerpob){
		
		//anhade el cuerpo b al simulador
		
		
		try
		{
			for (int i = 0; i < listBodies.size(); i++){
			
				if (!(listBodies.get(i).equals(cuerpob))){
					//anhade el objeto
					listBodies.add(cuerpob);
				}
				else {
					//throw exception;
					System.out.println("El objeto introducido ya se encuentra, intenta añadiendo otro objeto");
				}
			}
			
			//llama a la factoria para crear un nuevo body
			
			
		}
		catch (IllegalArgumentException exceptions)
		{
			System.out.println("El objeto ya se encuentra en el simulador");
		}
	}
	
	@Override
	public String toString() {
		return "PhysicsSimulator [cuerpo=" + this.cuerpo + ", lista de cuerpos=" + this.listBodies
				+ ", tiempoRealPorPaso=" + this.tiempoRealPorPaso
				+ ", leyesGravedad=" + this.leyesGravedad + ", newtonUGravitation="
				+ newtonUGravitation + ", fallingTCenter=" + fallingTCenter
				+ ", nGavity=" + nGavity + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public String toString2() {
		return "Time: " + this.tiempoRealPorPaso + ", bodies: [" + listBodies + "]";
		
	}
}

// 4 gatos
//bringmebackhansolo
//pirar
//kafka
//principito boa y elefante