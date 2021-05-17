package modelo;

import modelo.proyectil.DisparoNave;
import util.Constantes;

public class NaveEspacial implements ElementoDePantalla {

	private int posicionX;
	private int posicionY;
	private int alto;
	private int ancho;
	private boolean visible;
	private String rutaImagen;
	private int cantidadDisparos;
	private DisparoNave disparo;

	public NaveEspacial() {
		visible=true;
		cantidadDisparos=0;
	}



	@Override
	public void mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccion) {
		int siguientePosicion = posicionX+direccion.getUnidad();
		if(estaDentroLimitePantalla(siguientePosicion))
			posicionX = siguientePosicion;
	}
	public boolean estaDentroLimitePantalla(int coordenada){
		return (coordenada>=0 && coordenada<=Constantes.BORDE_PANTALLA_NAVE);
	}

	public void disparar (int posX, int posY)
	{
		if(disparo==null)
		{
			cantidadDisparos++;
			disparo = new DisparoNave(posX, posY);

		}
	}


	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public int getCantidadDisparos() {
		return cantidadDisparos;
	}

	public void setCantidadDisparos(int cantidadDisparos) {
		this.cantidadDisparos = cantidadDisparos;
	}
	@Override
	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	@Override
	public int getPosicionY() {
		return posicionY;
	}

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


}