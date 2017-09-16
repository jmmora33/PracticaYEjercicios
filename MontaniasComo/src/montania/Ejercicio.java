package montania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ejercicio {

public static void main(String[] args) throws FileNotFoundException{
	
	Montania montania = new Montania();
	Scanner sc = new Scanner(new File(".\\Entradas\\01_QueleaBienArchivo.in"));
	int[] coordenadasY;
	montania.setCantCambios(sc.nextInt());
	coordenadasY = new int[montania.getCantCambios()+1];
	
	for (int i = 0; i < coordenadasY.length; i++) 
		coordenadasY[i] = sc.nextInt();
	montania.setCapacidadCarro(coordenadasY[0] -10);
	montania.setCoordenadasY(coordenadasY);
	sc.close();
	
	System.out.println(montania.mover() +" "+ montania.getValorYFinal());
}


	

}
