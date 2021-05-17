package controlador;


import control.Teclado;
import modelo.NaveEspacial;
import modelo.Partida;
import modelo.Puntaje;
import modelo.enemigo.Alien;
import modelo.fabrica.FactoryEnemigo;
import modelo.nivel.Nivel;

public class ControladorJuego {

	private static ControladorJuego instancia;
	private Partida partidaActual;
	private NaveEspacial naveEspacial;
	private Alien [][] aliens;
	private Puntaje puntaje;



	private boolean enEjecucion;

	private ControladorJuego(Partida partidaActual) {
		this.partidaActual = partidaActual;
		inicializarNaveEspacial();
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

	public void inicio() {
		// TODO - implement ControlDeJuego.inicio
		throw new UnsupportedOperationException();
	}

	public void TerminarJuego() {
		// TODO - implement ControlDeJuego.TerminarJuego
		throw new UnsupportedOperationException();
	}

	public void moveJugador() {
		// TODO - implement ControlDeJuego.moveJugador
		throw new UnsupportedOperationException();
	}

	public void crearAliens() {
		// TODO - implement ControlDeJuego.crearAliens
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


	public void setNaveEspacial(NaveEspacial naveEspacial) {
		this.naveEspacial = naveEspacial;
	}
}