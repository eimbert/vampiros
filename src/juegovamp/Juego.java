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
			personajes.add(new Personaje(new MovimientoAleatorio(newCol, newFil) , "V", TiposMovimiento.MOVIMIENTO_ALEATORIO));
			t.posicionarEnTablero(personajes);
		}
		personajes.add(new Personaje(new MovimientoJugador(0,0), "@", TiposMovimiento.MOVIMIENTO_JUGADOR));
		t.posicionarEnTablero(personajes);
	}

	@Override
	public void run() {
		while(numVampiros > 0 && numJugadas > 0) {
			System.out.println("Jugadas pendientes:" + numJugadas-- + "\nvampiros:" + numVampiros);
			System.out.println(t);
			String movimiento = reader.nextLine();
			moverPersonajes(movimiento); 
			t.posicionarEnTablero(personajes);
		}
		if (numVampiros == 0)
			System.out.println("You Win!!!");
		else
			System.out.println("You Lost :(");
	}
	
	private void moverPersonajes(String movimiento) {
		for(Personaje p: personajes) {
			if (p.getTipoMovimiento() == TiposMovimiento.MOVIMIENTO_ALEATORIO) {
				do {
					p.mover(t.getNumColumnas(), t.getNumFilas());
				}while(!ControlTablero.controlarSiPosionLibre(p.getCoordenadaX(), p.getCoordenadaY(), t));
			}
			else {
				int[] coordenadas =InputOutput.nuevasCoordenadas(p, movimiento, t.getNumColumnas(), t.getNumFilas());
				p.mover(coordenadas[0], coordenadas[1]);
				if (ControlTablero.comprobarColision(p.getCoordenadaX(), p.getCoordenadaY(), t)) {
					numVampiros--;
					personajes.remove(0);
					break;
				}
			}
		}
	}
}
