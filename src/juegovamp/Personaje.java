package juegovamp;

public class Personaje {
	private ActoresJuego elemento; 
	private String simbolo;
	private int tipoMovimiento; //0 -> jugador; 1 -> Aleatorio
	
	public Personaje(ActoresJuego a, String simbolo, int tipoMovimiento){
		this.elemento = a;
		this.simbolo = simbolo;
		this.tipoMovimiento = tipoMovimiento;
	}
	
	public void mover(int x, int y) {
		elemento.mover(x, y);
	}
	
	public int getCoordenadaX(){
		return elemento.getCoordenadaX();
	}
	
	public int getCoordenadaY() {
		return elemento.getCoordenadaY();
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
	
	
}
