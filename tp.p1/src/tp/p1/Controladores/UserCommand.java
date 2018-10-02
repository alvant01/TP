package tp.p1.Controladores;

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
	
	
	
	

}
