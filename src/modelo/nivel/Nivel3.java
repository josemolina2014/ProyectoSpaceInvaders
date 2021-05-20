package modelo.nivel;

public class Nivel3 implements Nivel{
    @Override
    public int getVelocidadEnemigos() {
        return 20;
    }

    @Override
    public String getNombre() {
        return "Nivel 3";
    }
}
