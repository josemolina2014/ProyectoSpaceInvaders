package hilos;

import controlador.ControladorJuego;
import gui.estadosJuego.Juego;
import modelo.enemigo.Alien;

public class HiloEnemigos extends Thread {
	private Juego interfaz;
	private Alien enemigo;
	private ControladorJuego controladorJuego;

	public HiloEnemigos(Alien invasores, Juego interfaz, ControladorJuego controladorJuego) {

		this.controladorJuego = controladorJuego;
		enemigo = invasores;
		this.interfaz = interfaz;
	}

	@Override
	public void run() {

		while (controladorJuego.isEnEjecucion()) {

			enemigo.mover();


			try {
				sleep(80);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			interfaz.updateUI();

			if (enemigo.getBomba() != null) {
				if (enemigo.getBomba().getPosicionY() >= 420) {
					enemigo.getBomba().impacto();
					enemigo.eliminarDisparo();
				}
			}

		}

	}

}