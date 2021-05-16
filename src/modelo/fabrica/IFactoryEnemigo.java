package modelo.fabrica;

import modelo.enemigo.Calamar;
import modelo.enemigo.Cangrejo;
import modelo.enemigo.Pulpo;

public interface IFactoryEnemigo {

	public Calamar crearCalamar(int posicionX, int posicionY);
	public Pulpo crearPulpo(int posicionX, int posicionY);
	public Cangrejo crearCangrejo(int posicionX, int posicionY);

}