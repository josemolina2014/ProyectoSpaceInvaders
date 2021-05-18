package modelo.proyectil;

import modelo.ElementoDePantalla;
import modelo.enemigo.Alien;
import mundo.Enemigo;
import util.Constantes;

public class DisparoNave implements ElementoDePantalla, Proyectil {

	private int posicionX;
	private int posicionY;
	private int alto;
	private int ancho;
	private boolean visible;
	private String rutaImagen;
	private boolean impacto;

	public DisparoNave(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		impacto=false;
	}

	public boolean hitsEnemigo(Alien alien) {
		boolean salida = false;
		int r = 8;
		if (alien != null) {
			double cateto = this.posicionX - alien.getPosicionX();
			double cateto2 = this.posicionY - alien.getPosicionY();
			double d = Math.sqrt((cateto * cateto) + (cateto2 * cateto2));

			if (d < (r + alien.getAncho())) {
				salida = true;
			}
		}
		return salida;
	}

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

	@Override
	public void mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccionHorizontal) {

	}
	@Override
	public void movimientoVertical(){
		posicionY = posicionX - Constantes.DIRECCION_MOVIMIENTO_VERTICAL.ARRIBA.getUnidad();
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	@Override
	public boolean isImpacto() {
		return impacto;
	}

	public void setImpacto(boolean impacto) {
		this.impacto = impacto;
	}
}