package regaliten;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Grafo {

	private int[][] matAdy;
	private int[][] matColores;
	private int cantNodos;
	private Scanner sc;
	private Nodo[] nodos;
	private int cantColores;
	private int mayores[][];
	
	private int maxColor;
	private int cantRep;
	
	public Grafo(String archivo) {
		
		try {
		sc = new Scanner(new File(archivo));
		cantNodos = sc.nextInt();
		matAdy = new int[cantNodos][cantNodos];
		matColores = new int[cantNodos][cantNodos];
		nodos = new Nodo[cantNodos];
		for (int i = 0; i < matAdy.length; i++) {
			sc.nextInt();
			int indice = sc.nextInt() -1;
			while(indice != -2){
				matAdy[i][indice] = 1;
				matAdy[indice][i] = 1;
				indice = sc.nextInt() -1;
			}
			nodos[i] = new Nodo(i);
		}
		calcularGrados();
	    colorearPowell();
		}catch(Exception e) {
			System.err.println("Pelado cabeza de pene");
		}
	}
	
	public void calcularGrados() {
		int grado ;
		for(int i = 0 ; i < matAdy.length; i++) {
			grado = 0;
			for (int j = 0; j < matAdy.length; j++) {
				if(matAdy[i][j] == 1)
					grado ++;
			}
			nodos[i].setGrado(grado);
		}
	}
	
	public void colorearPowell() {
	//	Arrays.sort(nodos);
		
		for (int i = 0; i < nodos.length; i++) {
			colorear();
			reordenar();
			despintarGrafo();
		}
		
		mayores = new int [cantNodos][2];
		
		for (int i = 0; i < mayores.length; i++) {
			this.mayorPorLinea(matColores[i]);
		}
		
		
		
		System.out.println("PEPE");
	}
	
	public void mayorPorLinea (int[] colores) {
		
		HashMap<Integer, Integer> frec = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < colores.length; i++) {
			if(frec.containsKey(colores[i])) {
				frec.put(colores[i], frec.get(i)+1);
			}
			else
				frec.put(colores[i], 1);
		}
		
		Iterator it = frec.keySet().iterator();
		
		while(it.hasNext()) {
			int valor = it.next();
			if(this.cantRep< )
		}
	}
	
	public void despintarGrafo(){
		for (int i = 0; i < nodos.length; i++) {
			nodos[i].setColor(0);
		}
	}
	
	public void reordenar() {
		
		Nodo aux = new Nodo(nodos[0]);
		
		for (int i = 1; i < nodos.length; i++) {
		 nodos[i -1] = nodos[i];	
		}
		nodos[nodos.length-1] = aux;
	}
	
	public void colorear() {
		int color;
		int indice = nodos[0].getNumero();
		
		cantColores = 0;
		for (int i = 0; i < cantNodos; i++) {
			color = 1;
			/** Mientras el color no se pueda usar, elijo otro color**/
			while (!sePuedeColorear(i, color)) 
				color++;
			
			nodos[i].setColor(color);
			matColores[indice][nodos[i].getNumero()] = color;
			if (color > cantColores)
				cantColores = color;
		}
	}
	
	private boolean sePuedeColorear(int indice, int color) {
		int i = 0;
		boolean sePuede = true;
		if (nodos[indice].getColor() != 0) // si el nodo fue coloreado
			sePuede = false;
		while (i < cantNodos && sePuede) {
			// Si hay un nodo adyacente con ese color, no se puede colorear. Si el nodo fue coloreado tampoco se puede.
			if (nodos[i].getColor() == color && i != indice) {
				if (esAdyacente(nodos[i].getNumero(), nodos[indice].getNumero()))
					sePuede = false;
			}
			i++;
		}
		return sePuede;
	}
	
	public boolean esAdyacente(final int i, final int j) {
		return matAdy[i][j] == 1;
	}
	
}
