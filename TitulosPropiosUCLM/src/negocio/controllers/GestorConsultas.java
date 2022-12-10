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
	public Collection<CursoPropio> consultarEstadoCursos(EstadoCurso estadoCurso) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> estados = null;
		try {
			
				estados = cursoPropioDAO.listarCursosPorEstado(estadoCurso);
				System.out.println("Error al introducir los datos para consultar los estados de los cursos");
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
			//filtro para poner fechas realistas
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
		//si está vacío o no
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