package testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public void seleccionarMaterias1() {
		int id=-5;
		assertFalse(id>0);

	}
	public void seleccionarMaterias2() {
		int id=10;
		assertTrue(id>0);

	}
	@Test
	public void realizarMateria() {
		String dniProfesorResponsable="";
		String nombre="";
		double horas=0.00;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		try {
			fechaInicio = format.parse("2002-02-20");
			fechaFin=format.parse("2002-05-20");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		

		
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM");

		String anioInicio = getYearFormat.format(fechaInicio);
		String mesInicio = getMonthFormat.format(fechaInicio);


		String anioFin = getYearFormat.format(fechaFin);
		String mesFin = getMonthFormat.format(fechaFin);

		Date fechaActual = new Date();
		String anioActual = getYearFormat.format(fechaActual);

		assertTrue( !(  (dniProfesorResponsable.equals("") || dniProfesorResponsable.length()>9) ||
				(nombre.equals("")) || 
				(horas<0))  || 
				(Integer.parseInt(anioInicio)< Integer.parseInt(anioActual)) ||
				(Integer.parseInt(anioFin)< Integer.parseInt(anioActual)) ||
				(Integer.parseInt(mesInicio) != 6) || (Integer.parseInt(mesInicio) != 7) ||
				(Integer.parseInt(mesFin) != 6) || Integer.parseInt(mesFin) != 7);
	}


}
