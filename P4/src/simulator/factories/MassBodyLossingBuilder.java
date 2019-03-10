package simulator.factories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simulator.misc.Vector;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassBodyLossingBuilder extends Builder<Body> {


	public MassLossingBody createInstance(JSONObject info)
	{
		
		try
		{
		 
		if ("mlb".equals(info.get("type")))
		{
			JSONObject data = info.getJSONObject("data");
			
			

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
			a[1] = 0;
			
			try
			{
			MassLossingBody mlb = new MassLossingBody(data.getString("id"),data.getDouble("factor"),data.getDouble("freq"), new Vector(v) , new Vector(a),  new Vector(p),data.getDouble("mass"));
			return mlb;
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
		
		jo1.put("desc", "cuerpo que pierde masa");
		jo1.put("data", "\"type\": \"mlb\", \"data\"{ \\\"type\\\": \\\"mlb\\\",\\\"data\\\": {\\\"id\\\": \\\"b1\\\",\\\"pos\\\": [-3.5e10, 0.0e00],\\\"vel\\\": [0.0e00, 1.4e03],\\\"mass\\\": 3.0e28,\\\"freq\\\": 1e3,\\\"factor\\\": 1e-3}}\"");
		return null;
	}
}
