package pelicula;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Grafo implements Cloneable{

	private static final int INF = 100000;
	public static final int ESCENAINI = 1;
	private int[][] matAdy;
	private Segmento[] segmentos;
	private int cantSegmentos;
	private int escenaFinal;
	private Scanner sc;

	public Grafo(String archivo) {
		Segmento segmento = new Segmento();
		try {
			sc = new Scanner(new File(archivo));

			cantSegmentos = sc.nextInt();
			escenaFinal = sc.nextInt();
			matAdy = new int[cantSegmentos][cantSegmentos];
			segmentos = new Segmento[cantSegmentos];
			iniciarMatAdy();
			for (int i = 0; i < cantSegmentos; i++) {
				segmento.setNumero(sc.nextInt());
				segmento.setEscenaIni(sc.nextInt());
				segmento.setEscenaFin(sc.nextInt());
				segmentos[i] = new Segmento(segmento);

			}
			calcularCosto();
			System.out.println("PEPE");
		} catch (IOException e) {
			System.err.println("La culpa es del dolape del frente");
			e.printStackTrace();
		}
	}

	public void calcularCosto() {

		for (int i = 0; i < segmentos.length; i++) {
			int costo;

			for (int k = i+1; k < segmentos.length; k++) {
				costo = segmentos[i].getEscenaFin() - segmentos[k].getEscenaIni();
				if (costo >= 0) {
					matAdy[i][k] = costo;
					matAdy[k][i] = costo;
				}
					
			}

		}
	}

	public void iniciarMatAdy() {
		for (int i = 0; i < matAdy.length; i++)
			for (int j = 0; j < matAdy.length; j++)
				if (i == j)
					matAdy[i][j] = 0;
				else
					matAdy[i][j] = INF;
	}


	@Override
	   public Grafo clone(){
	        Grafo obj=null;
	        try{
	            obj= (Grafo)super.clone();
	        }catch(CloneNotSupportedException ex){
	            System.out.println(" no se puede duplicar");
	        }
	        return obj;
	    }

	public int[][] getMatAdy() {
		return matAdy;
	}

	public void setMatAdy(int[][] matAdy) {
		this.matAdy = matAdy;
	}

	public Segmento[] getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(Segmento[] segmentos) {
		this.segmentos = segmentos;
	}

	public int getCantSegmentos() {
		return cantSegmentos;
	}

	public void setCantSegmentos(int cantSegmentos) {
		this.cantSegmentos = cantSegmentos;
	}

	public int getEscenaFinal() {
		return escenaFinal;
	}

	public void setEscenaFinal(int escenaFinal) {
		this.escenaFinal = escenaFinal;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public static int getInf() {
		return INF;
	}

	public Grafo(int[][] matAdy, Segmento[] segmentos, int cantSegmentos, int escenaFinal) {
		super();
		this.matAdy = matAdy;
		this.segmentos = segmentos;
		this.cantSegmentos = cantSegmentos;
		this.escenaFinal = escenaFinal;
	}
	
	
	
}
