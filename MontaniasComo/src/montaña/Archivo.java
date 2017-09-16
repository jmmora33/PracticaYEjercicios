package montaña;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {

	
	public Montaña leerArchivo(String miPath) throws FileNotFoundException{
		
		Montaña montaña = new Montaña();
		Scanner sc = new Scanner(new File(miPath));
		int[] coordenadasY;
		montaña.setCantCambios(sc.nextInt());
		coordenadasY = new int[montaña.getCantCambios()];
		
		for (int i = 0; i < coordenadasY.length; i++) 
			coordenadasY[i] = sc.nextInt();
		montaña.setCapacidadCarro(coordenadasY[0] -10);
		montaña.setCoordenadasY(coordenadasY);
		sc.close();
		return montaña;
	}
	
	public void escribirArchivo(int x, int y, String miPath) throws IOException{
	
	  PrintWriter escritura = new PrintWriter(new FileWriter(miPath));
	  
	  escritura.print(x);
	  escritura.println(y);
	  escritura.close();
	}
}
