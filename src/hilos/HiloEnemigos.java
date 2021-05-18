package hilos;

import controlador.ControladorJuego;
import gui.SpaceInvaders;
import gui.estadosJuego.Juego;
import interfaz.InterfazSpaceInvaders;
import modelo.enemigo.Alien;
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
		// TODO Auto-generated method stub
		while (controladorJuego.isEnEjecucion()) {

			enemigo.mover();


			try {
				sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			interfaz.updateUI();

/*
			if (enemigo.getDisparoUno() != null) {
				if (enemigo.getDisparoUno().getPosY() >= 420) {
					enemigo.getDisparoUno().setImpacto(true);
					enemigo.eliminarDisparo();
				}
			}
*/
		}

	}

}