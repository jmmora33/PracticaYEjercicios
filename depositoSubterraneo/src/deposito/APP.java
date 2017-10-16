package deposito;

import java.util.*;
import java.io.*;

/***COMPLEJIDAD DEL ALGORITMO O(N2)**/
public class APP {

	public static void main(String[] args) throws FileNotFoundException {

		String archivoEntrada = "deposito.in";
		String archivoSalida = "deposito.out";

		/* PARA ARCHIVOS */
		Scanner sc = new Scanner(new File(archivoEntrada));
		PrintWriter salida = new PrintWriter(new File(archivoSalida));
		/* VOLUMEN TOTAL Y EL RESTO */
		int volumenAIngresar = 0;
		int volumenRestante;
		/* CANTIDAD DE DEPOSITOS EXISTENTES */
		int cantidadDeDepositos = sc.nextInt();
		/* VARIABLE QUE VA A CONTENER A LOS DEPOSITOS */
		Deposito deposito;
		/* LISTA DE DE DEPOSITOS */
		ArrayList<Deposito> depositos = new ArrayList<Deposito>();
		/* PROG DIN */
		int[][] matValores;
		int[] cantidadPorNivel;
		/* INDICES */
		int nivel = 0;
		int alturaSobrante = 0;
		
		long time = System.currentTimeMillis();
		/* CARGA DE DEPOSITOS O(N) */
		for (int i = 0; i < cantidadDeDepositos; i++) {
			deposito = new Deposito();
			deposito.setSuperficie(sc.nextInt());
			deposito.setAltura(sc.nextInt());
			depositos.add(deposito);
		}
		/* VOLUMEN A INGRESAR A LOS DEPOSITOS O(1)*/
		volumenAIngresar = sc.nextInt();
		/* ALTURA QUE SOBRA INICIALMENTE  O(1)*/
		alturaSobrante = depositos.get(0).getAltura();
		/** SE INICIALIZA LA MATRIZ CON LOS VALORES  O(1)**/
		matValores = new int[cantidadDeDepositos][depositos.get(0).getAltura()];
		/** SE INICIALIZA EL VECTOR CANTIDAD POR NIVEL CON LOS VALORES  O(1)**/
		cantidadPorNivel = new int[depositos.get(0).getAltura()];
		/* SE CIERRA EL SCANNER */
		sc.close();

		/* CARGO LA MATRIZ DE VALORES POR METRO 3  O(N2)*/

		for (int i = 0; i < depositos.size(); i++) {
			int m = 0;
			for (int j = matValores[i].length -1 ; j >= (matValores[i].length - depositos.get(i).getAltura()) ; j--) {
				matValores[i][j] = depositos.get(i).getVolumen(1)* (depositos.get(i).getAltura() - m);
				m++;
			}

		}
		
		/** CARGO VECTOR CON CANTIDAD DE DEPOSITOS POR NIVEL  O(N2)*/

		for (int j = 0; j < cantidadPorNivel.length; j++) {
			while (nivel < depositos.size() && matValores[nivel][j] != 0)
				nivel++;
	
			cantidadPorNivel[j] = nivel;
			nivel = 0;
		}
		
		/* SI EL VOLUMEN TOTAL ES MAYOR A TODOS LOS DEPOSITOS->REBALSA  O(1)*/
		if (volumenAIngresar > sumoNivel(matValores, depositos.get(0).getAltura()-1)) {
			volumenAIngresar -= sumoNivel(matValores, depositos.get(0).getAltura()-1);
			salida.println("Rebalsa:" + volumenAIngresar );
			salida.close();
		} else {// AQUI VA LO COMENTADO FUERA DE LA CLASE
        
			
			nivel = 0;
			volumenRestante = volumenAIngresar;
			while (nivel < matValores.length && volumenRestante > 0 ) {
				volumenRestante = volumenAIngresar - sumoNivel(matValores, nivel);
				alturaSobrante -= 1;
				nivel ++;
			}// O(N)
            if(nivel == 0){ // O(1)
            	salida.println("No se usaron Depositos");
    			salida.println("Altura:" + alturaSobrante);
            }else{// O(1)
            	salida.println("cantidadDepositosUsado:" + cantidadPorNivel[nivel-1]);
    			salida.println("Altura:" + alturaSobrante);
            }
			
		}

		salida.close();
		long end = System.currentTimeMillis() - time;
		
		System.out.println(end);
	}

	public static int sumoNivel(int[][] mat, int nivel) {
		int resultado = 0;
		int i = 0;
		while (i < mat.length && mat[i][nivel] != 0) {
			resultado += mat[i][nivel];
			i++;
		}// O(N)
		return resultado;
	}

}
