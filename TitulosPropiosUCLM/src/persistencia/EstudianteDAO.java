package persistencia;

import java.util.*;

import negocio.entities.*;
import presentacion.MainTesting;

public class EstudianteDAO implements AbstractEntityDAO <Object> {
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
		LinkedList<Object> resultado;
		Collection<Estudiante> alumnosEncontrados=null;
		String selectSQLEdicion= "SELECT * FROM estudiante"
				+ "WHERE titulacion = '"+titulacion+"'  ";

		resultado = GestorBD.select(selectSQLEdicion);
	
		if (!resultado.isEmpty()) {
			for (int i = 0; i <resultado.size(); i++) {
				Estudiante alumnoAux=(Estudiante) resultado.get(i);
				alumnosEncontrados.add(alumnoAux);
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error encontrando estudiantes");
		return alumnosEncontrados;
	}

	public Collection<Estudiante> listarCalificacion(double calificacion){
		LinkedList<Object> resultado;
		Collection<Estudiante> alumnosEncontrados=null;
	
		String selectSQLEdicion= "SELECT * FROM estudiante"
				+ "WHERE calificacion = '"+calificacion+"' ";
		resultado = GestorBD.select(selectSQLEdicion);
		
		if (!resultado.isEmpty()) {
			for (int i = 0; i < resultado.size(); i++) {
				Estudiante alumnoAux=(Estudiante)resultado.get(i);
				alumnosEncontrados.add(alumnoAux);
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error encontrando estudiantes");
		return alumnosEncontrados;
	}

	@Override
	public Object get(String id) {
		LinkedList<Object> resultado;
		Estudiante alumnoEncontrado=null;
		String selectSQL= "SELECT * FROM estudiante WHERE id = '"+id+"' ";

		resultado = GestorBD.select(selectSQL);
		
		if (!resultado.isEmpty()) {
			alumnoEncontrado=(Estudiante)resultado.get(0);
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar estudiante");
		return alumnoEncontrado ;
	}

	@Override
	public int insert(Object entity) {
		int resultado=0;
		Estudiante alumno=(Estudiante)entity;
		String insertSQL = "INSERT INTO estudiante (idEstudiante,dni,nombre,apellidos,titulacion,calificacion)"
				+ "VALUES ( '"+alumno.getIdEstudiante()+"','"+alumno.getDni()+", '"+alumno.getNombre()+"'', '"+alumno.getApellidos()+"', '"+alumno.getTitulacion()+"', '"+alumno.getCualificacion()+"' )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error creando curso estudiante ");
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
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error modificando estudiante ");
		return alumno;
	}

	@Override
	public int delete(Object entity) {
		int resultado=0;
		Estudiante alumno=(Estudiante)entity;
		String insertSQL = " DELETE FROM estudiante WHERE dni= '"+alumno.getDni()+"'   ";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0)
			MainTesting.escribirLog(MainTesting.ERROR, "Error eliminando estudiante ");
		return resultado;
	}	
}