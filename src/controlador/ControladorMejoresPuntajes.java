package controlador;

import modelo.Puntaje;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorMejoresPuntajes {


    private List<Puntaje> mejores10Puntajes;
    private List<String> mejoresPuntajes;

    public ControladorMejoresPuntajes() {
        mejores10Puntajes = new ArrayList<>();
    }

    public void agregarPuntaje(Puntaje nuevoPuntaje) {

        try {
            if(mejores10Puntajes.size()<10){
                mejores10Puntajes.add(nuevoPuntaje);
                mejores10Puntajes.sort(Comparator.comparing(Puntaje::getPuntuacion).reversed());
                serializarPuntaje();
            }
            else{
                //clasifica para el top 10
                if(nuevoPuntaje.getPuntuacion()>mejores10Puntajes.get(9).getPuntuacion()){
                    mejores10Puntajes.add(nuevoPuntaje);
                    mejores10Puntajes.sort(Comparator.comparing(Puntaje::getPuntuacion).reversed());

                    mejores10Puntajes = mejores10Puntajes.stream().limit(10).collect(Collectors.toList());
                    serializarPuntaje();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     *
     */
    public void serializarPuntaje() throws IOException {

        File archivo = new File("./data/puntaje");

        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(mejores10Puntajes);

        oos.close();
        fos.close();

    }

    /**
     *
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void deserializarPuntaje() throws IOException, ClassNotFoundException {

        File archivo = new File("./data/puntaje");

        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        mejores10Puntajes = (List<Puntaje>) ois.readObject();

        ois.close();
        fis.close();
    }

    public List<String> getResumenMejoresPuntajes(){
        return mejores10Puntajes.stream().map(Puntaje::toString).collect(Collectors.toList());
    }
}
