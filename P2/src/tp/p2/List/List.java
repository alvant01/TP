package tp.p2.List;

import java.util.Arrays;

public class List {

	private GameObject[] list;
	private GameObject objectAux;
	private int numElem;
	private int tamInicio;
	
	
	public List() {
		this.tamInicio = 10;
		this.list = new GameObject[this.tamInicio];
		this.objectAux = new GameObject();
		this.numElem =0;
	}
	
	//String [] array = (String []) arrayOrigen.clone()
	public void redimensionar()
	{
		this.list = Arrays.copyOf(this.list, this.numElem + (this.tamInicio*2));//redimesionar
		this.numElem = this.numElem + (this.tamInicio*2);
	}
	
	public void insert(int ciclo, GameObject o)
	{
		//creo un nuevo objeto
		this.list[this.numElem] = o;
		
		//posicionamiento
		this.list[this.numElem].setCicloI(ciclo);
		this.numElem++;
	}

	public GameObject getObjectAux() {
		return objectAux;
	}

	public GameObject[] getList() {
		return list;
	}

	public void setList(GameObject[] list) {
		this.list = list;
	}

	public int getNumElem() {
		return numElem;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	public int getTamInicio() {
		return tamInicio;
	}

	public void setTamInicio(int tamInicio) {
		this.tamInicio = tamInicio;
	}

	public void setObjectAux(GameObject objectAux) {
		this.objectAux = objectAux;
	}

	public boolean lose() {
		for(int i = 0; i < this.numElem; i++)
		{
			if(this.list[i].getPosX() == 0)
			{return true;}
		}
		return false;
	}

	public boolean contains(int posX, int posY) {
		for(int i  = 0; i < this.numElem; i++)
		{
			if(this.list[i].getPosX() == posX && this.list[i].getPosY() == posY)
				return true;
		}
		return false;
	}

	public String getPieza(int posX, int posY) {
		// TODO Auto-generated method stub
		return null;
	}
}
