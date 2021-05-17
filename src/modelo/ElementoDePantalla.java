package modelo;

import util.Constantes;

public interface ElementoDePantalla {
    int getPosicionX();
    int getPosicionY();
    int getAlto();
    int getAncho();
    boolean isVisible();
    String getRutaImagen();
    void mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccion);
}
