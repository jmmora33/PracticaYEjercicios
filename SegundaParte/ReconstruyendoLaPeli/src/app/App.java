package app;

import pelicula.Distra;
import pelicula.Grafo;

public class App {





	public static void main(String[] args) {

	  String archivo = "pelicula.in";
	  Grafo grafo = new Grafo(archivo);
	  int[] recorridos;
	  Distra distra = new Distra(grafo, 0);
	   distra.muestraCostos();
	   System.out.println();
	   distra.MostrarRuta(9);
	}
}
