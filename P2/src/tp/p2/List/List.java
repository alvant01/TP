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
	public int containsPosition(int posX, int posY) {
		for(int i  = 0; i < this.numElem; i++)
		{
			if(this.list[i].getPosX() == posX && this.list[i].getPosY() == posY)
				return i;
		}
		return -1;
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
				if(obj.getPlantas()[0] == obj.getPlanta())//sunflower
				{
					obj.updateSunflower(scm, ciclos);
				}
				else if(obj.getPlantas()[1] == obj.getPlanta())
				{
					damageZombie(obj.getPosX(), obj.getPosY(), obj.getDamage());
				}
				else if(obj.getPlantas()[2] == obj.getPlanta())
				{
					//Nothing
				}
				else if(obj.getPlantas()[3] == obj.getPlanta())
				{
					cherryExplosion(obj.getPosX(), obj.getPosY(), obj.getDamage());
				}
			}
			else
			{
				if(contains(obj.getPosX(), obj.getPosY()-1))
				{
					if(obj.updateZombie(ciclos))
						damagePlant(obj.getPosX(),obj.getPosY(), obj.getDamage());
				}
				else
					obj.setPosY(obj.getPosY()-1);
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
	int pos;
	int adjX = -1;
	int adjY = -1;
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
	}

	private void damageZombie(int posX, int posY, int damage) {
		for(int i = 0 + posY; i < this.numElem; i++)
		{
			if(this.list[i].isZombie())
			{
				this.list[i].damage(damage);
				if(this.list[i].getHealth() == 0)
					eliminar(i);
			}
		}
	}
}
