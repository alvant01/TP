package tp.p2.List;

import java.util.Random;

public class SunList {


	private SunObject[] sList;
	private int numElem;
	private int tamInicio;
	private int frecuencia;
	
	
	public SunList() {
		this.tamInicio = 10;
		this.frecuencia = 5;
		this.sList = new SunObject[this.tamInicio];
		this.numElem = 0;
	}
	public void insertRandom()
	{
		int posX = random(4);	
		int posY = random(8);
		while(contains(posX, posY))
		{
			posX = random(4);	
			posY = random(8);
		}
		this.sList[this.numElem] = new SunObject(posX, posY);
		this.numElem++;
	}
	public void insert(int posX, int posY) {
		if(!contains(posX, posY))
		{
			this.sList[this.numElem] = new SunObject(posX, posY);
			this.numElem++;
		}
	}
	private boolean contains(int posX, int posY) {
		for(int i = 0; i < this.numElem; i++)
		{
			if(this.sList[i].getPosX() == posX && this.sList[i].getPosY() == posY)
				return true;
		}
		return false;
	}
	public int containsPosition(int posX, int posY) {
		for(int i = 0; i < this.numElem; i++)
		{
			if(this.sList[i].getPosX() == posX && this.sList[i].getPosY() == posY)
				return i;
		}
		return -1;
	}
	private int random(int i) {
		Random rd = new Random();
		return rd.nextInt(i);
	}
	public void delete(int i)
	{
		this.sList[i] = null;
		this.numElem--;
		for(; i < this.numElem; i++)
		{
			this.sList[i] = this.sList[i+1];
		}
	}
	public boolean haveSun(int pos)
	{
		return true;
	}
	public boolean getSunCoins(int posX, int posY) {
		int pos = containsPosition(posX, posY);
		if(pos != -1)
		{
			delete(pos);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Getters y Setters
	public SunObject[] getsList() {
		return sList;
	}
	public void setsList(SunObject[] sList) {
		this.sList = sList;
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
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	

}
