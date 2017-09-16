import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import figura.Circulo;
import figura.Punto;
import figura.Rectangulo;

public class testCirculo {

	Circulo circulo1, circulo2;
	Rectangulo rectangulo1, rectangulo2;
	Punto p2, p1;
	
	@Before
	public void before() {
		circulo1 = new Circulo(1,1,1);
		circulo2 = new Circulo(2,2,2);
		p1 = new Punto(2,3);
		p2 = new Punto(5,1);
		rectangulo1 = new Rectangulo(p1,p2);
		p1 = new Punto(3,7);
		p2 = new Punto(7,2);
		rectangulo2 = new Rectangulo(p1,p2);
	}
	
	@Test
	public void circuloTest() {
		
	}
	@Test
	public void intersectaConTest() {
		assertTrue(circulo1.intersectaCon(circulo2));
		assertTrue(rectangulo1.intersectaCon(rectangulo2));
	}
	 @Test
	public void rectanguloTest() {
		
	}
	
	
	
}
