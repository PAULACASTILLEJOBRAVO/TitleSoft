package negocio.controllers;

import java.util.*;

import negocio.entities.*;
import persistencia;
public class GestorConsultas {

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> consultarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.consultarIngresos
		throw new UnsupportedOperationException();
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		List ingresos = new ArrayList (cursoPropioDAO.listarIngersos(tipo, fechaInicio, fechaFin));
		return ingresos;
	}

	/**
	 * 
	 * @param estadoCurso
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> consultarEstadoCursos(EstadoCurso estadoCurso, Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.consultarEstadoCursos
		throw new UnsupportedOperationException();
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		List estados = new ArrayList (cursoPropioDAO.listarCursosPorEstado(estadoCurso, fechaInicio, fechaFin));
		return estados; 
		
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.listarEdicionesCursos
		throw new UnsupportedOperationException();
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		List ediciones = new ArrayList (cursoPropioDAO.listarEdicionesCursos(fechaInicio, fechaFin));
		return ediciones;
	}

}