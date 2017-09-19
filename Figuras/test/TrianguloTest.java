import static org.junit.Assert.*;

import org.junit.Test;

import figura.Punto;
import figura.Triangulo;

public class TrianguloTest {

	@Test
	public void queInterpreteInterseccion(){
	
		Triangulo abc = new Triangulo(new Punto(1,5), new Punto(0,2), new Punto(0,8));
		Triangulo def = new Triangulo(new Punto(5,1), new Punto(2,0), new Punto(8,0));
	
		assertTrue(abc.intersectaCon(def));
	}
	
	@Test
	public void queAgregueAlArray(){
		Triangulo abc = new Triangulo(new Punto(1,5), new Punto(0,2), new Punto(0,8));
		Triangulo def = new Triangulo(new Punto(5,1), new Punto(2,0), new Punto(8,0));
		abc.agruparFigura(def);
		
		assertTrue(abc.getFiguras().size() != 0);
	}
}
