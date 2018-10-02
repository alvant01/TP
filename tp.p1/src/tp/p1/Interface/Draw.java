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
		
		
		for (int i = 0; i < tablero.getFilas(); i++)
		{
			if (i%2 != 0)
			{
			
				for(int j = 0; j < tablero.getColumnas();j++)
				{
					drawLineasV(i,j);
					
				}
			}
			else
			{
				drawLineasH();
			}
			
		}
	}
	
	public void drawLineasH()
	{
		System.out.print(" ");
		for(int i = 0; i < tablero.getColumnas()-1; i++)
		{
			System.out.print("-------");
		}
		System.out.println("-------");
	}
	
	public void drawLineasV(int posX, int posY)
	{
		ContCasillas est = null;
		System.out.print("|");
		for(; posY< tablero.getColumnas(); posY++)
		{
			if(tablero.getEstadoCasilla(posX, posY) != est.VACIO)
			{
				switch(tablero.getEstadoCasilla(posX, posY))
				{
				case  est.GIRASOL: System.out.print("P[" + this.SList.getPlantHP(posX, posY) + "]");
				break;
				
				}
				
			}
		}
	}
	
	
	public void drawFiguras()
	{}
	
	
	
	
	
	
}
