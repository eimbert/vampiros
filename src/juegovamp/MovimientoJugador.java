package juegovamp;

public class MovimientoJugador implements ActoresJuego{
	private int posX;
	private int posY;
	
	public MovimientoJugador(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void mover(int col, int fila) {
		this.posX = col;
		this.posY = fila;
	}

	@Override
	public int getCoordenadaX() {
		return posX;
	}

	@Override
	public int getCoordenadaY() {
		return posY;
	}
}
