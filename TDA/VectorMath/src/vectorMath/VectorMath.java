package vectorMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VectorMath {
	
	
	private double [] vec;
	private Scanner sc;
	
	
	
	public double[] getVec() {
		return vec;
	}

	public void setVec(double[] vec) {
		this.vec = vec;
	}

	public VectorMath(String path) throws FileNotFoundException
	{
		sc = new Scanner(new File(path));
		vec = new double[sc.nextInt()];
		// SI las componentes vienen cargadas en el archivo
		/*for (int i = 0; sc.hasNextInt(); i++) 
			this.getVec()[i] = sc.nextInt();*/
		
	}
	
	public VectorMath(int dim) {
		vec = new double[dim];	
	}

	public VectorMath Sumar(VectorMath vec1) throws DistDimException
	{
		VectorMath vec2 = new VectorMath(vec.length);
		if(this.vec.length!=vec1.vec.length){
			throw new DistDimException(" Distinta Dimension ");
		}
		for (int i = 0; i < vec.length; i++) {
			vec2.vec[i] = vec[i] + vec1.vec[i];
		}
		
		return vec2;
	}

	public double Producto(VectorMath vec1)
	{
		double result=0;
		for (int i=0;i<this.vec.length;i++){
			result+=this.vec[i]*vec1.vec[i];
		}
		return result;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	}
	
	public int getDimension()
	{
		return this.vec.length;
	}
	public double Modulo(){
		double aux=0;
		for (int i = 0; i < vec.length; i++) {
			aux+=Math.pow(vec[i],2);
		}
		Math.sqrt(aux);
		return aux;
	}
	
	public VectorMath multiplicarConMatriz(MatrizMath matriz)
	{
		VectorMath resultado;

		if(this.getDimension()!= matriz.getDimensionColumna()) // VER TEORIA
			throw new DistDimException("Error en las dimensiones");
		
		/*Obtengo la fila i de la matriz y luego acumulo las multiplicaciones entre vectores. 
		 Eso se acumulara en las  posiciones i del vector.*/
		resultado = new VectorMath(matriz.getDimensionFila()); 
		for (int i = 0; i < matriz.getDimensionColumna(); i++) { 
			VectorMath aux = matriz.obtenerFila(i);
			for (int j = 0; j < vec.length; j++) 
				resultado.getVec()[i]	+= aux.getVec()[j]*this.getVec()[j]; 
 
 		}
		
		return resultado;
	}
	
}
