package modelo.nivel;

public class Nivel1 implements Nivel {
    private int velocidadEnemigos;
    private String nombre;

    public Nivel1() {
        velocidadEnemigos =5;
        nombre="Nivel 1";
    }


    @Override
    public int getVelocidadEnemigos() {
        return velocidadEnemigos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }


}