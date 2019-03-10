package simulator.model;

import simulator.misc.Vector;

public class Body{
	
	protected String id;
	
	protected Vector v;
	
	protected Vector a;
	
	protected Vector p;
	
	protected double m;
	
	
	
	public Body(String id, Vector vel,Vector acc, Vector poss, double mass) {
		this.id = id;
		this.a = acc;
		this.p = poss;
		this.m= mass;
		this.v = vel;
	}
	public String getId()
	{
		return this.id;
	}
	public Vector getVelocity() {
		return new Vector(v);
	}
	public Vector getAcceleration(){
		return new Vector(a);
	}
	public Vector getPosition(){
		return new Vector(p);
	}
	public double getMass(){
		return this.m;
	}
	void setVelocity(Vector v)
	{
		Vector newV = new Vector(v);
		this.v = newV;
	}
	void setAcceleration(Vector a)
	{
		Vector newA = new Vector(a);
		this.a = newA;
	}
	void setPosition(Vector p) 
	{
		Vector newP = new Vector(p);
		this.p = newP;
	}
	void move(double t)
	{
		/*Vector v = this.v.scale(t);
		Vector m = this.a.scale(0.5).scale(t*t);
		
		Vector c  = v.plus(m);
		*/
		Vector recorrido = this.v.scale(t).plus(this.a.scale(0.5).scale(t*t));
		
		//double d = recorrido.coordinate(0)+this.p.coordinate(0);
		if((this.p.coordinate(0)> 0 && this.p.coordinate(0)+recorrido.coordinate(0) <0  ))
			this.p = new Vector(2);
		else if (this.p.coordinate(0)< 0 && recorrido.coordinate(0)+this.p.coordinate(0) > 0 )
			this.p = new Vector(2);
		else
			this.p = this.p.plus(recorrido);
		this.v = this.v.plus(this.a.scale(t));
	}
	public String toString()
	{
		return "{ \"id\": \"" +  this.id + "\", \"mass\": " + this.m + ", \"pos\": "+ this.p + ", \"vel\": " + this.v+ ", \"acc\":" + this.a + "}";
	}
}
