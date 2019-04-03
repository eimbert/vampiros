package juegovamp;

import juegovamp.Personaje;

public class Jugador extends Personaje {

	public Jugador(int posx, int posy, String simbolo) {
		super(posx, posy, simbolo);
	}

	@Override
	public void mover(int newx, int newy) {
		super.setPosx(newx);
		super.setPosy(newy);
	}

}
