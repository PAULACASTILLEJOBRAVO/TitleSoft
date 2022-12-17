package negocio.controllers;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.CursoPropio;
import persistencia.CursoPropioDAO;
import presentacion.Main_testing;

public class GestorConsultasTest {

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
	public void seleccionarCurso() {
		int id = 1;
		assertTrue(id>=0);
	}
	@Test
	public void cursosPorCentro() {
		int id = 1;
		assertTrue(id>=0);
	}
	@Test
	public void consultarIngresos() {
		
		Date d = new Date(2022-12-22);
		
	}

}
