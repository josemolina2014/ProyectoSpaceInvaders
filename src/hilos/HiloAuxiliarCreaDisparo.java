package hilos;

import controlador.ControladorJuego;
import gui.estadosJuego.Juego;
import interfaz.InterfazSpaceInvaders;
import mundo.Partida;

public class HiloAuxiliarCreaDisparo extends Thread {

	private ControladorJuego controladorJuego;
	private Juego framePrincipal;

	public HiloAuxiliarCreaDisparo(ControladorJuego controladorJuego, Juego framePrincipal) {
		this.controladorJuego = controladorJuego;
		this.framePrincipal = framePrincipal;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (controladorJuego.isEnEjecucion()) {

			int fila = (int) (Math.random() * 4);
			int columna = (int) (Math.random() * 9);

			if (controladorJuego.getAliens()[fila][columna] != null) {
				controladorJuego.getAliens()[fila][columna].disparar(
						controladorJuego.getAliens()[fila][columna].getPosicionX(),
						controladorJuego.getAliens()[fila][columna].getPosicionY());

			}

			try {
				sleep(800);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
