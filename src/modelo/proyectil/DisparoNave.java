package modelo.proyectil;

import modelo.ElementoDePantalla;

public class DisparoNave implements ElementoDePantalla, Proyectil {

	private int posicionX;
	private int posicionY;
	private int alto;
	private int ancho;
	private boolean visible;
	private String rutaImagen;

	@Override
	public int getPosicionX() {
		return posicionX;
	}

	@Override
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	@Override
	public int getPosicionY() {
		return posicionY;
	}

	@Override
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	@Override
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	@Override
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
}