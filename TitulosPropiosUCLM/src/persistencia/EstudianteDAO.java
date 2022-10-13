package persistencia;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;

public class EstudianteDAO extends AbstractEntityDAO{
	
	
	public int crearEstudiante(Estudiante alumno) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO estudiante (dni,nombre,apellidos,titulacion,calificacion)"
				+ "VALUES ()";//falta los get

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Estudiante nuevo creado");
		}else
			System.err.println("Error creando curso estudiante ");

		return resultado;

	}

	/**
	 * 
	 * @param curso
	 */
	public Estudiante seleccionarEstudiante(Estudiante alumno) throws Exception {
		Vector<Object> resultado;
		String SelectSQL= "SELECT * FROM estudiante WHERE id LIKE '"+alumno.getDni()+"' ";


		resultado = GestorBD.select(SelectSQL);
		
	
		
		if (resultado.isEmpty()==false) {
			System.out.println("Estudiante seleccionado");
			
		}else
			System.err.println("Error al seleccionar estudiante");

		return resultado ;
		
		//error por el tipo de return
	}

	/**
	 * 
	 * @param curso
	 */
	public Estudiante editarEstudiante(Estudiante alumno) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		String updateSQL = "";//no se si el curso que se le pasa es el curso que se quiere modificar o es el curso ya modificado

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Estudiante modificado");
		}else
			System.err.println("Error modificando estudiante ");

		return resultado;//no se porque devuelve curso, como esta hecho devuelve un numero
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<Estudiante> listarEstudianteTitulacion(String titulacion) throws Exception {
		Vector<Object> resultado;
		String SelectSQLEdicion= "SELECT * FROM estudiante"
				+ "WHERE titulacion = '"+titulacion+"'  ";

		resultado = GestorBD.select(SelectSQLEdicion);
	

		if (resultado.isEmpty()==false) {
			System.out.println("Estudiantes encontrados");
			
		}else
			System.err.println("Error encontrando estudiantes");

		return resultado;
		
		//lo he hecho con vector<object> porque es como lo hice en base de datos, se puede cambiar
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public double listarCalificacion(double calificacion) throws Exception {
		// TODO - implement CursoPropioDAO.listarIngresos
		Vector<Object> resultado;
	
		String SelectSQLEdicion= "SELECT * FROM estudiante"
				+ "WHERE calificacion >= '"+calificacion+"' ";
		resultado = GestorBD.select(SelectSQLEdicion);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Estudiantes encontrados");

		}else
			System.err.println("Error encontrando estudiantes");

		return resultado;
		//error por el tipo de return

		
	}

	
	
	
	
}