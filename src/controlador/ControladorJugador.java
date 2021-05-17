package controlador;

import excepciones.NicknameYaExisteException;
import modelo.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControladorJugador {

    private List<Jugador> jugadores;
    private Jugador jugadorActual;

    public ControladorJugador() {
        try {
            deserializarJugador();
        } catch (IOException | ClassNotFoundException e) {
            jugadores = new ArrayList<>();
        }

    }

    public void agregarJugador(String nombre, String nickname) throws IOException, NicknameYaExisteException
    {
        if(buscarJugador(nickname) == null){
            Jugador jugador  = new Jugador(nombre,nickname);
            jugadores.add(jugador);
            serializarJugador();
        }
        else
            throw new NicknameYaExisteException(nickname);
    }

    /**
     * Busca el jugador, si este no existe devuelve null
     * @param nickname usuario a buscar
     * @return jugador o null en caso contrario
     */
    public Jugador buscarJugador(String nickname){

        if((jugadores!=null) && (nickname!=null))
        {
           return jugadores.stream().filter(item -> item.getNickname().equalsIgnoreCase(nickname)).findAny().orElse(null);
        }
        else
            return null;

    }


    public void serializarJugador() throws IOException {

        File archivo = new File("./data/jugador");

        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(jugadores);

        oos.close();
        fos.close();

    }

    public void deserializarJugador() throws IOException, ClassNotFoundException {

        File archivo = new File("./data/jugador");

        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        jugadores = (ArrayList<Jugador>) ois.readObject();

        ois.close();
        fis.close();
    }

    public List<Jugador> getJugadoresOrdenadosPorNickname() {
        jugadores.sort(Comparator.comparing(Jugador::getNickname));
        return jugadores;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
}
