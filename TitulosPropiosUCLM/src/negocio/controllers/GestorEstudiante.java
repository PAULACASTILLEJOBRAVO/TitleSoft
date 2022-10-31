package negocio.controllers;

import java.util.Collection;

import negocio.entities.*;
import persistencia.*;

public class GestorEstudiante {

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public int introducirEstudiante(Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.crearEstudiante(estudianteNuevo);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}
	
	public Estudiante selecionarEstudiante(Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.seleccionarEstudiante(estudianteNuevo);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}
	
	public Estudiante actualizarEstudiante(Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.editarEstudiante(estudianteNuevo);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}
	
	public int eliminarEstudiante(Collection<Matricula> matriculas, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		
		Estudiante estudianteNuevo=new Estudiante(matriculas, cualificacion, cualificacion, cualificacion, cualificacion, cualificacion);
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.eliminarEstudiante(estudianteNuevo);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}
	
	
	public Collection<Estudiante> consultarEstudianteTitulacion(String titulacion) {
		
		
		EstudianteDAO estudianteDAO=new EstudianteDAO();
		
		try {
			return estudianteDAO.listarEstudianteTitulacion(titulacion);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}
	
	
	
	
	
	
	
}
