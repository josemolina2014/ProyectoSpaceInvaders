package modelo;

import java.io.Serializable;

public class Puntaje implements Serializable {

	private int puntuacion;
	private Jugador jugador;
	private String nombrePartida;

	public Puntaje(int puntuacion, Jugador jugador, String nombrePartida) {
		this.puntuacion = puntuacion;
		this.jugador = jugador;
		this.nombrePartida = nombrePartida;
	}

	@Override
	public String toString() {
		String puntos = puntuacion + "";
		return "" + puntos + " " + jugador.getNickname() + " " + nombrePartida;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getNombrePartida() {
		return nombrePartida;
	}

	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
}