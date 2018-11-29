package tp.p2.Controladores;

public class SunCoinsManager {
	
	
	private int sunCoins;
	public SunCoinsManager()
	{
		this.sunCoins = 20;
	}
	public int getSunCoins() {
		return sunCoins;
	}
	public void setSunCoins(int sunCoins) {
		this.sunCoins = sunCoins;
	}
	public void addSunCoins(int coins)
	{
		this.sunCoins = this.sunCoins + coins;
	}
	public void removeSuncoins(int cost) {
		this.sunCoins = this.sunCoins - cost;
	}
	public void insertRandom() {
		// TODO Auto-generated method stub
		
	}
	
}
