package modelo.enemigo;

import util.Constantes;

public class Pulpo extends Alien{

	public Pulpo(int posicionX, int posicionY) {
		super(posicionX, posicionY);
	}

	@Override
	public int getPuntosPorMuerte() {
		return Constantes.PUNTOS_X_MUERTE_PULPO;
	}
}