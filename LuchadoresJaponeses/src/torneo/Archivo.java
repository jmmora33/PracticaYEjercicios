package torneo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Archivo {

	public Torneo leerArchivo (String miPath) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(miPath));
		int cantLuchadores = sc.nextInt();
		System.out.println("Cantidad de luchadores:" + cantLuchadores);
		Luchador luchadorNuevo = new Luchador();
		Luchador [] luchadoresTorneo = new Luchador [cantLuchadores];
		for (int i = 0; i < luchadoresTorneo.length ; i++) {
			luchadorNuevo.setPeso(sc.nextInt());
			luchadorNuevo.setAltura(sc.nextInt());
			luchadoresTorneo[i]= new Luchador(luchadorNuevo);
			//System.out.println("Luchador["+i+"]" + luchadorNuevo.toString());
		}
		
		Torneo torneo = new Torneo (cantLuchadores,luchadoresTorneo);
		sc.close();
		return torneo;
	}
	
	public Archivo() {
		
	}
	
	
	public void EscribirArchivo (Torneo torneo,int [] solucion, String Path) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(Path));
	    salida.println(torneo.getCantidadDeLuchadores());      
		for (int i=0;i<torneo.getCantidadDeLuchadores();i++) {
			salida.println(solucion[i]);
		}
		salida.close();
		
	}
 


	
	
}
