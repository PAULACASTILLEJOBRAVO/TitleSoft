package persistencia;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;
public class ProfesorDAO extends AbstractEntityDAO {
	
	
	public int crearProfesor(Profesor profesores) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO cursopropio (id,nombre,ECTS,fechaInicio,fechaFin,tasaMatricula,edicion,estado,tipoCurso,Centro,secretario,director) "
				+ "VALUES ()";//falta los get

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Curso nuevo creado");
		}else
			System.err.println("Error creando curso nuevo ");

		return resultado;

	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio seleccionarCurso(CursoPropio curso) throws Exception {
		Vector<Object> resultado;
		String SelectSQL= "SELECT * FROM cursopropio WHERE id LIKE '"+curso.getId()+"' ";


		resultado = GestorBD.select(SelectSQL);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Curso seleccionado");
		}else
			System.err.println("Error al seleccionar curso");

		return resultado ;
		
		//error por el tipo de return
	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio editarCurso(CursoPropio curso) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		String updateSQL = "";//no se si el curso que se le pasa es el curso que se quiere modificar o es el curso ya modificado

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Curso modificado");
		}else
			System.err.println("Error modificando curso ");

		return resultado;//no se porque devuelve curso, como esta hecho devuelve un numero
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarCursosPorEstado(EstadoCurso estado, Date fechaInicio, Date fechaFin) throws Exception {
		Vector<Object> resultado;
		String SelectSQLEdicion= "SELECT * FROM cursopropio"
				+ "WHERE estado = '"+estado+"'and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Cursos encontrados");

		}else
			System.err.println("Error encontrando cursos");

		return resultado;
		
		//lo he hecho con vector<object> porque es como lo hice en base de datos, se puede cambiar
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) throws Exception {
		// TODO - implement CursoPropioDAO.listarIngresos
		Vector<Object> resultado;
		double ingresos=0.0;
		String SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
				+ "WHERE tipoCurso = '"+tipo+"'and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Ingresos Calculados");
			ingresos=Integer.parseInt(resultado.toString());

		}else
			System.err.println("Error calculando ingresos");

		return ingresos;
		
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public void listarEdicionesCursos(Date fechaInicio, Date fechaFin) throws Exception {
		Vector<Object> resultado;
		
		/*
		 * no se porque para listar las ediciones se utilizan las fechas cuando hay una columna que es la edicion en si
		 */
		
		String SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
				+ "WHERE  fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Ingresos Calculados");
			

		}else
			System.err.println("Error calculando ingresos");

	
		
	}
	
	
	
	
	
	
}