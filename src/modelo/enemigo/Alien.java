package modelo.enemigo;

import modelo.ElementoDePantalla;
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


    public Alien(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
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

    }
}
