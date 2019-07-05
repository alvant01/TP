package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.model.FallingToCenterGravity;
import simulator.model.GravityLaws;

public class FallingToCenterGravityBuilder extends Builder<GravityLaws> {

	
	public FallingToCenterGravity createInstance(JSONObject info)
	{
		
		try
		{
		 
		if ("ftcg".equals(info.get("type")))
		{	
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

	public JSONObject getBuilderInfo() {
		JSONObject jo1 = new JSONObject();
		jo1.put("desc", "cayendo");
		jo1.put("type", "ftcg");
		jo1.put("data", "");
		
		return jo1;
	}
}
