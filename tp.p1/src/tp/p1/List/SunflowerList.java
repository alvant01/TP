package tp.p1.List;

import tp.p1.Plants.Sunflower;

public class SunflowerList {

	private Sunflower[] listSf;
	private Sunflower sfAux;
	private int numElem;
	
	public SunflowerList()
	{
		this.listSf = new Sunflower[32];
		this.sfAux = new Sunflower();
		this.numElem = 0;
	}
	
	//Prototipo
	public void insert(int posX, int posY)
	{
		//creo un nuevo objeto
		this.listSf[this.numElem] = new Sunflower();
		
		//posicionamiento
		this.listSf[this.numElem].setPosX(posX);
		this.listSf[this.numElem].setPosY(posY);
		
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
				this.listSf[cont] = null;
				this.numElem--;
			}
		}
		reordenar(cont);
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
	
	public int getPlantHP(int x, int y)
	{
		for (int i = 0; i < this.numElem; i++)
		{
			if (this.listSf[i].getPosX() == x && this.listSf[i].getPosY() == y)
			{
				return this.listSf[i].getHealth();
			}
			
		}
		return 0;
	}
	public boolean contains(int posX, int posY)
	{
		for(int i = 0; i <this.numElem; i++)
		{
			if(this.listSf[i].getPosX()== posX && this.listSf[i].getPosY() == posY)
				return true;
		}
		return false;
	}

	public Sunflower[] getListSf() {
		return listSf;
	}

	public void setListSf(Sunflower[] listSf) {
		this.listSf = listSf;
	}

	public int getNumElem() {
		return numElem;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	public void setPlantHP(int x, int y, int HP) {
		for (int i = 0; i < this.numElem; i++)
		{
			if (this.listSf[i].getPosX() == x && this.listSf[i].getPosY() == y)
			{
				this.listSf[i].setHealth(HP);
			}
			
		}
		
	}

	public Sunflower getSfAux() {
		return sfAux;
	}

	public void setSfAux(Sunflower sfAux) {
		this.sfAux = sfAux;
	}
}
