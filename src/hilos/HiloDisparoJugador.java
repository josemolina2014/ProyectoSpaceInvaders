package hilos;

import controlador.ControladorJuego;
import gui.SpaceInvaders;
import gui.estadosJuego.Juego;
import interfaz.InterfazSpaceInvaders;
import modelo.enemigo.Alien;
import modelo.proyectil.DisparoNave;
import mundo.Enemigo;
import mundo.NaveJugador;
import mundo.Partida;

public class HiloDisparoJugador extends Thread {

	private ControladorJuego controladorJuego;
	private Juego framePrincipal;
	private Alien[][] enemigos;

	public HiloDisparoJugador(ControladorJuego controladorJuego, Juego framePrincipal, Alien[][] enemigos) {
		this.controladorJuego = controladorJuego;
		this.framePrincipal = framePrincipal;
		this.enemigos = enemigos;
	}

	@Override
	public void run() {
		System.out.println("controladorJuego = " + controladorJuego.isEnEjecucion());
		while (controladorJuego.getNaveEspacial().getDisparo()  != null && !controladorJuego.getNaveEspacial().getDisparo().isImpacto()) {

			DisparoNave disparoNave = (DisparoNave) controladorJuego.getNaveEspacial().getDisparo();
			disparoNave.movimientoVertical();

			for (int i = 0; i < enemigos.length && disparoNave != null	&& !disparoNave.isImpacto(); i++)
			{
				for (int j = 0; j < enemigos[0].length && disparoNave != null
						&& !disparoNave.isImpacto(); j++) {
					if (disparoNave.hitsEnemigo(enemigos[i][j])) {
						disparoNave.setImpacto(true);
						controladorJuego.getPartidaActual().setPuntaje(enemigos[i][j].getPuntosPorMuerte());

						//controladorJuego.eliminarUnEnemigo(enemigos[i][j]);
						controladorJuego.eliminarUnEnemigo(i,j);

						controladorJuego.getNaveEspacial().eliminarDisparo();
						framePrincipal.repaint();
						framePrincipal.updateUI();
						//framePrincipal.getCurrentState().getMainPanel().repaint();
						//framePrincipal.getCurrentState().getMainPanel().updateUI();

					}
				}
			}

			try {
				sleep(2);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			//framePrincipal.getCurrentState().getMainPanel().updateUI();
			//framePrincipal.getCurrentState().getMainPanel().updateUI();
			framePrincipal.updateUI();
			if (disparoNave != null) {
				if (disparoNave.getPosicionY() <= 0) {
					controladorJuego.getNaveEspacial().eliminarDisparo();
				}
			}
		}

	}

}
