package negocio.controllers;

import java.util.*;


import negocio.entities.*;
import persistencia.CursoPropioDAO;
import presentacion.Main_testing;
import negocio.entities.*;
public class GestorConsultas {
	private CursoPropioDAO cursoPropioDAO;
	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public double consultarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		double ingresos = 0;
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		 try {
			ingresos = cursoPropioDAO.listarIngresos(tipo, fechaInicio, fechaFin);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al consulatar ingresos");

		}
		return ingresos;
	}

	/**
	 * 
	 * @param estadoCurso
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<CursoPropio> consultarEstadoCursos(EstadoCurso estadoCurso, Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> estados = null;
		try {
			estados = cursoPropioDAO.listarCursosPorEstado(estadoCurso, fechaInicio, fechaFin);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al consular por estados");

		}
		return estados; 
		
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
		try {
			ediciones = cursoPropioDAO.listarEdicionesCursos(fechaInicio, fechaFin);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar por ediciones");

		}
		return ediciones;
	}

}