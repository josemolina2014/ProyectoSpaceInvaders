package modelo;

import modelo.fabrica.FactoryNivel;
import modelo.nivel.Nivel;

import java.io.Serializable;

public class Partida implements Serializable {

    private String nombre;
    private Jugador jugador;
    private Nivel nivel;
    private int puntaje;
    private int vidas;

    /**
     * Constructor de la clase Partida
     * inicializa una partida por defecto en
     * el nivel 1 y con 3 vidas
     * @param nombre nombre de la partida que se va a crear
     */
    public Partida(String nombre) {
        this.nombre = nombre;

        try {
            FactoryNivel factoryNivel = new FactoryNivel();
            nivel = factoryNivel.crearNivel("1");
            vidas= 3;

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
