package gui.estadosJuego;

import controlador.ControladorJuego;
import gui.SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Juego extends JPanel implements EstadoJuego{

    private SpaceInvaders framePrincipal;

    private ControladorJuego controladorJuego;


    public Juego(SpaceInvaders framePrincipal) {
        this.framePrincipal = framePrincipal;

        controladorJuego = ControladorJuego.getInstancia(framePrincipal.getPartidaSeleccionada());

        setPreferredSize(new Dimension(SpaceInvaders.ANCHO, SpaceInvaders.ALTO));
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon iconFondo = new ImageIcon("./data/imagenes/fondoJuego.jpg");

        g.drawImage(iconFondo.getImage(), 0, 0, null);

        ImageIcon imagen = new ImageIcon("./data/imagenes/Naves/nave.png");

        //DIBUJAR INFORMACIÓN DEL JUGADOR
        g.setColor(Color.WHITE);
        g.setFont(new Font("ArcadeClassic", Font.PLAIN, 24));
        g.drawString("NICKNAME", 30, 40);
        g.drawString("PUNTUACION ", 250, 40);

        g.setColor(Color.GREEN);
        g.drawString(controladorJuego.getPartidaActual().getJugador().getNickname(), 140, 40);
        g.drawString(controladorJuego.getPartidaActual().getPuntaje() + "", 400, 40);


        if(controladorJuego.isEnEjecucion())
        {
            g.drawString("Vidas jugador " + controladorJuego.getPartidaActual().getVidas() , 100, 470);
        }
    }


    @Override
    public JPanel getMainPanel() {
        return this;
    }



    @Override
    public KeyListener getKeyListener() {
        return null;
    }
}
