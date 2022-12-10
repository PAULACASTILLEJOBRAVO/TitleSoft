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
			 if(tipo !=TipoCurso.CORTA_DURACION || tipo != TipoCurso.ESPECIALISTA || tipo != TipoCurso.EXPERTO || tipo != TipoCurso.FORMACION_AVANZADA || tipo != TipoCurso.FORMACION_CONTINUA || tipo != TipoCurso.MASTER || tipo != TipoCurso.MICROCREDENCIALES) {
					ingresos = cursoPropioDAO.listarIngresos(tipo, fechaInicio, fechaFin);
			 }
			 else {
				 System.out.println("Error al introducir los datos para consultar los ingresos");
				 return (Double) null;
			 }
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
	public Collection<CursoPropio> consultarEstadoCursos(EstadoCurso estadoCurso) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> estados = null;
		try {
			if(estadoCurso != EstadoCurso.EN_IMPARTIZICION || estadoCurso != EstadoCurso.EN_MATRICULACION || estadoCurso != EstadoCurso.PROPUESTA_RECHAZADA || estadoCurso != EstadoCurso.PROPUESTO || estadoCurso!= EstadoCurso.TERMINADO || estadoCurso!=EstadoCurso.VALIDADO) {
				estados = cursoPropioDAO.listarCursosPorEstado(estadoCurso);
			}
			else {
				System.out.println("Error al introducir los datos para consultar los estados de los cursos");
			}
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

	
	public CursoPropio seleccionarCurso(String id) throws Exception {
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			System.out.println("id introducido no válido para la selección del curso");
		}
		return cursoDAO.seleccionarCurso(id);
	}
	
	public CursoPropio actualizarCurso(CursoPropio curso) throws Exception {
		
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		return cursoDAO.editarCurso(curso);
	}
	
	public Collection<CursoPropio> cursosPorCentro(String id) throws Exception{
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			System.out.println("id introducido no válido para la selección del curso por centro");
		}
		return cursoDAO.cursosPorCentro(id);
		
	}

	
}