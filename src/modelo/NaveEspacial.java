package modelo;

import modelo.fabrica.FactoryProyectil;
import modelo.proyectil.Proyectil;
import util.Constantes;

public class NaveEspacial implements ElementoDePantalla {

	private int posicionX;
	private int posicionY;
	private int alto;
	private int ancho;
	private boolean visible;
	private String rutaImagen;
	private int cantidadDisparos;
	private Proyectil disparo;
	private FactoryProyectil factoryProyectil;

	public NaveEspacial() {
		visible=true;
		cantidadDisparos=0;
		factoryProyectil = new FactoryProyectil();
	}



	@Override
	public void mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccion) {
		int siguientePosicion = posicionX+(direccion.getUnidad()*Constantes.MULTIPLICADOR_MOVIMIENTO_NAVE);
		if(estaDentroLimitePantalla(siguientePosicion))
			posicionX = siguientePosicion;
	}
	public boolean estaDentroLimitePantalla(int coordenada){
		return (coordenada>=0 && coordenada<=Constantes.BORDE_PANTALLA_NAVE);
	}

	public boolean estaDentroLimitePantalla(){
		return (posicionX>=0 && posicionX<=Constantes.BORDE_PANTALLA_ALIEN);
	}
	public void disparar (int posX, int posY)
	{
		if(disparo==null)
		{
			cantidadDisparos++;

			disparo = factoryProyectil.crearProyectil(Constantes.Tipo_proyectil.NAVE,posX,posY);
		}
	}
	public void eliminarDisparo()
	{
		disparo = null;
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
	public boolean isVisible() {return visible;	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	@Override
	public String getRutaImagen() {
		return rutaImagen;
	}

	public Proyectil getDisparo() {
		return disparo;
	}
}