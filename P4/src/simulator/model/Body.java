package simulator.model;

import simulator.misc.Vector;

public class Body{
	
	protected String id;
	
	protected Vector v;
	
	protected Vector a;
	
	protected Vector p;
	
	protected double m;
	
	
	
	public Body(Vector vel,Vector acc, Vector poss, double mass) {
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
		//return (Vector) this.v.clone();
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
		this.p = this.p.plus(this.v.scale(t)).plus(this.a.scale(0.5).scale(t*t));
		this.v = this.v.plus(this.a.scale(t));
	}
	public String toString()
	{
		return "{ 'id':" +  this.id + ", 'mass':" + this.m + ", 'pos': "+ this.p + ", 'vel':" + this.v+ ", 'acc':" + this.a + "}";
	}
}
