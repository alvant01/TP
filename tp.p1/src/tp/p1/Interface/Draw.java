package tp.p1.Interface;

import tp.p1.Game.ContCasillas;
import tp.p1.Game.Tablero;
import tp.p1.List.*;
public class Draw 
{
	
	private Tablero tablero;
	private SunflowerList SList;
	private PeaShooterList PList;
	private ZombieList ZList;
	
	public Draw()
	{}
	
	public Draw(Tablero t, SunflowerList SL, PeaShooterList PS, ZombieList ZL)
	{
		this.tablero = t;
		this.SList = SL;
		this.PList =PS;
		this.ZList = ZL;
	}
	
	
	
	public void drawTablero()
	{
		
		
		for (int i = 0; i < tablero.getFilas()*2; i++)
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
		for(int i = 0; i < tablero.getColumnas()-1; i++)
		{
			System.out.print("-------");
		}
		System.out.println("-------");
	}
	
	public void drawLineasV(int posX)
	{
		ContCasillas est = null;
		System.out.print("|");
		for(int posY = 0; posY< tablero.getColumnas(); posY++)
		{
			est = tablero.getEstadoCasilla(posX, posY);
		
			if( est != ContCasillas.VACIO)
			{
				drawFiguras(est,posX, posY);
			}
			else
			{
				System.out.print("      ");
			}
			System.out.print("|");
		}
		System.out.println("");
	}
	
	
	public void drawFiguras(ContCasillas est,int posX,int posY)
	{
		switch(est)
		{
		case  SUNFLOWER: System.out.print(" S[" + this.SList.getPlantHP(posX, posY) + "] ");
			break;
		case PEASHOOTER: System.out.print(" P[" + this.PList.getPlantHP(posX, posY) + "] ");
			break;
		case ZOMBIE: System.out.print(" Z[" + this.ZList.getZombieHP(posX, posY) + "] ");
			break;
		default:
			break;
		}
	}
	
}
