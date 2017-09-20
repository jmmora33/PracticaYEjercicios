import static org.junit.Assert.assertTrue;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Before;
import org.junit.Test;

import figura.Circulo;
import figura.Punto;
import figura.Rectangulo;
import figura.Triangulo;

public class testCirculo {

	Circulo circulo1, circulo2, circulo3;
	Rectangulo rectangulo1, rectangulo2, rectangulo3;
	Punto p2, p1;
	
	@Before
	public void before() {
		circulo1 = new Circulo(5,4,1);
		circulo2 = new Circulo(2,2,2);
		circulo3 = new Circulo(7,7,2);
		p1 = new Punto(1,0);
		p2 = new Punto(4,4);
		rectangulo1 = new Rectangulo(p1,p2);
		p1 = new Punto(3,7);
		p2 = new Punto(7,2);
		rectangulo2 = new Rectangulo(p1,p2);
		p1 = new Punto(0,20);
		p2 = new Punto(20,0);
		rectangulo3 = new Rectangulo(p1, p2);
	}
	@Test
	public void queEncuentreLaFiguraQueQuiereIntersectar() throws InvalidAttributesException{
		
	Triangulo triangulo = new Triangulo();
	
	 circulo1.intersectaCon(triangulo);
	
	}
	@Test
	public void circuloTest() {
		
	}
	@Test
	public void intersectaTest() {
		assertTrue(!circulo1.intersectaCon(circulo2));
		assertTrue(rectangulo1.intersectaCon(rectangulo2));
	}
	 @Test
	public void rectanguloTest() {
		Rectangulo otroRectangulo = new Rectangulo(new Punto(6,-6), new Punto(4,2));
		assertTrue(otroRectangulo.intersectaCon(rectangulo2));
		System.out.println(otroRectangulo.getV1());
	}
	
	 @Test 
	 public void queDetecteInterseccionConFigura() {
		 assertTrue(circulo1.intersectaCon(rectangulo1));
		 assertTrue(circulo2.intersectaCon(rectangulo2));
		 assertTrue(circulo3.intersectaCon(rectangulo3));
	 }
//	
	
}
