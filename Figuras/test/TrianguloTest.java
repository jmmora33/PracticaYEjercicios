import static org.junit.Assert.*;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Test;

import figura.Punto;
import figura.Rectangulo;
import figura.Triangulo;

public class TrianguloTest {

	@Test
	public void queInterpreteInterseccion() throws InvalidAttributesException{
	
		Triangulo abc = new Triangulo(new Punto(1,5), new Punto(0,2), new Punto(0,8));
		Triangulo def = new Triangulo(new Punto(5,1), new Punto(2,0), new Punto(8,0));
	
		assertTrue(abc.intersectaCon(def));
	}
	
	@Test
	public void queAgregueAlArray() throws InvalidAttributesException{
		Triangulo abc = new Triangulo(new Punto(1,5), new Punto(0,2), new Punto(0,8));
		Triangulo def = new Triangulo(new Punto(5,1), new Punto(2,0), new Punto(8,0));
		abc.agruparFigura(def);
		
		assertTrue(abc.getFiguras().size() != 0);
	}
	
	@Test
	public void queCalculeArea() throws InvalidAttributesException{
		Triangulo abc = new Triangulo(new Punto(1,1), new Punto(2,2), new Punto(1,2));
		
		
		assertTrue(abc.area() == 0.5);
	}
	@Test
	public void queEvalueInterseccionConRect() throws InvalidAttributesException{
		Triangulo abc = new Triangulo(new Punto(1,5), new Punto(0,2), new Punto(0,8));
		Rectangulo def = new Rectangulo(new Punto(0,2), new Punto(2,0));
		
		assertTrue(abc.intersectaCon(def));
	}
	@Test
	public void queCalculePerimetro() throws InvalidAttributesException{
		Triangulo abc = new Triangulo(new Punto(1,1), new Punto(2,2), new Punto(0,2));
		
		System.out.println(abc.perimetro());
		//assertTrue(abc.perimetro() == 3);
	}
}

