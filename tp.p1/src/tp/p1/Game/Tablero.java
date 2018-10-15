package tp.p1.Game;

import tp.p1.Game.ContCasillas;;


public class Tablero {
	private ContCasillas tablero[][];
	private int filas;
	private int columnas;
	private ContCasillas estado;
	
	public Tablero()
	{
		this.filas = 4;
		this.columnas = 8;
		
		tablero = new ContCasillas[this.filas][this.columnas];
		
		for(int i  = 0; i < this.filas ; i++)
		{
			for (int j = 0; j < this.columnas;j++ )
			{
				this.tablero[i][j] = ContCasillas.VACIO;
			}
		}
	}
	
	
	public void change(ContCasillas newEstado, int posX,int posY)
	{
		this.tablero[posX][posY] = newEstado;
	}


	public ContCasillas[][] getTablero() {
		return tablero;
	}
	public ContCasillas getEstadoCasilla(int x, int y) {
		return tablero[x][y];
	}

	public void setTablero(ContCasillas[][] tablero) {
		this.tablero = tablero;
	}


	public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}


	public int getColumnas() {
		return columnas;
	}


	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}


	public ContCasillas getEstado() {
		return estado;
	}


	public void setEstado(ContCasillas estado) {
		this.estado = estado;
	}
}
