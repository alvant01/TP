package tp.p1.Controladores;

import tp.p1.Plants.Sunflower;

public class UserCommand {
	

	private enum commands{ADD, RESET, LIST, NONE, EXIT};
	
	private String userCommand;
	
	private String plantAdd;
	
	private int x;
   
	private int y;
	
	//public UserCommand()
	//{}
	
	public UserCommand(String com, String plant, int x, int y)
	{
		this.userCommand = com;
		this.plantAdd = plant;
		this.x = x;
		this.y = y;
	}
	
	public UserCommand(String com)
	{
		this.userCommand = com;
	}

	public String getUserCommand() {
		return userCommand;
	}

	public void setUserCommand(String userCommand) {
		this.userCommand = userCommand;
	}

	public String getPlantAdd() {
		return plantAdd;
	}

	public void setPlantAdd(String plantAdd) {
		this.plantAdd = plantAdd;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public add()
	{
		Sunflower f = new Sunflower();
		if(this.plantAdd == f.toString() )
		{
			//pasa por parametros
		}
		
	}
	

}
