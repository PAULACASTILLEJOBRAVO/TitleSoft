package negocio.controllers;

import negocio.entities.*;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso() {
		// TODO - implement GestorPropuestasCursos.realizarPropuestaCurso
		throw new UnsupportedOperationException();
		
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
				
		EstadoCurso impartido = EstadoCurso.EN_IMPARTIZICION;
				
		EstadoCurso matriculado = EstadoCurso.EN_MATRICULACION;
		
		EstadoCurso rechazado = EstadoCurso.PROPUESTA_RECHAZADA;
		
		EstadoCurso propuesto = EstadoCurso.PROPUESTO;
		
		EstadoCurso terminado = EstadoCurso.TERMINADO;
		
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