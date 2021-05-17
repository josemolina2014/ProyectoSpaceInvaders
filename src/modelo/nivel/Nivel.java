package modelo.nivel;

import modelo.enemigo.Alien;

public interface Nivel {

	public int getVelocidadEnemigos();

	public int getVidasEnemigos();

	public int getNombre();

	public Alien[][] getEnemigos();
}