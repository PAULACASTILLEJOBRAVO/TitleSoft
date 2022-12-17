package Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GestorCentroTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before -> How many times do i appear?");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After -> How many times do i appear?");
	}
	@Test
	public void seleccionarCentro() {
		int id = -1;
		assertTrue(id>=0);
	}
	@Test
	public void seleccionarCentro1() {
		int id = 1;
		assertTrue(id>=0);
	}
	@Test
	public void seleccionarCentro2() {
		int id = 0;
		assertTrue(id>=0);
	}
}
