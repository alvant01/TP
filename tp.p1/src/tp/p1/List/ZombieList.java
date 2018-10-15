package tp.p1.List;

import tp.p1.Zombies.CommonZombie;

public class ZombieList {

	private CommonZombie[] listSZ;
	private int numElem;
	
	public ZombieList()
	{
		this.listSZ = null;
		this.numElem = 0;
	}
	
	//Prototipo
	public void insert(int posX, int posY)
	{
		//creo un nuevo objeto
		this.listSZ[this.numElem] = new CommonZombie();
		
		//posicionamiento
		this.listSZ[this.numElem].setPosX(posX);
		this.listSZ[this.numElem].setPosY(posY);
		
		this.numElem++;
	}
	
	public void eliminar(int posX, int posY)
	{
		int cont = 0;
		boolean encontrado = false;
		
		for(; cont< this.numElem && !encontrado; cont++)
		{
			if (this.listSZ[cont].getPosX() == posX 
					&& this.listSZ[cont].getPosY() == posY)
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
			this.listSZ[pos] = this.listSZ[pos+1];
			pos++;
		}
		this.listSZ[pos] = null;
	}

	public int getZombieHP(int posX, int posY) {
		for (int i = 0; i < this.numElem; i++)
		{
			if (this.listSZ[i].getPosX() == posX && this.listSZ[i].getPosY() == posY)
			{
				return this.listSZ[i].getHealth();
			}
			
		}
		return 0;
	}

	public boolean contains(int posX, int posY) {
		for(int i = 0; i <this.numElem; i++)
		{
			if(this.listSZ[i].getPosX()== posX && this.listSZ[i].getPosY() == posY)
				return true;
		}
		return false;
	}
}
