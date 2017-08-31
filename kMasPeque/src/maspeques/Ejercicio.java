package maspeques;

import java.util.*;


public class Ejercicio {

	public static void main(String[] args) {
        String miPathEnt ="numero.in";
        String miPathSal ="salida.out";
		Archivo archivo = new Archivo();
		int cantNumeros, cantMenores;
		int contadorLec = 1;
		 int i = 1;
		 int numero;
		archivo.abrirArchivo(miPathEnt);
		cantNumeros = archivo.leerCantidadNumero();
		cantMenores = archivo.leerCantidadAMostrar();
		
		int[] vecSalida = new int[cantMenores];
          
		
		//CARGA EL PRIMER VALOR
		vecSalida[0] = archivo.leerSiguienteNumero();
		//CARGA LOS PRIMEROS VALORES
		   while(i < cantMenores-1)
		   {    numero = archivo.leerSiguienteNumero();
			   if(!esDuplicado(numero, vecSalida,i))
			  	 {
				   vecSalida[i] = numero;
				   i ++;
			  	 }
			   contadorLec ++;
		   }  
		
		  
		   Arrays.sort(vecSalida);
		   
		  for ( i = 0; i < cantNumeros-contadorLec ; i++) {
		     numero = archivo.leerSiguienteNumero();
			  if(numero < vecSalida[cantMenores -1])
			  {  if(!esDuplicado(numero, vecSalida,vecSalida.length))
			  	 {
				   vecSalida[cantMenores - 1] = numero;
				   Arrays.sort(vecSalida); 
			  	 }
			  }
			
	     }
		  archivo.cerrarArchivo(); // Cierra el de entrada.
		  archivo.escribir(miPathSal,vecSalida);
		  
	
	}
	
	public static boolean esDuplicado(int numero, int[] vector, int cantidad)
	{
		for (int i = 0; i < cantidad; i++) {
			if(numero == vector[i])
				return true;
		}
		return false;
	}

}
