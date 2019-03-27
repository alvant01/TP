package simulator.model;

import java.util.List;
import java.lang.Math;

import simulator.misc.Vector;

public class FallingToCenterGravity implements GravityLaws {

	private double g; //gravedad
	
	public FallingToCenterGravity(){
		
		 this.g = -9.81;
	}
	
	@Override
	public void apply(List<Body> cuerpo) {
		
		for (int i = 0; i < cuerpo.size(); i++)
		{	
			Body current = cuerpo.get(i);
			current.setAcceleration(current.getPosition().direction().scale(g));
		}
	}
}