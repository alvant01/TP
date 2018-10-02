package tp.p1.List;

import tp.p1.Plants.Sunflower;

public class SunflowerList {

	private Sunflower[] listSf;
	private int numElem;
	
	public SunflowerList()
	{
		this.listSf = null;
		this.numElem = 0;
	}
	
	//Prototipo
	public void insert(int posX, int posY)
	{
		//creo un nuevo objeto
		this.listSf[this.numElem] = new Sunflower();
		
		//posicionamiento
		this.listSf[this.numElem].setPosX(posX);
		this.listSf[this.numElem].setPosX(posY);
		
		this.numElem++;
	}
	
	public void eliminar(int posX, int posY)
	{
		int cont = 0;
		boolean encontrado = false;
		
		for(; cont< this.numElem && !encontrado; cont++)
		{
			if (this.listSf[cont].getPosX() == posX 
					&& this.listSf[cont].getPosY() == posY)
			{
				reordenar(cont);
			}
		}
		
	}
	//reordena el array apartir de una posicion
	public void reordenar(int pos)
	{
		while(pos < this.numElem-1)
		{
			this.listSf[pos] = this.listSf[pos+1];
			pos++;
		}
		this.listSf[pos] = null;
	}
}
