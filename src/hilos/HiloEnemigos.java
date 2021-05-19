package hilos;

import controlador.ControladorJuego;
import gui.SpaceInvaders;
import gui.estadosJuego.Juego;
import interfaz.InterfazSpaceInvaders;
import modelo.enemigo.Alien;
import modelo.proyectil.BombaAlien;
import mundo.Enemigo;

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

			if (enemigo.getDisparo() != null) {
				if (enemigo.getDisparo().getPosicionY() >= 420) {
					enemigo.getDisparo().impacto();
					enemigo.eliminarDisparo();
				}
			}

		}

	}

}