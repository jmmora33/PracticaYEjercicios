package monticulo;

public class Nodo implements Comparable<Nodo> {

	private int prioridad;
	private int dato;
	
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	@Override
	public String toString() {
		return "Nodo [prioridad=" + prioridad + ", dato=" + dato + "]";
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo(int prioridad, int dato) {
		super();
		this.prioridad = prioridad;
		this.dato = dato;
	}
	
	public Nodo() {
		this(100,12);
	}
	
	
	@Override
	public int compareTo(Nodo nodo) {
		
		
		return this.getPrioridad() < nodo.getPrioridad()?1:this.getPrioridad() > nodo.getPrioridad() ?-1:0;
	}

	
	
	
	
}
