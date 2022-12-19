package testing;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GestorConsultasTest {

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() {
		System.out.println("@Before -> How many times do i appear?");
	}

	@After
	public void tearDown() {
		System.out.println("@After -> How many times do i appear?");
	}
	@Test
	public void seleccionarCurso() {
		int id = 1;
		assertTrue(id>=0);
	}
	@Test
	public void seleccionarCurso1() {
		int id = -1;
		assertFalse(id>=0);
	}
	@Test
	public void seleccionarCurso2() {
		int id = 0;
		assertTrue(id>=0);
	}
	@Test
	public void cursosPorCentro() {
		int id = 1;
		assertTrue(id>=0);
	}
	@Test
	public void cursosPorCentro1() {
		int id = -1;
		assertFalse(id>=0);
	}
	@Test
	public void cursosPorCentro2() {
		int id = 0;
		assertTrue(id>=0);
	}
	@Test
	public void consultarIngresos() {
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");	     
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
	     int anioInicio = 2023;
	     int anioFin = 2039;
	     int mesInicio = 4;
	     int mesFin = 5;
		assertTrue(anioInicio>= Integer.parseInt(anioActual) && anioFin>= Integer.parseInt(anioActual)
	    		 && mesInicio != 6 && mesInicio != 7 && mesFin != 6 && mesFin != 7 && mesInicio <= 12 && mesFin <= 12);
		
	}
	@Test
	public void consultarIngresos1() {
		 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");	     
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
	     int anioInicio = 2024;
	     int anioFin = 1999;
	     int mesInicio = 6;
	     int mesFin = 11;
		assertFalse(anioInicio>= Integer.parseInt(anioActual) && anioFin>= Integer.parseInt(anioActual)
	    		 && mesInicio != 6 && mesInicio != 7 && mesFin != 6 && mesFin != 7 && mesInicio <= 12 && mesFin <= 12);
		
	}
	@Test
	public void consultarIngresos2() {
	
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");	     
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
	     int anioInicio = 1987;
	     int anioFin = 2023;
	     int mesInicio = 12;
	     int mesFin = 7;
		assertFalse(anioInicio>= Integer.parseInt(anioActual) && anioFin>= Integer.parseInt(anioActual)
	    		 && mesInicio != 6 && mesInicio != 7 && mesFin != 6 && mesFin != 7 && mesInicio <= 12 && mesFin <= 12);
		
}
	@Test
	public void consultarIngresos3() {
	
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");	     
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
	     int anioInicio = 2067;
	     int anioFin = 2024;
	     int mesInicio = 2;
	     int mesFin = 9;
		assertTrue(anioInicio>= Integer.parseInt(anioActual) && anioFin>= Integer.parseInt(anioActual)
	    		 && mesInicio != 6 && mesInicio != 7 && mesFin != 6 && mesFin != 7 && mesInicio <= 12 && mesFin <= 12);
		
}
	@Test
	public void listarCursosEstados() {
		
	}
}
