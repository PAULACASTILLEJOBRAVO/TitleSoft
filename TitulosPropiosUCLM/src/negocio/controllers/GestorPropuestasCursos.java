package negocio.controllers;

import java.sql.SQLException;
import java.util.Date;

import negocio.entities.*;
import persistencia.CursoPropioDAO;
import persistencia.MateriaDAO;
import presentacion.Main_testing;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso(String nombre, Date fechaInicio, Date fechaFin, int ECTS, double tasaMatricula, int edicion,  String dniDirector, String dniSecretario, EstadoCurso estado, TipoCurso tipo, String centro) {
		
		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor director = gestorProfesor.seleccionarProfesor(dniDirector);
		Profesor secretario = gestorProfesor.seleccionarProfesor(dniSecretario);
		
		CursoPropio nuevoCurso = new CursoPropio(nombre, fechaInicio, fechaFin, ECTS, tasaMatricula, edicion, director, secretario, estado, tipo, centro);
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		
		try {
			cursoPropioDAO.crearNuevoCurso(nuevoCurso);
		}catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al realizar propuesta");
		}
		
		return nuevoCurso;
		
	}

	/**
	 * 
	 * @param curso
	 */
	public void editarPropuestaCurso(CursoPropio curso) {
		
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		
		try {
			cursoPropioDAO.editarCurso(curso);
		}catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al editar curso");

		}
		
	}

	/**
	 * 
	 * @param curso
	 */
	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		
		EstadoCurso estado;
		
		EstadoCurso valido = EstadoCurso.VALIDADO;	
		EstadoCurso rechazado = EstadoCurso.PROPUESTA_RECHAZADA;
		
		if(valido == curso.getEstado()) {
			estado = rechazado;
		}else {
			estado = valido;
		}
		
		curso.setEstado(estado);
		
		return estado;
	}

	/**
	 * 
	 * @param curso
	 */
	public void altaCursoAprobado(CursoPropio curso) {
		if(curso.getEstado().equals(EstadoCurso.VALIDADO)) {
			
		}
	}
	
	public void realizarMateriasCurso(Materia materia, CursoPropio curso) throws ClassNotFoundException, SQLException {
		MateriaDAO materiaDAO = new MateriaDAO();
		materiaDAO.vincularCursoMateria(materia, curso);
	}
}