package maspeques;
import java.util.*;
import java.io.*;


public class Archivo {

private Scanner sc;

public Scanner getSc() {
	return sc;
}

public void setSc(Scanner sc) {
	this.sc = sc;
}

void abrirArchivo(String miPath)
{
	
 try {
	this.setSc(new Scanner(new File(miPath)));
} catch (FileNotFoundException e) {
	System.err.println("Error Archivo:"+e);
}
 
}

int leerCantidadNumero()
{
  if(this.getSc().hasNext())
	  return this.getSc().nextInt();
  else 
	  return 0;

}

int leerCantidadAMostrar()
{
	  if(this.getSc().hasNext())
		  return this.getSc().nextInt();
	  else 
		  return 0;

}

int leerSiguienteNumero()
{
				  	
return this.getSc().nextInt();

}

void cerrarArchivo()
{
	
 this.getSc().close();
}

void escribir(String miPath, int[] vector)
{
	PrintWriter salida;
	try {
		salida = new PrintWriter(new FileWriter(miPath));
		salida.println(vector.length);
		for (int i = 0; i < vector.length; i++) {
			salida.println(vector[i]);
		}
		

		salida.close();
	} catch (IOException e) {
		System.err.println("Error de escritura"+e);
	}      
	
	
}
}
