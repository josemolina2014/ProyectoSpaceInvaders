package modelo.nivel;

public class Nivel1 implements Nivel {
    private int velocidadEnemigos;
    private int vidasEnemigos;
    private String nombre;


    public Nivel1() {
        velocidadEnemigos =5;
        vidasEnemigos=1;
        nombre="Nivel 1";
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
    public String getNombre() {
        return nombre;
    }


}