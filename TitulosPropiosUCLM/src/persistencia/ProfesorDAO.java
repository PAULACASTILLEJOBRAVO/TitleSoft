package persistencia;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;
public class ProfesorDAO extends AbstractEntityDAO {
	
	
	public int crearProfesor(Profesor profesores) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO profesor (dni,nombre,apellidos,doctor,materia) " //materia aqui no, es materia quien tiene al responsable,es decir el profesor
				+ "VALUES ( '"+profesores.getDni()+"', '"+profesores.getNombre()+"' , '"+profesores.getApellidos()+"', '"+profesores.isDoctor()+"' ,'"+profesores.getMateria()+"'    )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Profesor nuevo creado");
		}else
			System.err.println("Error creando profesor nuevo ");

		return resultado;

	}

	/**
	 * 
	 * @param curso
	 */
	public Profesor seleccionarProfesor(Profesor profe) throws Exception {
		Vector<Object> resultado;
		Profesor profesorEncontrado =null; 
		String SelectSQL= "SELECT * FROM profesor WHERE dni LIKE '"+profe.getDni()+"' ";


		resultado = GestorBD.select(SelectSQL);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Profesor seleccionado");
			profesorEncontrado=(Profesor) resultado.get(0);
		}else
			System.err.println("Error al seleccionar profesor");

		return profesorEncontrado ;
		
		//error por el tipo de return
	}

	/**
	 * 
	 * @param curso
	 */
	public Profesor editarProfesor(Profesor profe) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		String updateSQL = "UPDATE profesor SET"
				+ " ";

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Profesor modificado");
		}else
			System.err.println("Error modificando profesor ");

		return profe;//no se porque devuelve curso, como esta hecho devuelve un numero
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<Profesor> listarProfesorPorDoctor(boolean doctor) throws Exception {
		Vector<Object> resultado;
		Collection<Profesor> profesorEncontrados=null;
		String SelectSQLEdicion= "SELECT * FROM profesor"
				+ "WHERE doctor = '"+doctor+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Cursos encontrados");
			for (int i = 0; i < resultado.size(); i++) {
				Profesor profeAux=(Profesor) resultado.get(i);
				profesorEncontrados.add(profeAux);
				
			}

		}else
			System.err.println("Error encontrando cursos");

		return profesorEncontrados;
		
		
	}

	
	
}