package modelo;

import modelo.fabrica.FactoryNivel;
import modelo.nivel.Nivel;

import java.io.Serializable;

public class Partida implements Serializable {

    private String nombre;
    private Jugador jugador;
    private Nivel nivel;
    private int puntaje;

    public Partida(String nombre) {
        this.nombre = nombre;

        try {
            FactoryNivel factoryNivel = new FactoryNivel();
            nivel = factoryNivel.crearNivel("1");

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
}
