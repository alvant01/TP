package tp.p3.Controladores;

import java.util.Arrays;
import java.util.Random;

import tp.p3.List.Sun;

public class SunCoinsManager {
	
	
	private Sun[] sList;
	private int numElem;
	private int tamInicio;
	private int frecuencia;
	private int sunCoins;
	public SunCoinsManager()
	{
		this.sunCoins = 20;
		this.tamInicio = 10;
		this.frecuencia = 5;
		this.sList = new Sun[this.tamInicio];
		this.numElem = 0;
	}
	public int getSunCoins() {
		return sunCoins;
	}
	public void setSunCoins(int sunCoins) {
		this.sunCoins = sunCoins;
	}
	public void addSunCoins(int coins)
	{
		this.sunCoins = this.sunCoins + coins;
	}
	public void removeSuncoins(int cost) {
		this.sunCoins = this.sunCoins - cost;
	}
	public void insertRandom()
	{
		int posX = random(4);	
		int posY = random(8);
		int i  = 0;
		while(contains(posX, posY) && i < 32)
		{
			posX = random(4);	
			posY = random(8);
			i++;//Si todas las casillas tienen un sol evitamos un bucle infinito
		}
		this.sList[this.numElem] = new Sun(posX, posY);
		this.numElem++;
		if(this.numElem >= this.tamInicio)
		{
			redimensionar();
		}
	}
	public void insert(int posX, int posY) {
		if(!contains(posX, posY))
		{
			this.sList[this.numElem] = new Sun(posX, posY);
			this.numElem++;
			if(this.numElem >= this.tamInicio)
			{
				redimensionar();
			}
		}
	}
	public void redimensionar()
	{
		this.sList = Arrays.copyOf(this.sList,this.tamInicio*2);//redimesionar
		this.tamInicio = this.tamInicio*2;
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
	public Sun[] getsList() {
		return sList;
	}
	public void setsList(Sun[] sList) {
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
