package modelo.fabrica;

import modelo.proyectil.Proyectil;

public interface IFactoryProyectil {

	Proyectil crearProyectil(int tipo, int PosicionX, int posicionY);

}