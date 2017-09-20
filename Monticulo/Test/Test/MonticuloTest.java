package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import monticulo.Monticulo;

public class MonticuloTest {
/*
	@Test
	public void testSacar() {
		int[] vector ={0,15,9,8,4,6,1};
		Monticulo monticulo = new Monticulo(vector);
		assertEquals(monticulo.sacar(), 15);
	}*/

	@Test
	public void testAgregar() {
		int[] vector ={0,15,9,8,4,6,1};
		Monticulo monticulo = new Monticulo(vector);
		monticulo.sacar();
		assertEquals(monticulo.agregar(10), true);
		for(int i = 1 ; i <= monticulo.getTope(); i++)
			System.out.println(monticulo.getVector()[i]);
	}
}
