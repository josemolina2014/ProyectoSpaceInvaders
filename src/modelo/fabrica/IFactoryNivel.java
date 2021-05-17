package modelo.fabrica;

import modelo.nivel.Nivel;

public interface IFactoryNivel {

	public Nivel crearNivel(String tipoNivel) throws Exception ;

}