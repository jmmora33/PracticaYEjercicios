package monticulo;

public class ColaPrioriGen<T> {
	
	
	public void insertar(T elemento) {
		//this.monticulo.agregar(elemento);
//		this.getMonticulo().agregar(elemento);
	}
	public void sacar(Nodo nodo) {
		this.monticulo.sacar();
	}
	
	public ColaPrioriGen() {
			this(1,1, new MonticuloGen<>());
		}
	public ColaPrioriGen(int primero, int ultimo, MonticuloGen<?> monticulo) {
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
		
		public void setMonticulo(MonticuloGen<?> monticulo) {
			this.monticulo = monticulo;
		}
		
	public MonticuloGen<?> getMonticulo() {
			return monticulo;
		}

	private int primero;
	private int ultimo;
	private MonticuloGen<?> monticulo; 
}
