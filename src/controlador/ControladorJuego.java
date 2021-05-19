package controlador;


import gui.estadosJuego.Juego;
import hilos.HiloDisparoJugador;
import modelo.NaveEspacial;
import modelo.Partida;
import modelo.enemigo.Alien;
import modelo.nivel.Nivel;

public class ControladorJuego {


	private Partida partidaActual;
	private NaveEspacial naveEspacial;
	private Alien [][] aliens;



	private HiloDisparoJugador hiloDisparoJugador;
	private boolean enEjecucion;
	private boolean juegoEnPausa;

	public ControladorJuego(Partida partidaActual) {
		this.partidaActual = partidaActual;
		inicializarNaveEspacial();
		inicializarEnemigos(partidaActual.getNivel());

		iniciarJuego();
	}

	public void iniciarJuego() {
		enEjecucion=true;
	}
	public void detenerJuego() {
		enEjecucion=false;
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


	public void impactoEnNaveJugador()
	{
		partidaActual.setVidas(partidaActual.getVidas()-1);
	}

	public boolean jugadorSinVidas()
	{
		return partidaActual.getVidas()==0;
	}

	public boolean nivelCompletado() {
		int contador = 0;

		for (int i = 0; i < aliens.length; i++) {
			for (int j = 0; j < aliens[i].length; j++) {

				if (aliens[i][j] == null) {
					contador++;
				}
			}
		}

		return (contador == (aliens.length*aliens[0].length));
	}

	public void finalizarJuego()
	{
		detenerJuego();
	}

	public boolean siguienteNivel(){

		Nivel siguienteNivel = partidaActual.getSiguienteNivel();
		if(siguienteNivel!=null) {
			partidaActual.setNivel(siguienteNivel);
			inicializarEnemigos(siguienteNivel);
			return true;
		}
		else
		{
			detenerJuego();
			return false;
		}
	}

	public int puntosPorVida(){
		return (partidaActual.getVidas()*200);
	}

	public int puntosPorDisparos()
	{
		return naveEspacial.getCantidadDisparos();

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

	public void inicarHiloNave(Juego framePrincipal){
		hiloDisparoJugador = new HiloDisparoJugador(this, framePrincipal, aliens);
		hiloDisparoJugador.start();
	}

	public boolean isJuegoEnPausa() {
		return juegoEnPausa;
	}

	public void pausarJuego(){
		juegoEnPausa=true;
	}
	public void desPausarJuego(){
		juegoEnPausa=false;
	}
}