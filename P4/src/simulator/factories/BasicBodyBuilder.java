package simulator.factories;

import java.util.List;

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
			Body b = new Body(data.getString("id"),new Vector(data.getInt("vel")) , new Vector(0),  new Vector(data.getInt("poss")),data.getDouble("mass"));
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

	public JSONObject getInfo() {
		JSONObject jo1 = new JSONObject();
		
		jo1.put("desc", "cuerpo normal");
		return null;
	}
}
