package gui.estadosJuego;

import controlador.ControladorJuego;
import controlador.ControladorMejoresPuntajes;
import controlador.EventosTeclado;
import gui.SpaceInvaders;
import hilos.*;
import modelo.proyectil.BombaAlien;
import modelo.proyectil.DisparoNave;
import util.Constantes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;



public class Juego extends JPanel implements EstadoJuego{

    private SpaceInvaders framePrincipal;

    private ControladorJuego controladorJuego;

    private EventosTeclado eventosTeclado;

    private HiloEnemigos hiloEnemigo;
    private HiloAuxiliarCreaDisparo hiloDisparoAlien;
    private HiloAnimacionEnemigos hiloAnimacionEnemigos;
    private HiloDisparoEnemigos hiloDisparoEnemigos;
    private HiloDisparoJugador hiloDisparoJugador;


    public Juego(SpaceInvaders framePrincipal) {
        super();
        this.framePrincipal = framePrincipal;
        this.framePrincipal.setJuegoEnCurso(true);



        //controladorJuego = ControladorJuego.getInstancia(framePrincipal.getPartidaSeleccionada());

        controladorJuego = new ControladorJuego(framePrincipal.getPartidaSeleccionada());
        setPreferredSize(Constantes.TAMANO_PANTALLA);
        setLayout(null);
        eventosTeclado  = new EventosTeclado(this,controladorJuego);
        addKeyListener(eventosTeclado);
        inciarHilos();
    }
    public void inciarHilos(){
        startHiloEnemigo();
        startHiloDisparoAlien();
        startHiloAnimacion();
        startHiloDisparoEnemigo();
    }

    private void startHiloEnemigo() {
        for (int i = 0; i <controladorJuego.getAliens().length; i++) {
            for (int j = 0; j < controladorJuego.getAliens()[0].length; j++) {
                if (controladorJuego.getAliens()[i][j] != null) {
                    hiloEnemigo = new HiloEnemigos(controladorJuego.getAliens()[i][j], this, controladorJuego);
                    hiloEnemigo.start();
                }
            }
        }
    }
    public void startHiloDisparoAlien() {
        hiloDisparoAlien = new HiloAuxiliarCreaDisparo(controladorJuego, this);
        hiloDisparoAlien.start();
    }
    public void startHiloAnimacion() {
        for (int i = 0; i <controladorJuego.getAliens().length; i++) {
            for (int j = 0; j < controladorJuego.getAliens()[0].length; j++) {
                if (controladorJuego.getAliens()[i][j] != null) {
                    hiloAnimacionEnemigos = new HiloAnimacionEnemigos(controladorJuego.getAliens()[i][j], this, controladorJuego);
                    hiloAnimacionEnemigos.start();
                }
            }
        }
    }

    public void startHiloDisparoEnemigo() {
        hiloDisparoEnemigos = new HiloDisparoEnemigos(controladorJuego, this);
        hiloDisparoEnemigos.start();
    }

    public void detenerHilos(){
        hiloAnimacionEnemigos=null;
        hiloDisparoAlien=null;
        hiloEnemigo=null;
        hiloDisparoEnemigos=null;
        hiloDisparoJugador=null;

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
        g.drawString("NIVEL ", 510, 40);

        g.setColor(Color.GREEN);
        g.drawString(controladorJuego.getPartidaActual().getJugador().getNickname(), 140, 40);
        g.drawString(controladorJuego.getPartidaActual().getPuntaje() + "", 400, 40);
        g.drawString(controladorJuego.getPartidaActual().getNivel().getNombre(), 510, 40);

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

        for (int i = 0; i < controladorJuego.getAliens().length; i++) {
            for (int j = 0; j < controladorJuego.getAliens()[i].length; j++) {
                if (controladorJuego.getAliens()[i][j] != null) {
                    if (controladorJuego.getAliens()[i][j].getBomba() != null) {
                        BombaAlien bombaAlien = (BombaAlien) controladorJuego.getAliens()[i][j].getBomba();
                        if (bombaAlien != null) {
                            g.setColor(Color.RED);
                            g.fillOval(bombaAlien.getPosicionX(), bombaAlien.getPosicionY(), 7, 7);
                        }
                    }
                }
            }
        }


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

        if (controladorJuego.nivelCompletado()) {
            //controladorJuego.finalizarJuego();
            detenerHilos();
            int bonificacion = (controladorJuego.puntosPorVida() - controladorJuego.puntosPorDisparos());
            if (bonificacion > 0)
                controladorJuego.getPartidaActual().agregarPuntos(bonificacion);

            if(controladorJuego.siguienteNivel())
                inciarHilos();
            else
            {
                finDelJuegoXVictoria();
            }
        }

        // PERDIÓ
        if (controladorJuego.jugadorSinVidas()) {
            controladorJuego.finalizarJuego();
            detenerHilos();
            int bonificacion = (controladorJuego.puntosPorVida() - controladorJuego.puntosPorDisparos());
            if (bonificacion > 0)
                controladorJuego.getPartidaActual().agregarPuntos(bonificacion);
            finDelJuegoXPerdida();
        }

        if(controladorJuego.isEnEjecucion())
        {
            g.drawString("Vidas jugador " + controladorJuego.getPartidaActual().getVidas() , 100, 470);
        }
    }

    private void finDelJuegoXPerdida(){
        repaint();

        ControladorMejoresPuntajes mejoresPuntajes = new ControladorMejoresPuntajes();
        mejoresPuntajes.validarPartida(controladorJuego.getPartidaActual());

        framePrincipal.setCurrentState(new PerdidaPartida(framePrincipal));
    }
    private void finDelJuegoXVictoria(){
        repaint();

        ControladorMejoresPuntajes mejoresPuntajes = new ControladorMejoresPuntajes();
        mejoresPuntajes.validarPartida(controladorJuego.getPartidaActual());
        framePrincipal.setCurrentState(new GanarPartida(framePrincipal));

    }

    public void volverAMenuPrincipal()
    {
        framePrincipal.setCurrentState(new MenuPrincipal(framePrincipal));
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
