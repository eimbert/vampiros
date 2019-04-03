package juegovamp;

public abstract class Personaje {
	private String simbolo;
	private int posx;
	private int posy;
	
	public abstract void mover(int newx, int newy);
	
	public Personaje(int posx, int posy, String simbolo){
		this.posx = posx;
		this.posy = posy;
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
	
}
