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

	private HiloDisparoJugador hiloDisparoJugador;
	private boolean enEjecucion;

	private ControladorJuego(Partida partidaActual) {
		this.partidaActual = partidaActual;
		inicializarNaveEspacial();
		inicializarEnemigos(partidaActual.getNivel());
		inciarTodosLosHilos();
		enEjecucion=true;
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

	public void TerminarJuego() {
		enEjecucion=false;
		int bonificacion = puntosPorVida()-puntosPorDisparos();
		if(bonificacion>0)
			partidaActual.setPuntaje(bonificacion);

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

	public void inciarTodosLosHilos(){

		startHiloEnemigo();
		startHiloAnimacion();
		startHiloAuxiliar();
		startHiloDisparoEnemigo();
	}

	private void startHiloDisparoEnemigo() {

	}

	private void startHiloAuxiliar() {
	}

	private void startHiloAnimacion() {

	}

	private void startHiloEnemigo() {
		/*
		HiloEnemigos hiloEnemigo;
		for (int i = 0; i <aliens.length; i++) {
			for (int j = 0; j < aliens[0].length; j++) {
				if (aliens[i][j] != null) {
					hiloEnemigo = new HiloEnemigos(aliens[i][j], this);
					hiloEnemigo.start();
				}
			}
		}*/

	}



	public void matarHilos(){

	}



	public void setNaveEspacial(NaveEspacial naveEspacial) {
		this.naveEspacial = naveEspacial;
	}
}