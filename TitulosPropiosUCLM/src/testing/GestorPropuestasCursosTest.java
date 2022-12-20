package testing;


import org.junit.*;

import presentacion.MainTesting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorPropuestasCursosTest {
	
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
	public void realizarPropuestaCurso(){
		String nombre ="ADE";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		int eCTS=-14;
		double tasaMatricula = -23.7;
		int edicion = -8;
		String dniDirector="01234567A";
		String dniSecretario="31456173G";
		String centro="UCLM";
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
		
		assertFalse( !((nombre.equals("")) ||
				(tasaMatricula<0) ||
				(edicion<0) ||
				(eCTS<0) ||
				(dniDirector.equals("") || dniDirector.length()>9) ||
				(dniSecretario.equals("") || dniSecretario.length()>9 ) ||
				(centro.equals("")) ||
				(Integer.parseInt(anioInicio)> Integer.parseInt(anioActual)) ||
				(Integer.parseInt(anioFin)< Integer.parseInt(anioActual)) ||
				(Integer.parseInt(mesInicio) == 6) || (Integer.parseInt(mesInicio)) == 7 || 
				(Integer.parseInt(mesFin) == 6) || (Integer.parseInt(mesFin) == 7)) );
		
	}
	
	@Test
	public void realizarPropuestaCurso2(){
		String nombre ="ADE";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		double tasaMatricula =200;
		int edicion =12;
		int eCTS=12;
		String dniDirector="01234567A";
		String dniSecretario="31456173G";
		String centro="UCLM";
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
		
		assertTrue( !((nombre.equals("")) ||
				(tasaMatricula<0) ||
				(edicion<0) ||
				(eCTS<0) ||
				(dniDirector.equals("") || dniDirector.length()>9) ||
				(dniSecretario.equals("") || dniSecretario.length()>9 ) ||
				(centro.equals("")) ||
				(Integer.parseInt(anioInicio)> Integer.parseInt(anioActual)) ||
				(Integer.parseInt(anioFin)> Integer.parseInt(anioActual)) ||
				(Integer.parseInt(mesInicio) == 6) || (Integer.parseInt(mesInicio)) == 7 || 
				(Integer.parseInt(mesFin) == 6) || (Integer.parseInt(mesFin) == 7)) );
		
	}
	
}
