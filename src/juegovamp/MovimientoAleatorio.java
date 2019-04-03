package juegovamp;

import java.util.Random;

public class MovimientoAleatorio implements ActoresJuego{
	private int posX;
	private int posY;
	
	public MovimientoAleatorio(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void mover(int maxX, int maxY) {
		long newX = new Random().nextInt(maxX);
		long newY = new Random().nextInt(maxY);
		if (posX + newX > maxX-1) posX = (maxX-1);
		else posX = (int)newX;
		if (posY + newY > maxY-1) posY = (maxY-1);
		else posY= (int)newY;
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

