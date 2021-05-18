package modelo.fabrica;

import modelo.proyectil.Proyectil;
import util.Constantes;

public interface IFactoryProyectil {

	Proyectil crearProyectil(Constantes.Tipo_proyectil tipo, int posicionX, int posicionY);

}