package negocio.controllers;

import java.util.Date;

import negocio.entities.*;
import persistencia.CursoPropioDAO;
import presentacion.MainTesting;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso(String nombre, Date fechaInicio, Date fechaFin, int eCTS, double tasaMatricula, int edicion,  String dniDirector, String dniSecretario, EstadoCurso estado, TipoCurso tipo, String centro) {
		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor director = gestorProfesor.seleccionarProfesor(dniDirector);
		Profesor secretario = gestorProfesor.seleccionarProfesor(dniSecretario);
		
		CursoPropio nuevoCurso = new CursoPropio(nombre, fechaInicio, fechaFin, eCTS, tasaMatricula, edicion, director, secretario, estado, tipo, centro);
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();	
		
		cursoPropioDAO.crearNuevoCurso(nuevoCurso);
		return nuevoCurso;
	}

	public void editarPropuestaCurso(CursoPropio curso) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		cursoPropioDAO.editarCurso(curso);		
	}

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
}