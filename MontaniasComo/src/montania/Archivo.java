package montania;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {

	
	public Montania leerArchivo(String miPath) throws FileNotFoundException{
		
		Montania montania = new Montania();
		Scanner sc = new Scanner(new File(miPath));
		int[] coordenadasY;
		montania.setCantCambios(sc.nextInt());
		coordenadasY = new int[montania.getCantCambios()+1];
		
		for (int i = 0; i < coordenadasY.length; i++) 
			coordenadasY[i] = sc.nextInt();
		montania.setCapacidadCarro(coordenadasY[0] -10);
		montania.setCoordenadasY(coordenadasY);
		sc.close();
		return montania;
	}
	
	public void escribirArchivo(int x, int y, String miPath) throws IOException{
	
	  PrintWriter escritura = new PrintWriter(new FileWriter(miPath));
	  
	  escritura.print(x);
	  escritura.println(y);
	  escritura.close();
	}
}
