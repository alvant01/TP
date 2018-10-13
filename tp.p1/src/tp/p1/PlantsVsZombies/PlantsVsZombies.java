package tp.p1.PlantsVsZombies;

import java.util.Scanner;

import tp.p1.Controladores.Commands;
import tp.p1.Controladores.UserCommand;
import tp.p1.Interface.Update;
import tp.p1.List.PeaShooterList;
import tp.p1.List.SunflowerList;
import tp.p1.List.ZombieList;

public class PlantsVsZombies {

	private UserCommand uCommand;
	private PeaShooterList psList;
	private SunflowerList sfList;
	private ZombieList zList;
	private int sunCoins;
	
	private Update update;
	
	public PlantsVsZombies()
	{
		this.psList  = new PeaShooterList();
		this.sfList = new SunflowerList();
		this.zList = new ZombieList();
		
		this.uCommand = new UserCommand(this.sfList, this.psList, this.zList);
		
		this.sunCoins = 0;
		
		this.update = new Update();
	}
	public static void main(String args[])
	{
		
	}
	
	public void menuCommands()
	{
		String comando;
		Scanner sc = new Scanner(System.in);
		System.out.print("Command > ");
		comando = sc.nextLine();
		if (comando.toLowerCase() == "exit")
		{}
		else
			while(!this.uCommand.reconocedor(comando))
				comando = sc.nextLine();
	}
	
	public void updateGame()
	{
		update.actualizarTablero(this);
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
	public int getSunCoins() {
		return sunCoins;
	}
	public void setSunCoins(int sunCoins) {
		this.sunCoins = sunCoins;
	}
	public Update getUpdate() {
		return update;
	}
	public void setUpdate(Update update) {
		this.update = update;
	}
}
