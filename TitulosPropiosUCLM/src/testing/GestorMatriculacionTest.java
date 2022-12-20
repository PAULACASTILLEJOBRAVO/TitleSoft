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
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass(){
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() {
		System.out.println("@Before -> How many times do i appear?");
	}

	@After
	public void tearDown(){
		System.out.println("@After -> How many times do i appear?");
	}
	
	@Test
	public void realizarMatriculacion0() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = format.parse("2022-05-05");
		} catch (Exception e) {
			MainTesting.escribirLog("Errores.log", "Error en la creacion de las fechas para los test ");	
		}
		assertTrue(realizarMatriculacion( "1", "123", ModoPago.TRANSFERENCIA, fecha, true));
	}
	
	@Test
	public void realizarMatriculacion1() { 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha=null;
		try {
			fecha = format.parse("2022-05-05");
		} catch (Exception e) {
			MainTesting.escribirLog("Errores.log", "Error en la creacion de las fechas para los test ");	
		}
		assertFalse(realizarMatriculacion("86", "pepe", ModoPago.TRANSFERENCIA, fecha, false));
	}
	
	public boolean realizarMatriculacion(String curso, String alumno, ModoPago tipo,Date fecha,boolean pagado) {
		boolean value = false;
		
		java.sql.Date fecha1 = (java.sql.Date) fecha;

			value = (negocio.controllers.GestorMatriculacion.realizarMatriculacion(curso, alumno, tipo, fecha1, pagado));
		
		return value;
	}
	
}


