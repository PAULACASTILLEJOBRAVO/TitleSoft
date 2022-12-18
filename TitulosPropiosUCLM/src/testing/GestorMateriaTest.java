package testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.*;

import negocio.entities.CursoPropio;
import negocio.entities.Materia;

public class GestorMateriaTest {

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass()  {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp()  {
		System.out.println("@Before -> How many times do i appear?");
	}

	@After
	public void tearDown(){
		System.out.println("@After -> How many times do i appear?");
	}
	
	
	@Test
	public void seleccionarMaterias() {
		int id=0;
		assertTrue(id>0);
		
	}
	@Test
	public void realizarMateria() {
		String dniProfesorResponsable="";
		String nombre="";
		double horas=0.00;
		Date fechaInicio=new Date(2002-02-20);
		Date fechaFin=new Date(2002-02-20);
		
		
		assertTrue( !(  (dniProfesorResponsable.equals("") || dniProfesorResponsable.length()>9) ||
				(nombre.equals("")) || 
				(horas<0))  );
	}
	
	
}
