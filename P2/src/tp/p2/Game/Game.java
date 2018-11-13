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
		this.fabricarPlanta = new PlantFactory(gObject);
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
		
		this.list.update(this.scm, this.ciclos);
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
			GameObject o  = this.fabricarPlanta.creaPlanta(planta, posX, posY);
			if(o != null)
			{
				this.list.insert(this.ciclos, o);
				return true;
			}
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
