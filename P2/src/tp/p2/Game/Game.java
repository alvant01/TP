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
	
	private SunList sList;
	
	private PlantFactory fabricarPlanta;
	
	private ZombieFactory fabricarZombie;
	
	private SunCoinsManager scm;
	
	private ZombieManager zManager;
	
	private GameObject gObject;

	private String level;
	
	private int semilla;
	
	private boolean printDebug;
	
	private boolean alreadyCatch;
	
	private int ciclos;
	
	public Game(){
		this.list	  		= new List();
		this.sList			= new SunList();
		this.scm      		= new SunCoinsManager();
		this.gObject 		= new GameObject();
		this.fabricarPlanta = new PlantFactory(this.gObject);
		this.fabricarZombie = new ZombieFactory(this.gObject);
		this.zManager		= new ZombieManager();
		
		this.printDebug = false;
		this.ciclos= 0;
	}

	public void reiniciar() {
		this.list.setNumElem(0);
	}

	public void updateGame() {
		int posX;
		this.list.update(this, this.ciclos);
		
		if(this.zManager.cicloZombie(this.ciclos))
		{
			posX = this.zManager.pos();
			while(this.list.containsZombie(posX, 7))
				posX = this.zManager.pos();
				
				
			GameObject o= this.fabricarZombie.creaZombie(this.zManager.zombieType(),posX,7);
			this.list.insert(this.ciclos, o);
			this.zManager.setZombiesPorSalir(this.zManager.getZombiesPorSalir()-1);
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
	
	public char obtenerSun(int posX, int posY) {
		int posList;
		posList = this.sList.containsPosition(posX, posY);
		
		if (posList != -1){
			return this.sList.getsList()[posList].getVisual();
		}
		return ' ';//vacio
	}


	public String obtenerPiezaDebug(int i) { 
		String s =  this.list.getList()[i].getString() + "[l:" + this.list.getList()[i].getHealth() + ",x:" + this.list.getList()[i].getPosX()+ ",y:" + this.list.getList()[i].getPosY()+ ",t:";
		if(this.list.getList()[i].getFrecuency() != 0)
			if((this.ciclos - this.list.getList()[i].getCicloI())%this.list.getList()[i].getFrecuency() == 0)
				s = s + 0;
			else
				s = s + (this.list.getList()[i].getFrecuency()-((this.ciclos - this.list.getList()[i].getCicloI())%this.list.getList()[i].getFrecuency()));
		else
			s  =s + 0;
		return s;

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
		this.semilla=this.zManager.semillaRandom();
	}

	public boolean isFinished() {
		if(this.zManager.getZombiesRestantes()==0)
		{
			System.out.println("Player Wins");
			return true;
		}
		else if(this.list.lose())
		{
			System.out.println("Zombies Wins");
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


	public void printMode() {
		if(this.printDebug)
			this.printDebug = false;
		else
			this.printDebug = true;
		
	}

	public void catchSun(int posX, int posY) {
		if(!this.alreadyCatch)
		{	
			if(this.sList.getSunCoins(posX, posY))
			{
				this.scm.addSunCoins(20);
				this.alreadyCatch = true;
			}
		}
		else
		{
			System.out.println("Solo un sol por turno");
		}
	}
	
	public void setAlreadyCatch(boolean alreadyCatch) {
		this.alreadyCatch = alreadyCatch;
	}

	public void updateSuns() {
		if(this.ciclos%this.sList.getFrecuencia() == 0)
		{
			this.sList.insertRandom();
		}
		
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
		return this.zManager.getZombiesPorSalir();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public PlantFactory getFabricarPlanta() {
		return fabricarPlanta;
	}

	public void setFabricarPlanta(PlantFactory fabricarPlanta) {
		this.fabricarPlanta = fabricarPlanta;
	}

	public ZombieFactory getFabricarZombie() {
		return fabricarZombie;
	}

	public void setFabricarZombie(ZombieFactory fabricarZombie) {
		this.fabricarZombie = fabricarZombie;
	}

	public ZombieManager getzManager() {
		return zManager;
	}

	public void setzManager(ZombieManager zManager) {
		this.zManager = zManager;
	}

	public GameObject getgObject() {
		return gObject;
	}

	public void setgObject(GameObject gObject) {
		this.gObject = gObject;
	}

	public String getLevel() {
		return level;
	}
	public boolean getPrintDebug() {
		return printDebug;
	}

	public void setPrintDebug(boolean printDebug) {
		this.printDebug = printDebug;
	}


	public void setReamingZombies() {
		this.zManager.setZombiesRestantes(this.zManager.getZombiesRestantes()-1);
	}


	public SunList getsList() {
		return sList;
	}

	public void setsList(SunList sList) {
		this.sList = sList;
	}

	public boolean isAlreadyCatch() {
		return alreadyCatch;
	}

	public void addSun(int posX, int posY) {
		this.sList.insert(posX,posY);
	}


	 
}
