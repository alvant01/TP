package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.misc.Vector;
import simulator.model.FallingToCenterGravity;
import simulator.model.GravityLaws;
import simulator.model.NewtonUniversalGravitation;

public class FallingToCenterGravityBuilder extends Builder<GravityLaws> {

	
	public FallingToCenterGravity createInstance(JSONObject info)
	{
		
		try
		{
		 
		if ("ftcg".equals(info.get("type")))
		{
			JSONObject data = info.getJSONObject("data");
			
			try
			{
			FallingToCenterGravity ftcg = new FallingToCenterGravity();
			return ftcg;
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

	public JSONObject getInfo() {
		JSONObject jo1 = new JSONObject();
		
		jo1.put("desc", "cuerpo que pierde masa");
		jo1.put("data", "\"type\": \"mlb\", \"data\"{ \\\"type\\\": \\\"mlb\\\",\\\"data\\\": {\\\"id\\\": \\\"b1\\\",\\\"pos\\\": [-3.5e10, 0.0e00],\\\"vel\\\": [0.0e00, 1.4e03],\\\"mass\\\": 3.0e28,\\\"freq\\\": 1e3,\\\"factor\\\": 1e-3}}\"");
		return null;
	}
}
