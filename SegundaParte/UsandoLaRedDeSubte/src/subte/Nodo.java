package subte;

import java.util.ArrayList;

public class Nodo {

	private int nLinea;
	private int [] estaciones;
	
	public Nodo (int nlinea, int [] estaciones) {
		this.setnLinea(nlinea);
		this.setEstaciones(estaciones);
	}

	public int getnLinea() {
		return nLinea;
	}

	public void setnLinea(int nLinea) {
		this.nLinea = nLinea;
	}

	public int [] getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(int [] estaciones) {
		this.estaciones = estaciones;
	}
	
	public boolean contiene (int estacion) {
		for (int i = 0; i < this.estaciones.length; i++) {
			if (this.estaciones[i] == estacion)
				 return true;
		}
		return false;
	}


}
