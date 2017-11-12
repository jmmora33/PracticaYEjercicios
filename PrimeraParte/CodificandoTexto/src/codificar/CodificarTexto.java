package codificar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CodificarTexto extends EjercicioOIA {

	public CodificarTexto(File entrada, File salida) {
		super(entrada, salida);
	}

	public static void main(String[] args) throws FileNotFoundException {
		CodificarTexto codificarTexto = new CodificarTexto(new File("codificar.in"),new File("codificar.out"));
		codificarTexto.resolver();
	}

	@Override
	public void resolver(){
	try {
		Scanner sc = new Scanner (entrada);
		PrintWriter arcSalida = new PrintWriter (salida);
		StringBuffer resultado = new StringBuffer();
		int cantidadDeDigitos = sc.nextInt();
		String digitos = sc.next();
		int tamañoPalabra = sc.nextInt();
		String mensaje;
		String abcdario = "abcdefghijklmnopqrstuvwxyz";
		
		sc.nextLine();//Limpio para ir a la siguiente linea
		mensaje = sc.nextLine();
		
		for (int i = 0, j = 0; i < tamañoPalabra; i++) {
			if(mensaje.charAt(i) != ' ') {
				int desplazamiento = digitos.charAt(j%cantidadDeDigitos)-'0';
				int valor = mensaje.charAt(i)%'a';
				resultado.append(abcdario.charAt((valor +desplazamiento) % 26));
				j++;
			}
		}
		System.out.println(resultado);
		sc.close();
		arcSalida.close();
	}
    catch (Exception e){
    		e.getStackTrace();
    		e.printStackTrace();
    	}
	}
}