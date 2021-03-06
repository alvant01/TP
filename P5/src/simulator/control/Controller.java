package simulator.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.GravityLaws;
import simulator.model.PhysicsSimulator;
import simulator.model.SimulatorObserver;

public class Controller {

	private Factory<Body> factory;
	private Factory<GravityLaws> factoryL;
	private PhysicsSimulator ps;
	private int pasos;
	
	public Controller(PhysicsSimulator ps, Factory<Body> factory, Factory<GravityLaws> factoryL) {
		this.factoryL = factoryL;
		this.factory = factory;
		this.ps = ps;
	}
	
	public void loadBodies(InputStream in)
	{
		
		JSONObject jsonInput = new JSONObject(new JSONTokener(in));
		JSONArray jarray = jsonInput.getJSONArray("bodies");
		for(int i = 0; i < jarray.length(); i++)
		{
			Body n = this.factory.createInstance(jarray.getJSONObject(i));
			this.ps.addBody(n);
		}
	}
	public void run(int n, OutputStream out) throws IOException
	{
		out.write("{ \n".getBytes());
		out.write("\"states\": [ \n".getBytes());
		for(int i = 0; i < n; i++)
		{
			this.ps.advance();
			out.write(ps.toString2().getBytes());
			if(i != n-1)
				out.write(",\n".getBytes());
			else
				out.write("\n".getBytes());
		}
		out.write("] \n".getBytes());
		out.write("} \n".getBytes());
		out.close();
	}
	
	
	
	
	
	//P5
	public void reset()
	{
		this.ps.reset();
	}
	public void setDeltaTime(double dt)
	{
		this.ps.setDeltaTime(dt);
	}
	public void addObserver(SimulatorObserver o)
	{
		this.ps.addObserver(o);
	}
	public void run(int n)
	{
		for(int i  =0; i< n; i++)
			this.ps.advance();
	}
	public Factory<GravityLaws> getGravityLawsFactory()
	{
		return this.factoryL;
	}
	public void setGravityLaws(JSONObject info)
	{
		this.ps.setGravityLaws(this.factoryL.createInstance(info));
	}

	
	
	
	
	
	
	
	
	
	//Getters and Setters
	
	public Factory<Body> getFactory() {
		return factory;
	}

	public void setFactory(Factory<Body> factory) {
		this.factory = factory;
	}

	public PhysicsSimulator getPs() {
		return ps;
	}

	public void setPs(PhysicsSimulator ps) {
		this.ps = ps;
	}

	public int getPasos() {
		return pasos;
	}

	public void setPasos(int pasos) {
		this.pasos = pasos;
	}
}
