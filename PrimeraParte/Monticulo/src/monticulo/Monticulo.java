package monticulo;

public class Monticulo {

	private int[] vector;
	private int tope;

	public int getTope() {
		return tope;
	}

	public void setTope(int tope) {
		this.tope = tope;
	}

	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	public Monticulo(int[] vector) {
		super();
		this.vector = vector;
		this.setTope(vector.length - 1);
	}

	public boolean agregar(int valor) {

		this.tope ++;
		if (this.tope == vector.length)
			return false;

		vector[tope] = valor;
		reordenarInsert();

		return true;
	}

	public void reordenarInsert() {
		int aux;
		for (int i = this.tope; i > 1; i /= 2) {
			if (vector[i] > vector[i / 2]) {
				aux = vector[i];
				vector[i] = vector[i / 2];
				vector[i / 2] = aux;
			} else
				break;
		}
	}

	public int sacar() {

		int retorno = 0;
		if (vector[1] != 0 && vector != null) {
			retorno = vector[1];
			vector[1] = vector[tope];
			this.setTope(this.getTope() - 1);
			reordenarSacar();
		}
		System.out.println(this.vector);
		return retorno;
	}

	public void reordenarSacar() {
		int aux;
		for (int i = 1; i <= this.getTope(); i *= 2) {
			if ((i * 2 + 1) <= this.tope && vector[i * 2 + 1] > vector[i * 2]) {

				if (vector[i] < vector[i * 2 + 1]) {
					aux = vector[i];
					vector[i] = vector[i * 2 + 1];
					vector[i * 2 + 1] = aux;
				} else
					break;
			} else if (i * 2 <= this.tope && vector[i] < vector[i * 2]) {
				aux = vector[i];
				vector[i] = vector[i * 2];
				vector[i * 2] = aux;
			} else
				break;
		}
	}
}
