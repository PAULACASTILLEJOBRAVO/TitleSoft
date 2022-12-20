package testing;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.CursoPropio;
import negocio.entities.TipoCurso;
import persistencia.CursoPropioDAO;
import presentacion.MainTesting;

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
	public void consultarIngresos0() {		
		assertFalse(consultarIngresos(TipoCurso.ESPECIALISTA, 2022, 2023, 11, -8));
		
	}
	@Test
	public void consultarIngresos1() {
		assertTrue(consultarIngresos(TipoCurso.MASTER, 2022, 2023, 11, 6));
		
	}
	@Test
	public void listarCursosEstados0() {
		assertFalse(listarCursosEstados(2022, 2023, 11, 8));
	}
	@Test
	public void listarCursosEstados1() {
		assertTrue(listarCursosEstados(2022, 2024, 12, 01));
	}
	
	
	@Test
	public void listarCursosRechazadosYPropuestos0() {
		assertTrue(listarCursosRechazadosYPropuestos(2022, 2024, 12, 1));
	}
	
	@Test
	public void listarCursosRechazadosYPropuestos1() {
		assertFalse(listarCursosRechazadosYPropuestos(2022, 2023, 11, 8));
	}
	
	@Test
	public void listarEdicionesCursos0() {
		assertTrue(listarEdicionesCursos(2022, 2024, 12, 1));
	}
	
	@Test
	public void listarEdicionesCursos1() {
		assertFalse(listarEdicionesCursos(2022, 2023, 11, 8));
	}
	
	@Test
	public void seleccionarCurso0() {
		assertTrue(seleccionarCurso(1));
	}
	
	@Test
	public void seleccionarCurso1() {
		assertFalse(seleccionarCurso(2));
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
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");		}
		try {
			consulta = (negocio.controllers.GestorConsultas.consultarIngresos(tipo, fechaInicio, fechaFin));
		}catch(Exception e) {
			consulta=0;
		}
	    
		valor = (consulta > 0);
		return valor;
	}
	public boolean listarCursosRechazadosYPropuestos(int anioInicio, int anioFin, int mesInicio, int mesFin) {
		boolean valor = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Collection<CursoPropio> ediciones;
	     Date fechaInicio=null;
		Date fechaFin=null;
		String fecha1 =  anioInicio + "-" + mesInicio + "-" + "1";
		String fecha2 =  anioFin + "-" + mesFin + "-" + "1";
		
		try {
			fechaInicio = format.parse(fecha1);
			fechaFin=format.parse(fecha2);
		} catch (ParseException e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");		}
		try {
			ediciones = (negocio.controllers.GestorConsultas.listarCursosEstados(fechaInicio, fechaFin));
		}catch(Exception e) {
			ediciones=null;
		}
	    
		valor = (ediciones != null);
		return valor;
	}
	public boolean listarCursosEstados(int anioInicio, int anioFin, int mesInicio, int mesFin) {
		boolean valor = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Collection<CursoPropio> ediciones;
	     Date fechaInicio=null;
		Date fechaFin=null;
		String fecha1 =  anioInicio + "-" + mesInicio + "-" + "1";
		String fecha2 =  anioFin + "-" + mesFin + "-" + "1";
		
		try {
			fechaInicio = format.parse(fecha1);
			fechaFin=format.parse(fecha2);
		} catch (ParseException e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");		}
		try {
			ediciones = (negocio.controllers.GestorConsultas.listarCursosRechazadosYPropuestos(fechaInicio, fechaFin));
		}catch(Exception e) {
			ediciones=null;
		}
	    
		valor = (ediciones != null);
		return valor;
	}
	public boolean listarEdicionesCursos(int anioInicio, int anioFin, int mesInicio, int mesFin) {
		boolean valor = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Collection<CursoPropio> ediciones;
	     Date fechaInicio=null;
		Date fechaFin=null;
		String fecha1 =  anioInicio + "-" + mesInicio + "-" + "1";
		String fecha2 =  anioFin + "-" + mesFin + "-" + "1";
		
		try {
			fechaInicio = format.parse(fecha1);
			fechaFin=format.parse(fecha2);
		} catch (ParseException e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");		}
		try {
			ediciones = (negocio.controllers.GestorConsultas.listarEdicionesCursos(fechaInicio, fechaFin));
		}catch(Exception e) {
			ediciones=null;
		}
	    
		valor = (!ediciones.isEmpty());
		return valor;
	}
	
	public boolean seleccionarCurso(int id) {
		boolean valor = false;
		CursoPropio curso=null;
		String ident  = id + "";
		try {
		curso = (negocio.controllers.GestorConsultas.seleccionarCurso(ident));
		}catch(Exception e ) {
			curso = null;
		}
		valor = (curso!= null);
		return valor;
	}

}
