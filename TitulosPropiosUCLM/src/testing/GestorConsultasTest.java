package testing;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.EstadoCurso;
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
		assertTrue(consultarIngresos(TipoCurso.MASTER, -2023, -2098, -3, -8));
		
	}
	@Test
	public void consultarIngresos1() {
		assertFalse(consultarIngresos(TipoCurso.ESPECIALISTA, 2024, 2025, 4, 3));
		
	}

	
	@Test
	public void listarEdicionesCursos0() {
		assertFalse(comProbarFecha(-2023, -2098, -3, -8));
	}
	
	@Test
	public void listarEdicionesCursos1() {
		assertTrue(comProbarFecha(2024, 2025, 4, 3));
	}
	
	public void listarCursosEstado0() {
		assertTrue(comProbarFecha(-2023, -2098, -3, -8));
	}
	
	public void listarCursosEstado1() {
		assertTrue(comProbarFecha(2024, 2025, 4, 3));
	}
	

	public boolean consultarIngresos(TipoCurso tipo, int anioInicio, int anioFin, int mesInicio, int mesFin) {
		boolean valor = false;
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");	     
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
		valor = (anioInicio>= Integer.parseInt(anioActual) && anioFin>= Integer.parseInt(anioActual)
	    		 && mesInicio != 8 && mesInicio != 7 && mesFin != 7 && mesFin != 8 && mesInicio <= 12 && mesFin <= 12 &&
			    		 (tipo == TipoCurso.CORTA_DURACION || tipo == TipoCurso.ESPECIALISTA || tipo == TipoCurso.EXPERTO || tipo == TipoCurso.FORMACION_AVANZADA || tipo == TipoCurso.FORMACION_CONTINUA || tipo == TipoCurso.MASTER || tipo == TipoCurso.MICROCREDENCIALES));
		return valor;
		
	}
	public boolean comprobarId(int id) {
		boolean valor = false;
		valor= (id>=0);
		return valor;
	}
	
	public boolean comProbarFecha(int anioInicio, int anioFin, int mesInicio, int mesFin) {
		boolean valor = false;
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");	     
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
		valor = (anioInicio>= Integer.parseInt(anioActual) && anioFin>= Integer.parseInt(anioActual)
	    		 && mesInicio != 8 && mesInicio != 7 && mesFin != 7 && mesFin != 8 && mesInicio <= 12 && mesFin <= 12);
		return valor;
	}
	

}
