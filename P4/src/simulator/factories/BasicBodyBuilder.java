package simulator.factories;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simulator.misc.Vector;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {

	public BasicBodyBuilder() {
		// TODO Auto-generated constructor stub
	}

	
	public Body createInstance(JSONObject info)
	{
		
		try
		{
		 
		if ("basic".equals(info.get("type")))
		{
			JSONObject data = info.getJSONObject("data");
			
			try
			{
			
			double[] v = new double[2];
			double[] p = new double[2];
			double[] a = new double[2];
			
			JSONArray g = data.getJSONArray("vel");
			
			
			v[0] = g.getDouble(0);	
			v[1] = g.getDouble(1);
			
			g = data.getJSONArray("pos");
			
			
			p[0] = g.getDouble(0);	
			p[1] = g.getDouble(1);
			
			a[0] = 0;
			a[1] = 1;
			
			
			Body b = new Body(data.getString("id"), new Vector(v) , new Vector(a),  new Vector(p),data.getDouble("mass"));
			return b;
			}
			catch(JSONException ex)
			{
				throw new IllegalArgumentException();
			}	
		}
		return null;
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println(ex);
		}
		return null;
	}

	public JSONObject getBuilderInfo() {
		JSONObject jo1 = new JSONObject();
		
		/*
		jo1.put("data", "\"type\": \"basic\", \"data\": { \"id\": \"b1\", \"pos\": [0.0e00, 0.0e00], \"vel\": [0.05e04, 0.0e00], \"mass\": 5.97e24");
		*/
		jo1.put("desc", "cuerpo normal");
		jo1.put("type", "basic");
		jo1.put("data", "{ \"id\": \"b1\", \"pos\", \"vel\", \"mass\" })");
		
		return jo1;
	}
}
