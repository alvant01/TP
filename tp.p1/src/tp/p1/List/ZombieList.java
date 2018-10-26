package tp.p1.List;

import tp.p1.Zombies.CommonZombie;

public class ZombieList {

	private CommonZombie[] listSZ;
	private CommonZombie zAux;
	private int numElem;
	
	public ZombieList()
	{
		this.listSZ = new CommonZombie[15];
		this.zAux = new CommonZombie();
		this.numElem = 0;
	}
	
	//Prototipo
	public boolean update(int ciclos, int pos){
			if ((this.listSZ[pos].getCicloZom()%this.zAux.getFrecuency() - ciclos%this.zAux.getFrecuency()) == 0)
			{
			 return true;	
			}
		return false;
		}
		/*	else{
				this.listSZ[i].setPosY(this.listSZ[i].getPosY()-1);
				if (this.listSZ[i].getPosY() == 0){
					gm.setFin(true);
				}
			}
		}
	}*/
	
	
	public void getHurt(int damage, int PosX){
		int i =0;
		for (; i != PosX; i++);
			
		this.listSZ[i].setHealth(this.listSZ[i].getHealth()- damage);
		
		if (this.listSZ[i].getHealth() <= 0 ){
			this.eliminar(this.listSZ[i].getPosX(), i);
		}
	}
	
	public void insert(int posX, int posY, int cicloZom)
	{
		//creo un nuevo objeto
		this.listSZ[this.numElem] = new CommonZombie();
		
		//posicionamiento
		this.listSZ[this.numElem].setPosX(posX);
		this.listSZ[this.numElem].setPosY(posY);
		this.listSZ[this.numElem].setCicloZom(cicloZom);
		
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
				this.listSZ[cont] = null;
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
	public void avanzar(int posX, int posY)
	{
		for (int i = 0; i < this.numElem; i++)
		{
			if (this.listSZ[i].getPosX() == posX && this.listSZ[i].getPosY() == posY)
			{
				this.listSZ[i].setPosY(posY-1);
			}
			
		}
		
	}
	public void setZombieHP(int posX, int posY, int health)
	{
		for (int i = 0; i < this.numElem; i++)
		{
			if (this.listSZ[i].getPosX() == posX && this.listSZ[i].getPosY() == posY)
			{
				this.listSZ[i].setHealth(health);
			}
			
		}
	}

	public boolean contains(int posX, int posY) {
		for(int i = 0; i <this.numElem; i++)
		{
			if(this.listSZ[i].getPosX()== posX && this.listSZ[i].getPosY() == posY)
				return true;
		}
		return false;
	}

	public CommonZombie[] getListSZ() {
		return listSZ;
	}

	public void setListSZ(CommonZombie[] listSZ) {
		this.listSZ = listSZ;
	}

	public int getNumElem() {
		return numElem;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	public int getFrecuency() {
		CommonZombie z = new CommonZombie();
		return z.getFrecuency();
	}

	public CommonZombie getZAux() {
		return this.zAux;
	}
}
