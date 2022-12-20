package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.*;

import negocio.controllers.GestorUsuarios;
import negocio.entities.TipoUsuario;
import negocio.entities.Usuario;
import presentacion.MainTesting;
public class GestorUsuariosTest {



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
		assertTrue( (usuario.equals("")|| password.equals("")) ); 
	}
	@Test
	public void comprobarUsuario2() {
		String usuario="jefe";
		String password="jefe";
		assertFalse( (usuario.equals("")|| password.equals("")) ); 
	}
	@Test
	public void seleccionarUsuario() {
		String usuario="";
		assertTrue( (usuario.equals("")) );
	}
	@Test
	public void seleccionarUsuario2() {
		String usuario="jefe";
		assertFalse( (usuario.equals("")) );
	}
	@Test
	public void contrasenaCorrectaLoging() {
		Usuario usuario=new Usuario("", "", TipoUsuario.JEFE);
		
		String password="";
		assertTrue( comprobarContraseña(usuario, password));
		
	}
	@Test
	public void contrasenaCorrectaLoging2() {
		Usuario usuario=new Usuario("jefe", "jefe", TipoUsuario.JEFE);
		
		String password="jefe";
		assertFalse(comprobarContraseña(usuario, password));
	}
	
	public boolean comprobarContraseña(Usuario usuario, String password) {
		if(password.equals("")) {
			if(usuario.getPassword().equals("")) {
				return true;
			}
		}
			
		return false;
	}
	
	public boolean comprobarUsuario(String usuario, String password) {
		if(password.equals("")) {
			if(usuario.equals("")) {
				return true;
			}
		}
			
		return false;
	}
}
