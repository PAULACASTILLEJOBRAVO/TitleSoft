package testing;

import static org.junit.Assert.*;

import java.sql.Date;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.Matricula;
import negocio.entities.ModoPago;

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
	public void seleccionarMatricula() {
		Date d = new Date (2019-04-04);
		Matricula m = new Matricula(1, "1", "123", ModoPago.TRANSFERENCIA, d ,true);
		assertTrue(m.getIdMatricula()>0);
	}
	}


