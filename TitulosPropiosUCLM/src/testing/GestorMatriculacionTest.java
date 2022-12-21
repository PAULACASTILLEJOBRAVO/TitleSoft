package testing;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.ModoPago;
import presentacion.MainTesting;

public class GestorMatriculacionTest {

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
	public void realizarMatriculacion0() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = format.parse("2022-05-05");
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");	
		}
		assertTrue(realizarMatriculacion( "1", "123", ModoPago.TRANSFERENCIA, fecha, true));
	}
	
	@Test
	public void realizarMatriculacion1() { 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = format.parse("1999-05-09");
		} catch (Exception e) {
			
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");	
		}
		assertFalse(realizarMatriculacion("1", "123", ModoPago.TARJETA_CREDITO, fecha, false));
	}
	
	public boolean realizarMatriculacion(String curso, String alumno, ModoPago tipo,Date fecha,boolean pagado) {
		boolean value = false;
		
//		java.sql.Date fecha1 = (java.sql.Date) fecha;

			value = (negocio.controllers.GestorMatriculacion.realizarMatriculacion(curso, alumno, tipo, fecha, pagado));
		
		return value;
	}
	
}


