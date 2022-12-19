package negocio.controllers;

import java.text.SimpleDateFormat;
import java.util.*;
import presentacion.MainTesting;
import negocio.entities.*;
import persistencia.CursoPropioDAO;
public class GestorConsultas {

	public double consultarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		double ingresos = 0;
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();


			 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
			 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm"); 
		     String anioInicio = getYearFormat.format(fechaInicio);
		     String mesInicio = getMonthFormat.format(fechaInicio);

		     String anioFin = getYearFormat.format(fechaFin);
		     String mesFin = getMonthFormat.format(fechaInicio);
		     Date fechaActual = new Date();
		     String anioActual = getYearFormat.format(fechaActual);

		     if(Integer.parseInt(anioInicio)>= Integer.parseInt(anioActual) && Integer.parseInt(anioFin)>= Integer.parseInt(anioActual)
		    		 && Integer.parseInt(mesInicio) != 6 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesFin) != 6 && Integer.parseInt(mesFin) != 7
		    		 && Integer.parseInt(mesInicio)<= 12 && Integer.parseInt(mesFin)<=12 ){

		    	 ingresos = cursoPropioDAO.listarIngresos(tipo, fechaInicio, fechaFin);
		     }
				return ingresos;
	}

	public Collection<CursoPropio> consultarCursosPropuestos(EstadoCurso estadoCurso) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> estados = null;
		
		estados = cursoPropioDAO.listarCursosEstadoPropuesto(estadoCurso);
		return estados; 
	}

	public Collection<CursoPropio> listarCursosEstados(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
			
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

			ediciones = cursoPropioDAO.listarCursosEstados(fechaInicio, fechaFin);
		     }
		return ediciones;
	}

	public Collection<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
		
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
		return ediciones;
	}


	public CursoPropio seleccionarCurso(String id) {
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			MainTesting.escribirLog(MainTesting.ERROR, "id introducido no válido para la selección del curso");
		}
		return cursoDAO.seleccionarCurso(id);
	}

	public CursoPropio actualizarCurso(CursoPropio curso) {	
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		return cursoDAO.editarCurso(curso);
	}

	public Collection<CursoPropio> cursosPorCentro(String id) {
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			MainTesting.escribirLog(MainTesting.ERROR,"id introducido no válido para la selección del curso por centro");
		}
		return cursoDAO.cursosPorCentro(id);
	}

	public int idCurso(CursoPropio curso) {
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		return cursoDAO.seleccinarID(curso);
	}
}