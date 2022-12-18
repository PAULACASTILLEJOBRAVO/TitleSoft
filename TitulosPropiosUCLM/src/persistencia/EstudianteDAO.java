package persistencia;

import java.util.*;

import negocio.entities.*;

public class EstudianteDAO extends AbstractEntityDAO{
	public int crearEstudiante(Estudiante alumno) {
		return insert(alumno);
	}

	public Estudiante seleccionarEstudiante(Estudiante alumno) {
		return (Estudiante)get(alumno.getDni());
	}
	
	public Estudiante editarEstudiante(Estudiante alumno)  {
		return (Estudiante) update(alumno);
	}

	public int eliminarEstudiante(Estudiante alumno) {
		return delete(alumno);
	}
	
	public Collection<Estudiante> listarEstudianteTitulacion(String titulacion) {
		Vector<Object> resultado;
		Collection alumnosEncontrados=null;
		String SelectSQLEdicion= "SELECT * FROM estudiante"
				+ "WHERE titulacion = '"+titulacion+"'  ";

		resultado = GestorBD.select(SelectSQLEdicion);
	
		if (resultado.isEmpty()==false) {
			System.out.println("Estudiantes encontrados");
			for (int i = 0; i <resultado.size(); i++) {
				Estudiante alumnoAux=(Estudiante) resultado.get(i);
				alumnosEncontrados.add(alumnoAux);
			}
		}else
			System.err.println("Error encontrando estudiantes");
		return alumnosEncontrados;
	}

	public Collection<Estudiante> listarCalificacion(double calificacion){
		Vector<Object> resultado;
		Collection alumnosEncontrados=null;
	
		String SelectSQLEdicion= "SELECT * FROM estudiante"
				+ "WHERE calificacion = '"+calificacion+"' ";
		resultado = GestorBD.select(SelectSQLEdicion);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Estudiantes encontrados");
			for (int i = 0; i < resultado.size(); i++) {
				Estudiante alumnoAux=(Estudiante)resultado.get(i);
				alumnosEncontrados.add(alumnoAux);
			}
		}else
			System.err.println("Error encontrando estudiantes");
		return alumnosEncontrados;
	}

	@Override
	public Object get(String id) {
		Vector<Object> resultado;
		Estudiante alumnoEncontrado=null;
		String SelectSQL= "SELECT * FROM estudiante WHERE id = '"+id+"' ";

		resultado = GestorBD.select(SelectSQL);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Estudiante seleccionado");
			alumnoEncontrado=(Estudiante)resultado.get(0);
		}else
			System.err.println("Error al seleccionar estudiante");
		return alumnoEncontrado ;
	}

	@Override
	public int insert(Object entity) {
		int resultado=0;
		Estudiante alumno=(Estudiante)entity;
		String insertSQL = "INSERT INTO estudiante (idEstudiante,dni,nombre,apellidos,titulacion,calificacion)"
				+ "VALUES ( '"+alumno.getIdEstudiante()+"','"+alumno.getDni()+", '"+alumno.getNombre()+"'', '"+alumno.getApellidos()+"', '"+alumno.getTitulacion()+"', '"+alumno.getCualificacion()+"' )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Estudiante nuevo creado");
		}else
			System.err.println("Error creando curso estudiante ");
		return resultado;
	}

	@Override
	public Object update(Object entity){
		int resultado=0;
		Estudiante alumno=(Estudiante) entity;
		String updateSQL = "UPDATE estudiante SET "
				+ "idEstudiante= '"+alumno.getIdEstudiante()+"' ,"
				+ "dni= '"+alumno.getDni()+","
				+ "nombre= '"+alumno.getNombre()+","
				+ "apellidos= '"+alumno.getApellidos()+","
				+ "titulacion= '"+alumno.getTitulacion()+","
				+ "calificacion= '"+alumno.getCualificacion()+"";

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Estudiante modificado");
		}else
			System.err.println("Error modificando estudiante ");
		return alumno;
	}

	@Override
	public int delete(Object entity) {
		int resultado=0;
		Estudiante alumno=(Estudiante)entity;
		String insertSQL = " DELETE FROM estudiante WHERE dni= '"+alumno.getDni()+"'   ";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Estudiante nuevo eliminado");
		}else
			System.err.println("Error eliminando estudiante ");
		return resultado;
	}	
}