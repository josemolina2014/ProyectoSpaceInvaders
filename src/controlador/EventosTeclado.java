package controlador;

import gui.SpaceInvaders;

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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
