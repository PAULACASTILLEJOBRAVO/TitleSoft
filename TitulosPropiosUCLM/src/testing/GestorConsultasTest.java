package testing;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.TipoCurso;

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
		assertTrue(comprobarId(1));
	}
	@Test
	public void seleccionarCurso1() {
		assertFalse(comprobarId(-1));
	}

	@Test
	public void cursosPorCentro() {
		assertTrue(comprobarId(2));
	}
	@Test
	public void cursosPorCentro1() {
		assertFalse(comprobarId(-1));
	}
	
	@Test
	public void consultarIngresos0() {		
		assertFalse(consultarIngresos(TipoCurso.ESPECIALISTA, -2023, -2098, -3, -8));
		
	}
	@Test
	public void consultarIngresos1() {
		assertTrue(consultarIngresos(TipoCurso.CORTA_DURACION, 2024, 2025, 4, 3));
		
	}

	
//	@Test
//	public void listarEdicionesCursos0() {
//		assertFalse(comprobarFecha(-2023, -2098, -3, -8));
//	}
//	
//	@Test
//	public void listarEdicionesCursos1() {
//		assertTrue(comprobarFecha(2024, 2025, 4, 3));
//	}
//	
//	@Test
//	public void listarCursosEstado0() {
//		assertFalse(comprobarFecha(-2023, 2023, 9, 6));
//	}
//	@Test
//	public void listarCursosEstado1() {
//		assertTrue(comprobarFecha(2024, 2025, 4, 3)); 
//	}
//	@Test
//	public void listarCursosEstado2() {
//		assertFalse(comprobarFecha(2024, 2025, 7, 3)); 
//	}
//	@Test
//	public void listarCursosEstado3() {
//		assertFalse(comprobarFecha(2024, 2025, 2, 8)); 
//	}
//	
//	@Test
//	public void listarCursosEstado4() {
//		assertFalse(comprobarFecha(2024, 2025, 3, 7)); 
//	}
//	@Test
//	public void listarCursosEstado5() {
//		assertFalse(comprobarFecha(2024, 2025, 8, 2)); 
//	}
//	@Test
//	public void listarCursosEstado6() {
//		assertFalse(comprobarFecha(2024, -2025, 8, 2)); 
//	}
//
//	@Test
//	public void listarCursosEstado7() {
//		assertFalse(comprobarFecha(2024, 2025, 4, 33)); 
//	}
//	
//	@Test
//	public void listarCursosEstado8() {
//		assertFalse(comprobarFecha(2024, 2025, 44, 3)); 
//	}
	
	public boolean comprobarId(int id) {
		boolean valor = false;
		valor= (id>=0);
		return valor;
	}
	
	public boolean consultarIngresos(TipoCurso tipo, int anioInicio, int anioFin, int mesInicio, int mesFin) {
		boolean valor = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	     double consulta=0;
	     Date fechaInicio=null;
		Date fechaFin=null;
		String fecha1 =  anioInicio + "-" + mesInicio + "-" + "1";
		String fecha2 =  anioFin + "-" + mesFin + "-" + "1";
		
		try {
			fechaInicio = format.parse(fecha1);
			fechaFin=format.parse(fecha2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    consulta = (negocio.controllers.GestorConsultas.consultarIngresos(tipo, fechaInicio, fechaFin));
	    System.out.println("---------------------- " + consulta);
		valor = (consulta > 0);
		return valor;
	}
	

}
