package juegovamp;

public class ControlTablero {

	public static Boolean controlarSiPosionLibre (int col, int fil, Tablero t) {
		if (t.getCharPosicion(col, fil).equals("."))
			return true;
		else
			return false;
	}
}
