package controlador;


import gui.SpaceInvaders;
import hilos.HiloDisparoJugador;
import modelo.NaveEspacial;
import modelo.Partida;
import modelo.Puntaje;
import modelo.enemigo.Alien;
import modelo.nivel.Nivel;

public class ControladorJuego {

	private static ControladorJuego instancia;
	private Partida partidaActual;
	private NaveEspacial naveEspacial;
	private Alien [][] aliens;
	private Puntaje puntaje;

	private HiloDisparoJugador hiloDisparoJugador;
	private boolean enEjecucion;

	private ControladorJuego(Partida partidaActual) {
		this.partidaActual = partidaActual;
		inicializarNaveEspacial();
		inicializarEnemigos(partidaActual.getNivel());
		enEjecucion=true;
	}
	private synchronized static void createInstance(Partida partida){
		if(instancia==null)
			instancia = new ControladorJuego(partida);
	}

	public static ControladorJuego getInstancia(Partida partida) {
		if(instancia==null) createInstance(partida);
		return instancia;
	}

	public void inicializarEnemigos(Nivel nivel) {
		aliens = new ControladorEnemigos().crearEnemigos(nivel);
	}

	public void inicializarNaveEspacial(){
		naveEspacial = new ControladorNaveEspacial().crearNaveEspacial();
	}

	public void eliminarUnEnemigo(Alien alien) {
		for (int i = 0; i < aliens.length; i++) {
			for (int j = 0; j < aliens[0].length; j++) {
				if (aliens[i][j] != null) {
					if (aliens[i][j].equals(alien)) {
						aliens[i][j] = null;
					}
				}
			}
		}

	}
	public void eliminarUnEnemigo(int fila, int columna)
	{
		if(fila<aliens.length && columna<aliens[0].length)
			aliens[fila][columna] = null;
	}


	public void TerminarJuego() {
		// TODO - implement ControlDeJuego.TerminarJuego
		throw new UnsupportedOperationException();
	}


	public boolean isEnEjecucion() {
		return enEjecucion;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}

	public Alien[][] getAliens() {
		return aliens;
	}

	public NaveEspacial getNaveEspacial() {
		return naveEspacial;
	}

	public void inicarHiloNave(SpaceInvaders framePrincipal){
		hiloDisparoJugador = new HiloDisparoJugador(this, framePrincipal, aliens);
		hiloDisparoJugador.run();
	}



	public void setNaveEspacial(NaveEspacial naveEspacial) {
		this.naveEspacial = naveEspacial;
	}
}