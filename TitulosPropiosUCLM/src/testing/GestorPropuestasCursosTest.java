package testing;



import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;
import presentacion.MainTesting;

import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GestorPropuestasCursosTest {

	GestorPropuestasCursos gCurso=new GestorPropuestasCursos(); 
	@BeforeClass
	public static void setUpBeforeClass(){
		MainTesting.escribirLog(MainTesting.ERROR, "@BeforeClass");		
	}

	@AfterClass
	public static void tearDownAfterClass()  {
		MainTesting.escribirLog(MainTesting.ERROR, "@AfterClass");		
	}

	@Before
	public void setUp() {
		MainTesting.escribirLog(MainTesting.ERROR, "@Before -> How many times do i appear?");
	}

	@After
	public void tearDown()  {
		MainTesting.escribirLog(MainTesting.ERROR, "@After -> How many times do i appear?");	
	}


	@Test
	public void realizarPropuestaCurso(){
		String nombre ="ADE";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		double tasaMatricula = -23.7;
		int edicion = -8;
		String dniDirector="789";
		String dniSecretario="567";
		String centro="UCLM";
		try {
			fechaInicio = format.parse("1999-02-20");
			fechaFin=format.parse("2003-05-12");
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");	
		}


		assertFalse( realizarPropuestaCurso0(nombre, fechaInicio, fechaFin, tasaMatricula, edicion,
				dniDirector, dniSecretario, EstadoCurso.VALIDADO, TipoCurso.MASTER, centro) );

	}

	@Test
	public void realizarPropuestaCurso2(){
		String nombre ="ADE";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		double tasaMatricula =200;
		int edicion =12;
		String dniDirector="789";
		String dniSecretario="567";
		String centro="UCLM";
		try {
			fechaInicio = format.parse("2002-02-20");
			fechaFin=format.parse("2003-05-12");
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");	
		}

		assertTrue(realizarPropuestaCurso0(nombre, fechaInicio, fechaFin, tasaMatricula, edicion,
				dniDirector, dniSecretario, EstadoCurso.VALIDADO, TipoCurso.MASTER, centro) );

	}
	private boolean realizarPropuestaCurso0(String nombre, Date fechaInicio, Date fechaFin, double tasaMatricula, int edicion,  String dniDirector, String dniSecretario, EstadoCurso estado, TipoCurso tipo, String centro) {
		if(gCurso.realizarPropuestaCurso(nombre, fechaInicio, fechaFin, tasaMatricula, edicion, dniDirector, dniSecretario, estado, tipo, centro)==null) {
			return false;
		}
		return true;
	}

}