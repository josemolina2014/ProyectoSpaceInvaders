package modelo.nivel;

public class Nivel2 implements Nivel{

    private int velocidadEnemigos;
    private int vidasEnemigos;
    private String nombre;

    public Nivel2() {
        velocidadEnemigos =10;
        vidasEnemigos=2;
        nombre="Nivel 2";
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