package simulator.model;

import java.util.List;

public class NoGravity implements GravityLaws {

	public NoGravity(){
		
	}
	
	@Override
	public void apply(List<Body> bodies) {

		/*for (int i = 0; i < bodies.size(); i++)
		{	
			
			NoHagasNada(bodies.get(i));
		
		}
		*/
	}

	private void NoHagasNada(Body body) {

		//No hace nada
	}

}