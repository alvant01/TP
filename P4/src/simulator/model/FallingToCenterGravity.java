package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class FallingToCenterGravity implements GravityLaws {

	@Override
	public void apply(List<Body> bodies) {
		// TODO Auto-generated method stub

	}
	
	double g = 9.81;
	Vector coordenadas;
	
	public Vector cayendo (double _data[], int i, Vector d1) {
		
		coordenadas = d1.scale(-g);
		
		return coordenadas;
		
	}
}