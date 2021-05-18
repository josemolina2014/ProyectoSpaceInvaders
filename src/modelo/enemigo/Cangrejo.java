package modelo.enemigo;

import util.Constantes;

public class Cangrejo extends Alien {


	public Cangrejo(int posicionX, int posicionY) {
		super(posicionX, posicionY);
	}

	@Override
	public int getPuntosPorMuerte() {
		return Constantes.PUNTOS_X_MUERTE_CANGREJO;
	}
}