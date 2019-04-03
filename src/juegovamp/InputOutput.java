package juegovamp;

public class InputOutput {

	public static int[] nuevasCoordenadas(Personaje p, String movimientoSolicitado, int columnasTablero, int filasTablero) {
		int[] coordenadas = new int[2];
		
		int columnaActual = p.getCoordenadaX();
		int filaActual = p.getCoordenadaY();
		char[] aux= new char[1];
		for(int x = 0; x<movimientoSolicitado.length(); x++) {
			movimientoSolicitado.getChars(x, x+1, aux, 0);
			switch(aux[0]){
			case 'a':
				if(columnaActual > 0) columnaActual--;
				break;
			case 'd':
				if(columnaActual < columnasTablero - 1) columnaActual++;
				break;
			case 'w':
				if(filaActual > 0 ) filaActual--;
				break;
			case 's':
				if(filaActual < filasTablero - 1) filaActual++;
				break;
			}
		}
		
		coordenadas[0] = columnaActual;
		coordenadas[1] = filaActual;
		return coordenadas;
	}
}
