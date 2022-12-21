package testing;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

import negocio.controllers.GestorMateria;
import negocio.entities.CursoPropio;
import negocio.entities.Materia;
import persistencia.CursoPropioDAO;
import presentacion.MainTesting;

public class GestorMateriaTest {
	GestorMateria gMateria= new GestorMateria();
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
	public void seleccionarMaterias1() {
		String id="1";
		assertTrue(seleccionarMaterias0(id));
	}
	@Test
	public void seleccionarMaterias2() {
		String id="-5";
		assertFalse(seleccionarMaterias0(id));
	}
	
	public boolean seleccionarMaterias0(String id) {
		Materia materiaAux=gMateria.seleccionarMaterias(id);
		if(Integer.parseInt(id)>0 && materiaAux !=null) {
			return true;
		}
		return false;
	}
	@Test
	public void realizarMateria1() {
		String dniProfesorResponsable="789";
		String nombre="Hola";
		double horas=12.4;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		try {
			fechaInicio = format.parse("2002-02-20");
			fechaFin=format.parse("2003-05-12");
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");	
		}

		assertTrue( realizarMateria0(dniProfesorResponsable, nombre, horas, fechaInicio, fechaFin));
	}
	@Test
	public void realizarMateria2() {
		String dniProfesorResponsable="12345678C";
		String nombre="Hola";
		double horas=-12.4;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio=null;
		Date fechaFin=null;
		try {
			fechaInicio = format.parse("1999-02-20");
			fechaFin=format.parse("2003-05-12");
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR, "Error en la creacion de las fechas para los test ");	
		}
		assertFalse( realizarMateria0(dniProfesorResponsable, nombre, horas, fechaInicio, fechaFin));

	}

	public boolean realizarMateria0(String dniProfesorResponsable,String nombre,double horas,Date fechaInicio,Date fechaFin) {
		CursoPropioDAO cursoDAO= new CursoPropioDAO();
		CursoPropio curso=cursoDAO.seleccionarCurso("1");

		Materia materiaAux=gMateria.realizarMateria(dniProfesorResponsable, nombre, horas, fechaInicio, fechaFin, curso);
		if(materiaAux==null) {
			return false;
		}
		return true;
	}


}