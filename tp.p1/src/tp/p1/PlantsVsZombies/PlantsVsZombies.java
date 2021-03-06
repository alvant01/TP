package tp.p1.PlantsVsZombies;

import tp.p1.Controladores.Controller;
//Pintar tablero --Completos
//Comandos --Completos
//update	--Completo
//Zombies	-Completo
//Flujo		-
public class PlantsVsZombies
{
	private Game gameMaster;
	private Controller controllerMaster; 
	public PlantsVsZombies()
	{
		this.gameMaster = new Game();
		this.controllerMaster = new Controller(gameMaster);
	}

	public static void main(String args[])
	{
		PlantsVsZombies pvz = new PlantsVsZombies();
		if(args.length == 1)
		{
			pvz.gameMaster.setLevel(args[0]);
		}
		else if(args.length == 2)
		{
			pvz.gameMaster.setLevel(args[0]);
			pvz.gameMaster.setSemilla(Integer.parseInt(args[1]));
		}
		else
		{
			pvz.controllerMaster.menuSemLevel();
		}
		pvz.controllerMaster.run();
	}

}






















/*import java.util.Arrays;



import java.util.Random;
import java.util.Scanner;

import tp.p1.Controladores.Commands;
import tp.p1.Controladores.ComputerAction;
import tp.p1.Controladores.SunCoinsManager;
import tp.p1.Controladores.UserCommand;
import tp.p1.Game.Tablero;
import tp.p1.Interface.Draw;
import tp.p1.Interface.Update;
import tp.p1.List.PeaShooterList;
import tp.p1.List.SunflowerList;
import tp.p1.List.ZombieList;

public class PlantsVsZombies {

	private UserCommand uCommand;
	private PeaShooterList psList;
	private SunflowerList sfList;
	private ZombieList zList;
	private SunCoinsManager sunCoins;
	private boolean fin;
	
	private ComputerAction ca;
		
	private Draw draw;
	
	private Update update;
	
	private Tablero tablero;
	
	public PlantsVsZombies()
	{
		this.fin = false;
		this.psList  = new PeaShooterList();
		this.sfList = new SunflowerList();
		this.zList = new ZombieList();
		
		this.uCommand = new UserCommand(this.sfList, this.psList, this.zList);
		
		this.sunCoins = new SunCoinsManager();
		this.tablero = new Tablero();
		this.update = new Update(this.tablero);
		
		
		this.draw = new Draw(this.tablero,this.sfList, this.psList, this.zList);
		
		this.ca = new ComputerAction(this.zList);
		
	}
	public static void main(String args[])
	{
		PlantsVsZombies PvZ = new PlantsVsZombies();
		
		PvZ.draw.drawTablero();
		while(!PvZ.menuCommands())
		{
			PvZ.updateGame();
			PvZ.draw.drawTablero();
		}
	}
	
	public boolean menuCommands()
	{	
		PreguntaSemilla();
		
		String comando;
		Scanner sc = new Scanner(System.in);
		System.out.print("Command > ");
		comando = sc.next();
		
		while (!(comando.toLowerCase().equals("exit")) && !(comando.toUpperCase().equals("E")))
		{
			if (comando.toLowerCase().equals("reset") || comando.toUpperCase().equals("R"))
			{
				this.reiniciar();
				this.pintarTablero();
				System.out.print("Command > ");
				comando = sc.next();
			}
			while(!this.uCommand.reconocedor(this.tablero, comando, sc, this.sunCoins))
				comando = sc.next();
			
			if (this.win())
			{
				System.out.println("Victoria");
				return true;
			}
			else if (this.fin)
			{
				System.out.println("Has Perdido");
				return true;
			}
			sc.reset();
			this.updateGame();
			this. pintarTablero();
			System.out.print("Command > ");
			comando = sc.next();
			
		}
		sc.close();
		return false;
		
	}
	
	
	public int PreguntaSemilla(){
		
		int semilla = 0;
		String levelIntroducido;
		String deseo;
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Introduce nivel a jugar: ");
		levelIntroducido = sc1.next();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Deseas introducir semilla? S o N ");
		deseo = sc2.next();
		
		if (deseo.toUpperCase().equals("SI") || deseo.toUpperCase().equals("S")){
			Scanner sc3 = new Scanner(System.in);
			System.out.print("Introduce Semilla: ");
			semilla = sc3.nextInt();
		}
		else if (deseo.toUpperCase().equals("NO") || deseo.toUpperCase().equals("N")){
			Random rd = new Random();
			semilla = rd.nextInt();
	
		}
		
		this.ca.Generador(ca.getNumZomGen(), semilla, levelIntroducido);
		return semilla;		
		
	}
	
	public void reiniciar()
	{
		this.psList.setNumElem(0);
		this.sfList.setNumElem(0);
		this.zList.setNumElem(0);
		
		this.sunCoins.setSunCoins(20);
		this.tablero = new Tablero();
		this.update = new Update(this.tablero);
		this.draw = new Draw(this.tablero,this.sfList, this.psList, this.zList);
		
	}
	public boolean win()
	{
		int i[] = new int[5555];
		int j = 0;
		return false;
	
/*		if(this.ca.getZombiesRestantes == 0)
		{
			return true;
		}
		else return false;
	}
	
	public void updateGame()
	{
		update.actualizarTablero(this);
	}
	public void pintarTablero()
	{
		System.out.println(this.sunCoins.getSunCoins());
		this.draw.drawTablero();
	}
	
	
	
	
	
	public ComputerAction getComputerAction()
	{
		return this.ca;
	}
	
	
	public UserCommand getuCommand() {
		return uCommand;
	}
	public void setuCommand(UserCommand uCommand) {
		this.uCommand = uCommand;
	}
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
	public Update getUpdate() {
		return update;
	}
	public void setUpdate(Update update) {
		this.update = update;
	}
	public SunCoinsManager getSunCoins() {
		return sunCoins;
	}
	public void setSunCoins(SunCoinsManager sunCoins) {
		this.sunCoins = sunCoins;
	}
	public Draw getDraw() {
		return draw;
	}
	public void setDraw(Draw draw) {
		this.draw = draw;
	}
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	public ComputerAction getCa() {
		return ca;
	}
	public void setCa(ComputerAction ca) {
		this.ca = ca;
	}
}*/