package modelo.enemigo;

import modelo.ElementoDePantalla;
import modelo.fabrica.FactoryProyectil;
import modelo.proyectil.BombaAlien;
import util.Constantes;

import java.util.List;

public abstract class Alien implements ElementoDePantalla, Cloneable {

    private int posicionX;
    private int posicionY;
    private int alto;
    private int ancho;
    private boolean visible;
    private String rutaImagen;
    private int puntosPorMuerte;
    private List<String> urlImagenes;
    private int vidas;
    private int velocidad;
    private Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccion;
    private BombaAlien disparo;
    private FactoryProyectil factoryProyectil;


    public Alien(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;

        direccion = Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL.DERECHA;
        this.ancho = Constantes.ALIEN_ANCHO;
        this.alto= Constantes.ALIEN_ALTO;

    }

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

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public int getPosicionX() {
        return posicionX;
    }

    @Override
    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public List<String> getUrlImagenes() {
        return urlImagenes;
    }

    public void setUrlImagenes(List<String> urlImagenes) {
        this.urlImagenes = urlImagenes;
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

    public Alien clonar() throws CloneNotSupportedException {
        return (Alien) this.clone();
    }

    public int getPuntosPorMuerte() {
        return puntosPorMuerte;
    }

    public void setPuntosPorMuerte(int puntosPorMuerte) {
        this.puntosPorMuerte = puntosPorMuerte;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }


    @Override
    public void mover(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccion) {

        int siguientePosicion = posicionX+direccion.getUnidad()*velocidad;
        if(estaDentroLimitePantalla(siguientePosicion))
            posicionX = siguientePosicion;
        else
        {
            posicionY += Constantes.UNIDADES_DESCENSO_ALIEN;
            invertirDireccionHorizontal();
        }

    }

    protected void invertirDireccionHorizontal(){
        switch (direccion){
            case IZQUIERDA: direccion= Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL.DERECHA;break;
            case DERECHA: direccion= Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL.IZQUIERDA; break;
        }
    }


    public boolean estaDentroLimitePantalla(int coordenada){
        return (coordenada>=0 && coordenada<=Constantes.BORDE_PANTALLA_NAVE);
    }

    public void mover()
    {
        mover(direccion);
    }

    public Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL getDireccion() {
        return direccion;
    }

    public void setDireccion(Constantes.DIRECCION_MOVIMIENTO_HORIZONTAL direccion) {
        this.direccion = direccion;
    }

    public void disparar(int posicionX, int posicionY)
    {
        if(disparo==null){
            disparo = new BombaAlien(posicionX,posicionY);
        }
    }



    public BombaAlien getDisparo() {
        return disparo;
    }

    public void setDisparo(BombaAlien disparo) {
        this.disparo = disparo;
    }
    public void eliminarDisparo() {
        this.disparo = null;
    }
}
