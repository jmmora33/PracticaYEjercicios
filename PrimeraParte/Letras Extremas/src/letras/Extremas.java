package letras;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Extremas {

	public static void main(String[] args) throws IOException {

		String miPath = "Archivo.in";
		String miPathSalida = "Archivo.out";
		int cantidad;
		int[] letras = new int[26]; // Se ponen en orden segun la letra
		List<String> nombres = new ArrayList<String>();
		ArrayList<Integer> maximos = new ArrayList<>();
		Scanner sc = new Scanner(new File(miPath));
		PrintWriter salida = new PrintWriter(new File(miPathSalida));
		cantidad = sc.nextInt();

		for (int i = 0; i < cantidad; i++)
			nombres.add(sc.next());

		sc.close();
		// LETRAS REPETIDAS O(N)
		for (String nombre : nombres) {

			letras[(int) nombre.charAt(0) % (int) 'a']++;
			letras[(int) nombre.charAt(nombre.length() - 1) % (int) 'a']++;
		}

		maximos = buscarMaximos(letras);

		salida.print("Letras: ");
		for (int i = 0; i < maximos.size(); i++) {
				int letra = (int)'A' + maximos.get(i) ;
				salida.print((char) letra) ;
				
			}
		salida.println();

		for (String nombre : nombres) {
			for (int j = 0; j < maximos.size(); j++) {
					if ((int) nombre.charAt(0) == maximos.get(j) + (int) 'a'
							|| (int) nombre.charAt(nombre.length() - 1) == maximos.get(j) + (int) 'a') {
						System.out.println(nombre);
						salida.println(nombre);
					}

			}

		}

		salida.close();
	}

	public static void mostrarLetrasRep(int[] letras) {

		for (int i = 0; i < letras.length; i++)
			System.out.println((char) (i + 'a') + ":" + " " + letras[i]);

	}

	public static ArrayList<Integer> buscarMaximos(int[] letras) {

		ArrayList<Integer> maximos = new ArrayList<>();
		int maximo = 1;
		// Busco el maximo
		for (int i = 0; i < letras.length; i++)
			if (letras[i] > maximo)
				maximo = letras[i];

		// Me fijo quien tiene valor maximo y lo saco
		for (int i = 0, j = 0; i < letras.length; i++) {
			if (letras[i] == maximo) {
				maximos.add(i); // Guardo la posicion del maximo en el vector para luego mostrarlo.
				j++;
			}

		}

		return maximos;
	}

}
