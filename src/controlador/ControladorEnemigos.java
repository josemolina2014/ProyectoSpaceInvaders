package controlador;

import modelo.enemigo.Alien;
import modelo.fabrica.FactoryEnemigo;
import modelo.nivel.Nivel;
import modelo.nivel.Nivel1;
import util.Constantes;

public class ControladorEnemigos {

    private Alien[][] aliens;
    private int coordenadaY=0;

    private int calcularPosicionX(int columna)
    {
        return Constantes.ALIEN_ANCHO *(columna+1);
    }
    private int calcularPosicionY(int columna)
    {
        return Constantes.ALIEN_ALTO *(columna+1);
    }

    public Alien[][] crearEnemigos(Nivel nivel) {

        aliens = new Alien [Constantes.ALIEN_FILAS][Constantes.ALIEN_COLUMNAS];

        generarEnemigos(Constantes.TiposEnemigos.CALAMAR,Constantes.ALIEN_FILAS_CALAMARES, nivel);
        generarEnemigos(Constantes.TiposEnemigos.CANGREJO,Constantes.ALIEN_FILAS_CANGREJOS, nivel);
        generarEnemigos(Constantes.TiposEnemigos.PULPO,Constantes.ALIEN_FILAS_PULPOS, nivel);

        return aliens;
    }

    private  void generarEnemigos(Constantes.TiposEnemigos type, int cantidadFilas, Nivel nivel){
        try {
            FactoryEnemigo fabricaEnemigos = new FactoryEnemigo();
            for (int fila = 0; fila < cantidadFilas; fila++)
            {
                for (int columna = 0; columna < aliens[fila].length; columna++)
                {
                    Alien alien = fabricaEnemigos.crearAlien(type,calcularPosicionX(columna), calcularPosicionY(coordenadaY));
                    alien.setVidas(nivel.getVidasEnemigos());
                    alien.setVelocidad(nivel.getVelocidadEnemigos());

                    aliens[fila][columna]=alien;
                    System.out.println("velocidad "+nivel.getVelocidadEnemigos() + " calcularPosicionX: "+calcularPosicionX(columna) +"\tcalcularPosicionY: " + calcularPosicionY(coordenadaY));
                }
                System.out.println("*************************************");
                coordenadaY++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
