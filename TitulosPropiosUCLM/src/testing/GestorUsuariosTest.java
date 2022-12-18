package testing;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import negocio.controllers.GestorUsuarios;
import negocio.entities.TipoUsuario;
import negocio.entities.Usuario;
public class GestorUsuariosTest {



	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp()  {
		System.out.println("@Before -> How many times do i appear?");
	}

	@After
	public void tearDown() {
		System.out.println("@After -> How many times do i appear?");
	}

	@Test
	public void comprobarUsuario() {
		String usuario="";
		String password="";
		assertTrue( !(usuario.equals("")|| password.equals("")) );
	}
	@Test
	public void seleccionarUsuario() {
		String usuario="";
		assertTrue( !(usuario.equals("")) );
	}
	@Test
	public void contrasenaCorrectaLoging() {
		Usuario usuario=new Usuario("jefe", "jefe", TipoUsuario.JEFE);
		
		String password="";
		assertTrue( !(password.equals("")|| usuario.getPassword().equals("") ) );
		
	}
}
