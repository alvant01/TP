package simulator.factories;

import org.json.JSONObject;

public abstract class Builder<T> {

	public Builder() {
		// TODO Auto-generated constructor stub
	}
	public abstract T createInstance(JSONObject info) ;
	public abstract JSONObject getBuilderInfo();
}
