package testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

import negocio.entities.CursoPropio;
import negocio.entities.Materia;
import presentacion.MainTesting;

public class GestorMateriaTest {

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
		String dniProfesorResponsable="12345678C";
		String nombre="Hola";
		double horas=12.4;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		try {
			fechaInicio = format.parse("2002-02-20");
			fechaFin=format.parse("2003-05-12");
		} catch (Exception e) {
			MainTesting.escribirLog("Errores.log", "Error en la creacion de las fechas para los test ");	
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
				(Integer.parseInt(anioInicio)> Integer.parseInt(anioActual)) ||
				(Integer.parseInt(anioFin)> Integer.parseInt(anioActual)) ||
				(Integer.parseInt(mesInicio) == 6) || (Integer.parseInt(mesInicio) == 7) ||
				(Integer.parseInt(mesFin) == 6) || Integer.parseInt(mesFin) == 7);
	}
	@Test
	public void realizarMateria2() {
		String dniProfesorResponsable="12345678C";
		String nombre="Hola";
		double horas=-12.4;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		try {
			fechaInicio = format.parse("2002-02-20");
			fechaFin=format.parse("2003-05-12");
		} catch (Exception e) {
			MainTesting.escribirLog("Errores.log", "Error en la creacion de las fechas para los test ");	
		}
		

		
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM");

		String anioInicio = getYearFormat.format(fechaInicio);
		String mesInicio = getMonthFormat.format(fechaInicio);


		String anioFin = getYearFormat.format(fechaFin);
		String mesFin = getMonthFormat.format(fechaFin);

		Date fechaActual = new Date();
		String anioActual = getYearFormat.format(fechaActual);

		assertFalse( !(  (dniProfesorResponsable.equals("") || dniProfesorResponsable.length()>9) ||
				(nombre.equals("")) || 
				(horas<0))  || 
				(Integer.parseInt(anioInicio)> Integer.parseInt(anioActual)) ||
				(Integer.parseInt(anioFin)> Integer.parseInt(anioActual)) ||
				(Integer.parseInt(mesInicio) == 6) || (Integer.parseInt(mesInicio) == 7) ||
				(Integer.parseInt(mesFin) == 6) || Integer.parseInt(mesFin) == 7);
	}


}
