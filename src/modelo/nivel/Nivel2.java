package modelo.nivel;

import modelo.enemigo.Alien;

public class Nivel2 implements Nivel{

    private int velocidadEnemigos;
    private int vidasEnemigos;
    private int nombre;
    private Alien[][] enemigos;
    public Nivel2() {
        velocidadEnemigos =5;
        vidasEnemigos=2;
    }

    @Override
    public int getVelocidadEnemigos() {
        return velocidadEnemigos;
    }

    @Override
    public int getVidasEnemigos() {
        return vidasEnemigos;
    }

    @Override
    public int getNombre() {
        return nombre;
    }

    @Override
    public Alien[][] getEnemigos() {
        return enemigos;
    }
}