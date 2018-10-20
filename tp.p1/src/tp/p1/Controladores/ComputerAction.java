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
	private Tablero t;
	private int[] ciclos;
	//private int nivel;
	private int numZomGen;
	private int ZombiesRestantes;
	private int ZombiesPorSalir;
	private int semilla;
	private String nivelI;
	private int fila;
	private String levelIntroducido;
		
	public ComputerAction(ZombieList zl) {
		
		this.ListaZombie = zl;
		

	
		
	}
	
	
	public int Reconocedor(String levelIntroducido){
		
		if (levelIntroducido.toUpperCase().equals(Level.EASY.toString()) || levelIntroducido.toUpperCase().equals("E")){
			this.numZomGen = 3;
			return this.numZomGen;
		}
		else if (levelIntroducido.toUpperCase().equals(Level.HARD.toString()) || levelIntroducido.toUpperCase().equals("H")){
			this.numZomGen = 5;
			return this.numZomGen;
		}
		else if (levelIntroducido.toUpperCase().equals(Level.INSANE.toString()) || levelIntroducido.toUpperCase().equals("I")){
			this.numZomGen = 10;
			return this.numZomGen;
		}
		return 0;
		
	}
	


	public void Generador(int numZomGen, int semilla, String levelIntroducido){
		
		Random rd = new Random(semilla);
		this.ciclos = new int [3];
		int PosA = 0;
		int numZombiesAcum = 0;
		int contCiclos = 0;
		double frecuencia = 0;
		float aleatorio;
		this.numZomGen = Reconocedor(levelIntroducido);
				
		if (this.numZomGen == 3)
		{
			frecuencia = 0.1;
		}
		else if (this.numZomGen == 5){
			frecuencia = 0.2;
		}
		else if (this.numZomGen == 10){
			frecuencia = 0.3;
		}
		
		int i = 0;
				
		while ( numZombiesAcum < this.numZomGen ){
			//genera un numero aleatorio entre 0 y 1
			aleatorio = rd.nextFloat();
			//frecuencia++;
			//escoge los numero menores a la frecuencia, con lo que equivaldria a la probabilidad del nivel
			
			if (aleatorio <= frecuencia){
				PosA = contCiclos;
				contCiclos++;
				numZombiesAcum++;
				this.ciclos[i] = PosA;
				i++;
				//Arrays.fill(this.ciclos, PosA);
			}
			else{
				contCiclos++;
			}
		
		}
		//return this.ciclos;
}

	public int GenerarFila(int semilla){
		Random rd = new Random(semilla);
		
		this.fila = rd.nextInt();
		return this.fila;
	}

	

	public int Insertar(int ciclo, Tablero t){
		
		//int n = 0;
		//int PosA = numZomGen;
		boolean encontrado = false;
		int i = 0;
		int posY = 7;
		int posX = this.fila;
		boolean insertado;
		
		
		
		while (encontrado == false && i < this.numZomGen ){
			// recorro el arreglo, si el ciclo en el que esta corresponde
			if (this.ciclos[i] == ciclo){
				this.ListaZombie.insert(posX, posY);
				i++;
				encontrado = true;
				//insertado = true;
				this.ZombiesPorSalir--;
				t.change(ContCasillas.ZOMBIE, posX, posY);

				return this.ZombiesPorSalir;
				
			}
			else {
				i++;
			}
		}
		//t.change(ContCasillas.ZOMBIE, posX, posY);
		return this.ZombiesPorSalir;
		
	}


	public ZombieList getListaZombie() {
		return ListaZombie;
	}


	public void setListaZombie(ZombieList listaZombie) {
		ListaZombie = listaZombie;
	}


	public Tablero getT() {
		return t;
	}


	public void setT(Tablero t) {
		this.t = t;
	}


	public int[] getCiclos() {
		return ciclos;
	}


	public void setCiclos(int[] ciclos) {
		this.ciclos = ciclos;
	}


	public int getNumZomGen() {
		return numZomGen;
	}


	public void setNumZomGen(int numZomGen) {
		this.numZomGen = numZomGen;
	}


	public int getZombiesRestantes() {
		return ZombiesRestantes;
	}


	public void setZombiesRestantes(int zombiesRestantes) {
		ZombiesRestantes = zombiesRestantes;
	}


	public int getZombiesPorSalir() {
		return ZombiesPorSalir;
	}


	public void setZombiesPorSalir(int zombiesPorSalir) {
		ZombiesPorSalir = zombiesPorSalir;
	}


	public int getSemilla() {
		return semilla;
	}


	public void setSemilla(int semilla) {
		this.semilla = semilla;
	}


	public String getNivelI() {
		return nivelI;
	}


	public void setNivelI(String nivelI) {
		this.nivelI = nivelI;
	}


	public int getFila() {
		return fila;
	}


	public void setFila(int fila) {
		this.fila = fila;
	}
}