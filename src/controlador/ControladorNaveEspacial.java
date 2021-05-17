package controlador;

import modelo.NaveEspacial;
import util.Constantes;

public class ControladorNaveEspacial {

    public NaveEspacial crearNaveEspacial()
    {
        NaveEspacial naveEspacial = new NaveEspacial();

        naveEspacial.setAlto(Constantes.NAVE_JUGADOR_ALTO);
        naveEspacial.setAncho(Constantes.NAVE_JUGADOR_ANCHO);
        naveEspacial.setPosicionX(Constantes.NAVE_JUGADOR_POSICION_INICIAL_X);
        naveEspacial.setPosicionY(Constantes.NAVE_JUGADOR_POSICION_INICIAL_Y);

        naveEspacial.setRutaImagen(Constantes.NAVE_JUGADOR_URL_IMAGEN);


        return naveEspacial;
    }
}
