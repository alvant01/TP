package tp.p1.List;

import tp.p1.Plants.PeaShooter;

public class PeaShooterList {

	private PeaShooter[] listSP;
	private int numElem;
	
	public PeaShooterList()
	{
		this.listSP = null;
		this.numElem = 0;
	}
	
	//Prototipo
	public void insert(int posX, int posY)
	{
		//creo un nuevo objeto
		this.listSP[this.numElem] = new PeaShooter();
		
		//posicionamiento
		this.listSP[this.numElem].setPosX(posX);
		this.listSP[this.numElem].setPosX(posY);
		
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
}

