package vectorMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrizMath {
	
	private double [][] mat;
	private Scanner sc;
	
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

	public double obtenerValor(int numFila, int numCol) {
		return this.getMat()[numFila-1][numCol-1];
	}
	
	public void setearValor(int numFila, int numCol, double valor) {
		this.mat[numFila -1][numCol -1] = valor;
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
	
   public int getDimensionFila()
   {
	   return this.mat[0].length;
	   
   }
   
   public int getDimensionColumna()
   {
	   return this.mat.length;
   }
}
