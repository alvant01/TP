package simulator.model;

import java.util.ArrayList;
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
		
		List<Body> listaBody = new ArrayList<Body>();
		this.fuerza = 0;
		this.G = 6.67384E-11;
		this.aplicarAceleracion = null;
		this.distancia = 0;
		this.fuerzaAcumulada = 0;
		
	}
	//Considero que la gravitacion universal solo puede darsse entre dos cuepros
	//el enunciado dicta: Bi se define como la suma de 
	//todas las fuerzas aplicadas sobre Bi por otros cuerpos
	@Override
	public void apply(List<Body> bodies) {
		
		this.listaBody = bodies;
		for (int i = 0; i < bodies.size(); i++)
		{	
			
			AplicarAceleracion(bodies.get(i));
		
		}
		
		//this.aplicarAceleracion = bodies.get(0).getAcceleration().scale(FuerzaAcumulada(bodies.get(1)));
		//bodies.get(0).setAcceleration(this.aplicarAceleracion);
		
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
	
	public double FuerzaAcumulada(Body cuerpo1, Body cuerpo2){
		//Por que aqui se hacen dos veces? //Porque el enunciado dicta: Bi se define como la suma de 
		//todas las fuerzas aplicadas sobre Bi por otros cuerpos
		//Calculamos la fureza acumulado sobre UN solo cuerpo
		//Calculamos la fuerza acumulada de todos los objetos sobre el cuerpo en cuestion

		
		//for (int i = 0; i < listaBody.size(); i++){
			
			//double masa2 = listaBody.get(i).getMass();
			//Vector pos2 = listaBody.get(i).getPosition();
			
			this.fuerzaAcumulada = this.fuerzaAcumulada + FuerzaAplicada(cuerpo1.getMass(), cuerpo2.getMass(), cuerpo1.getPosition(), cuerpo2.getPosition());
		//}
		
		return fuerzaAcumulada;
		
	}
	
	public void AplicarAceleracion(Body cuerpoA){
		//Este no es un for similar al que habia antes mas arriba?
		int j = -1;
		double aSol[] = new double[2];
		//Obtiene el otro cuerpo
		for(int i = 0; i < this.listaBody.size(); i++)
		{
			if(!this.listaBody.get(i).equals(cuerpoA))
				j = i;
		}
		if (j == -1)
			throw new  IllegalArgumentException();
		
		//this.aplicarAceleracion = 
		double fAcumulada = FuerzaAcumulada(this.listaBody.get(j), cuerpoA);
		
		
		aSol[0] = 0.0;
		aSol[1] = fAcumulada;
		
		this.aplicarAceleracion = cuerpoA.getAcceleration().plus(new Vector(aSol));
		//Aqui deberia de ser:
		// a = F/m
		//He intentado bastante hacer que funcione con esa otra formula pero tengo problemas con el vector
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