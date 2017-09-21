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
	public void testAgregar() {
         MonticuloDin monticulo = new MonticuloDin();
         monticulo.agregar(new Nodo(5,3));
         monticulo.agregar(new Nodo(3,3));
         monticulo.agregar(new Nodo(1,3));
         assertTrue(monticulo.getArbol().size() != 0);
         System.out.println(monticulo.getArbol().get(0));
         System.out.println(monticulo.getArbol().get(1));
         System.out.println(monticulo.getArbol().get(2));
	}
	
	@Test
	public void testSacar() {
		  MonticuloDin monticulo = new MonticuloDin();
		  Nodo nodo1 = new Nodo(1,3);
		  Nodo nodo2 = new Nodo(3,3);
		  Nodo nodo3 = new Nodo(5,3);
	         monticulo.agregar(nodo3);
	         monticulo.agregar(nodo2);
	         monticulo.agregar(nodo1);
	        
	         System.out.println(monticulo.getArbol().get(0));
	         System.out.println(monticulo.getArbol().get(1));
	         System.out.println(monticulo.getArbol().get(2));
	         monticulo.sacar();
	         monticulo.sacar();
	         
	         assertTrue( monticulo.sacar()== nodo3);
	}
	
	@Test
	public void testAgregarCola() {
         ColaPrioridad cp = new ColaPrioridad();
         cp.insertar(new Nodo(5,3));
         cp.insertar(new Nodo(3,3));
         cp.insertar(new Nodo(1,3));
         assertTrue(cp.getMonticulo().getArbol().size() != 0);
         System.out.println(cp.getMonticulo().getArbol().get(0));
         System.out.println(cp.getMonticulo().getArbol().get(1));
         System.out.println(cp.getMonticulo().getArbol().get(2));
	}
	


}