package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.Centro;
import persistencia.CentroDAO;
public class GestorCentroTest {

	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass(){
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp(){
		System.out.println("@Before -> How many times do i appear?");
	}

	@After
	public void tearDown() {
		System.out.println("@After -> How many times do i appear?");
	}
	@Test
	public void testSeleccionarCentro() {
		String id = "UCLM";
		assertTrue(comprobarId(id));
	}
	@Test
	public void testSeleccionarCentro1() {
		String id = "UCM";
		assertTrue(comprobarId(id));
	}
	@Test
	public void testSeleccionarCentro2() {
		String id = "dnsnsj";
		assertFalse(comprobarId(id));
	}

	
	public boolean comprobarId(String id) {
		boolean valor = false;
	Centro centro= null;	
	centro = (negocio.controllers.GestorCentro.seleccionarCentro(id));
		valor = (centro != null);
		return valor;
	}
}
