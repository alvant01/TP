package tp.p2.Controladores;

import java.util.Random;

//import tp.p2.List.ZombieList;

import java.lang.String;

public class ZombieManager {
	private int[] ciclos;
	private int numZomGen;
	private int ZombiesRestantes;
	private int ZombiesPorSalir;
	private int semilla;
	private String nivelI;
	private int[] fila;
		
	public ZombieManager()
	{
		
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
	


	public void Generador(int semilla, String levelIntroducido){
		
		Random rd = new Random(semilla);
		this.ciclos = new int [10];
		int PosA = 0;
		int numZombiesAcum = 0;
		int contCiclos = 0;
		double frecuencia = 0;
		float aleatorio;
		this.numZomGen = Reconocedor(levelIntroducido);
		this.ZombiesPorSalir = this.numZomGen;
		this.ZombiesRestantes = 4;//this.numZomGen;
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
	


	public int semillaRandom() {
		Random rd = new Random(System.currentTimeMillis());
		this.semilla = rd.nextInt(100);
		return this.semilla;
	}

	public int zombieType()
	{
		int z;
		Random rd = new Random();
		z = rd.nextInt(2);
		while(z == 0)
		{
			z = rd.nextInt(2);
		}
		return z;
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
		this.ZombiesRestantes = zombiesRestantes;
	}


	public int getZombiesPorSalir() {
		return ZombiesPorSalir;
	}


	public void setZombiesPorSalir(int zombiesPorSalir) {
		this.ZombiesPorSalir = zombiesPorSalir;
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


	public int[] getFila() {
		return fila;
	}


	public void setFila(int[] fila) {
		this.fila = fila;
	}
}