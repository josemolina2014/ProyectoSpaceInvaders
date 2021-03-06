package controlador;

import modelo.Jugador;
import modelo.Partida;

import java.util.List;

public class ControladorPartida {


    public Partida inicializarPartida(Jugador jugador, String nombre)
    {
        Partida nuevaPartida = new Partida(nombre);
        nuevaPartida.setJugador(jugador);
      //  nuevaPartida.setPuntaje(0); // se traslada al constructor de la clase
        jugador.getPartidas().add(nuevaPartida);

        return nuevaPartida;
    }


    /**
     * Busca el jugador, si este no existe devuelve null
     * @param nombre usuario a buscar
     * @return jugador o null en caso contrario
     */
    public Partida buscarPartida(Jugador jugador, String nombre){

        List<Partida> partidas = jugador.getPartidas();
        if((partidas !=null) && (nombre!=null))
        {
            return partidas.stream().filter(item -> item.getNombre().equalsIgnoreCase(nombre)).findAny().orElse(null);
        }
        else
            return null;
    }

}
