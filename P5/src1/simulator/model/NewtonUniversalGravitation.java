package simulator.model;

import java.util.List;

public class NewtonUniversalGravitation implements GravityLaws {

	/*@Override
	public void apply(List<Body> bodies) {
		// TODO Auto-generated method stub
		
	}*/

	double fuerza;
	double G = 6.67E-11;
	
	public double aceleracion (int m1, int m2, int p1, int p2) {
		
		fuerza = G*((m1*m2)/(p1-p2));
		
		return fuerza;
		
	}

	@Override
	public void apply(List<Body> bodies) {
		// TODO Auto-generated method stub
		
	}
}