package tp.p2.Printers;

import tp.p2.Game.Game;

public class DebugPrinter extends BoardPrinter {

	private Game game;
	
	public DebugPrinter(Game g) {
		this.game = g;
	}

	@Override
	public void encodeGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReleasePrinter() {
		// TODO Auto-generated method stub
		
	}
	
	//Mejorar
	public void DebugPrinter() {
		for(int i = 0; i < this.game.getList().getNumElem(); i++)
		{
			System.out.print("-----------------------");
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
			System.out.print("-----------------------");
		}
		System.out.println();
		
	}


}
