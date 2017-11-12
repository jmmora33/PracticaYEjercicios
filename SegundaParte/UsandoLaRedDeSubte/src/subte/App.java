package subte;

import java.io.IOException;

public class App {
	
	private static String entrada = "subte.in";
	private static String salida = "subte.out";
    private static Grafo grafo;
	public static void main(String[] args) throws IOException {
		
		 grafo = new Grafo (entrada,salida);

	}
	public static String getEntrada() {
		return entrada;
	}
	public static void setEntrada(String entrada) {
		App.entrada = entrada;
	}
	public static String getSalida() {
		return salida;
	}
	public static void setSalida(String salida) {
		App.salida = salida;
	}
	public static Grafo getGrafo() {
		return grafo;
	}
	public static void setGrafo(Grafo grafo) {
		App.grafo = grafo;
	}

	
	
}
