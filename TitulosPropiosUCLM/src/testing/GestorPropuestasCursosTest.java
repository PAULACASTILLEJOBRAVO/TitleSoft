package testing;

import org.apache.derby.impl.sql.execute.CurrentDatetime;
import org.junit.*;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

public class GestorPropuestasCursosTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void tearDown()  {
		System.out.println("@After -> How many times do i appear?");
	}
	
	
	@Test
	public void realizarPropuestaCurso(){
		String nombre ="";
		Date fechaInicio;
		Date fechaFin;
		int eCTS = 0;
		double tasaMatricula = 0;
		int edicion = 0;
		String dniDirector="";
		String dniSecretario="";
		String centro="";
		
		assertTrue( !((nombre.equals("")) ||
				( eCTS<0) ||
				(tasaMatricula<0) ||
				(edicion<0) ||
				(dniDirector.equals("") || dniDirector.length()>9) ||
				(dniSecretario.equals("") || dniSecretario.length()>9 ) ||
				(centro.equals(""))  )  );
		
	}
	
}
