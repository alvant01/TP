package tp.p3.Command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import tp.p3.Exceptions.CommandExecuteException;
import tp.p3.Exceptions.FileContentsException;
import tp.p3.Game.Game;
//import tp.p3.util.MyStringUtils;

public class LoadCommand extends Command {

	private String fichero;
	
	public LoadCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws FileContentsException, CommandExecuteException, IOException{
		BufferedWriter inTmp = null;
		BufferedReader out = null;
		//System.out.println("El directorio temporal del sistema es "
		//		  + System.getProperty("java.io.tmpdir"));
		File file = new File(this.fichero + ".dat");
		File tempFile =  new File("PvZtmp.dat"); //archivo temporal
		try
		{
			inTmp =  new  BufferedWriter(new FileWriter(tempFile));
			inTmp.write("Archivo de salvado temporal ");
			inTmp.newLine();
			inTmp.newLine();
			game.store(inTmp);
			inTmp.close();
			
			if(!file.exists())
				throw new FileContentsException("Archivo no encontrado");
			/*if (MyStringUtils.fileExists(this.fichero)) //No funciona
			{
				throw new FileContentsException("Archivo no encontrado");
			}*/
			out =  new  BufferedReader(new FileReader(file));
			out.readLine();//Leo la cabecera
			out.readLine();//Leo el salto de linea
			game.load(out);
			System.out.println("Game successfully loaded from file " + this.fichero);
		}
		catch(IOException | NumberFormatException | NullPointerException ex)
		{
			BufferedReader outTmp =  new  BufferedReader(new FileReader(tempFile));
			outTmp.readLine();//Leo la cabecera
			outTmp.readLine();//Leo el salto de linea
			game.load(outTmp);
			out.close();
			throw new FileContentsException("Error loading, restoring to a previous game.");
		}
		finally
		{
			tempFile.delete();
		}
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].toLowerCase().equals("load") || commandWords[0].toLowerCase().equals("l"))
		{
			this.fichero = commandWords[1];
			return this;
		}
		return null;
	}

}
