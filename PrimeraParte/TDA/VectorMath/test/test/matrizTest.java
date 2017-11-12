package test;

import static org.junit.Assert.*;

import org.junit.Test;

import vectorMath.MatrizMath;

public class matrizTest {

	@Test
	public void multiplicarMatrizTest() {
		MatrizMath mat1 = new MatrizMath(2, 2);
		MatrizMath mat2 = new MatrizMath(2,1);
		
		mat1.setearValor(0,0, 1);
		mat1.setearValor(0,1, 2);
		mat1.setearValor(1,0, 3);
		mat1.setearValor(1,1, 4);
		
		mat2.setearValor(0, 0, 1);
		mat2.setearValor(1, 0, 2);
		
		MatrizMath resultado = mat1.ProductoMatricial(mat2);
		
		resultado.mostrarMat();
		
	}

}
