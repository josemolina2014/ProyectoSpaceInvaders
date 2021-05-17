package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {

    private String nickname;
    private String nombre;
    private List<Partida> partidas;


    public Jugador() {
        partidas = new ArrayList<>();
    }

    public Jugador(String nickname, String nombre) {
        this.nickname = nickname;
        this.nombre = nombre;
        partidas = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    @Override
    public String toString() {
        return nickname;
    }
}
