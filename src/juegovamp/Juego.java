package juegovamp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego implements Runnable {
	private int numVampiros;
	private int numJugadas;
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	private Tablero  t;
	private Scanner reader = new Scanner(System.in);
	
	/**
	 * 
	 * @param numVampiros Cantidad de vampiros de la partida
	 * @param numJugadas En cuantas jugadas hay que finalizar
	 * @param columnasTablero Columnas del tablero de juego
	 * @param filasTablero Filas del tablero de juego
	 */
	public Juego(int numVampiros, int numJugadas, int columnasTablero, int filasTablero) {
		super();
		this.numVampiros = numVampiros;
		this.numJugadas = numJugadas;
		t = new Tablero(columnasTablero, filasTablero);
	
		for (int x = 0; x < this.numVampiros; x++) {
			int newCol;
			int newFil;
			do {
				newCol = new Random().nextInt(t.getNumColumnas());
				newFil =  new Random().nextInt(t.getNumFilas());
			}while(!ControlTablero.controlarSiPosionLibre(newCol, newFil, t));
			personajes.add(new Personaje(new MovimientoAleatorio(newCol, newFil) , "V", 1));
			t.posicionarEnTablero(personajes);
		}
		personajes.add(new Personaje(new MovimientoJugador(0,0), "@", 0));
		t.posicionarEnTablero(personajes);
	}

	@Override
	public void run() {
		while(numVampiros > 0) {
			System.out.println("" + numJugadas--);
			System.out.println(t);
			String movimiento = reader.nextLine();
			moverPersonajes(movimiento); 
			t.posicionarEnTablero(personajes);
		}
	}
	
	private void moverPersonajes(String movimiento) {
		for(Personaje p: personajes) {
			if (p.getTipoMovimiento() == 1) {
				do {
					p.mover(t.getNumColumnas(), t.getNumFilas());
				}while(!ControlTablero.controlarSiPosionLibre(p.getCoordenadaX(), p.getCoordenadaY(), t));
			}
			else {
				desglosarMovimiento(p, movimiento);
				break;
			}
		}
	}
	
	private void desglosarMovimiento(Personaje  p, String movimiento) {
		int columnaActual = p.getCoordenadaX();
		int filaActual = p.getCoordenadaY();
		char[] aux= new char[1];
		for(int x = 0; x<movimiento.length(); x++) {
			movimiento.getChars(x, x+1, aux, 0);
			switch(aux[0]){
			case 'a':
				if(columnaActual > 0) columnaActual--;
				break;
			case 'd':
				if(columnaActual < t.getNumColumnas()-1) columnaActual++;
				break;
			case 'w':
				if(filaActual > 0 ) filaActual--;
				break;
			case 's':
				if(filaActual < t.getNumFilas()-1) filaActual++;
				break;
			}
		}
		p.mover(columnaActual, filaActual);
		//comprobarColision((Jugador)p);
	}
	
	/*private void comprobarColision(Jugador j) {
		if(!(t.getCharPosicion(j.getPosx(), j.getPosy()).equals("."))) {
			//numVampiros--;
			//personajes.remove(0);
			if(numVampiros == 0) System.out.println("Ganaste");
		}
		
	}*/
}
