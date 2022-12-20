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
		MainTesting.escribirLog("Errores.log", "@BeforeClass");		
	}

	@AfterClass
	public static void tearDownAfterClass()  {
		MainTesting.escribirLog("Errores.log", "@AfterClass");		
	}

	@Before
	public void setUp() {
		MainTesting.escribirLog("Errores.log", "@Before -> How many times do i appear?");
	}

	@After
	public void tearDown()  {
		MainTesting.escribirLog("Errores.log", "@After -> How many times do i appear?");	
	}

	@Test
	public void comprobarUsuario() {
		String usuario="";
		String password="";
		assertTrue( !(usuario.equals("")|| password.equals("")) ); 
	}
	@Test
	public void comprobarUsuario2() {
		String usuario="";
		String password="";
		assertFalse( !(usuario.equals("")|| password.equals("")) ); 
	}
	@Test
	public void seleccionarUsuario() {
		String usuario="";
		assertTrue( !(usuario.equals("")) );
	}
	@Test
	public void seleccionarUsuario2() {
		String usuario="";
		assertFalse( !(usuario.equals("")) );
	}
	@Test
	public void contrasenaCorrectaLoging() {
		Usuario usuario=new Usuario("jefe", "jefe", TipoUsuario.JEFE);
		
		String password="";
		assertTrue( !(password.equals("")|| usuario.getPassword().equals("") ) );
		
	}
	@Test
	public void contrasenaCorrectaLoging2() {
		Usuario usuario=new Usuario("jefe", "jefe", TipoUsuario.JEFE);
		
		String password="";
		assertFalse( !(password.equals("")|| usuario.getPassword().equals("") ) );
	}
}
