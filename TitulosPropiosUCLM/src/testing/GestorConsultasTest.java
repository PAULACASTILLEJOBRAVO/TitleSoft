package testing;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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
		
		Date dInicio = new Date(2023-12-03);
		Date dFin = new Date(2024-05-07);
		 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm"); 
	     String anioInicio = getYearFormat.format(dInicio);
	     String mesInicio = getMonthFormat.format(dInicio);

	     String anioFin = getYearFormat.format(dFin);
	     String mesFin = getMonthFormat.format(dInicio);
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
		assertTrue((Integer.parseInt(anioInicio)< Integer.parseInt(anioActual) && Integer.parseInt(anioFin)< Integer.parseInt(anioActual)
	    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7));
		
	}
	@Test
	public void consultarIngresos1() {
		
		Date dInicio = new Date(2023-06-14);
		Date dFin = new Date(2039-06-04);
		 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm"); 
	     String anioInicio = getYearFormat.format(dInicio);
	     String mesInicio = getMonthFormat.format(dInicio);

	     String anioFin = getYearFormat.format(dFin);
	     String mesFin = getMonthFormat.format(dInicio);
	     Date fechaActual = new Date();
	     String anioActual = getYearFormat.format(fechaActual);
		assertTrue((Integer.parseInt(anioInicio)< Integer.parseInt(anioActual) && Integer.parseInt(anioFin)< Integer.parseInt(anioActual)
	    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7));
		
	}
	@Test
	public void consultarIngresos2() {
	
	Date dInicio = new Date(2023-07-28);
	Date dFin = new Date(1999-10-16);
	 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm"); 
     String anioInicio = getYearFormat.format(dInicio);
     String mesInicio = getMonthFormat.format(dInicio);

     String anioFin = getYearFormat.format(dFin);
     String mesFin = getMonthFormat.format(dInicio);
     Date fechaActual = new Date();
     String anioActual = getYearFormat.format(fechaActual);
	assertTrue((Integer.parseInt(anioInicio)< Integer.parseInt(anioActual) && Integer.parseInt(anioFin)< Integer.parseInt(anioActual)
    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7));
	
}
	@Test
	public void consultarIngresos3() {
	
	Date dInicio = new Date(1987-04-07);
	Date dFin = new Date(2024-07-27);
	 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm"); 
     String anioInicio = getYearFormat.format(dInicio);
     String mesInicio = getMonthFormat.format(dInicio);

     String anioFin = getYearFormat.format(dFin);
     String mesFin = getMonthFormat.format(dInicio);
     Date fechaActual = new Date();
     String anioActual = getYearFormat.format(fechaActual);
     System.out.println("El año actual es: " + anioActual);
     System.out.println("El año de inicio es: " + anioInicio);
     System.out.println("El año fin es: " + anioFin);
	assertTrue((Integer.parseInt(anioInicio)< Integer.parseInt(anioActual) && Integer.parseInt(anioFin)< Integer.parseInt(anioActual)
    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7));
	
}
	@Test
	public void consultarIngresos4() {
	
	Date dInicio1 = new Date(2067-03-14);
	Date dFin = new Date(2024-11-05);
	 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm"); 
     String anioInicio = getYearFormat.format(dInicio1);
     String mesInicio = getMonthFormat.format(dInicio1);

     String anioFin = getYearFormat.format(dFin);
     String mesFin = getMonthFormat.format(dInicio1);
     Date fechaActual = new Date();
     String anioActual = getYearFormat.format(fechaActual);
    
     

	assertTrue((Integer.parseInt(anioInicio)< Integer.parseInt(anioActual) && Integer.parseInt(anioFin)< Integer.parseInt(anioActual)
    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7));
	
}
	@Test
	public void listarCursosEstados() {
		
	}
}
