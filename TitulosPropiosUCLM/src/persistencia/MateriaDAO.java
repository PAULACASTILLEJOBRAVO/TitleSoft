package persistencia;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;

public class MateriaDAO extends AbstractEntityDAO {
	
	
	public int crearMateria(Materia materia) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO materia (nombre,horas,fechaInicio,fechaFin,Curso) "
				+ "VALUES ()";//falta los get

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Materia nuevo creado");
		}else
			System.err.println("Error creando materia nueva ");

		return resultado;

	}
	
	 
		public Materia seleccionarMateria(Materia materia) throws Exception {
			Vector<Object> resultado;
			String SelectSQL= "SELECT * FROM materia WHERE id LIKE '"+materia.getNombre()+"' ";


			resultado = GestorBD.select(SelectSQL);
			
			if (resultado.isEmpty()==false) {
				System.out.println("Materia seleccionado");
			}else
				System.err.println("Error al seleccionar materia");

			return resultado ;
			
			//error por el tipo de return
		}

		/**
		 * 
		 * @param curso
		 */
		public Materia editarMateria(Materia materia) throws Exception {
			// TODO - implement CursoPropioDAO.editarCurso
			int resultado=0;
			String updateSQL = "";//no se si el curso que se le pasa es el curso que se quiere modificar o es el curso ya modificado

			resultado = GestorBD.update(updateSQL);
			if (resultado > 0) {
				System.out.println("Materia modificado");
			}else
				System.err.println("Error modificando materia ");

			return resultado;//no se porque devuelve curso, como esta hecho devuelve un numero
		}

		/**
		 * 
		 * @param estado
		 * @param fechaInicio
		 * @param fechaFin
		 */
		public List<CursoPropio> listarMateriaHoras(int horas) throws Exception {
			Vector<Object> resultado;
			String SelectSQLEdicion= "SELECT * FROM materia"
					+ "WHERE horas >= '"+horas+"'";

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
		public double listarMateriaCurso(int curso) throws Exception {
			// TODO - implement CursoPropioDAO.listarIngresos
			Vector<Object> resultado;
			double ingresos=0.0;
			String SelectSQLEdicion= "SELECT * FROM materia"
					+ "WHERE Curso = '"+curso+"'and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

			resultado = GestorBD.select(SelectSQLEdicion);
			
			if (resultado.isEmpty()==false) {
				System.out.println("Materia encontrada");
			}else
				System.err.println("Error encontrando materia");

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