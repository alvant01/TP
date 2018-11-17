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
		
	public ZombieManager()
	{
		this.ZombiesRestantes = 2;
	}
	
	public double Reconocedor(String levelIntroducido){
		
		if (levelIntroducido.toUpperCase().equals(Level.EASY.toString()) || levelIntroducido.toUpperCase().equals("E")){
			this.numZomGen = 3;
			return 0.1;
		}
		else if (levelIntroducido.toUpperCase().equals(Level.HARD.toString()) || levelIntroducido.toUpperCase().equals("H")){
			this.numZomGen = 5;
			return 0.2;
		}
		else if (levelIntroducido.toUpperCase().equals(Level.INSANE.toString()) || levelIntroducido.toUpperCase().equals("I")){
			this.numZomGen = 10;
			return 0.3;
		}
		return 0;
		
	}
	
	//frcuencia y generacion de ciclos

	public boolean Generador(int semilla, String levelIntroducido){
		
		Random rd = new Random(semilla);
		this.ciclos = new int [10];
		double frecuencia;
		double aleatorio;
		frecuencia = Reconocedor(levelIntroducido);
		if(frecuencia == 0)
		{
			return false;
		}
		this.ZombiesPorSalir = this.numZomGen;
		this.ZombiesRestantes = this.numZomGen;
		
		int cont = 0;
		
		for(int i = 0; cont < this.ZombiesPorSalir; i++ )
		{
			//genera un numero aleatorio entre 0 y 1
			aleatorio = rd.nextDouble();
			if(aleatorio <= frecuencia)
			{
				this.ciclos[cont] = i; 
				cont++;
			}		
		}
		cont++;
		return true;
}
	public boolean cicloZombie(int ciclo)
	{
		for(int i  =0; i < this.numZomGen; i++)
		{
			if(this.ciclos[i] == ciclo)
				return true;
		}
		return false;
	}

	//Genera la semilla aleatoria
	public int semillaRandom() {
		Random rd = new Random(System.currentTimeMillis());
		this.semilla = rd.nextInt(100);
		return this.semilla;
	}
	//coge el tipo de zombie
	public int zombieType()
	{
		int z;
		Random rd = new Random();
		z = rd.nextInt(3);
		return z;
	}
	

	public int pos() {
		int z;
		Random rd = new Random();
		z = rd.nextInt(4);
		
		return z;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Getters y Setters
	public int[] getCiclos() {
		return ciclos;
	}


	public void setCiclos(int[] ciclos) {
		this.ciclos = ciclos;
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
}