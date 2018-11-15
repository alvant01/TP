package tp.p2.List;

import java.util.Arrays;

import tp.p2.Controladores.SunCoinsManager;

public class List {

	private GameObject[] list;
	private int numElem;
	private int tamInicio;
	
	
	public List() {
		this.tamInicio = 10;
		this.list = new GameObject[this.tamInicio];
		this.numElem =0;
	}
	
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

	public boolean lose() {
		for(int i = 0; i < 4; i++)
		{
			if(containsZombie(i, 0) )
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
	public int containsPosition(int posX, int posY) {
		for(int i  = 0; i < this.numElem; i++)
		{
			if(this.list[i].getPosX() == posX && this.list[i].getPosY() == posY)
				return i;
		}
		return -1;
	}
	public boolean containsZombie(int posX, int posY) {
		for(int i  = 0; i < this.numElem; i++)
		{
			if(this.list[i].getPosX() == posX && this.list[i].getPosY() == posY && this.list[i].isZombie())
				return true;
		}
		return false;
	}

	public String getPieza(int posX, int posY) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(SunCoinsManager scm, int ciclos) {
		for(int i = 0; i< this.getNumElem();i++)
		{
			
			GameObject obj = this.list[i];
			if(obj.isPlant())
			{
				if(obj.getPlanta().getTipoPlanta().equals("S"))//sunflower
				{
					obj.updateSunflower(scm, ciclos);
				}
				else if(obj.getPlanta().getTipoPlanta().equals("P"))
				{
					if(obj.updatePlant(ciclos))
						damageZombie(obj.getPosX(), obj.getPosY(), obj.getDamage());
				}
				else if(obj.getPlanta().getTipoPlanta().equals("N"))
				{
					//Nothing
				}
				else if(obj.getPlanta().getTipoPlanta().equals("C"))
				{
					if(obj.updatePlant(ciclos))
						cherryExplosion(obj.getPosX(), obj.getPosY(), obj.getDamage());
				}
			}
			else
			{
				if(contains(obj.getPosX(), obj.getPosY()-1))
				{
					damagePlant(obj.getPosX(),obj.getPosY(), obj.getDamage());
				}
				else
				{
					if(obj.updateZombie(ciclos))
						obj.setPosY(obj.getPosY()-1);
				}
			}
		}
		
	}

	private void damagePlant(int posX, int posY, int damage) {
		for(int i = 0 + posY; i < this.numElem; i++)
		{
			if(this.list[i].isPlant())
			{
				this.list[i].damage(damage);
				if(this.list[i].getHealth() == 0)
					eliminar(i);
			}
		}
		
	}

	private void eliminar(int i) {
		this.list[i] = null;
		this.numElem--;
		for(; i < this.numElem; i++)
		{
			this.list[i] = this.list[i+1];
		}
		
	}

	private void cherryExplosion(int posX, int posY, int damage) {
	int pos, posC;
	int adjX = -1;
	int adjY = -1;
	posC = containsPosition(posX,posY);
	for(int i = 0; i < 9; i++ )
		{
			pos = containsPosition(posX+adjX,posY+adjY);
			if(pos != -1 && this.list[pos].isZombie())
			{
				this.list[pos].damage(damage);
			}
			if(adjY == 1)
			{
				adjY = -1;
				adjX++;
			}
			else
				adjY++;
		}
		
		eliminar(posC);
	}

	private void damageZombie(int posX, int posY, int damage) {
		for(int i = 0 + posY; i < this.numElem; i++)
		{
			if(this.list[i].isZombie() && this.list[i].getPosX() == posX)
			{
				this.list[i].damage(damage);
				if(this.list[i].getHealth() == 0)
					eliminar(i);
				return;
			}
		}
	}
}
