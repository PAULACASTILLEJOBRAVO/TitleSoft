package testing;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.controllers.GestorUsuarios;
import negocio.entities.TipoUsuario;
import negocio.entities.Usuario;
import presentacion.MainTesting;
public class GestorUsuariosTest {

	GestorUsuarios gUsuario=new GestorUsuarios();

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
	public void comprobarUsuario() {
		String usuario="";
		String password="";
		assertFalse( gUsuario.comprobarUsuario(usuario, password) ); 
	}
	@Test
	public void comprobarUsuario2() {
		String usuario="jefe";
		String password="jefe";
		assertTrue( gUsuario.comprobarUsuario(usuario, password)); 
	}
	@Test
	public void seleccionarUsuario() {
		String usuario="";
		assertFalse( seleccionarUsuario0(usuario) );
	}
	@Test
	public void seleccionarUsuario2() {
		String usuario="jefe";
		assertTrue( seleccionarUsuario0(usuario));
	}
	
	public boolean seleccionarUsuario0(String usuario) {
		if(gUsuario.seleccionarUsuario(usuario)==null) {
			return false;
		}
		return true;
	}
	
	@Test
	public void contrasenaCorrectaLoging() {
		Usuario usuario=new Usuario("", "", TipoUsuario.JEFE);
		
		String password="";
		assertFalse(gUsuario.contrasenaCorrectaLoging(usuario, password));
		
	}
	@Test
	public void contrasenaCorrectaLoging2() {
		Usuario usuario=new Usuario("jefe", "jefe", TipoUsuario.JEFE);
		
		String password="jefe";
		assertTrue( gUsuario.contrasenaCorrectaLoging(usuario, password));
	}
	
	
}