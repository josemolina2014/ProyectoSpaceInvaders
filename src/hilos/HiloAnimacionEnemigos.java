package hilos;

import controlador.ControladorJuego;
import gui.estadosJuego.Juego;
import interfaz.InterfazSpaceInvaders;
import modelo.enemigo.Alien;
import mundo.Enemigo;
import mundo.InvasorCalamar;
import mundo.InvasorCangrejo;

import java.util.concurrent.TimeUnit;

public class HiloAnimacionEnemigos extends Thread {

	private Alien enemigo;
	private Juego interfaz;
	private ControladorJuego controladorJuego;

	
	public HiloAnimacionEnemigos(Alien invasores, Juego principal, ControladorJuego controladorJuego) {

		this.enemigo = invasores;
		this.interfaz = principal;
		this.controladorJuego= controladorJuego;
	}
	
	@Override
	public void run()
	{
		while (controladorJuego.isEnEjecucion())
		{
			for (String rutaImagen: enemigo.getUrlImagenes())
			{
				enemigo.setRutaImagen(rutaImagen);
				esperar(1);
			}
		}
	}

	private void esperar(int segundos)
	{
		try {
			sleep(TimeUnit.SECONDS.toMillis(segundos));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
