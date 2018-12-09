package tp.p3.Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.Controladores.*;
import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Exceptions.FileContentsException;
import tp.p3.List.*;
import tp.p3.Printers.DebugPrinter;
import tp.p3.Printers.GamePrinter;
import tp.p3.Printers.ReleasePrinter;
import tp.p3.Factory.*;


public class Game {
	private List list;
	
	private SunList sList;
	
	private PlantFactory fabricarPlanta;
	
	private ZombieFactory fabricarZombie;
	
	private SunCoinsManager scm;
	
	private ZombieManager zManager;

	private String level;
	
	private int semilla;
	
	private boolean alreadyCatch;
	
	private int ciclos;
	
	private GamePrinter gPrinter;

	private boolean printDebug;
	
	private boolean exit;
	
	private boolean noPrint;
	
	public Game(){
		this.list	  		= new List();
		this.sList			= new SunList();
		this.scm      		= new SunCoinsManager();
		this.fabricarPlanta = new PlantFactory();
		this.fabricarZombie = new ZombieFactory();
		this.zManager		= new ZombieManager();
		this.gPrinter 		= new ReleasePrinter(this);
		this.exit 			= false;
		this.printDebug 	= false;
		this.ciclos= 0;
	}

	public void reiniciar() {
		this.list.setNumElem(0);
		this.ciclos = 0;
	}

	public void updateGame() throws CommandExecuteException {
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
		String s =  this.list.getList()[i].getStringNoHealth() + "[l:" + this.list.getList()[i].getHealth() + ",x:" + this.list.getList()[i].getPosX()+ ",y:" + this.list.getList()[i].getPosY()+ ",t:";
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
		else if(this.exit)
		{
			System.out.println("****** Game over!: User exit ******\r\n" + "");
			return true;
		}
		return false;
	}
	@SuppressWarnings("unused")
	public boolean addPlant(String planta, int posX, int posY) throws CommandExecuteException
	{
		//Llamar factory
		if (!this.list.contains(posX, posY) && (posX >= 0 && posX < 4)&& (posY >= 0 && posY < 8) ){
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
				throw new CommandExecuteException("No hay soles");
		}
		else
			throw new CommandExecuteException("Posicion no valida: Fuera de Rango.");
		return false;
	}
	public boolean addZombie(int posX, int posY) throws CommandExecuteException
	{
		this.fabricarZombie = new ZombieFactory();
		if (!this.list.contains(posX, posY)){
			
			GameObject o  = this.fabricarZombie.creaZombie(this.zManager.zombieType(), posX, posY);
			this.list.insert(this.ciclos, o);
			return true;
		}
		return false;
	}



	public void catchSun(int posX, int posY) throws CommandExecuteException {
		if(!this.alreadyCatch)
		{	
			if(this.sList.getSunCoins(posX, posY))
			{
				this.scm.addSunCoins(10);
				this.alreadyCatch = true;
			}
			else
			{
				throw new CommandExecuteException("No hay sol en esa casilla");
			}
		}
		else
		{
			throw new CommandExecuteException("Solo un sol por turno");
		}
	}
	
	public void setAlreadyCatch(boolean alreadyCatch) {
		this.alreadyCatch = alreadyCatch;
	}

	public void updateSuns() {
		if(this.ciclos%this.sList.getFrecuencia() == 0)
		{
			this.scm.insertRandom();
		}
		
	}
	
	public void setExit(boolean exit) {
		this.exit = exit;
	}



	public void printMode() {
		if(!this.printDebug)
		{
			this.gPrinter = new DebugPrinter(this);
			this.printDebug =true;
		}
		else
		{
			this.gPrinter = new ReleasePrinter(this);
			this.printDebug =false;
		}
		
	}
	public void printGame()
	{		
		this.gPrinter.printGame();
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
		return PlantFactory.getPlantas()[i].getCost();
	}

	public int getPlantaHealth(int i) {
		return PlantFactory.getPlantas()[i].getHealth();
	}

	public int getPlantaDamage(int i) {
		return PlantFactory.getPlantas()[i].getDamage();
	}

	public String getPlantaBehaviour(int i) {
		return PlantFactory.getPlantas()[i].getBehaviour();
	}
	
	//Zombies
	public int getZombienHealth(int i){
		return ZombieFactory.getZombies()[i].getHealth();
	}
	public int getZombieDamage(int i){
		return ZombieFactory.getZombies()[i].getDamage();
	}
	public String getZombieBehaviour(int i){
		return ZombieFactory.getZombies()[i].getBehaviour();
	}
	public int getZombieFrecuency(int i){
		return ZombieFactory.getZombies()[i].getFrecuency();
	}

	
	//hasta aqui
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

	public String getLevel() {
	String level;
		if(this.level.toLowerCase().equals("e"))
			level = "EASY";
		else if(this.level.toLowerCase().equals("h"))
			level = "HARD";
		else
			level = "INSANE";
		return level;
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

	public void cherryExplosion(int posX, int posY, int damage) {
		this.list.cherryExplosion(posX, posY, damage,this);
	}
	public void damageZombie(int posX, int posY, int damage) {
		this.list.damageZombie(posX, posY, damage, this);
	}
	public void damagePlant(int posX, int posY, int damage) {
		this.list.damagePlant(posX, posY, damage);
	}

	public boolean contains(int posX, int posY) throws CommandExecuteException {
		return this.list.contains(posX, posY);
	}

	public void store(BufferedWriter in) throws IOException {
		in.write("cycle: " + this.ciclos);
		in.newLine();
		in.write("sunCoins: " + this.scm.getSunCoins());
		in.newLine();
		in.write("level: " + this.ciclos);
		in.newLine();
		in.write("remZombies: " + this.getRemainingZombies());
		in.newLine();
		this.list.store(in);
	}

	public void load(BufferedReader out) throws FileContentsException, CommandExecuteException {
		String s1;
		try {
			this.reiniciar();
			s1 = out.readLine();

			this.setCiclos(loadParseAux(s1, 7));
			
			s1 = out.readLine();
			
			this.scm.setSunCoins(loadParseAux(s1, 10));
			
			s1 = out.readLine();
			
			this.level = String.valueOf(loadParseAux(s1, 7));
			
			s1 = out.readLine();
			
			this.zManager.setZombiesRestantes(loadParseAux(s1, 12));

			s1 = out.readLine();
			if(s1 != null)
				this.list.load(s1.toCharArray(), this);
			
			
		} catch (IOException e) {
			throw new FileContentsException("Error al cargar el fichero");
		}
		
	}
	
	public int loadParseAux(String s, int pos) throws FileContentsException
	{
		String sAux = "";

		for(int i = pos;i < s.length(); i++ )
		{
			sAux += s.charAt(i);
		}
		return Integer.parseInt(sAux);

	}
	
	public void insertarLoad(String s, int h, int posX, int posY, int ciclo ) throws CommandExecuteException
	{
		GameObject o;
		if(GameObject.isPlant(s))
			 o  = this.fabricarPlanta.creaPlanta(s, posX, posY);
		else
			 o= this.fabricarZombie.creaZombie(this.zManager.parse(s), posX, posY);
		o.setHeath(h);
		this.list.insert(ciclo, o);
	}

	public boolean isExit() {
		return exit;
	}
	
	 
}
