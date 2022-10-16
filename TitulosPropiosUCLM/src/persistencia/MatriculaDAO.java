package persistencia;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;


public class MatriculaDAO extends AbstractEntityDAO {
	
	public int crearMatricula(Matricula matricula) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO matricula (titulacion,Fecha,pagado,Modo,Curso) "
				+ "VALUES ()";//falta los get

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Matricula nueva creado");
		}else
			System.err.println("Error creando matricula nueva ");

		return resultado;

	}

	/**
	 * 
	 * @param curso
	 */
	public Matricula seleccionarMatricula(Matricula matricula) throws Exception {
		Vector<Object> resultado;
		String SelectSQL= "SELECT * FROM matricula WHERE id LIKE '"+matricula.getTitulo()+"' ";


		resultado = GestorBD.select(SelectSQL);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Matricula seleccionada");
		}else
			System.err.println("Error al seleccionar la matricula");

		return resultado ;
		
		//error por el tipo de return
	}

	/**
	 * 
	 * @param curso
	 */
	public Matricula editarMatricula(Matricula matricula) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		String updateSQL = "";//no se si el curso que se le pasa es el curso que se quiere modificar o es el curso ya modificado

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Matricula modificado");
		}else
			System.err.println("Error modificando matricula ");

		return resultado;//no se porque devuelve curso, como esta hecho devuelve un numero
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarMatriculaTitulacion(String titulacion) throws Exception {
		Vector<Object> resultado;
		String SelectSQLEdicion= "SELECT * FROM matricula"
				+ "WHERE titulacion = '"+titulacion+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Matricula encontrados");

		}else
			System.err.println("Error encontrando matricula");

		return resultado;
		
		//lo he hecho con vector<object> porque es como lo hice en base de datos, se puede cambiar
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	 
		public List<CursoPropio> listarMatriculaCurso(int curso) throws Exception {
			Vector<Object> resultado;
			String SelectSQLEdicion= "SELECT * FROM matricula"
					+ "WHERE Curso = '"+curso+"' ";

			resultado = GestorBD.select(SelectSQLEdicion);

			if (resultado.isEmpty()==false) {
				System.out.println("Matricula encontradas");

			}else
				System.err.println("Error encontrando matriculas");

			return resultado;
			
			//lo he hecho con vector<object> porque es como lo hice en base de datos, se puede cambiar
		}




	
	
}
