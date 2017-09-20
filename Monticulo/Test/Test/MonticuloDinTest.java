package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import monticulo.ColaPrioridad;
import monticulo.Monticulo;
import monticulo.MonticuloDin;
import monticulo.Nodo;

public class MonticuloDinTest {

	@Test
	public void queCreeUnNodo() {
		
		Nodo nodo = new Nodo();
		
		assertTrue(nodo.getPrioridad() == 100);
	}
	
	public void queCreeUnaCola() {
		
		ColaPrioridad cola = new ColaPrioridad();
		assertTrue(cola.getMonticulo().getArbol().size() == 0 && cola.getMonticulo().getTope() == 0);
	}

	@Test
	public void testSacar() {
	}

	@Test
	public void testAgregar() {
         MonticuloDin monticulo = new MonticuloDin();
         monticulo.agregar(new Nodo(5,3));
         monticulo.agregar(new Nodo(3,3));
         monticulo.agregar(new Nodo(1,3));
         assertTrue(monticulo.getArbol().size() != 0);
         System.err.println(monticulo.getArbol().get(0));
	}
}