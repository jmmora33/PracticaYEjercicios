import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import montaña.Archivo;
import montaña.Montaña;

public class MontañaTest {
	Archivo archivo;
	Montaña montaña;
	String miPathEntrada = "Archivo.in";
	@Before
	public void setUp(){
		archivo = new Archivo();
		montaña = new Montaña();
	}
	
	
	@Test
	public void queLeaBienElArchivo() throws FileNotFoundException{
		montaña = archivo.leerArchivo(miPathEntrada);
		
		Assert.assertEquals(montaña.mover(),167);
		
	}
}
