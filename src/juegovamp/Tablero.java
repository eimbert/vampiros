package juegovamp;

import java.util.ArrayList;

import juegovamp.Personaje;

public class Tablero {
	private int numFilas;
	private int numColumnas;
	private ArrayList<String> tablero;
	
	public Tablero(int x, int y) {
		numFilas = y;
		numColumnas = x;
		tablero = new ArrayList<String>();
		nuevoTablero();
		
	}
	public void posicionarEnTablero(ArrayList<Personaje> personajes) {
		tablero.clear();
		nuevoTablero();
		for(Personaje p: personajes) {
			int posicion = numFilas * p.getPosy() + p.getPosx();
			tablero.set(posicion, p.getSimbolo());
		}
	}
	
	public void nuevoTablero() {
		for (int posicion = 0; posicion < (numFilas*numColumnas); posicion++)
			tablero.add(".");
	}
	
	@Override
	public String toString() {
		String posiciones="";
		int posicion=0;
		for (int fil = 0; fil < numFilas; fil++) {
			for (int col = 0; col < numColumnas; col++)
				posiciones += tablero.get(posicion++);
			posiciones += "\n";
		}
			
		return posiciones;
	}
	public int getNumFilas() {
		return numFilas;
	}
	public int getNumColumnas() {
		return numColumnas;
	}
	
	public String getCharPosicion(int col, int fila) {
		int posicion = numFilas * fila + col;
		return tablero.get(posicion);
	}
	
}
