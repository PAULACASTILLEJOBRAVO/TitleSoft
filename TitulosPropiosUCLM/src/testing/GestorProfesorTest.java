package testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

public class GestorProfesorTest {

	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass()  {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() {
		System.out.println("@Before -> How many times do i appear?");
	}

	@After
	public void tearDown()  {
		System.out.println("@After -> How many times do i appear?");
	}
	
	
	@Test
	public void seleccionarProfesor() {
		String dni="";
		assertTrue(! (dni.equals("") || dni.length()>9 ) );
	}
	@Test
	public void seleccionarProfesor2() {
		String dni="123456789A";
		assertTrue(! (dni.equals("") || dni.length()>9 ) );
	}
	
}
