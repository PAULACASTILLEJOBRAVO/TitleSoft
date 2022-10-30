package persistencia;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;
public class ProfesorDAO extends AbstractEntityDAO {
	
	
	public int crearProfesor(Profesor profesores) throws Exception {
		return insert(profesores);

	}

	/**
	 * 
	 * @param curso
	 */
	public Profesor seleccionarProfesor(Profesor profe) throws Exception {
		return (Profesor) get(profe.getDni());
		
		
	}

	/**
	 * 
	 * @param curso
	 */
	public Profesor editarProfesor(Profesor profe) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		return(Profesor)update(profe);
	}

	public int eliminarProfesor(Profesor profesores) throws Exception {
		return delete(profesores);
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

	@Override
	public Object get(String id) throws Exception {
		Vector<Object> resultado;
		Profesor profesorEncontrado =null; 
		String SelectSQL= "SELECT * FROM profesor WHERE dni LIKE '"+id+"' ";


		resultado = GestorBD.select(SelectSQL);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Profesor seleccionado");
			profesorEncontrado=(Profesor) resultado.get(0);
		}else
			System.err.println("Error al seleccionar profesor");

		return profesorEncontrado ;
	}

	@Override
	public int insert(Object entity) throws Exception {
		int resultado=0;
		Profesor profesores=(Profesor)entity;
		String insertSQL = "INSERT INTO profesor (dni,nombre,apellidos,doctor,materia) " //materia aqui no, es materia quien tiene al responsable,es decir el profesor
				+ "VALUES ( '"+profesores.getDni()+"', '"+profesores.getNombre()+"' , '"+profesores.getApellidos()+"', '"+profesores.isDoctor()+"'  )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Profesor nuevo creado");
		}else
			System.err.println("Error creando profesor nuevo ");

		return resultado;
	}

	@Override
	public Object update(Object entity) throws Exception {
		int resultado=0;
		Profesor profe=(Profesor)entity;
		String updateSQL = "UPDATE profesor SET"
				+ " ";

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Profesor modificado");
		}else
			System.err.println("Error modificando profesor ");

		return profe;
	}

	@Override
	public int delete(Object entity) throws Exception {
		int resultado=0;
		Profesor profesores=(Profesor)entity;
		String insertSQL = "DELETE FROM profesor WHERE dni= '"+profesores.getDni()+"'  )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Profesor eliminado");
		}else
			System.err.println("Error eliminando profesor ");

		return resultado;
	}

	
	
}