package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import monticulo.ColaPrioriGen;
import monticulo.MonticuloGen;
import monticulo.Nodo;
import monticulo.Persona;

public class MonticuloGenTest {

	@Test
	public void queCreeUnNodo() {
		
		Nodo nodo = new Nodo();
		
		assertTrue(nodo.getPrioridad() == 100);
	}
	public void queCreeUnaCola() {
		
		ColaPrioriGen<Nodo> cola = new ColaPrioriGen<Nodo>();
		assertTrue(cola.getMonticulo().getArbol().size() == 0 && cola.getMonticulo().getTope() == 0);
	}

	@Test
	public void testAgregar() {
		//ColaPrioriGen<Nodo> cola = new ColaPrioriGen<Nodo>();
        
		MonticuloGen<Nodo> monticulo = new MonticuloGen<Nodo>();
		MonticuloGen<Persona> monticulo2 = new MonticuloGen<Persona>();
		 monticulo.agregar(new Nodo(5,3));
         monticulo.agregar(new Nodo(3,3));
         monticulo.agregar(new Nodo(1,3));
    	 monticulo2.agregar(new Persona("Juan",33));
         monticulo2.agregar(new Persona("Pedro",55));
         monticulo2.agregar(new Persona("Roman",66));
         assertTrue(monticulo.getArbol().size() != 0);
         System.out.println(monticulo.getArbol().get(0));
         System.out.println(monticulo.getArbol().get(1));
         System.out.println(monticulo.getArbol().get(2));
         System.out.println(monticulo2.getArbol().get(0));
         System.out.println(monticulo2.getArbol().get(1));
         System.out.println(monticulo2.getArbol().get(2));

	
	}
	
	


}
