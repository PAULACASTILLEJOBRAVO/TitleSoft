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
	public void seleccionarCurso2() {
		assertTrue(comprobarId(0));
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
	public void cursosPorCentro2() {
		assertTrue(comprobarId(0));
	}
	@Test
	public void consultarIngresos0() {		
		assertTrue(consultarIngresos(TipoCurso.CORTA_DURACION, 2023, 2039, 4, 5));
		
	}
	@Test
	public void consultarIngresos1() {
		assertFalse(consultarIngresos(TipoCurso.ESPECIALISTA, 2024, 1999, 7, 11));
		
	}
	@Test
	public void consultarIngresos2() {
		assertFalse(consultarIngresos(TipoCurso.FORMACION_AVANZADA, 1987, 2023, 12, 8));
		
}
	@Test
	public void consultarIngresos3() {
		assertTrue(consultarIngresos(TipoCurso.FORMACION_CONTINUA, 2067, 2024, 2, 9));
		
}
	@Test
	public void consultarIngresos4() {		
		assertTrue(consultarIngresos(TipoCurso.MASTER, 2023, 2039, 4, 5));
		
	}
	@Test
	public void consultarIngresos5() {
		assertFalse(consultarIngresos(TipoCurso.MICROCREDENCIALES, 2024, 1999, 7, 11));
		
	}
	
	@Test
	public void consultarCursosPropuestos0() {
		assertTrue(consultarCursosPropuestos(EstadoCurso.EN_IMPARTICION));
	}
	
	@Test
	public void consultarCursosPropuestos1() {
		assertTrue(consultarCursosPropuestos(EstadoCurso.EN_MATRICULACION));
	}
	@Test
	public void consultarCursosPropuestos2() {
		assertTrue(consultarCursosPropuestos(EstadoCurso.PROPUESTA_RECHAZADA));
	}
	@Test
	public void consultarCursosPropuestos3() {
		assertTrue(consultarCursosPropuestos(EstadoCurso.PROPUESTO));
	}
	@Test
	public void consultarCursosPropuestos4() {
		assertTrue(consultarCursosPropuestos(EstadoCurso.TERMINADO));
	}
	@Test
	public void consultarCursosPropuestos5() {
		assertTrue(consultarCursosPropuestos(EstadoCurso.VALIDADO));
	}
	
	public boolean consultarCursosPropuestos(EstadoCurso estadoCurso) {
		boolean valor = false;
		
		valor = (estadoCurso == EstadoCurso.EN_IMPARTICION || estadoCurso == EstadoCurso.EN_MATRICULACION || estadoCurso == EstadoCurso.PROPUESTA_RECHAZADA || estadoCurso == EstadoCurso.PROPUESTO || estadoCurso == EstadoCurso.TERMINADO || estadoCurso == EstadoCurso.VALIDADO);

		return valor;
		
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
	

}
