package testing;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.*;

import presentacion.MainTesting;

public class GestorProfesorTest {

	@BeforeClass
	public static void setUpBeforeClass(){
		MainTesting.escribirLog("Errores.log", "@BeforeClass");		
	}

	@AfterClass
	public static void tearDownAfterClass()  {
		MainTesting.escribirLog("Errores.log", "@AfterClass");		
	}

	@Before
	public void setUp() {
		MainTesting.escribirLog("Errores.log", "@Before -> How many times do i appear?");
	}

	@After
	public void tearDown()  {
		MainTesting.escribirLog("Errores.log", "@After -> How many times do i appear?");	
	}
	
	
	@Test
	public void seleccionarProfesor() {
		String dni="";
		assertFalse(! (dni.equals("") || dni.length()>9 ) );
	}
	@Test
	public void seleccionarProfesor2() {
		String dni="12345678A";
		assertTrue(! (dni.equals("") || dni.length()>9 ) );
	}
	
}
