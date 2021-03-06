package orden;

public class Ordenamiento<T extends Comparable> {

	public void seleccion(T[] arreglo) {
		/* Dejo en minimo la posicion del minimo */
		int minimo;
		int i, j;
		boolean flag = false;/* Me va a informar si hizo algun cambio */
		for (i = 0; i < arreglo.length - 1; i++) {
			minimo = i;
			for (j = i + 1; j < arreglo.length; j++) {
				if (arreglo[j].compareTo(arreglo[minimo]) < 0) {
					minimo = j;
					flag = true;/* Encontre al menos un minimo */
				}

			}
			if (!arreglo[minimo].equals(arreglo[i]) && flag) {
				T aux = arreglo[i];
				arreglo[i] = arreglo[minimo];
				arreglo[minimo] = aux;

			}
			flag = false;
		}
	}

	@SuppressWarnings("unchecked")
	public void insercion(T[] arreglo) {

		T aux;

		for (int i = 1; i < arreglo.length; i++) {
			aux = arreglo[i];
			for (int j = i - 1; j >= 0 && arreglo[j].compareTo(aux) > 0; j--) {
				arreglo[j + 1] = arreglo[j];
				arreglo[j] = aux;
			}
		}

	}

	public void shell(T[] arreglo) {
		T aux;
		boolean estado;
		for (int salto = arreglo.length / 2; salto > 0; salto = salto == 2 ? 1 : salto / 2) {
			do {
				estado = false;
				for (int i = 0; i + salto < arreglo.length; i++) {
					if (arreglo[i + salto].compareTo(arreglo[i]) < 0) {
						aux = arreglo[i];
						arreglo[i] = arreglo[i + salto];
						arreglo[i + salto] = aux;
						if (!estado)
							estado = true;
					}
				}
			} while (estado);

		}
	}

	// PARA ENTEROS NO ES GENERICO
	public void sort(int[] arreglo) {
		if (arreglo.length == 1)
			return;
		int medio = arreglo.length / 2;
		int[] parte1 = new int[medio];
		int[] parte2 = new int[arreglo.length - medio];

		for (int i = 0; i < arreglo.length; i++) {
			if (i < medio)
				parte1[i] = arreglo[i];
			else
				parte2[i - medio] = arreglo[i];

			sort(parte1);
			sort(parte2);
			merge(parte1, parte2, arreglo);

		}
	}

	private void merge(int[] parte1, int[] parte2, int[] resultado) {
		int index1 = 0;
		int index2 = 0;

		for (int i = 0; i < resultado.length; i++) {

			if (index1 == parte1.length) {
				resultado[i] = parte2[index2];
				index2++;
			} else if (index2 == parte2.length) {
				resultado[i] = parte1[index1];
				index1++;
			} else if (parte1[index1] < parte2[index2]) {
				resultado[i] = parte1[index1];
				index1++;
			} else {
				resultado[i] = parte2[index2];
				index2++;
			}
		}
	}

	public void quickSort(T[] arreglo) {

		arreglo = quickSortRecu(arreglo, 0, arreglo.length - 1);
	}

	public T[] quickSortRecu(T[] arreglos, int izq, int der) {

		int i = izq;
		int d = der;
		T aux;
		int pivote;

		if (izq >= der)
			return arreglos;

		if (izq != der) {

			pivote = izq;

			while (izq != der) {
				while (arreglos[der].compareTo(arreglos[pivote]) >= 0 && izq < der)
					der--;
				while (arreglos[izq].compareTo(arreglos[pivote]) < 0 && izq < der)
					izq++;

				if (der != izq) {
					aux = arreglos[der];
					arreglos[der] = arreglos[izq];
					arreglos[izq] = aux;
				}
				if (izq == der) {
					quickSortRecu(arreglos, i, izq - 1);
					quickSortRecu(arreglos, izq + 1, d);
				}
			}
		} else
			return arreglos;

		return arreglos;
	}
}