package modelo.enemigo;

import util.Constantes;

public class Calamar extends Alien{

	public Calamar(int posicionX, int posicionY) {
		super(posicionX, posicionY);
		//this.setPuntosPorMuerte(Constantes.PUNTOS_X_MUERTE_CALAMAR);
	}

	@Override
	public int getPuntosPorMuerte() {
		return Constantes.PUNTOS_X_MUERTE_CALAMAR;
	}
}