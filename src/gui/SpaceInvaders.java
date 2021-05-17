package gui;

import gui.estadosJuego.EstadoJuego;
import gui.estadosJuego.IntroJuego;
import gui.estadosJuego.MenuPrincipal;
import modelo.Jugador;
import modelo.Partida;
import util.Parametros;

import javax.swing.*;
import java.awt.*;

public class SpaceInvaders {
    public static final int ANCHO = 640;
    public static final int ALTO = 480;

    private JFrame jFrame;
    private EstadoJuego currentState;

    private Partida partidaSeleccionada;
    private Jugador jugadorSeleccionado;




    public SpaceInvaders() {
        Parametros.loadFont();
        jFrame = new JFrame();
        jFrame.setSize(ANCHO,ALTO);
        jFrame.setUndecorated(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
        jFrame.pack();
        jFrame.setVisible(true);
        cargarValorXdefecto();

        setCurrentState(new IntroJuego(this));
    }

    public static void main(String[] args) {
       new SpaceInvaders();
    }

    private void cargarValorXdefecto(){
        jugadorSeleccionado = new Jugador();
        jugadorSeleccionado.setNickname("Dummy");
        jugadorSeleccionado.setNombre("");

    }

    public void setCurrentState(EstadoJuego estadoJuego){

        currentState = estadoJuego;

        jFrame.getContentPane().removeAll();
        jFrame.repaint();


        jFrame.getContentPane().add(currentState.getMainPanel());

        jFrame.addKeyListener(currentState.getKeyListener());
        jFrame.pack();

    }



    public Partida getPartidaSeleccionada() {
        return partidaSeleccionada;
    }

    public void setPartidaSeleccionada(Partida partidaSeleccionada) {
        this.partidaSeleccionada = partidaSeleccionada;
    }

    public Jugador getJugadorSeleccionado() {
        return jugadorSeleccionado;
    }

    public void setJugadorSeleccionado(Jugador jugadorSeleccionado) {
        this.jugadorSeleccionado = jugadorSeleccionado;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public EstadoJuego getCurrentState() {
        return currentState;
    }
}
