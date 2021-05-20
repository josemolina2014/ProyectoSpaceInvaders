package modelo.fabrica;

import modelo.nivel.Nivel;
import modelo.nivel.Nivel1;
import modelo.nivel.Nivel2;
import modelo.nivel.Nivel3;

import java.util.LinkedList;
import java.util.Queue;

public class FactoryNivel implements IFactoryNivel{
	private Queue<Nivel> coladeNiveles;

	public FactoryNivel() {
		coladeNiveles =new LinkedList<>();
		coladeNiveles.add(new Nivel1());
		coladeNiveles.add(new Nivel2());
		coladeNiveles.add(new Nivel3());
	}

	@Override
	public Queue<Nivel> crearNivelesDelJuego(){
		return coladeNiveles;
	}

}