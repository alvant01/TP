package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class BuilderBasicFactory<T> implements Factory<T> {
	
	private List<Builder<T>> listaF;
	
	public BuilderBasicFactory(List<Builder<T>> builders) {
		this.listaF = builders;
	}

	@Override
	public T createInstance(JSONObject info) {
		for(int i = 0; i < this.listaF.size(); i++)
		{
			T jObject = listaF.get(i).createInstance(info);
			if(jObject != null)
				return jObject;
		}
		return null;
	}

	@Override
	public List<JSONObject> getInfo() {
		List<JSONObject> lista = new ArrayList<JSONObject>();
		for(int i = 0; i < this.listaF.size(); i++)
		{
			lista.add(this.listaF.get(i).getBuilderInfo());
		}
		return lista;
	}

}
