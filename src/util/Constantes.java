package util;

import java.awt.*;

public interface Constantes {


    Dimension TAMANO_PANTALLA = new Dimension(640, 480);


    //Aliens
    int ALIEN_ANCHO =40;
    int ALIEN_ALTO =40;

    int ALIEN_FILAS_CALAMARES =1;
    int ALIEN_FILAS_CANGREJOS =2;
    int ALIEN_FILAS_PULPOS =2;

    int ALIEN_FILAS = ALIEN_FILAS_CALAMARES + ALIEN_FILAS_CANGREJOS + ALIEN_FILAS_PULPOS;
    int ALIEN_COLUMNAS = 10;

    enum TiposEnemigos {
        CALAMAR, PULPO, CANGREJO
    }

    int NIVEL1_VIDAS=1;
    int NIVEL2_VIDAS=2;




}
