package tp.p3.Command;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Exceptions.FileContentsException;
import tp.p3.Game.Game;
import tp.p3.util.MyStringUtils;

public class SaveCommand extends Command {

	
	private String fichero;
	
	public SaveCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	@Override
	public boolean execute(Game game) throws FileContentsException, IOException {
		BufferedWriter in = null;
		File file = new File(this.fichero+ ".dat");
		try
		{
			in =  new  BufferedWriter(new FileWriter(file));
			if (MyStringUtils.fileExists(this.fichero))
			{
				System.out.println("El fichero se sobreescribira");
			}
			 
			 
			in.write("Plants Vs Zombie V.3.0 ");
			in.newLine();
			in.newLine();
			game.store(in);
			
			System.out.println("Game successfully saved in file " + this.fichero + ".dat. Use the load command to reload it");
		}
		catch(IOException ex)
		{
			throw new FileContentsException("Error al crear la salva");
		}
		finally
		{
			in.close();
		}
		return false;
	}
	//Excepcion no se admiten ficheros con espacios
	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].toLowerCase().equals("save") || commandWords[0].toLowerCase().equals("s"))
		{
			this.fichero = commandWords[1];
			return this;
		}
		return null;
	}

}
