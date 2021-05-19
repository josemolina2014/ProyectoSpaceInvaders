package controlador;


import gui.SpaceInvaders;
import gui.estadosJuego.Juego;
import hilos.HiloDisparoJugador;
import hilos.HiloEnemigos;
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
	private int estadoDelJuego;

	private HiloDisparoJugador hiloDisparoJugador;
	private boolean enEjecucion;
	private boolean juegoEnPausa;

	private ControladorJuego(Partida partidaActual) {
		this.partidaActual = partidaActual;
		inicializarNaveEspacial();
		inicializarEnemigos(partidaActual.getNivel());
		estadoDelJuego=1;
		iniciarJuego();
	}

	public void iniciarJuego() {
		enEjecucion=true;
	}
	public void detenerJuego() {
		enEjecucion=false;
	}

	private static void createInstance(Partida partida){
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

	public void impactoEnNaveJugador()
	{
		partidaActual.setVidas(partidaActual.getVidas()-1);
	}

	public void impactoEnAlien(){

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
		estadoDelJuego=2;
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




	public void TerminarJuego() {
		detenerJuego();
		int bonificacion = puntosPorVida()-puntosPorDisparos();
		if(bonificacion>0)
			partidaActual.agregarPuntos(bonificacion);

		System.out.println("pasar al menu principal");

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

	public void setNaveEspacial(NaveEspacial naveEspacial) {
		this.naveEspacial = naveEspacial;
	}

	public boolean isJuegoEnPausa() {
		return juegoEnPausa;
	}

	public void setJuegoEnPausa(boolean juegoEnPausa) {
		this.juegoEnPausa = juegoEnPausa;
	}
	public void pausarJuego(){
		juegoEnPausa=true;
	}
	public void desPausarJuego(){
		juegoEnPausa=false;
	}
}