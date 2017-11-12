package torneo;

import java.io.IOException;

public class Ejercicio {

	public static void main(String[] args) throws IOException {
	Archivo archivo= new Archivo ();
	Torneo torneo = archivo.leerArchivo("sumo6.in");
	archivo.EscribirArchivo(torneo,torneo.resolverTorneo(),"salida6.out");
	
	}

}
