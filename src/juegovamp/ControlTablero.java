package juegovamp;

public class ControlTablero {

	public static Boolean controlarSiPosionLibre (int col, int fil, Tablero t) {
		if (t.getCharPosicion(col, fil).equals(".")) {
			t.setReservarPosicion(col, fil);
			return true;
		}
		else
			return false;
	}
	
	public static Boolean comprobarColision(int columna, int fila, Tablero t) {
	if(!(t.getCharPosicion(columna, fila).equals("."))) 
		return true;
	else
		return false;
	}
}
