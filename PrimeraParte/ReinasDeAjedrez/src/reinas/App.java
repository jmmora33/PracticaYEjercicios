package reinas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner (new File ("Reinas2.in"));
		PrintWriter salida = new PrintWriter (new File ("Reinas.out"));
		
		Reina [] reinas = new Reina [sc.nextInt()];
		
		for (int i = 0; i < reinas.length; i++) {
			reinas[i] = new Reina (i+1,sc.nextInt());
		}
		
		
		int [][] matrizResultado = new int [reinas.length][reinas.length];
		
		boolean bandera = false;
		for (int i = 0; i < reinas.length-1; i++) {
			for (int j = i+1; j < reinas.length; j++) {
				if (reinas[i].intersectaCon(reinas[j], j-i)) {
					if (!bandera) {
						salida.println("NO");
						bandera = true;
				     }
					matrizResultado[i][j] = 1;
				}
					
			}
			
		}
		
		
		if(!bandera)
			salida.println("SI");
		else{
		for (int i = 0; i < matrizResultado.length; i++) {
			boolean primero = false;
			int aux = 0;
			for (int j = i+1; j < matrizResultado.length; j++) {
				if (matrizResultado[i][j] == 1) {
					if(!primero) {
						primero = true;
						aux = j;
						salida.println("("+(i+1)+";"+(j+1)+")");
					}
					else {
					   if (matrizResultado[aux][j]!=1) {
						   salida.println("("+(i+1)+";"+(j+1)+")");
					   }	 
					}
				}
			}
		}
		}
		
		sc.close();
		salida.close();
 	}


}


