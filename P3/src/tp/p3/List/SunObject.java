package tp.p3.List;

public class SunObject {

	private int posX;
	private int posY;
	private char visual;
	private int valor;
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public SunObject(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.visual = '*';
		this.valor = 10;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public char getVisual() {
		return visual;
	}
	public void setVisual(char visual) {
		this.visual = visual;
	}
	

}
