package simulator.factories;

import java.util.List;

import org.json.JSONObject;

public interface Factory<T> {
	
	static String cuerpoBasico = "{\"type\": \"basic\", \"data\": { \"id\": \"b1\", \"pos\": [0.0e00, 0.0e00], \"vel\": [0.05e04, 0.0e00], \"mass\": 5.97e24}}";
	static String cuerpoQuePierdeMasa = "{ \"type\": \"mlb\",\"data\": {\"id\": \"b1\",\"pos\": [-3.5e10, 0.0e00],\"vel\": [0.0e00, 1.4e03],\"mass\": 3.0e28,\"freq\": 1e3,\"factor\": 1e-3}}";
	static String Newton = "{\"type\": \"nlug\",\"data\": {}}";
	
	public T createInstance(JSONObject info);

	public List<JSONObject> getInfo();
}
