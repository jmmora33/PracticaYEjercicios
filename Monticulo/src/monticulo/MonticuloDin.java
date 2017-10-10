package monticulo;

import java.util.ArrayList;

public class MonticuloDin {

	public boolean agregar(Nodo valor) {
		this.ingresarValor(valor);
		reordenarInsert();

		return true;
	}

	public void reordenarInsert() {
		Nodo aux;
		for (int i = this.arbol.size() - 1; i >= 1; i /= 2) {
			if (this.arbol.get(i).compareTo(this.arbol.get(i / 2)) > 0) {
				aux = this.arbol.get(i);
				this.ingresarValor(this.arbol.get(i / 2), i);
				this.ingresarValor(aux, i / 2);
			} else
				break;
		}
	}

	public Nodo sacar() {

		// No hay nada en la cola
		if (this.arbol.size() == 0)
			return new Nodo(0, 0);

		Nodo retorno = this.arbol().get(0);
		this.ingresarValor(this.arbol.get(this.arbol.size() - 1), 0);
		this.arbol.remove(this.arbol.size() - 1);
		reordenarSacar();

		return retorno;
	}

	public void reordenarSacar() {
		Nodo aux;
		for (int i = 0; i < this.arbol.size(); i *= 2) {
			if ((i * 2 + 1) < this.arbol.size()
					&& this.arbol().get(i * 2 + 1).compareTo(this.arbol().get(i * 2)) > 0) {

				if (this.arbol.get(i).compareTo(this.arbol.get(i * 2 + 1)) < 0) {
					aux = this.arbol().get(i);
					this.ingresarValor(this.arbol.get(i * 2 + 1), i);
					this.ingresarValor(aux, i * 2 + 1);
				} else
					break;
			} else if (i * 2 < this.arbol().size()
					&& this.arbol.get(i).compareTo(this.arbol.get(i * 2)) < 0) {
				aux = this.arbol.get(i);
				this.ingresarValor(this.arbol.get(i * 2 + 1), i);
				this.ingresarValor(aux, i * 2 + 1);
			} else
				break;
		}
	}

	public void ingresarValor(Nodo valor) {

		this.arbol.add(valor);
	}

	public void ingresarValor(Nodo valor, int posicion) {

		this.arbol.set(posicion, valor);
	}

	public static ArrayList<Nodo> initArray() {
		ArrayList<Nodo> retorno = new ArrayList<Nodo>();
		retorno.add(new Nodo(0, 0));

		return retorno;
	}

	public MonticuloDin() {
		this(0, new ArrayList<Nodo>());
	}

	public MonticuloDin(int tope, ArrayList<Nodo> arbol) {
		super();
		this.tope = tope;
		this.arbol = arbol;
	}

	public int getTope() {
		return tope;
	}

	public void setTope(int tope) {
		this.tope = tope;
	}

	public ArrayList<Nodo> arbol() {
		return arbol;
	}

	public void setArbol(ArrayList<Nodo> arbol) {
		this.arbol = arbol;
	}

	public ArrayList<Nodo> getArbol() {
		return arbol;
	}

	private int tope;
	private ArrayList<Nodo> arbol;

}
