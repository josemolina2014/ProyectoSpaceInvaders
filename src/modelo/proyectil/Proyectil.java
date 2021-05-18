package modelo.proyectil;

import util.Constantes;

public interface Proyectil {

	public boolean isVisible();
	public void setVisible(boolean visible);
	public int getPosicionX();
	public void setPosicionX(int posicionX);
	public int getPosicionY();
	public void setPosicionY(int posicionY);
	public boolean isImpacto();
	public void movimientoVertical();



}