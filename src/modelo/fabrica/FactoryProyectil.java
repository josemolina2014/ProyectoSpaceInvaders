package modelo.fabrica;

import modelo.proyectil.BombaAlien;
import modelo.proyectil.DisparoNave;
import modelo.proyectil.Proyectil;
import util.Constantes;

public class FactoryProyectil implements  IFactoryProyectil{

	public FactoryProyectil() {
	}

	/**
	 * 
	 * @param tipo Tipo de proyectil, si es de nave o de un alien
	 * @param PosicionX coordenada X
	 * @param posicionY coordenada Y
	 */
	public Proyectil crearProyectil(Constantes.Tipo_proyectil tipo, int posicionX, int posicionY) {

		switch (tipo){
			case NAVE: return new DisparoNave(posicionX,posicionY);
			case ALIEN: return new BombaAlien(posicionX,posicionY);
			default: return  null;
		}
	}

}