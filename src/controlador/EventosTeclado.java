package controlador;

import gui.SpaceInvaders;
import gui.estadosJuego.Juego;
import util.Constantes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado implements KeyListener {

    private Juego framePrincipal;
    private ControladorJuego controladorJuego;

    public EventosTeclado(Juego framePrincipal, ControladorJuego controladorJuego) {
        this.framePrincipal = framePrincipal;
        this.controladorJuego = controladorJuego;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(controladorJuego.isEnEjecucion())
        {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                if(controladorJuego.getNaveEspacial().getDisparo()==null)
                {
                    controladorJuego.getNaveEspacial().disparar(
                            controladorJuego.getNaveEspacial().getPosicionX(),
                            Constantes.NAVE_JUGADOR_POSICION_INICIAL_Y
                    );
                    controladorJuego.inicarHiloNave(framePrincipal);
                    framePrincipal.updateUI();

                }
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                controladorJuego.getNaveEspacial().mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL.IZQUIERDA);
                framePrincipal.updateUI();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                controladorJuego.getNaveEspacial().mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL.DERECHA);
                framePrincipal.updateUI();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            framePrincipal.volverAMenuPrincipal();
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (controladorJuego.isJuegoEnPausa()) {
                controladorJuego.iniciarJuego();
                controladorJuego.desPausarJuego();
                framePrincipal.inciarHilos();
            } else {
                controladorJuego.detenerJuego();
                controladorJuego.pausarJuego();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {



    }
}
