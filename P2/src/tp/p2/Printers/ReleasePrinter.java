package tp.p2.Printers;

import tp.p2.Game.Game;

public class ReleasePrinter extends BoardPrinter {

	private Game game;
	private int numFilas;
	private int numColum;
	
	
	
	int cellSize = 7;
	String space = " ";
	String vDelimiter = "|";
	String hDelimiter = "-";
	
	public ReleasePrinter(Game g)
	{
		this.game = g;
		this.numFilas = 4;
		this.numColum = 8;
	}
	
	public void ReleasePrinter(int semilla, int ciclos, int sunCoins, int zombies) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void encodeGame() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void printGame(int semilla, int ciclos, int sunCoins, int zombies)
	{
		
		System.out.println("Random seed used: " + semilla);
		System.out.println("Number of cycles: " + ciclos);
		System.out.println("Sun coins: " + sunCoins);
		System.out.println("Remaning zombies: " + zombies);
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
		//StringBuilder sb = new StringBuilder();
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
		
		System.out.print("" + pieza + " ");
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
