package controlador;

import modelo.enemigo.Alien;
import modelo.fabrica.FactoryEnemigo;
import modelo.nivel.Nivel;
import util.Constantes;

public class ControladorEnemigos {

    private Alien[][] aliens;
    private int coordenadaY=0;

    private int calcularPosicionX(int columna)
    {
        return Constantes.ALIEN_POSICION_INICIAL_X *(columna+1);
    }
    private int calcularPosicionY(int columna)
    {
        return Constantes.ALIEN_POSICION_INCIAL_Y *(columna+1);
    }
    FactoryEnemigo fabricaEnemigos;

    public Alien[][] crearEnemigos(Nivel nivel) {

        aliens = new Alien [Constantes.ALIEN_FILAS][Constantes.ALIEN_COLUMNAS];
        fabricaEnemigos= new FactoryEnemigo();
        generarEnemigos(Constantes.TiposEnemigos.CALAMAR,Constantes.ALIEN_FILAS_CALAMARES, nivel);
        generarEnemigos(Constantes.TiposEnemigos.CANGREJO,Constantes.ALIEN_FILAS_CANGREJOS, nivel);
        generarEnemigos(Constantes.TiposEnemigos.PULPO,Constantes.ALIEN_FILAS_PULPOS, nivel);

        return aliens;
    }

    private void generarEnemigos(Constantes.TiposEnemigos type, int cantidadFilas, Nivel nivel){
        try {

            for (int fila = 0; fila < cantidadFilas; fila++)
            {
                for (int columna = 0; columna < aliens[coordenadaY].length; columna++)
                {
                    Alien alien = fabricaEnemigos.crearAlien(type,calcularPosicionX(columna), calcularPosicionY(coordenadaY));

                    alien.setVelocidad(nivel.getVelocidadEnemigos());

                    aliens[coordenadaY][columna]=alien;
                }
                coordenadaY++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
