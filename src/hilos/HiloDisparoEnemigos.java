package hilos;


import controlador.ControladorJuego;
import gui.estadosJuego.Juego;


public class HiloDisparoEnemigos extends Thread {

	private ControladorJuego controladorJuego;
	private Juego framePrincipal;

	public HiloDisparoEnemigos(ControladorJuego controladorJuego, Juego framePrincipal) {
		this.controladorJuego = controladorJuego;
		this.framePrincipal = framePrincipal;
	}

	/**
	 * se encarga de determinar si el misil de un alien golpea la nave
	 * en caso afirmativo le quita una vida al jugador
	 */
	@Override
	public void run() {
		super.run();

		while (controladorJuego.isEnEjecucion()) {
			
			for (int i = 0; i < controladorJuego.getAliens().length; i++) {
				for (int j = 0; j < controladorJuego.getAliens()[0].length; j++) {
					
					if (controladorJuego.getAliens()[i][j] != null) {
						if (controladorJuego.getAliens()[i][j].getDisparo() != null) {
							controladorJuego.getAliens()[i][j].getDisparo().movimientoVertical();
							
							if (controladorJuego.getAliens()[i][j].getDisparo().impactoAlAdversario(controladorJuego.getNaveEspacial())) {
								controladorJuego.getAliens()[i][j].eliminarDisparo();
								controladorJuego.impactoEnNaveJugador();
							}
						}
					}
				}
			}
			
			try {
				sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			framePrincipal.updateUI();
		}
	}
	
}
