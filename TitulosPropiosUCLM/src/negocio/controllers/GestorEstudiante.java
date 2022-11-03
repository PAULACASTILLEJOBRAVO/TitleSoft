package negocio.controllers;

import java.util.Collection;

import negocio.entities.*;
import persistencia.*;
import presentacion.Main_testing;

public class GestorEstudiante {

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public int introducirEstudiante(int idEstudiante,Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas,idEstudiante, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.crearEstudiante(estudianteNuevo);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al introducir estudiante");
			return 0;
		}
	}
	
	public Estudiante selecionarEstudiante(int idEstudiante,Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas,idEstudiante, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.seleccionarEstudiante(estudianteNuevo);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al seleccionar estudiante");
			return null;
		}
	}
	
	public Estudiante actualizarEstudiante(int idEstudiante,Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas,idEstudiante, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.editarEstudiante(estudianteNuevo);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al actualizar estudiante");
			return null;
		}
	}
	
	public int eliminarEstudiante(int idEstudiante,Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas,idEstudiante, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.eliminarEstudiante(estudianteNuevo);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al eliminar estudiante");
			return 0;
		}
	}
	
	
	public Collection<Estudiante> consultarEstudianteTitulacion(String titulacion) {
		
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.listarEstudianteTitulacion(titulacion);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar por titulacion");
			return null;
		}
	}
	
	
	
	
	
	
	
}
