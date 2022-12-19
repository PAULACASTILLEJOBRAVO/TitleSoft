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
	public void seleccionarCurso0() {
		assertTrue(seleccionarCurso(1));
	}
	@Test
	public void seleccionarCurso1() {
		assertFalse(seleccionarCurso(-1));
	}
	@Test
	public void seleccionarCurso2() {
		assertTrue(seleccionarCurso(0));
	}
	@Test
	public void cursosPorCentro() {
		assertTrue(seleccionarCurso(2));
	}
	@Test
	public void cursosPorCentro1() {
		int id = -1;
		//assertFalse();
	}
	@Test
	public void cursosPorCentro2() {
		int id = 0;
		assertTrue(id>=0);
	}
	@Test
	public void consultarIngresos0() {		
		assertTrue(consultarIngresos(2023, 2039, 4, 5));
		
	}
	@Test
	public void consultarIngresos1() {
		assertFalse(consultarIngresos(2024, 1999, 6, 11));
		
	}
	@Test
	public void consultarIngresos2() {
		assertFalse(consultarIngresos(1987, 2023, 12, 7));
		
}
	@Test
	public void consultarIngresos3() {
		assertTrue(consultarIngresos(2067, 2024, 2, 9));
		
}

	public boolean consultarIngresos(int anioInicio, int anioFin, int mesInicio, int mesFin) {
		boolean valor = false;
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");	     
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
		valor = (anioInicio>= Integer.parseInt(anioActual) && anioFin>= Integer.parseInt(anioActual)
	    		 && mesInicio != 6 && mesInicio != 7 && mesFin != 6 && mesFin != 7 && mesInicio <= 12 && mesFin <= 12);
		return valor;
		
	}
	public boolean seleccionarCurso(int id) {
		boolean valor = false;
		assertTrue(id>=0);
		return valor;
	}

}
