package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class NewtonUniversalGravitation implements GravityLaws {

	private List<Body> listaBody;
	private double fuerza;
	private double G;
	private Vector aplicarAceleracion;
	private double distancia;
	private double fuerzaAcumulada;

	
	public NewtonUniversalGravitation(){
		
		List<Body> listaBody;
		double fuerza = 0;
		double G = 6.67384E-11;
		Vector aplicarAceleracion = null;
		double distancia = 0;
		double fuerzaAcumulada = 0;
		
	}
	
	@Override
	public void apply(List<Body> bodies) {
		
		for (int i = 0; i < bodies.size(); i++)
		{	
			
			AplicarAceleracion(bodies.get(i));
		
		}
	}
	
	/*
	List<Body> listaBody;

	double fuerza;
	double G = 6.67384E-11;
	*/
	
	public double FuerzaAplicada (double masa1, double masa2, Vector pos1, Vector pos2) {
		
		this.fuerza = G*((masa1*(masa2))/(Distancia(pos1, pos2)*Distancia(pos1, pos2)));
	//	vd.direction.scale
		return this.fuerza;
		
	}
	
	public double Distancia(Vector p1, Vector p2){
		
		this.distancia = p1.distanceTo(p2);
		
		return distancia;
		
	}
	
	public double FuerzaAcumulada(Body cuerpoA){
		double masa1 = cuerpoA.getMass();
		Vector pos1 = cuerpoA.getPosition();
		
		for (int i = 0; i < listaBody.size(); i++){
			
			double masa2 = listaBody.get(i).getMass();
			Vector pos2 = listaBody.get(i).getPosition();
			
			this.fuerzaAcumulada = this.fuerzaAcumulada + FuerzaAplicada(masa1, masa2, pos1, pos2);
		}
		
		return fuerzaAcumulada;
		
	}
	
	public void AplicarAceleracion(Body cuerpoA){
		
		this.aplicarAceleracion = cuerpoA.getAcceleration().scale(FuerzaAcumulada(cuerpoA));
		cuerpoA.setAcceleration(this.aplicarAceleracion);
		
	}
	
	
}
	
	/*
	
	public double Fuerza(Body a, Body b){
		double masa1;
		double masa2;
		Vector pos1;
		Vector pos2;
		
		for (int i = 0; i < listaBody.size(); i++){
			for (int j = 1; j < listaBody.size(); j++){
				
				masa1 = listaBody.get(i).getMass();
				pos1 = listaBody.get(i).getPosition();
				masa2 = listaBody.get(j).getMass();
				pos2 = listaBody.get(j).getPosition();
			}

		}
		
		return fuerza;
		
	}
	*/

//declarar variables globales
//un for por cada body b(en) c
	// ver fuerza
	//2 for otro body ob c
		//if (b no equals ob) (por cada elemento que no sea yo)
	// fuerza Sum(Cal cl fuerza(ob,b))
	//b.setAcc cl (fuerza)

//diff = ob.position.resta(b,b)

//mirar las distancias entre los dos objetos
// diferencia y distencia
//d


//run arguments