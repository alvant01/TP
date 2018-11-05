package tp.p2.List;

import java.util.Arrays;

import tp.p2.Plants.GameObject;
import tp.p2.Plants.Sunflower;

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
		this.list = Arrays.copyOf(this.list, this.tamInicio*2);//redimesionar
	}
	
	public void insert(int posX, int posY,int ciclo, GameObject o)
	{
		//creo un nuevo objeto
		this.list[this.numElem] = o;
		
		//posicionamiento
		this.list[this.numElem].setPosX(posX);
		this.list[this.numElem].setPosX(posY);
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
}
