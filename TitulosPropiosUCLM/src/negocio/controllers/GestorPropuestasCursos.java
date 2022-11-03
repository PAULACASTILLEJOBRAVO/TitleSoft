package negocio.controllers;

import negocio.entities.*;
import persistencia.CursoPropioDAO;
import presentacion.Main_testing;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso() {
		
		CursoPropio nuevoCurso = new CursoPropio(null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, 0);
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

}