package vectorMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrizMath {
	
	private double [][] mat;
	
	public MatrizMath(String path) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(path));
		mat = new double[sc.nextInt()][sc.nextInt()];
	}
	
	public MatrizMath(int f,int c) {
		mat = new double[f][c];
	}

	public MatrizMath ProductoMatricial(MatrizMath mat1)
	{
		MatrizMath mat2 = new MatrizMath(mat[0].length,mat.length);
		
	
		return mat2;
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
