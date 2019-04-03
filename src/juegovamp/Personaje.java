package juegovamp;

public class Personaje {
	private ActoresJuego elemento; 
	private String simbolo;
	private TiposMovimiento tipoMovimiento;
	
	public Personaje(ActoresJuego a, String simbolo, TiposMovimiento movimiento){
		this.elemento = a;
		this.simbolo = simbolo;
		this.tipoMovimiento = movimiento;
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

	public TiposMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TiposMovimiento tipo) {
		this.tipoMovimiento = tipo;
	}
	
	
	
}
