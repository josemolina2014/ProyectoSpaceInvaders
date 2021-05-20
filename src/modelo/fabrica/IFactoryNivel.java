package modelo.fabrica;

import modelo.nivel.Nivel;

import java.util.Queue;

public interface IFactoryNivel {

	public Queue<Nivel> crearNivelesDelJuego();


}