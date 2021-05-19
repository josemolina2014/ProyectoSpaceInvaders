package modelo.proyectil;

import modelo.ElementoDePantalla;
import modelo.NaveEspacial;
import util.Constantes;

public class BombaAlien implements ElementoDePantalla, Proyectil{

	private int posicionX;
	private int posicionY;
	private int alto;
	private int ancho;
	private boolean visible;
	private String rutaImagen;
	private boolean impacto;

	public BombaAlien(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
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

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public String getRutaImagen() {
		return rutaImagen;
	}

	@Override
	public void mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccion) {

	}


	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	@Override
	public boolean isImpacto() {
		return impacto;
	}

	@Override
	public void movimientoVertical(){
		posicionY = posicionY +
				Constantes.DIRECCION_MOVIMIENTO_VERTICAL_PROYECTIL.ABAJO.getUnidad();
	}

	/**
	 * Impacto a la nave del jugador
	 * @param objeto
	 * @return
	 */
	@Override
	public boolean impactoAlAdversario(ElementoDePantalla objeto) {
		NaveEspacial naveEspacial = (NaveEspacial) objeto;
		boolean salida = false;

		if (naveEspacial != null) {

			double cateto = posicionX - naveEspacial.getPosicionX();
			double cateto2 = posicionY - naveEspacial.getPosicionY();
			double d = Math.sqrt((cateto * cateto) + (cateto2 * cateto2));

			if (d < naveEspacial.getAncho() + 8 && posicionY == naveEspacial.getPosicionY()
					&& (posicionX < naveEspacial.getPosicionX() + 35 && posicionX > naveEspacial.getPosicionX() - 10)) {
				salida = true;
			}
		}

		return salida;

	}

	@Override
	public void impacto() {
		setImpacto(true);
	}

	public void setImpacto(boolean impacto) {
		this.impacto = impacto;
	}


}