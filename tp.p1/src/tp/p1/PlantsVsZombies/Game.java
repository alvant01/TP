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
	
	private int ciclos;
	
	public Game(){
		this.psList   = new PeaShooterList();
		this.sfList   = new SunflowerList();
		this.zList    = new ZombieList();
		this.draw     = new GamePrinter(this);
		this.uCommand = new UserCommand(this);
		this.scm      = new SunCoinsManager();
		
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
		this.uCommand.reconocedor(comando);
		return false;
	}

	public void updateGame() {
		// TODO Auto-generated method stub
		
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
			this.sfList.insert(posX, posY);
			this.scm.setSunCoins(this.scm.getSunCoins() - this.sfList.getSfAux().getCost());
			return true;
		}
		return false;
	}
	
	
	
	
	 
}
