package negocio.controllers;

import negocio.entities.*;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso() {
		
		CursoPropio nuevoCurso = new CursoPropio(null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, 0);
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		
		try {
			cursoPropioDAO.crearNuevoCurso(nuevoCurso);
		}catch (Exception e) {
			throw new UnsupportedOperationException();
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
			throw new UnsupportedOperationException();
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
			throw new UnsupportedOperationException();
		}
	}

}