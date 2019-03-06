package simulator.factories;

import org.json.JSONException;
import org.json.JSONObject;

import simulator.misc.Vector;
import simulator.model.GravityLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuider extends Builder<GravityLaws> {

	public NewtonUniversalGravitationBuider() {
		// TODO Auto-generated constructor stub
	}
	
	public NewtonUniversalGravitation createInstance(JSONObject info)
	{
		
		try
		{
		 
		if ("nlug".equals(info.get("type")))
		{
//			JSONObject data = info.getJSONObject("data");
			
			try
			{
			NewtonUniversalGravitation nug = new NewtonUniversalGravitation();
			return nug;
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
		
		jo1.put("desc", "Ley de Newton");
		jo1.put("type", "nlug");
		jo1.put("data", "");
		
		return jo1;
	}

}
