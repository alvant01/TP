package tp.p1.Interface;

import tp.p1.PlantsVsZombies.Game;
public class GamePrinter 
{
	
	private Game game;
	private int numFilas;
	private int numColum;
	
	
	
	int cellSize = 7;
	String space = " ";
	String vDelimiter = "|";
	String hDelimiter = "-";
	
	public GamePrinter(Game g)
	{
		this.game = g;
		this.numFilas = 4;
		this.numColum = 8;
	}
	
	
	
	public void drawTablero()
	{
		
		
		for (int i = 0; i < this.numFilas*2; i++)
		{
			if (i%2 != 0)
			{

				drawLineasV(i/2);
			}
			else
			{
				drawLineasH();
			}
			
		}
		drawLineasH();
	}
	
	public void drawLineasH()
	{
		StringBuilder sb = new StringBuilder();
		System.out.print(" ");
		for(int i = 0; i < this.numColum-1; i++)
		{
			System.out.print("-------");
		}
		System.out.println("-------");
	}
	
	public void drawLineasV(int posX)
	{
		System.out.print("|");
		for(int posY = 0; posY< this.numColum; posY++)
		{
			drawFiguras(posX, posY);
			System.out.print("|");
		}
		System.out.println("");
	}
	
	
	public void drawFiguras(int posX,int posY)
	{
		String pieza;
		pieza = this.game.obtenerPieza(posX, posY);
		
		System.out.print("[ " + pieza + " ]");
	}



	public int getNumFilas() {
		return numFilas;
	}



	public void setNumFilas(int numFilas) {
		this.numFilas = numFilas;
	}



	public int getNumColum() {
		return numColum;
	}



	public void setNumColum(int numColum) {
		this.numColum = numColum;
	}
	
}
