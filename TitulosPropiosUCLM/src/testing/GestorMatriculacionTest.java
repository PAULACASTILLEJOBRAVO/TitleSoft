package testing;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		assertFalse(realizarMatriculacion("", "Pepe", -2023, -3));
	}
	
	@Test
	public void realizarMatriculacion1() {
		assertTrue(realizarMatriculacion("curso01 verano", "Ana", 2024, 4));
	}
	@Test
	public void realizarMatriculacion2() {
		assertFalse(realizarMatriculacion("curso01wertyuiolkjhgdfsavbnmk", "", 2024, 4));
	}
	
	@Test
	public void realizarMatriculacion3() {
		assertFalse(realizarMatriculacion("curso02", "", 2024, 4));
	}
	
	@Test
	public void realizarMatriculacion4() {
		assertFalse(realizarMatriculacion("curso verano", "uijhgtrfgvbngfdewsqjks", -2024, 4));
	}
	@Test
	public void realizarMatriculacion5() {
		assertFalse(realizarMatriculacion("curso01 verano", "Ana", -2024, 4));
	}
	
	@Test
	public void realizarMatriculacion6() {
		assertFalse(realizarMatriculacion("curso01 verano", "Ana", 2024, 7));
	}
	@Test
	public void realizarMatriculacion7() {
		assertFalse(realizarMatriculacion("curso01 verano", "Ana", 2024, 8));
	}
	
	public boolean realizarMatriculacion(String curso, String alumno, int anio, int mes) {
		boolean value = false;
		java.util.Date fechaActual = new java.util.Date();
		 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	     
	     String anioActual = getYearFormat.format(fechaActual);
		value = (curso.length() < 20 && curso.length() > 0 && alumno.length() < 20 && alumno.length() > 0 
				&& anio> Integer.parseInt(anioActual) && mes != 7 && mes != 8);

		return value;
	}
	
}


