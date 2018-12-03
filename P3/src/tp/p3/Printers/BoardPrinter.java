package tp.p3.Printers;

import tp.p3.Game.Game;

public abstract class BoardPrinter implements GamePrinter {


	protected Game game;
	protected int numFilas;
	protected int numColum;
	
	public BoardPrinter(Game g)
	{
		this.game = g;
		this.numFilas = 4;
		this.numColum = 8;
	}
	public abstract void encodeGame();
	
	public abstract void printGame();

}
