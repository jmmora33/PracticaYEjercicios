package monticulo;

public class ColaPrioridad {

	public void insertar(Nodo nodo) {

		this.getMonticulo().agregar(nodo);
	}

	public void sacar() {
		this.getMonticulo().sacar();
	}

	public ColaPrioridad() {
		this(1, 1, new MonticuloDin());
	}

	public ColaPrioridad(int primero, int ultimo, MonticuloDin monticulo) {
		super();
		this.primero = primero;
		this.ultimo = ultimo;
		this.monticulo = monticulo;
	}

	public int getPrimero() {
		return primero;
	}

	public void setPrimero(int primero) {
		this.primero = primero;
	}

	public int getUltimo() {
		return ultimo;
	}

	public void setUltimo(int ultimo) {
		this.ultimo = ultimo;
	}

	public MonticuloDin getMonticulo() {
		return monticulo;
	}

	public void setMonticulo(MonticuloDin monticulo) {
		this.monticulo = monticulo;
	}

	private int primero;
	private int ultimo;
	private MonticuloDin monticulo;

}
