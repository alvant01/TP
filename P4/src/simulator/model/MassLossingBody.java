package simulator.model;

import simulator.misc.Vector;

public class MassLossingBody extends Body {

	
	private double lossFactor;
	
	private double lossFrecuency;
	public MassLossingBody(double factor, double lossFrecuency,Vector vel, Vector acc, Vector poss, double mass) 
	{
		super(vel, acc, poss, mass);
		
		this.lossFactor = factor;
		this.lossFrecuency = lossFrecuency;
	}
	
	void move(double t)
	{
		double c = 0.0;
		super.move(t);
		c += t;
		if (this.lossFrecuency == c)
		{
			this.lossFactor = super.m*(1-this.lossFactor);
			c = 0.0;
		}
	}

}
