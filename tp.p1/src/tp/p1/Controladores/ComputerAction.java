package tp.p1.Controladores;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.lang.String;

import tp.p1.Game.ContCasillas;
import tp.p1.Game.Tablero;
import tp.p1.List.ZombieList;
import tp.p1.PlantsVsZombies.*;

public class ComputerAction {
	
	private ZombieList ListaZombie;
	private Tablero T;
	private int[] CiclosA;
	private int nivel;
	private int numZomGen;
	private int ZombiesRestantes;
	private int ZombiesPorSalir;
	private int semilla;
	private String nivelI;
		
	public ComputerAction(ZombieList zl) {
		
		this.ListaZombie = zl;
		this.CiclosA = this.Generador(nivel, semilla);
		

	
		
	}
	
	public int Reconocedor(String levelIntroducido){
		
		if (levelIntroducido.toUpperCase().equals(Level.EASY.toString()) || levelIntroducido.toUpperCase().equals("E")){
			numZomGen = 3;
			return numZomGen;
		}
		else if (levelIntroducido.toUpperCase().equals(Level.HARD.toString()) || levelIntroducido.toUpperCase().equals("H")){
			numZomGen = 5;
			return numZomGen;
		}
		else if (levelIntroducido.toUpperCase().equals(Level.INSANE.toString()) || levelIntroducido.toUpperCase().equals("I")){
			numZomGen = 10;
			return numZomGen;
		}
		return 0;
		
	}
	


	public int[] Generador(int numZomGen, int semilla){
		
		Random rd = new Random(semilla);
		int[] ciclos = new int [20];
		int PosA = 0;
		int numZombiesAcum = 0;
		int contCiclos = 0;
		double frecuencia = 0;
		float aleatorio;
				
		if (numZomGen == 3)
		{
			frecuencia = 0.1;
		}
		else if (numZomGen == 5){
			frecuencia = 0.2;
		}
		else if (numZomGen == 10){
			frecuencia = 0.3;
		}
		
		while ( numZombiesAcum < numZomGen ){
			//genera un numero aleatorio entre 0 y 1
			aleatorio = rd.nextFloat();
			//frecuencia++;
			//escoge los numero menores a la frecuencia, con lo que equivaldria a la probabilidad del nivel
			if (aleatorio <= frecuencia){
				PosA = contCiclos;
				contCiclos++;
				numZombiesAcum++;
				Arrays.fill(ciclos, PosA);
			}
			else{
				contCiclos++;
			}
		
		}
		return ciclos;
}

	public int GenerarFila(int semilla){
		Random rd = new Random(semilla);
		int fila;
		fila = rd.nextInt();
		return fila;
	}

	public boolean Insertar(int[] ciclos, int ciclo, int fila, Tablero t){
		
		//int n = 0;
		//int PosA = numZomGen;
		boolean encontrado = false;
		int i = 0;
		int posY = 7;
		int posX = fila;
		boolean insertado;
		
		
		while (encontrado == false ){
			// recorro el arreglo, si el ciclo en el que esta corresponde
			if (ciclos[i] == ciclo){
				this.ListaZombie.insert(posX, posY);
				i++;
				encontrado = true;
				insertado = true;
				t.change(ContCasillas.ZOMBIE, posX, posY);

				return insertado;
				
			}
		}
		//t.change(ContCasillas.ZOMBIE, posX, posY);
		return insertado = false;
		
	}
}
