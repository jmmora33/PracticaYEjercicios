package deposito;

import java.util.*;
import java.io.*;

public class APP {

	public static void main(String[] args) throws FileNotFoundException {

		String archivoEntrada = "deposito.in";
		String archivoSalida = "deposito.out";

		/* PARA ARCHIVOS */
		Scanner sc = new Scanner(new File(archivoEntrada));
		PrintWriter salida = new PrintWriter(new File(archivoSalida));
		/* VOLUMEN TOTAL */
		int volumenAIngresar = 0;
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
		/* CARGA DE DEPOSITOS */
		for (int i = 0; i < cantidadDeDepositos; i++) {
			deposito = new Deposito();
			deposito.setSuperficie(sc.nextInt());
			deposito.setAltura(sc.nextInt());
			depositos.add(deposito);
		}
		/* VOLUMEN A INGRESAR A LOS DEPOSITOS */
		volumenAIngresar = sc.nextInt();
		/* ALTURA QUE SOBRA INICIALMENTE */
		alturaSobrante = depositos.get(0).getAltura();
		/** SE INICIALIZA LA MATRIZ CON LOS VALORES **/
		matValores = new int[cantidadDeDepositos][depositos.get(0).getAltura()];
		/** SE INICIALIZA EL VECTOR CANTIDAD POR NIVEL CON LOS VALORES **/
		cantidadPorNivel = new int[depositos.get(0).getAltura()];
		/* SE CIERRA EL SCANNER */
		sc.close();

		/* CARGO LA MATRIZ DE VALORES POR METRO 3 */

		for (int i = 0; i < depositos.size(); i++) {
			int m = 0;
			for (int j = depositos.size() - 1; j >= depositos.size() - depositos.get(i).getAltura(); j--) {
				matValores[i][j] = depositos.get(i).getVolumen(1) * (depositos.get(i).getAltura() - m);
				m++;
			}

		}
		/** CARGO VECTOR CON CANTIDAD DE DEPOSITOS POR NIVEL */

		for (int j = 0; j < cantidadPorNivel.length; j++) {

			while (nivel < depositos.size() && matValores[nivel][j] != 0)
				nivel++;
	
			cantidadPorNivel[j] = nivel;
			nivel = 0;
		}
		/* SI EL VOLUMEN TOTAL ES MAYOR A TODOS LOS DEPOSITOS->REBALSA */
		if (volumenAIngresar > sumoNivel(matValores, depositos.get(0).getAltura()-1)) {
			volumenAIngresar -= sumoNivel(matValores, depositos.get(0).getAltura()-1);
			salida.println("Rebalsa:" + volumenAIngresar );
			salida.close();
		} else {// AQUI VA LO COMENTADO FUERA DE LA CLASE
        
			
			nivel = 0;
			while (nivel < matValores.length && volumenAIngresar > 0 ) {
				volumenAIngresar -= sumoNivel(matValores, nivel);
				alturaSobrante -= 1;
				nivel ++;
			}
            
			salida.println("cantidadDepositosUsado:" + cantidadPorNivel[nivel-1]);
			salida.println("Altura:" + alturaSobrante);
		}

		salida.close();
	}

	public static int sumoNivel(int[][] mat, int nivel) {
		int resultado = 0;
		int i = 0;
		while (i < mat.length && mat[i][nivel] != 0) {
			resultado += mat[i][nivel];
			i++;
		}
		return resultado;
	}

}
/* MIENTRAS EXISTA VOLUMEN Y HAYA DEPOSITOS */
// while (volumenAIngresar > 0 && index < cantidadDeDepositos) {
//
// /*Caso1: Son diferente altura*/
// if (index + 1 < cantidadDeDepositos

// && depositos.get(index).getAltura() != depositos.get(index + 1).getAltura())
// {
// alturaRel = depositos.get(index).getAltura() - depositos.get(index +
// 1).getAltura();
// for (int j = 0; j <= index; j++)
// volumenAIngresar -= depositos.get(j).getVolumen(alturaRel);
// alturaSobrante -= alturaRel;
// index++;
// } else {
// /*Caso2: con alturas iguales*/
// /*Cuento cuantos depos con la misma altura tengo*/
// while (index + cantDepoIgualAltura + 1 < cantidadDeDepositos
// && depositos.get(index + cantDepoIgualAltura).getAltura() == depositos
// .get(index + cantDepoIgualAltura + 1).getAltura())
// cantDepoIgualAltura++;
// /*SI TODOS LOS DEPOSITOS QUE QUEDAN SON IGUALES*/
// if (index + cantDepoIgualAltura + 1 >= cantidadDeDepositos) {
// while (index < cantidadDeDepositos) {
// sumaSup = depositos.get(index).getSuperficie();
// index++;
// }
//
// volumenAIngresar -= sumaSup * depositos.get(index - 1).getAltura();
// alturaSobrante -= depositos.get(index - 1).getAltura();
// } else {
// alturaRel = depositos.get(index).getAltura()
// - depositos.get(index + cantDepoIgualAltura + 1).getAltura();
// for (int i = 0; i <= cantDepoIgualAltura; i++) {
// sumaVol += depositos.get(index).getSuperficie() * alturaRel;
// alturaSobrante -= alturaRel;
// index++;
// }
// volumenAIngresar -= sumaVol;
// }
// }
//
// }