

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import montaña.Archivo;
import montaña.Montaña;

public class MontañaTest {
	Archivo archivo;
	Montaña montaña;
	
	@Before
	public void setUp(){
		archivo = new Archivo();
		montaña = new Montaña();
	}
	
	
	@Test
	public void queSeMuevaDeFormaCorrecta() throws FileNotFoundException{
		montaña = archivo.leerArchivo("Archivo.in");
		
		Assert.assertEquals(montaña.mover(),167);
		
	}
	
	@Test
	public void queLeaCorrectamenteElArchivo() throws FileNotFoundException{
		
		montaña = archivo.leerArchivo(".\\Entradas\\01_QueleaBienArchivo.in");

		Assert.assertEquals(montaña.mover() ,97);
	}
}
