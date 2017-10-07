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
		int volumenTotal = 0;
		/* CANTIDAD DE DEPOSITOS EXISTENTES */
		int cantidadDeDepositos = sc.nextInt();
		/* VARIABLE QUE VA A CONTENER A LOS DEPOSITOS */
		Deposito deposito;
		/* LISTA DE DE DEPOSITOS */
		ArrayList<Deposito> depositos = new ArrayList<Deposito>();
		/* VOLUMEN TOTAL EN LOS DEPOSITOS */
		int volumenDepositos = 0;

		/* CARGA DE DEPOSITOS */
		for (int i = 0; i < cantidadDeDepositos; i++) {
			deposito = new Deposito();
			deposito.setSuperficie(sc.nextInt());
			deposito.setAltura(sc.nextInt());
			depositos.add(deposito);
		}

		volumenTotal = sc.nextInt();
		/* SE CIERRA EL SCANNER */
		sc.close();

		/* SE CONOCE EL VOLUMEN TOTAL */
		for (Deposito deposito2 : depositos)
			volumenDepositos += deposito2.getVolumen();

		/* SI EL VOLUMEN TOTAL ES MAYOR A TODOS LOS DEPOSITOS->REBALSA */
		if (volumenTotal > volumenDepositos) {
			volumenTotal -= volumenDepositos;
			salida.println("Rebalsa:" + volumenTotal);
			salida.close();
		} else {
			int index = 0;
			int j = 0;
			int cantDepositosIguales = 0; // CAntidad de repeticiones y no de depositos
			int alturaRel = 0;
			int sumaSup = 0;
			int sumaVol = 0;
			int alturaSobrante = depositos.get(0).getAltura();
			
			while (volumenTotal > 0 && index < cantidadDeDepositos) {
				if (index + 1 < cantidadDeDepositos
						&& depositos.get(index).getAltura() != depositos.get(index + 1).getAltura()) {
					alturaRel = depositos.get(index).getAltura() - depositos.get(index + 1).getAltura();
					for (int i = 0; j <= index; i++) 
						volumenTotal -= depositos.get(j).getVolumen(alturaRel);
			
					alturaSobrante -= alturaRel;
					index++;
				} else {
					while (index + cantDepositosIguales + 1 < cantidadDeDepositos
							&& depositos.get(index + cantDepositosIguales).getAltura() == depositos
									.get(index + cantDepositosIguales + 1).getAltura())
						cantDepositosIguales++;

					if (index + cantDepositosIguales + 1 >= cantidadDeDepositos) {
						while (index < cantidadDeDepositos) {
							sumaSup = depositos.get(index).getSuperficie();
							index++;
						}

						volumenTotal -= sumaSup * depositos.get(index - 1).getAltura();
						alturaSobrante -= depositos.get(index - 1).getAltura();
					} else {
						alturaRel = depositos.get(index).getAltura()
								- depositos.get(index + cantDepositosIguales + 1).getAltura();
						while (index < cantidadDeDepositos) {
							sumaVol += depositos.get(index).getSuperficie() * alturaRel;
							index++;

							alturaSobrante -= alturaRel;
						}

						volumenTotal -= sumaVol;
					}
				}

			}
			salida.println(index);
			salida.println(alturaSobrante);
		}
		salida.close();
	}

}
