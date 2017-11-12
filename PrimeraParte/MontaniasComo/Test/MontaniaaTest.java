

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import montania.Archivo;
import montania.Montania;

public class MontaniaaTest {
	Archivo archivo;
	Montania montania;
	
	@Before
	public void setUp(){
		archivo = new Archivo();
		montania = new Montania();
	}
	
	
	@Test
	public void queSeMuevaDeFormaCorrecta() throws FileNotFoundException{
		montania = archivo.leerArchivo("Archivo.in");
		
		Assert.assertEquals(montania.mover(),167);
		
	}
	
	@Test
	public void queLeaCorrectamenteElArchivo() throws FileNotFoundException{
		
		montania = archivo.leerArchivo(".\\Entradas\\01_QueleaBienArchivo.in");

		Assert.assertEquals(montania.mover() ,97);
		Assert.assertEquals(montania.getValorYFinal() ,13);
	}
	
 @Test
 public void queNoPaseDosCimasIguales() throws FileNotFoundException {
	 
	montania = archivo.leerArchivo(".\\Entradas\\02_QueNoPaseDosVeces.in"); 
	
	Assert.assertEquals(montania.mover(), 80);
	
 }
}
