package tp.p3.List;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Exceptions.FileContentsException;
import tp.p3.Game.Game;

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
		this.list = Arrays.copyOf(this.list,this.tamInicio*2);//redimesionar
		this.tamInicio = this.tamInicio*2;
	}
	
	public void insert(int ciclo, GameObject o)
	{
		//creo un nuevo objeto
		this.list[this.numElem] = o;
		
		//posicionamiento
		this.list[this.numElem].setCicloI(ciclo);
		this.numElem++;
		if(this.numElem >= this.tamInicio)
			redimensionar();
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
	public void update(Game game, int ciclos) {
		for(int i = 0; i< this.getNumElem();i++)
		{
			
			GameObject obj = this.list[i];
			if(obj.isPlant())
			{
				obj.updatePlant(ciclos, game);
			}
			else
			{
				obj.updateZombie(ciclos, game);
			}
		}
		
	}

	public void damagePlant(int posX, int posY, int damage) {
		for(int i = 0; i < this.numElem; i++)
		{
			if(this.list[i].isPlant() && this.list[i].getPosX() == posX && this.list[i].getPosY() == posY-1)
			{
				this.list[i].damage(damage);
				if(this.list[i].getHealth() == 0)
					eliminar(i);
			}
		}
		
	}
	
	public void cherryExplosion(int posX, int posY, int damage, Game game) 
	{
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
					if(this.list[pos].getHealth() <= 0)
					{
						eliminar(pos);
						game.setReamingZombies();
					}
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

	public void eliminar(int i) {
		this.list[i] = null;
		this.numElem--;
		for(; i < this.numElem; i++)
		{
			this.list[i] = this.list[i+1];
		}
		
	}


	public void damageZombie(int posX, int posY, int damage, Game game) {
		for(int i = 0 + posY; i < this.numElem; i++)
		{
			if(this.list[i].isZombie() && this.list[i].getPosX() == posX)
			{
				this.list[i].damage(damage);
				if(this.list[i].getHealth() == 0)
				{
					eliminar(i);
					game.setReamingZombies();
				}
				return;
			}
		}
	}
	
	
	
	
	
	
	
	
	//Getters and Setters
	

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

	public void store(BufferedWriter in) throws IOException {
		//try
		//{
			for(int i  = 0; i < this.numElem; i++)
			{
				if (i != 0)
					in.write(',');
				in.write(this.list[i].externalise());

			}
		/*}
		catch (IOException e)
		{
			throw new FileContentsException("Error al crear la salva");
		}*/
	}

	public void load(char[] cs, Game game) throws FileContentsException, CommandExecuteException {
		int pos = 0;
		int tam = 0;
		try
		{
		//obj = cs.toCharArray();
			for(int i = 0; i < cs.length -1; i += tam+1)
			{
				tam = 0;
				for(;  cs.length != pos && cs[pos] != ','; pos++)
				{
					tam++;//calcula la pos hasta la coma
				}
				
				char[] obj = new char[tam];
				
				System.arraycopy(cs, i, obj, 0, tam);
				game.insertarLoad(Character.toString(obj[0]),
						Character.getNumericValue(obj[2]),Character.getNumericValue(obj[4]),Character.getNumericValue(obj[6]),Character.getNumericValue(obj[8]));
				pos++;
			}
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			throw new FileContentsException("Archivo de carga corrupto");
		}
		
	}

}
