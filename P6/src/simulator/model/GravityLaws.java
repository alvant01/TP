package simulator.model;

import java.util.List;

public interface GravityLaws {
	
	//Este metodo tiene que aplicar las leyes de la gravedad de cada uno especificamente
	//de los distintos cuerpos de la lista
	
	public void apply(List<Body>bodies);
	
}