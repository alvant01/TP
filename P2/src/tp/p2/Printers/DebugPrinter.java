package tp.p2.Printers;

import tp.p2.Game.Game;

public class DebugPrinter extends BoardPrinter {
	
	public DebugPrinter(Game g) {
		super(g);
	}

	@Override
	public void encodeGame() {
		
	}

	public void debugPrinter() {
		
		if(this.game.getList().getNumElem() > 0)
		{
			for(int i = 0; i < this.game.getList().getNumElem(); i++)
			{
				System.out.print("--------------------");
			}
			System.out.println();
			System.out.print("|");
			for(int i = 0; i < this.game.getList().getNumElem(); i++)
			{
				System.out.print(this.game.obtenerPiezaDebug(i) + "|");
			}
			System.out.println();
			for(int i = 0; i < this.game.getList().getNumElem(); i++)
			{
				System.out.print("--------------------");
			}
			System.out.println();
		}
	}
	public void releasePrinter() {
		System.out.println("Random seed used: " + this.game.getSemilla());
		System.out.println("Number of cycles: " + this.game.getCiclos());
		System.out.println("Sun coins: " + this.game.getScm().getSunCoins());
		System.out.println("Remaning zombies: " + this.game.getRemainingZombies());
		System.out.println("Level: " + this.game.getLevel());
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
	@Override
	public void printGame() {
		debugPrinter();
		releasePrinter();
		
	}


}
