package modelo.nivel;

public class Nivel2 implements Nivel{

    private int velocidadEnemigos;
    private String nombre;

    public Nivel2() {
        velocidadEnemigos =10;
        nombre="Nivel 2";
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