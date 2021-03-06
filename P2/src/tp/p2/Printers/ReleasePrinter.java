package tp.p2.Printers;

import tp.p2.Game.Game;

public class ReleasePrinter extends BoardPrinter {
	
	int cellSize = 7;
	String space = " ";
	String vDelimiter = "|";
	String hDelimiter = "-";
	
	public ReleasePrinter(Game g)
	{
		super(g);
	}
	
	public void releasePrinter() {
		System.out.println("Number of cycles: " + this.game.getCiclos());
		System.out.println("Sun coins: " + this.game.getScm().getSunCoins());
		System.out.println("Remaning zombies: " + this.game.getRemainingZombies());
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

	@Override
	public void encodeGame() {
		
	}
	
	
	public void drawLineasH()
	{
		//StringBuilder sb = new StringBuilder();
		System.out.print(" ");
		for(int i = 0; i < this.numColum-1; i++)
		{
			System.out.print("--------");
		}
		System.out.println("--------");
	}
	
	public void drawLineasV(int posX)
	{
		System.out.print("|");
		for(int posY = 0; posY< this.numColum; posY++)
		{
			drawFiguras(posX, posY);
			drawSun(posX, posY);
			System.out.print("|");
		}
		System.out.println("");
	}
	
	
	private void drawSun(int posX, int posY) {
		System.out.print(this.game.obtenerSun(posX, posY));
		
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

	@Override
	public void printGame() {
		releasePrinter();
		
	}

}
