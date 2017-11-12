package regaliten;

public class Nodo implements Comparable<Nodo> {

	private int numero;
	private int grado;
	private int color;
	
	
	public Nodo(int numero) {
		super();
		this.numero = numero;
		this.grado = 0;
		this.color = 0;
	}

		public Nodo(Nodo that) {
			this.numero = that.numero;
			this.grado = that.grado;
			this.color = that.color;
		}

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getGrado() {
		return grado;
	}


	public void setGrado(int grado) {
		this.grado = grado;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}


	@Override
	public int compareTo(Nodo that) {
		if(this.grado > that.getGrado())
			return -1;
		if(this.grado < that.getGrado())
			return 1;
		
		return 0;
	}
	
	
}
