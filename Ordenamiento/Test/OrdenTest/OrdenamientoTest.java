package OrdenTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import orden.Ordenamiento;
import orden.Persona;

public class OrdenamientoTest {

	Ordenamiento<Persona> ordenes;
	Persona[] personas;

	@Before
	public void setUp() {

		personas = new Persona[5];

		personas[0] = new Persona("Juan", 35);
		personas[1] = new Persona("Juan", 22);
		personas[3] = new Persona("Juan", 12);
		personas[2] = new Persona("Juan", 18);
		personas[4] = new Persona("Juan", 10);

		ordenes = new Ordenamiento<Persona>();

	}

	@Test
	public void InsercionTest() {

		long start = System.nanoTime();
		// Persona[] resultado = {new Persona("Juan",10),new
		// Persona("Juan",12),new Persona("Juan",18),new Persona("Juan",22),new
		// Persona("Juan",35)};
		ordenes.insercion(personas);

		long finish = System.nanoTime() - start;
		Assert.assertTrue(personas[0].getEdad() == 10);
		System.out.println("Insercion=" + finish);
	}

	@Test
	public void SeleccionTest() {
		long start = System.nanoTime();
		// Persona[] resultado = {new Persona("Juan",10),new
		// Persona("Juan",12),new Persona("Juan",18),new Persona("Juan",22),new
		// Persona("Juan",35)};
		ordenes.seleccion(personas);

		long finish = System.nanoTime() - start;
		Assert.assertTrue(personas[0].getEdad() == 10);
		System.out.println("Seleccion=" + finish);
	}

	@Test
	public void ShellTest() {
		long start = System.nanoTime();
		// Persona[] resultado = {new Persona("Juan",10),new
		// Persona("Juan",12),new Persona("Juan",18),new Persona("Juan",22),new
		// Persona("Juan",35)};
		ordenes.shell(personas);
		long finish = System.nanoTime() - start;
		Assert.assertTrue(personas[0].getEdad() == 10 && personas[1].getEdad() == 12);
		System.out.println("Shell=" + finish);
	}

	@Test
	public void QuickSortTest() {
		long start = System.nanoTime();
		// Persona[] resultado = {new Persona("Juan",10),new
		// Persona("Juan",12),new Persona("Juan",18),new Persona("Juan",22),new
		// Persona("Juan",35)};
		ordenes.quickSort(personas);
		long finish = System.nanoTime() - start;
		Assert.assertTrue(personas[0].getEdad() == 10 && personas[1].getEdad() == 12);
		System.out.println("QuickSort=" + finish);
	}
}
