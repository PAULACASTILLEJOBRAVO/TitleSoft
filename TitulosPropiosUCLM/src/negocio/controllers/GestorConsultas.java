package negocio.controllers;

import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.util.*;


import negocio.entities.*;
import persistencia.CursoPropioDAO;
import presentacion.MainTesting;
public class GestorConsultas {
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
			 
			 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
			 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm"); 
		     String anioInicio = getYearFormat.format(fechaInicio);
		     String mesInicio = getMonthFormat.format(fechaInicio);
		     
		     String anioFin = getYearFormat.format(fechaFin);
		     String mesFin = getMonthFormat.format(fechaInicio);
		     Date fechaActual = new Date();
		     String anioActual = getYearFormat.format(fechaActual);
		     
		     if(Integer.parseInt(anioInicio)< Integer.parseInt(anioActual) && Integer.parseInt(anioFin)< Integer.parseInt(anioActual)
		    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7){
		    	 
		    	 ingresos = cursoPropioDAO.listarIngresos(tipo, fechaInicio, fechaFin);
		     }
			
			 
			 
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al consulatar ingresos");

		}
		return ingresos;
	}

	/**
	 * 
	 * @param estadoCurso
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<CursoPropio> consultarCursosPropuestos(EstadoCurso estadoCurso) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> estados = null;
		try {
			if(estadoCurso != null) {
				estados = cursoPropioDAO.listarCursosEstadoPropuesto(estadoCurso);
				System.out.println("Error al introducir los datos para consultar los estados de los cursos");
			}
			estados = cursoPropioDAO.listarCursosEstadoPropuesto(estadoCurso);
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al consular por estados");

		}
		return estados; 
		
	}
	
	public Collection<CursoPropio> listarCursosEstados(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
		try {
			ediciones = cursoPropioDAO.listarCursosEstados(fechaInicio, fechaFin);
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al consultar por ediciones");

		}
		return ediciones;
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
			 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
			 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm");
			 
		     String anioInicio = getYearFormat.format(fechaInicio);
		     String mesInicio = getMonthFormat.format(fechaInicio);

		     
		     String anioFin = getYearFormat.format(fechaFin);
		     String mesFin = getMonthFormat.format(fechaInicio);
		     
		     Date fechaActual = new Date();
		     String anioActual = getYearFormat.format(fechaActual);
		     
		     if(Integer.parseInt(anioInicio)< Integer.parseInt(anioActual) && Integer.parseInt(anioFin)< Integer.parseInt(anioActual)
		    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7){
		    	 
			ediciones = cursoPropioDAO.listarEdicionesCursos(fechaInicio, fechaFin);
			}
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al consultar por ediciones");

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
		if(curso !=null) {

		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		return cursoDAO.editarCurso(curso);
		}
		return null;
		
	}
	
	public Collection<CursoPropio> cursosPorCentro(String id) throws Exception{
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			System.out.println("id introducido no válido para la selección del curso por centro");
		}
		return cursoDAO.cursosPorCentro(id);
		
	}

	public int idCurso(CursoPropio curso) throws SQLException {
		if(curso !=null) {
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		return cursoDAO.seleccinarID(curso);
		}
		return -1;
		
	}
}