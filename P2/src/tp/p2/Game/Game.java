package tp.p2.Game;

import tp.p2.Controladores.*;
import tp.p2.List.*;
import tp.p2.Plants.Plant;
import tp.p2.Printers.BoardPrinter;
import tp.p2.Printers.GamePrinter;
import tp.p2.Printers.ReleasePrinter;
import tp.p2.Zombies.Zombie;
import tp.p2.Factory.*;


public class Game {
	private List list;
	
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
		this.scm      		= new SunCoinsManager();
		this.gObject 		= new GameObject();
		this.fabricarPlanta = new PlantFactory(this.gObject);
		this.fabricarZombie = new ZombieFactory(this.gObject);
		this.zManager		= new ZombieManager();
		
		this.ciclos= 0;
	}

	public void reiniciar() {
		this.list.setNumElem(0);
	}

	public void pintarTablero() {
		
	//	this.draw.drawTablero(this.semilla, this.ciclos, this.scm.getSunCoins(),this.cAction.getZombiesPorSalir());
	}

	public void updateGame() {
		int posX;
		this.list.update(this.scm, this.ciclos);
		
		if(this.zManager.cicloZombie(this.ciclos))
		{
			posX = this.zManager.pos();
			while(this.list.containsZombie(posX, 7))
				posX = this.zManager.pos();
				
				
			GameObject o= this.fabricarZombie.creaZombie(this.zManager.zombieType(),posX,7);
			this.list.insert(this.ciclos, o);
		}
		this.ciclos++;
	}

	public String obtenerPieza(int posX, int posY) {
		int posList;
		posList = this.list.containsPosition(posX, posY);
		
		if (posList != -1){
			return this.list.getList()[posList].getString();
		}
		return "     ";//vacio
	}

	public boolean InicializarZombies()
	{
		return this.zManager.Generador(this.semilla, this.level);
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
		if (!this.list.contains(posX, posY) && (posX >0 || posX < 4)&& (posY >0 || posY < 8) ){
			GameObject o  = this.fabricarPlanta.creaPlanta(planta, posX, posY);
			if(this.scm.getSunCoins() >= o.getCost())
			{
				if(o != null)
				{
					this.list.insert(this.ciclos, o);
					this.scm.removeSuncoins(o.getCost());
					return true;
				}
			}
			else
				System.out.println("No tienes suficientes sunCoins");
		}
		else
			System.out.println("Posicion no valida");
		return false;
	}
	public boolean addZombie(int posX, int posY)
	{
		if (!this.list.contains(posX, posY)){
			
			GameObject o  = this.fabricarZombie.creaZombie(this.zManager.zombieType(), posX, posY);
			this.list.insert(this.ciclos, o);
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	//Getters y Setters
	
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

	public int getPlantaCost(int i) {
		return this.fabricarPlanta.getPlantas()[i].getCost();
	}

	public int getPlantaHealth(int i) {
		return this.fabricarPlanta.getPlantas()[i].getHealth();
	}

	public int getPlantaDamage(int i) {
		// TODO Auto-generated method stub
		return this.fabricarPlanta.getPlantas()[i].getDamage();
	}

	public String getPlantaBehaviour(int i) {
		return this.fabricarPlanta.getPlantas()[i].getBehaviour();
	}

	public int getRemainingZombies() {
		// TODO Auto-generated method stub
		return this.zManager.getZombiesPorSalir();
	}
	 
}
