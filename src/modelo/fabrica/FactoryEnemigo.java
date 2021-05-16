package modelo.fabrica;

import modelo.enemigo.Alien;
import modelo.enemigo.Calamar;
import modelo.enemigo.Cangrejo;
import modelo.enemigo.Pulpo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FactoryEnemigo implements IFactoryEnemigo {

	public Calamar crearCalamar(int posicionX, int posicionY ) {
		List<String> rutaImagenes = Arrays.asList(
				"./data/imagenes/Naves/s0.png",
				"./data/imagenes/Naves/s1.png");

		Calamar calamar = new Calamar(posicionX,posicionY);
		calamar.setRutaImagen(rutaImagenes.get(0));
		calamar.setUrlImagenes(rutaImagenes);

		return calamar;
	}

	@Override
	public Pulpo crearPulpo(int posicionX, int posicionY) {
		return null;
	}

	@Override
	public Cangrejo crearCangrejo(int posicionX, int posicionY) {
		return null;
	}


}