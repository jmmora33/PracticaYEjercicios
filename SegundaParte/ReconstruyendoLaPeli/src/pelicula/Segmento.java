package pelicula;

public class Segmento {

	private static final int ESCENAINI = 1;
	private int numero;
	private int escenaIni;
	private int escenaFin;
	
	public int getNumero() {
		return numero;
	}
	
	public Segmento (Segmento that) {
		this(that.getNumero()-1, that.escenaIni, that.escenaFin);
	}
	
	public Segmento () {
		this(0,0,0);
	}
	
	public Segmento(int numero, int escenaIni, int escenaFin) {
		super();
		this.numero = numero;
		this.escenaIni = escenaIni;
		this.escenaFin = escenaFin;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getEscenaIni() {
		return escenaIni;
	}
	public void setEscenaIni(int escenaIni) {
		this.escenaIni = escenaIni;
	}
	public int getEscenaFin() {
		return escenaFin;
	}
	public void setEscenaFin(int escenaFin) {
		this.escenaFin = escenaFin;
	}

	

	
}
