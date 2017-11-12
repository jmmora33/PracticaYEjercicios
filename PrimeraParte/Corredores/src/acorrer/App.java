package acorrer;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

	
	public static void main(String[] args) throws IOException {
		String archivoEnt = "corredores1.in";
		String archivoSal = "corredores.out";
		
		int cantComp;
		int cantCatF,cantCatM;
		int llegaron;
		
		int [][] podioF;
		int [][] podioM;
		
		Corredor []corredores;
		Categoria [] categoriasF;
		Categoria [] categoriasM;
		
		Scanner sc = new Scanner(new File (archivoEnt));
		PrintWriter salida = new PrintWriter(new FileWriter(archivoSal)); 
		
		cantComp = sc.nextInt();
		cantCatF = sc.nextInt();
		cantCatM = sc.nextInt();
		llegaron = sc.nextInt();
		
		
		categoriasF = new Categoria[cantCatF];
		categoriasM = new Categoria [cantCatM];
		corredores = new Corredor [cantComp];
		
		for (int i = 0; i < categoriasF.length; i++) {
			int id = i+1;
			int edadMin = sc.nextInt();
			int edadMax = sc.nextInt();
			categoriasF[i] = new Categoria (id,edadMin,edadMax);
		}
		
		for (int i = 0; i < categoriasM.length; i++) {
			int id = i+1;
			int edadMin = sc.nextInt();
			int edadMax = sc.nextInt ();
			categoriasM[i] = new Categoria (id,edadMin,edadMax);
		}
		
		for (int i = 0; i < corredores.length; i++) {
			int cat;
			int edad = sc.nextInt();
			String sexo = sc.next();
			if (sexo.equals("F")) {
				for (int j = 0; j < categoriasF.length; j++) {
					if (categoriasF[j].pertenece(edad)) {
						cat = categoriasF[j].getId();
						corredores[i] = new Corredor (edad,sexo,cat);
						break;
					}
				}
			}
			else {
				for (int j = 0; j < categoriasM.length; j++) {
					if (categoriasM[j].pertenece(edad)) {
						cat = categoriasM[j].getId();
						corredores[i] = new Corredor (edad,sexo,cat);
						break;
					}
				}
			}
			
		}
	
		podioF = new int [cantCatF][3];
		podioM = new int [cantCatM][3];
		
	for (int i = 0; i < llegaron; i++) { 
		int persona = sc.nextInt();
		if (corredores[persona-1].getSexo().equals("F")) {
			int cat = corredores[persona-1].getCategoria();
			for (int j = 0; j < 3; j++) {
				if (podioF[cat-1][j]==0) {
					podioF[cat-1][j] = persona;
					break;
				}
			}
		}
		else {
			int cat = corredores[persona-1].getCategoria();
			for (int j = 0; j < 3; j++) {
				if (podioM[cat-1][j]==0) {
					podioM[cat-1][j] = persona;
					break;
				}
			}
		}
		
	}
	sc.close();	
	
	for (int i = 0; i < cantCatF; i++) {
		salida.println(i+1 + "\t" + podioF[i][0] + "\t" + podioF[i][1] + "\t" + podioF[i][2]);
	}
	
	for (int i = 0; i < cantCatM; i++) {
		salida.println(i+1 + "\t" + podioM[i][0] + "\t" + podioM[i][1] + "\t" + podioM[i][2]);
	}
	
	salida.close();
	}
	
}
