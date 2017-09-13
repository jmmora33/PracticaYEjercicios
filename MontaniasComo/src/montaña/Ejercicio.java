package montaña;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ejercicio {

public static void main(String[] args) throws FileNotFoundException{
	
	Montaña montaña = new Montaña();
	Scanner sc = new Scanner(new File("Archivo.in"));
	int[] coordenadasY;
	montaña.setCantCambios(sc.nextInt());
	coordenadasY = new int[montaña.getCantCambios()];
	
	for (int i = 0; i < coordenadasY.length; i++) 
		coordenadasY[i] = sc.nextInt();
	montaña.setCapacidadCarro(coordenadasY[0] -10);
	montaña.setCoordenadasY(coordenadasY);
	sc.close();
	
	System.out.println(montaña.mover() +" "+ montaña.getCapacidadCarro());
}


	
}
