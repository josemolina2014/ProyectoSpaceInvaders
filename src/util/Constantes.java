package util;

import java.awt.*;

public interface Constantes {


    int ANCHO_PANTALLA=640;
    int ALTO_PANTALLA=480;
    Dimension TAMANO_PANTALLA = new Dimension(ANCHO_PANTALLA, ALTO_PANTALLA);

    //Aliens
    int ALIEN_POSICION_INICIAL_X =40;
    int ALIEN_POSICION_INCIAL_Y =40;

    int ALIEN_ANCHO=12;
    int ALIEN_ALTO=32;

    int ALIEN_FILAS_CALAMARES =1;
    int ALIEN_FILAS_CANGREJOS =2;
    int ALIEN_FILAS_PULPOS =2;

    int ALIEN_FILAS = ALIEN_FILAS_CALAMARES + ALIEN_FILAS_CANGREJOS + ALIEN_FILAS_PULPOS;
    int ALIEN_COLUMNAS = 10;

    int PUNTOS_X_MUERTE_CALAMAR=10;
    int PUNTOS_X_MUERTE_PULPO=20;
    int PUNTOS_X_MUERTE_CANGREJO=20;


    int NAVE_JUGADOR_ANCHO=30;
    int NAVE_JUGADOR_ALTO=19;

    int NAVE_JUGADOR_POSICION_INICIAL_X=300;
    int NAVE_JUGADOR_POSICION_INICIAL_Y=410;

    int BORDE_PANTALLA_NAVE=ANCHO_PANTALLA - (NAVE_JUGADOR_ANCHO+1);
    int BORDE_PANTALLA_ALIEN=ANCHO_PANTALLA - (ALIEN_POSICION_INICIAL_X +1);

    String NAVE_JUGADOR_URL_IMAGEN="./data/imagenes/Naves/nave.png";


    int NAVE_JUGADOR_VIDAS = 3;

    int MULTIPLICADOR_MOVIMIENTO_NAVE=10;

    enum DIRECCION_MOVIMIENTO_HORIZONTAL {
        IZQUIERDA (-1), DERECHA (1);
        private int unidad;
        DIRECCION_MOVIMIENTO_HORIZONTAL(int unidad) {
            this.unidad=unidad;
        }
        public int getUnidad() {
            return unidad;
        }
    }




    enum DIRECCION_MOVIMIENTO_VERTICAL_PROYECTIL {
        ARRIBA (1), ABAJO(5);
        private int unidad;

        DIRECCION_MOVIMIENTO_VERTICAL_PROYECTIL(int unidad) {
            this.unidad=unidad;
        }
        public int getUnidad() {
            return unidad;
        }
    }
    int UNIDADES_DESCENSO_ALIEN=20;

    enum TiposEnemigos {
        CALAMAR, PULPO, CANGREJO
    }
    enum Tipo_proyectil {
        NAVE, ALIEN
    }

}
