package tp.p2.Game;

import tp.p2.Controladores.*;
import tp.p2.List.*;
import tp.p2.Plants.Plant;
import tp.p2.Printers.GamePrinter;
import tp.p2.Zombies.Zombie;
import tp.p2.Factory.*;


public class Game {
	private List list;
	
	private GamePrinter draw;
	
	private PlantFactory fabricarPlanta;
	
	private ZombieFactory fabricarZombie;
	
	//private UserCommand uCommand;
	
	private SunCoinsManager scm;
	
	private ZombieManager zManager;
	
	private GameObject gObject;

	private String level;
	
	private int semilla;
	
	
	private int ciclos;
	
	public Game(){
		this.list	  		= new List();
		this.draw    		= new GamePrinter(this);
		this.scm      		= new SunCoinsManager();
		this.gObject 		= new GameObject();
		this.fabricarPlanta = new PlantFactory();
		this.fabricarZombie = new ZombieFactory();
		this.zManager		= new ZombieManager();
		
		this.ciclos= 0;
	}

	public void reiniciar() {
	//	this.psList.setNumElem(0);
	//	this.sfList.setNumElem(0);
	//	this.zList.setNumElem(0);
		
		
		
	}

	public void pintarTablero() {
		
	//	this.draw.drawTablero(this.semilla, this.ciclos, this.scm.getSunCoins(),this.cAction.getZombiesPorSalir());
	}

	public void updateGame() {
	/*	for(int i = 0; i < this.sfList.getNumElem();i++)
		{
			if (this.sfList.update(this.ciclos, i))
			{
				this.scm.addSunCoins(this.sfList.getSfAux().getSunGenerator());
			}
		}
		for(int i = 0; i < this.psList.getNumElem();i++)
		{
			if (this.psList.update(this.ciclos, i))
			{
				int numZomAux = this.zList.getNumElem();//Salvo el num zombies
				this.zList.getHurt(this.psList.getPsAux().getDamage(), this.psList.getListSP()[i].getPosX());
				if (this.zList.getNumElem() != numZomAux)
				{
					this.cAction.setZombiesRestantes(this.cAction.getZombiesRestantes()-1);
				}
			}
		}
		for(int i =0; i < this.zList.getNumElem();i++)
		{
			if(this.zList.update(this.ciclos, i))
			{
				if(this.sfList.contains(this.zList.getListSZ()[i].getPosX(),this.zList.getListSZ()[i].getPosY()-1))
				{
					this.sfList.damageSunflower(this.zList.getZAux().getDamage(),this.zList.getListSZ()[i].getPosX(),this.zList.getListSZ()[i].getPosY()-1);
				}
				else if(this.psList.contains(this.zList.getListSZ()[i].getPosX(),this.zList.getListSZ()[i].getPosY()-1))
				{
					this.psList.damagePeaShooter(this.zList.getZAux().getDamage(),this.zList.getListSZ()[i].getPosX(),this.zList.getListSZ()[i].getPosY()-1);
				}
				else if(this.zList.contains(this.zList.getListSZ()[i].getPosX(),this.zList.getListSZ()[i].getPosY()-1))
				{
					//do nothing
				}
				else
				{
					this.zList.avanzar(this.zList.getListSZ()[i].getPosX(),this.zList.getListSZ()[i].getPosY());
				}
			}
		}
		this.cAction.Insertar(this.ciclos);
		this.ciclos++;*/
	}

	public String obtenerPieza(int posX, int posY) {
		/*if (this.sfList.contains(posX, posY))
		{
			return "S["+ this.sfList.getPlantHP(posX, posY) + "]"; 
		}
		else if (this.psList.contains(posX, posY))
		{
			return "P["+ this.psList.getPlantHP(posX, posY) + "]"; 
		}
		else if (this.zList.contains(posX, posY))
		{
			return "Z["+ this.zList.getZombieHP(posX, posY) + "]"; 
		}*/
		return "    ";//vacio
	}

	public void InicializarZombies()
	{
		this.zManager.Generador(this.semilla, this.level);
	}
	
	public boolean win()
	{
		if(this.zManager.getZombiesRestantes() == 0)
		{
			return true;
		}
		return false;
	}

	public void genSemRandom() {
//		this.semilla=this.cAction.semillaRandom();
		this.semilla = 4;
		
	}

	public boolean isFinished() {
		if(this.zManager.getZombiesRestantes()==0)
		{
			return true;
		}
		else if(this.list.lose())
		{
			return true;
		}
		return false;
	}
	public boolean addPlant(String planta, int posX, int posY)
	{
		//Llamar factory 
		if (!this.list.contains(posX, posY)){
			Plant o  = this.fabricarPlanta.creaPlanta(planta, posX, posY);
			this.list.insert(this.ciclos, o);
			return true;
		}
		return false;
	}
	public boolean addZombie(int posX, int posY)
	{
		int zombie;
		if (!this.list.contains(posX, posY)){
			
			Zombie o  = this.fabricarZombie.creaZombie(this.zManager.zombieType(), posX, posY);
			this.list.insert(this.ciclos, o);
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	//Getters y Setters
	

	public GamePrinter getDraw() {
		return draw;
	}

	public void setDraw(GamePrinter draw) {
		this.draw = draw;
	}

	public SunCoinsManager getScm() {
		return scm;
	}

	public void setScm(SunCoinsManager scm) {
		this.scm = scm;
	}

	public int getCiclos() {
		return ciclos;
	}

	public void setCiclos(int ciclos) {
		this.ciclos = ciclos;
	}

	public int getSemilla() {
		return semilla;
	}

	public void setSemilla(int semilla) {
		this.semilla = semilla;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	 
}
