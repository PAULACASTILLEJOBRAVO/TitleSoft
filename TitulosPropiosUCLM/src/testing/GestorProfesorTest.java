package testing;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.*;

import presentacion.MainTesting;

public class GestorProfesorTest {

	@BeforeClass
	public static void setUpBeforeClass(){
		MainTesting.escribirLog(MainTesting.ERROR, "@BeforeClass");		
	}

	@AfterClass
	public static void tearDownAfterClass()  {
		MainTesting.escribirLog(MainTesting.ERROR, "@AfterClass");		
	}

	@Before
	public void setUp() {
		MainTesting.escribirLog(MainTesting.ERROR, "@Before -> How many times do i appear?");
	}

	@After
	public void tearDown()  {
		MainTesting.escribirLog(MainTesting.ERROR, "@After -> How many times do i appear?");	
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
