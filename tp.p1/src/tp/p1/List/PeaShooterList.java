package tp.p1.List;

import tp.p1.Plants.PeaShooter;

public class PeaShooterList {

	private PeaShooter[] listSP;
	private PeaShooter psAux;
	private int numElem;
	
	public PeaShooterList()
	{
		this.listSP = new PeaShooter[32];
		this.psAux = new PeaShooter();
		this.numElem = 0;
	}
	
	//Prototipo
	public void insert(int posX, int posY,int ciclo)
	{
		//creo un nuevo objeto
		this.listSP[this.numElem] = new PeaShooter();
		
		//posicionamiento
		this.listSP[this.numElem].setPosX(posX);
		this.listSP[this.numElem].setPosY(posY);
		this.listSP[this.numElem].setCicloI(ciclo);
		
		this.numElem++;
	}
	
	public void eliminar(int posX, int posY)
	{
		int cont = 0;
		boolean encontrado = false;
		
		for(; cont< this.numElem && !encontrado; cont++)
		{
			if (this.listSP[cont].getPosX() == posX 
					&& this.listSP[cont].getPosY() == posY)
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
			this.listSP[pos] = this.listSP[pos+1];
			pos++;
		}
		this.listSP[pos] = null;
	}

	public int getPlantHP(int x, int y)
	{
		for (int i = 0; i < this.numElem; i++)
		{
			if (this.listSP[i].getPosX() == x && this.listSP[i].getPosY() == y)
			{
				return this.listSP[i].getHealth();
			}
			
		}
		return 0;
	}
	
	public void setPlantHP(int x, int y, int HP)
	{
		for (int i = 0; i < this.numElem; i++)
		{
			if (this.listSP[i].getPosX() == x && this.listSP[i].getPosY() == y)
			{
				this.listSP[i].setHealth(HP);
			}
			
		}
	}
	public boolean contains(int posX, int posY) {
		for(int i = 0; i <this.numElem; i++)
		{
			if(this.listSP[i].getPosX()== posX && this.listSP[i].getPosY() == posY)
				return true;
		}
		return false;
	}
	public boolean update(int ciclos, int pos) {
		if((this.listSP[pos].getCicloI()%this.psAux.getFrecuency() - ciclos%this.psAux.getFrecuency()) == 0)
		{
			return true;
		}
		return false;
	}

	public PeaShooter[] getListSP() {
		return listSP;
	}

	public void setListSP(PeaShooter[] listSP) {
		this.listSP = listSP;
	}

	public int getNumElem() {
		return numElem;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	public PeaShooter getPsAux() {
		return psAux;
	}

	public void setPsAux(PeaShooter psAux) {
		this.psAux = psAux;
	}

	public void damagePeaShooter(int damage, int posX, int i) {
		// TODO Auto-generated method stub
		
	}
}

