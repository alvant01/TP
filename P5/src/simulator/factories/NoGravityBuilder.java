package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.model.GravityLaws;
import simulator.model.NoGravity;

public class NoGravityBuilder extends Builder<GravityLaws> {
	public NoGravity createInstance(JSONObject info)
	{
		
		try
		{
		 
		if ("ftcg".equals(info.get("type")))
		{
			try
			{
			NoGravity ng = new NoGravity();
			return ng;
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
		
		jo1.put("desc", "no gravedad");
		jo1.put("type", "ng");
		jo1.put("data", "");
		
		return jo1;
	}

}
