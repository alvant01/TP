package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller {

	
	private InputStream entrada;
	private OutputStream salida;
	
	private Factory<Body> factory;
	private PhysicsSimulator ps;
	
	public Controller(PhysicsSimulator ps, Factory<Body> factory) {
		this.factory = factory;
		this.ps = ps;
	}
	
	public void loadBodies(InputStream in)
	{
		
		JSONObject jsonInupt = new JSONObject(new JSONTokener(in));
		JSONArray jarray = jsonInupt.getJSONArray("body");
		
		for(int i = 0; i < jsonInupt.length(); i++)
		{
			Body n = this.factory.createInstance(jarray.getJSONObject(i));
			
			ps.addBody(n);
		}
	}
	public void run(int n, OutputStream out)
	{
		for(int i = 0; i < n; i++)
		{
			//Llamar a simulador n veces
			//Guardarlo en out
			//out=
		}
		
	}

}
