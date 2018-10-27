package tp.p1.PlantsVsZombies;

import tp.p1.List.*;
import tp.p1.Controladores.*;
import tp.p1.Interface.*;


public class Game {
	
	private PeaShooterList psList;
	private SunflowerList sfList;
	private ZombieList zList;
	
	private GamePrinter draw;
	
	private UserCommand uCommand;
	
	private SunCoinsManager scm;
	
	private ComputerAction cAction;

	private String level;
	
	private int semilla;
	
	
	private int ciclos;
	
	public Game(){
		this.psList   = new PeaShooterList();
		this.sfList   = new SunflowerList();
		this.zList    = new ZombieList();
		this.draw     = new GamePrinter(this);
		this.uCommand = new UserCommand(this);
		this.scm      = new SunCoinsManager();
		this.cAction  = new ComputerAction();
		
		this.ciclos= 0;
	}

	public void reiniciar() {
		this.psList.setNumElem(0);
		this.sfList.setNumElem(0);
		this.zList.setNumElem(0);
		
		
		
	}

	public void pintarTablero() {
		this.draw.drawTablero();
	}

	public boolean reconocedorComandos(String comando) {
		return this.uCommand.reconocedor(comando);
	}

	public void updateGame() {
		for(int i = 0; i < this.sfList.getNumElem();i++)
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
				this.zList.getHurt(this.sfList.getSfAux().getDamage(), this.psList.getListSP()[i].getPosX());
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
				else
				{
					this.zList.avanzar(this.zList.getListSZ()[i].getPosX(),this.zList.getListSZ()[i].getPosY());
				}
			}
		}
		this.cAction.Insertar(this.ciclos);
	}

	public String obtenerPieza(int posX, int posY) {
		if (this.sfList.contains(posX, posY))
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
		}
		return "    ";//vacio
	}

	public GamePrinter getDraw() {
		return draw;
	}

	public void setDraw(GamePrinter draw) {
		this.draw = draw;
	}

	public boolean addSunflower(int posX, int posY) {
		if (this.scm.getSunCoins() >= this.sfList.getSfAux().getCost())
		{
			this.sfList.insert(posX, posY, this.ciclos);
			this.scm.setSunCoins(this.scm.getSunCoins() - this.sfList.getSfAux().getCost());
			return true;
		}
		else
		{
			System.out.println("No tienes suficientes soles");
		}
		return false;
	}
	public boolean addPeaShooter(int posX, int posY) {
		if (this.scm.getSunCoins() >= this.psList.getPsAux().getCost())
		{
			this.psList.insert(posX, posY, this.ciclos);
			this.scm.setSunCoins(this.scm.getSunCoins() - this.psList.getPsAux().getCost());
			return true;
		}
		else
		{
			System.out.println("No tienes suficientes soles");
		}
		return false;
	}
	/*public void addZombie(int posX, int posY)
	{
		this.zList.insert(posX, posY, this.ciclos);
	}*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PeaShooterList getPsList() {
		return psList;
	}

	public void setPsList(PeaShooterList psList) {
		this.psList = psList;
	}

	public SunflowerList getSfList() {
		return sfList;
	}

	public void setSfList(SunflowerList sfList) {
		this.sfList = sfList;
	}

	public ZombieList getzList() {
		return zList;
	}

	public void setzList(ZombieList zList) {
		this.zList = zList;
	}

	public UserCommand getuCommand() {
		return uCommand;
	}

	public void setuCommand(UserCommand uCommand) {
		this.uCommand = uCommand;
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


	public ComputerAction getcAction() {
		return cAction;
	}

	public void setcAction(ComputerAction cAction) {
		this.cAction = cAction;
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
	
	public void InicializarZombies()
	{
		this.cAction.Generador(this.semilla, this.level);
	}
	
	public boolean win()
	{
		if(this.cAction.getZombiesRestantes() == 0)
		{
			return true;
		}
		return false;
	}
	public boolean lose()
	{
		for(int i = 0; i < this.zList.getNumElem();i++)
		{
			if(this.zList.contains(i, 0))
			{
				return true;
			}
		}
		return false;
	}
	
	
	 
}
