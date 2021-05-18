package modelo.fabrica;

import modelo.nivel.Nivel;
import modelo.nivel.Nivel1;
import modelo.nivel.Nivel2;

import java.util.HashMap;

public class FactoryNivel implements IFactoryNivel{

	private HashMap<String, Nivel> niveles;

	public FactoryNivel() {
		niveles = new HashMap<>();

		niveles.put("1",new Nivel1());
		niveles.put("2",new Nivel2());
	}

	@Override
	public Nivel crearNivel(String tipoNivel) throws Exception{
		if(niveles.get(tipoNivel)!=null)
			return niveles.get(tipoNivel);
		else
			throw new Exception("El nivel "+tipoNivel + " no existe");
	}




}