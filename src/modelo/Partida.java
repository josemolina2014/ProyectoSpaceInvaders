package modelo;

import modelo.fabrica.FactoryNivel;
import modelo.nivel.Nivel;
import util.Constantes;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Partida implements Serializable {

    private String nombre;
    private Jugador jugador;
    private Nivel nivel;
    private int puntaje;
    private int vidas;
    private Queue<Nivel> niveles;

    /**
     * Constructor de la clase Partida
     * inicializa una partida por defecto en
     * el nivel 1 y con 3 vidas
     * @param nombre nombre de la partida que se va a crear
     */
    public Partida(String nombre) {
        this.nombre = nombre;

        crearNivelesDelJuego();
        //obtengo el primer nivel del juego
        nivel = niveles.poll();
        vidas= Constantes.NAVE_JUGADOR_VIDAS;
        puntaje=0;

    }

    public void volverAJugar(){
        crearNivelesDelJuego();
        //obtengo el primer nivel del juego
        nivel = niveles.poll();
        vidas= Constantes.NAVE_JUGADOR_VIDAS;
        puntaje=0;
    }

    /**
     * Crea una pila con los niveles del juego
     * en este caso dos niveles
     */
    private void crearNivelesDelJuego(){
        try
        {
            niveles =new LinkedList<>();
            FactoryNivel factoryNivel = new FactoryNivel();
            niveles.add(factoryNivel.crearNivel("1"));
            niveles.add(factoryNivel.crearNivel("2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el siguiente nivel de la pila de niveles del juego
     * en el caso de que ya no existan  más niveles se retorna null
     * @return siguiente Nivel del juego, o null en caso de que ya no hayan mas niveles disponibles
     */
    public Nivel getSiguienteNivel(){
        return niveles.poll();
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

    public void agregarPuntosPorImpacto(int puntosPorImpacto) {
        this.puntaje +=puntosPorImpacto;
    }

    public void agregarPuntos(int puntos) {
        this.puntaje +=puntos;
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
