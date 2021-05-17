package modelo.fabrica;

import modelo.enemigo.Alien;
import modelo.enemigo.Calamar;
import modelo.enemigo.Cangrejo;
import modelo.enemigo.Pulpo;
import util.Constantes;

import java.util.Arrays;
import java.util.List;

public class FactoryEnemigo implements IFactoryEnemigo {



	public Alien crearAlien(Constantes.TiposEnemigos tipo, int posicionX, int posicionY) throws Exception
	{
		switch (tipo)
		{
			case CALAMAR:
				return crearCalamar(posicionX, posicionY);
			case PULPO:
				return crearPulpo(posicionX, posicionY);
			case CANGREJO:
				return crearCangrejo(posicionX, posicionY);
		}

		throw new Exception("Tipo no existe "+tipo);
	}


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
		List<String> rutaImagenes = Arrays.asList(
				"./data/imagenes/Naves/r0.png",
				"./data/imagenes/Naves/r1.png");
		Pulpo pulpo = new Pulpo(posicionX,posicionY);
		pulpo.setRutaImagen(rutaImagenes.get(0));
		pulpo.setUrlImagenes(rutaImagenes);

		return pulpo;
	}

	@Override
	public Cangrejo crearCangrejo(int posicionX, int posicionY) {
		List<String> rutaImagenes = Arrays.asList(
				"./data/imagenes/Naves/p0.png",
				"./data/imagenes/Naves/p1.png");
		Cangrejo cangrejo = new Cangrejo(posicionX,posicionY);
		cangrejo.setUrlImagenes(rutaImagenes);
		cangrejo.setRutaImagen(rutaImagenes.get(0));

		return cangrejo;
	}


}