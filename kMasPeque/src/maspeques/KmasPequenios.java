package maspeques;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class KmasPequenios {
	
	public static void main(String[] args) throws IOException {
			int cantEnteros;
			int cantPequenios;
			
			TreeSet<Integer> enteros = new TreeSet<Integer>();

			String t="KPeque.in";
            GeneradorDePeques.generarArchivo(t);
			Scanner sc = new Scanner(new File(t));
			cantEnteros=sc.nextInt();
			cantPequenios=sc.nextInt();
			for(int i=0;i<cantEnteros;i++)
				enteros.add(sc.nextInt());		

			sc.close();
			
			PrintWriter s = new PrintWriter(new FileWriter("pequenios.out")); 
			s.println(cantPequenios);
			for(int i=0;i<cantPequenios;i++){
				s.println(enteros.first());	
				enteros.remove(enteros.first());
			}
			s.close();
	}
	
}