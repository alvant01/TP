package simulator.factories;

import java.util.List;

import org.json.JSONObject;

public class BuilderBasicFactory<T> implements Factory<T> {

	public BuilderBasicFactory(List<Builder<T>> builders) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public T createInstance(JSONObject info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JSONObject> getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
