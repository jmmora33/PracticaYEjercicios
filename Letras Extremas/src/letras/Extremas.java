package letras;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Extremas {

	public static void main(String[] args) throws FileNotFoundException {
	
		String miPath = "Archivo.in";
        int cantidad;
		int[] letras = new int[26] ;		// Se ponen en orden segun la letra
        List<String> nombres = new ArrayList<String>();
        int[] maximos = new int[4];
        Scanner sc = new Scanner(new File(miPath));
        cantidad = sc.nextInt();
        
        for (int i = 0; i < cantidad; i++) 
        	nombres.add(sc.next());
		
        sc.close();
        
        for(String nombre: nombres) {
        
       
        	letras[(int)nombre.charAt(0)%(int)'a']++;

        	letras[(int)nombre.charAt(nombre.length()-1)%(int)'a']++;
        }
        
      maximos = buscarMaximos(letras);

      for (int i = 0; i < maximos.length; i++) {
    	  for(String nombre: nombres) {
              
        	  if((int)nombre.charAt(0) == maximos[i]+(int)'a' || (int)nombre.charAt(nombre.length()-1) == maximos[i]+(int)'a' ) 
        		System.out.println(nombre);  
        	  
          }

      }
      
	}

	
	public void mostrarLetrasRep(int[] letras) {
		
		 for (int i = 0; i < letras.length; i++) 
				System.out.println((char)(i + 'a') +":"+" "+letras[i]);
			
	}
	
	public static int[] buscarMaximos(int[] letras) {
		
		int[] maximos = new int[4];
		int maximo = 1;		 
		// Busco el maximo
		for(int i = 0; i <letras.length; i ++) 
			if(letras[i] > maximo)
				maximo = letras[i];
		
		// Me fijo quien tiene valor maximo y lo saco
		for(int i = 0, j = 0; i <letras.length; i ++) {
			if(letras[i] == maximo) {
				maximos[j] = i;
				j++;
			}
			
		}
				
		return maximos;
	}
	
}
