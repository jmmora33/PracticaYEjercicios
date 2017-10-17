package vectorMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrizMath {
	


	public double obtenerValor(int numFila, int numCol) {
		return this.getMat()[numFila ][numCol ];
	}
	
	public void setearValor(int numFila, int numCol, double valor) {
		this.mat[numFila ][numCol ] = valor;
	}
	
	public VectorMath obtenerFila(int index) {
		VectorMath resultado = new VectorMath(this.getDimensionColumna());
		resultado.setVec(this.getMat()[index]);
		return resultado;
	}
	
	public MatrizMath ProductoMatricial(MatrizMath mat1){
		MatrizMath resultado = new MatrizMath(this.getDimensionFila(), mat1.getDimensionColumna());
		
		for (int i = 0; i < resultado.getDimensionFila(); i++) {
			for (int j = 0; j < resultado.getDimensionColumna(); j++) {
				double acumulador = 0;
				for(int ciclo = 0; ciclo <resultado.getDimensionColumna(); ciclo ++)
					 acumulador += this.obtenerValor(j, ciclo) * mat1.obtenerValor(ciclo, j);
					resultado.setearValor(i, j, acumulador);
				
			}
		}
	
		return resultado;
	}
	///TESTEAR
	 public static MatrizMath traspuesta(MatrizMath matriz){
	        MatrizMath resultado=new MatrizMath(matriz.getDimensionColumna(),matriz.getDimensionFila());
	        for(int i = 0; i< matriz.getDimensionFila(); i++){
	            for(int j=0; j < matriz.getDimensionColumna(); j++){
	                resultado.setearValor(i, j,  matriz.getMat()[j][i]);
	            }
	        }
	        return resultado;
	    }
	///Testear
	//Se denomina traza a la suma de los elementos de su diagonal principal.
	public double traza(){
	        double tr=0.0;
	        if(this.getDimensionFila() == this.getDimensionColumna())
	        for(int i=0; i < this.getDimensionFila(); i++){
	            tr += this.getMat()[i][i];
	        }
	        return tr;
	    }
	
   public int getDimensionFila()
   {
	   return this.mat[0].length;
	   
   }
   
   public int getDimensionColumna()
   {
	   return this.mat.length;
   }
	
   
   public void mostrarMat() {
	   for (int i = 0; i < mat.length; i++) 
		for (int j = 0; j < mat.length; j++) 
			System.out.print(this.mat[i][j]);
	 System.out.println();
   }
	public MatrizMath(String path) throws FileNotFoundException
	{
	    this.sc = new Scanner(new File(path));
		mat = new double[sc.nextInt()][sc.nextInt()];
	}
	
	public MatrizMath(int f,int c) {
		mat = new double[f][c];
	}
   
	
	
	public double[][] getMat() {
		return mat;
	}

	public void setMat(double[][] mat) {
		this.mat = mat;
	}

	private double [][] mat;
	private Scanner sc;

}
