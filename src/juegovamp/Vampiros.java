package juegovamp;

import java.util.Random;

public class Vampiros extends Personaje {

	public Vampiros(int maxX, int maxY, String simbolo) {
		super(maxX, maxY, simbolo);
	}

	public void mover(int maxX, int maxY) {
		long newX = new Random().nextInt(maxX-1);
		long newY = new Random().nextInt(maxY-1);
		if (super.getPosx() + newX > maxX-1) super.setPosx(maxX-1);
		else super.setPosx((int)newX);
		if (super.getPosy() + newY > maxY-1) super.setPosy(maxY-1);
		else super.setPosy((int)newY);
	}
	
	
}

