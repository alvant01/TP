package simulator.model;

import java.util.ArrayList;
import java.util.List;

import simulator.misc.Vector;

public class NewtonUniversalGravitationDiego implements GravityLaws {

	private List<Body> listaBody;
	private double fuerza;
	private double G;
	private double aplicarAceleracion;
	private double distancia;
	private double fuerzaAcumulada;

	
	public NewtonUniversalGravitationDiego(){
		
		List<Body> listaBody = new ArrayList<Body>();
		this.fuerza = 0;
		this.G = 6.67384E-11;
		this.aplicarAceleracion = 0;
		this.distancia = 0;
		this.fuerzaAcumulada = 0;
		
	}
	
	//Se busca cada cuerpo para luego aplicar la aceleracion
	@Override
	public void apply(List<Body> bodies) {
		
		this.listaBody = bodies;
		for (int i = 0; i < bodies.size(); i++)
		{	
			
			//Calculo Fuerza
			//setAplicarAceleracion(bodies.get(i));
			AplicarAceleracion(bodies.get(i));
		}		
	}
	
	/*
	List<Body> listaBody;

	double fuerza;
	double G = 6.67384E-11;
	*/
	
	/*
	private void ForceCalculation(Body body) {
		for(int i = 0; i < this.listaBody.size(); i++)
		{
			if(!body.equals(this.listaBody.get(i)))
			{
				this.aplicarAceleracion = this.aplicarAceleracion.plus(accelerationCalculation(body, this.listaBody.get(i)));
			}
		}
		
	}
	*/
	
	//Aplica la ley de la Gravedad entre 2 cuerpos en especifico
	public double FuerzaAplicada (double masa1, double masa2, Vector pos1, Vector pos2) {
		
		//calculo de la fuerza a aplicar, evitando de que sea dividida por 0
		if (!((Distancia(pos1, pos2)) == 0)) {
			
			this.fuerza = G*((masa1*(masa2))/(Distancia(pos1, pos2)*Distancia(pos1, pos2)));
		
		}
		
		else{
			//Do nothing
		}
		
		return this.fuerza;
		
	}
	
	//Calcula la distancia entre dos cuerpos
	public double Distancia(Vector p1, Vector p2){
		
		this.distancia = p1.distanceTo(p2);
		
		return distancia;
		
	}
	
	private void MultiplicarPorAngulo(Body x, Body y){
		
		if (!(x.getId().equals(y))){
			//x.getId().equals(y)
			this.aplicarAceleracion = FuerzaAcumulada(x)/(x.getMass())*((FuerzaAcumulada(y)/y.getMass()));
			//x.getPosition().scale(y.getPosition());
			//x.getPosition()*y.getPosition();
			//(x.getPosition().direction()).scale(y.getPosition().direction());
			double aAceleracion[] = new double[1];
			aAceleracion[0] = this.aplicarAceleracion;
			x.setAcceleration(new Vector(aAceleracion));
			return ;
		}

	}
	
	
	//Por cada cuerpo llamado, se calcula la fuerza que le aplican los demas cuerpos sobre el
	public double FuerzaAcumulada(Body cuerpoA){
		double masa1 = cuerpoA.getMass();
		Vector pos1 = cuerpoA.getPosition();
		//El enunciado dicta: Bi se define como la suma de 
		//todas las fuerzas aplicadas sobre Bi por otros cuerpos
		//Calculamos la fuerza acumulada de todos los objetos sobre el cuerpo en cuestion
		
		//double masa1 = cuerpoA.getMass();
		//Vector pos1 = cuerpoA.getPosition();
		
		for (int i = 0; i < listaBody.size(); i++){
			
			//se excluye del caso al mismo objeto
			if (!(this.listaBody.get(i).equals(cuerpoA))){
			
				double masa2 = listaBody.get(i).getMass();
				Vector pos2 = listaBody.get(i).getPosition();
				
				this.fuerzaAcumulada = this.fuerzaAcumulada + FuerzaAplicada(masa1, masa2, pos1, pos2);
			}
			else {
				//Caso en que el cálculo de la fuerza sea sobre el mismo objeto
				//No se lanza excepcion debido a que no queremos que el programa se detenga
				//ni tampoco que emita mensaje alguno
			}
		}
		
		return this.fuerzaAcumulada;	
	}
	
	//Aplica la aceleracion al cuerpo en cuestion
	public void AplicarAceleracion(Body cuerpoA){
		
		this.aplicarAceleracion = FuerzaAcumulada(cuerpoA)/(cuerpoA.getMass());
		double aAceleracion[] = new double[1];
		aAceleracion[0] = this.aplicarAceleracion;
		cuerpoA.setAcceleration(new Vector(aAceleracion));
		
	}
	
	private Vector accelerationCalculation(Body body, Body body2) {
		//Calculo el angulo
		double direction = Math.atan((body.getAcceleration().coordinate(0) - body2.getAcceleration().coordinate(0) )/body.getAcceleration().coordinate(1));
		double aPos[]  = new double[2];
		double dirX = 0;
		double dirY = 0;
		
		
		if(body.getPosition().coordinate(0) < 0)
		{
			dirX = -1;
		}
		if(body.getPosition().coordinate(1) < 0)
		{
			dirY = -1;
		}
		
		//Calculo la acceleracion respecto a su aceleracion inicial y su grado
		//pos*(g+a)*cos(direccion)
		aPos[0] = dirX*((body.getAcceleration().coordinate(0) + this.G) * Math.cos(direction));
		//pos*(g+a)*sin(direccion)
		aPos[1] = dirY*((body.getAcceleration().coordinate(1) + this.G) * Math.sin(direction));
		
		
		return new Vector(aPos);
	}
	
}