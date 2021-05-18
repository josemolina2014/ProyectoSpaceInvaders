package gui.estadosJuego;

import controlador.ControladorJuego;
import controlador.EventosTeclado;
import gui.SpaceInvaders;
import modelo.proyectil.DisparoNave;
import mundo.NaveJugador;
import util.Constantes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Juego extends JPanel implements EstadoJuego{

    private SpaceInvaders framePrincipal;

    private ControladorJuego controladorJuego;

    private EventosTeclado eventosTeclado;


    public Juego(SpaceInvaders framePrincipal) {
        super();
        this.framePrincipal = framePrincipal;
        this.framePrincipal.setJuegoEnCurso(true);

        controladorJuego = ControladorJuego.getInstancia(framePrincipal.getPartidaSeleccionada());

        setPreferredSize(new Dimension(SpaceInvaders.ANCHO, SpaceInvaders.ALTO));
        setLayout(null);
        eventosTeclado  = new EventosTeclado(framePrincipal,controladorJuego);
        addKeyListener(eventosTeclado);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon iconFondo = new ImageIcon("./data/imagenes/fondoJuego.jpg");

        g.drawImage(iconFondo.getImage(), 0, 0, null);

        ImageIcon imagen = new ImageIcon(controladorJuego.getNaveEspacial().getRutaImagen());

        g.drawImage(imagen.getImage(),
                controladorJuego.getNaveEspacial().getPosicionX(),
                controladorJuego.getNaveEspacial().getPosicionY(),
                imagen.getIconWidth(), imagen.getIconHeight(),
                null);

        //DIBUJAR INFORMACIÓN DEL JUGADOR
        g.setColor(Color.WHITE);
        g.setFont(new Font("ArcadeClassic", Font.PLAIN, 24));
        g.drawString("NICKNAME", 30, 40);
        g.drawString("PUNTUACION ", 250, 40);

        g.setColor(Color.GREEN);
        g.drawString(controladorJuego.getPartidaActual().getJugador().getNickname(), 140, 40);
        g.drawString(controladorJuego.getPartidaActual().getPuntaje() + "", 400, 40);

        // DISPARO DE LA NAVE
        DisparoNave disparoNave = (DisparoNave) controladorJuego.getNaveEspacial().getDisparo();

        if (disparoNave != null) {
            g.setColor(Color.WHITE);
            g.fillOval(disparoNave.getPosicionX() + 13, disparoNave.getPosicionY(), 7, 7);

            if (disparoNave.getPosicionY() == 0 || disparoNave.isImpacto()) {
                ImageIcon choque = new ImageIcon("./data/imagenes/Naves/muereBicho.png");
                g.drawImage(choque.getImage(), disparoNave.getPosicionX(), disparoNave.getPosicionY() - 6, null);
            }
        }
        // DISPARO ENEMIGO



        // DIBUJAR ENEMIGOS

        for (int i = 0; i < controladorJuego.getAliens().length; i++) {
            for (int j = 0; j < controladorJuego.getAliens()[i].length; j++) {
                if (controladorJuego.getAliens()[i][j] != null) {
                    if (controladorJuego.getAliens()[i][j] != null) {
                        ImageIcon icono = new ImageIcon(controladorJuego.getAliens()[i][j].getRutaImagen());
                        g.drawImage(icono.getImage(), controladorJuego.getAliens()[i][j].getPosicionX(),
                                controladorJuego.getAliens()[i][j].getPosicionY(), null);
                    }
                }
            }
        }

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
        return eventosTeclado;
    }
}
