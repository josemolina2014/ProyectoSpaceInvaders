package controlador;

import gui.SpaceInvaders;
import util.Constantes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado implements KeyListener {

    private SpaceInvaders framePrincipal;
    private ControladorJuego controladorJuego;

    public EventosTeclado(SpaceInvaders framePrincipal, ControladorJuego controladorJuego) {
        this.framePrincipal = framePrincipal;
        this.controladorJuego = controladorJuego;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        if(controladorJuego.isEnEjecucion()){
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                controladorJuego.getNaveEspacial().
            }
        }


        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            controladorJuego.getNaveEspacial().mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL.IZQUIERDA);
            framePrincipal.getCurrentState().getMainPanel().updateUI();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            controladorJuego.getNaveEspacial().mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL.DERECHA);
            framePrincipal.getCurrentState().getMainPanel().updateUI();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {



    }
}
