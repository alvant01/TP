package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class PhysicsSimulator {
	
	private List<Body> listBodies; //Lista de cuerpos
	private double tiempoRealPorPaso;
	private GravityLaws leyesGravedad;
	private double tiempoActual;
	
	
	private List<SimulatorObserver> listaObservadores;
	
	
	//tiempoRealPorPaso es un numero de tipo double que representa el tiempo (en segundos)
	//gl es un objeto del tipo GravityLaws que representa las leyes de la gravedad que el simulador aplicara a los cuerpos
	
	
	//Constructora que recibe los siguientes parametros, si alguno de los parametros no es valido o es nulo
	// se debe de lanzar una excepcion
	
	public PhysicsSimulator(double tiempoRealPorPaso, GravityLaws leyesGravedad ) throws IllegalArgumentException{
		this.tiempoActual = 0.0;
		this.tiempoRealPorPaso = tiempoRealPorPaso;
		this.leyesGravedad = leyesGravedad;
		this.listBodies = new ArrayList<Body>();
		this.listaObservadores = new ArrayList<SimulatorObserver>();
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
		
		for(int i = 0; i < this.listaObservadores.size(); i++)
			this.listaObservadores.get(i).onAdvance(listBodies, tiempoActual);
	}
	public void addBody(Body cuerpob){
		
		//añade el cuerpo b al simulador
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
			
			for(int i = 0; i < this.listaObservadores.size(); i++)
				this.listaObservadores.get(i).onBodyAdded(listBodies, cuerpob);
		}
		catch (IllegalArgumentException exceptions)
		{
			System.out.println("El objeto ya se encuentra en el simulador");
		}
	}
	public String toString2() {
		return "{ \"time\": " + this.tiempoActual + ", \"bodies\": " + listBodies.toString() + "}";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//P5
	
	
	public void reset()
	{
		this.listBodies.clear();
		
		this.tiempoActual = 0.0;
		
		for(int i = 0; i < this.listaObservadores.size(); i++)
			this.listaObservadores.get(i).onReset(listBodies, this.tiempoActual, this.tiempoRealPorPaso, this.leyesGravedad.toString());
	}
	public void setDeltaTime(double dt)
	{
		try
		{
			if(Double.isNaN(dt))
				throw new IllegalArgumentException();
			this.tiempoRealPorPaso = dt;
			
			for(int i = 0; i < this.listaObservadores.size(); i++)
				this.listaObservadores.get(i).onDeltaTimeChanged(this.tiempoRealPorPaso);
		}
		catch(IllegalArgumentException ex)
		{
			
		}
	}
	public void setGravityLaws(GravityLaws gravityLaws)
	{
		try
		{
			if(gravityLaws == null)
				throw new IllegalArgumentException();
			this.leyesGravedad = gravityLaws;
			
			for(int i = 0; i < this.listaObservadores.size(); i++)
				this.listaObservadores.get(i).onGravityLawChanged(gravityLaws.toString());
		}
		catch(IllegalArgumentException ex)
		{
			
		}
	}
	
	public void addObserver(SimulatorObserver o)
	{
		this.listaObservadores.add(o);
		
		o.onRegister(listBodies, tiempoActual, tiempoRealPorPaso, this.leyesGravedad.toString());
		//this.listaObservadores.onRegister(listBodies, tiempoActual, tiempoRealPorPaso, this.leyesGravedad.toString());
	}

	
	
	
	
	
	
	
	
	
	
	//Getters and setters
	public List<Body> getListBodies() {
		return listBodies;
	}

	public void setListBodies(List<Body> listBodies) {
		this.listBodies = listBodies;
	}

	public double getTiempoRealPorPaso() {
		return tiempoRealPorPaso;
	}

	public void setTiempoRealPorPaso(double tiempoRealPorPaso) {
		this.tiempoRealPorPaso = tiempoRealPorPaso;
	}

	public GravityLaws getLeyesGravedad() {
		return leyesGravedad;
	}

	public void setLeyesGravedad(GravityLaws leyesGravedad) {
		this.leyesGravedad = leyesGravedad;
	}

	public double getTiempoActual() {
		return tiempoActual;
	}

	public void setTiempoActual(double tiempoActual) {
		this.tiempoActual = tiempoActual;
	}

}

// 4 gatos
//bringmebackhansolo
//pirar
//kafka
//principito boa y elefante