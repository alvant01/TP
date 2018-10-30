package tp.p2.List;

import tp.p2.Plants.Sunflower;

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
	
	public void insert(int posX, int posY, int ciclo)
	{
		//creo un nuevo objeto
		this.listSf[this.numElem] = new Sunflower();
		
		//posicionamiento
		this.listSf[this.numElem].setPosX(posX);
		this.listSf[this.numElem].setPosY(posY);
		this.listSf[this.numElem].setCicloI(ciclo);
		
		this.numElem++;
	}
	
	public void eliminar(int pos)
	{
		
		this.listSf[pos] = null;
		this.numElem--;
		reordenar(pos);
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
		int pos = localizarPlanta(x,y);
		if (this.listSf[pos].getPosX() == x && this.listSf[pos].getPosY() == y)
		{
			return this.listSf[pos].getHealth();
		}
			
		return 0;
	}
	public boolean contains(int posX, int posY)
	{
		int pos = localizarPlanta(posX,posY);
		if(pos != -1)
		{
			if(this.listSf[pos].getPosX()== posX && this.listSf[pos].getPosY() == posY)
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

	public boolean update(int ciclos, int pos) {
		if((this.listSf[pos].getCicloI()%this.sfAux.getFrecuency() - ciclos%this.sfAux.getFrecuency()) == 0 && this.listSf[pos].getCicloI() != ciclos)
		{
			return true;
		}
		return false;
	}

	public void damageSunflower(int damage, int posX, int posY) {
		int pos = localizarPlanta(posX, posY);
		
		this.listSf[pos].setHealth(this.listSf[pos].getHealth() - damage);
		
		if (this.listSf[pos].getHealth() <= 0)
			eliminar(pos);
		
	}
	public int localizarPlanta(int posX, int posY)
	{
		for(int i = 0; i <this.numElem; i++)
		{
			if(this.listSf[i].getPosX()== posX && this.listSf[i].getPosY() == posY)
				return i;
		}
		return -1;

	}
}
