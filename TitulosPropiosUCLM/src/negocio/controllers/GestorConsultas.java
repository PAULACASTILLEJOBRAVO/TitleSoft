package negocio.controllers;

import java.text.SimpleDateFormat;
import java.util.*;
import presentacion.MainTesting;
import negocio.entities.*;
import persistencia.CursoPropioDAO;
public class GestorConsultas { 

	public static double consultarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		double ingresos = -1;
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();


			 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
			 SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM"); 
		     String anioInicio = getYearFormat.format(fechaInicio);
		     String mesInicio = getMonthFormat.format(fechaInicio);

		     String anioFin = getYearFormat.format(fechaFin);
		     String mesFin = getMonthFormat.format(fechaInicio);
		    
		     if(Integer.parseInt(anioInicio)>= 2000 && Integer.parseInt(anioFin)>= 2000 && Integer.parseInt(anioFin)>= Integer.parseInt(anioInicio)
		    		 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesInicio) != 8 && Integer.parseInt(mesFin) != 8 && Integer.parseInt(mesFin) != 7
		    		 && Integer.parseInt(mesInicio)<= 12 && Integer.parseInt(mesFin)<=12){
		    	 	
		    	 ingresos = cursoPropioDAO.listarIngresos(tipo, fechaInicio, fechaFin);

		    	 System.out.println("11111111111111111111111111111111111111111 ingresos: "+ ingresos);
		     }
				return ingresos;
	}

	public Collection<CursoPropio> consultarCursosPropuestos(EstadoCurso estadoCurso) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> estados = null;
		estados = cursoPropioDAO.listarCursosEstadoPropuesto(estadoCurso);
		return estados; 
	}

	public static Collection<CursoPropio> listarCursosEstados(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
			
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
			 SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM"); 
		     String anioInicio = getYearFormat.format(fechaInicio);
		     String mesInicio = getMonthFormat.format(fechaInicio);

		     String anioFin = getYearFormat.format(fechaFin);
		     String mesFin = getMonthFormat.format(fechaInicio);

		     if(Integer.parseInt(anioInicio)>= 2000 && Integer.parseInt(anioFin)>= 2000 && Integer.parseInt(anioFin)>= Integer.parseInt(anioInicio)
		    		 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesInicio) != 8 && Integer.parseInt(mesFin) != 8 && Integer.parseInt(mesFin) != 7
		    		 && Integer.parseInt(mesInicio)<= 12 && Integer.parseInt(mesFin)<=12){
			ediciones = cursoPropioDAO.listarCursosEstados(fechaInicio, fechaFin);
		     }
		return ediciones;
	}
	
	public Collection<CursoPropio> listarCursosRechazadosYPropuestos(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
			
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
			 SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM"); 
		     String anioInicio = getYearFormat.format(fechaInicio);
		     String mesInicio = getMonthFormat.format(fechaInicio);

		     String anioFin = getYearFormat.format(fechaFin);
		     String mesFin = getMonthFormat.format(fechaInicio);

		     if(Integer.parseInt(anioInicio)>= 2000 && Integer.parseInt(anioFin)>= 2000 && Integer.parseInt(anioFin)>= Integer.parseInt(anioInicio)
		    		 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesInicio) != 8 && Integer.parseInt(mesFin) != 8 && Integer.parseInt(mesFin) != 7
		    		 && Integer.parseInt(mesInicio)<= 12 && Integer.parseInt(mesFin)<=12){

			ediciones = cursoPropioDAO.listarCursosRechazadosYPropuestos(fechaInicio, fechaFin);
		     }
		return ediciones;
	}

	public Collection<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
		
			 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
			 SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM");

		     String anioInicio = getYearFormat.format(fechaInicio);
		     String mesInicio = getMonthFormat.format(fechaInicio);


		     String anioFin = getYearFormat.format(fechaFin);
		     String mesFin = getMonthFormat.format(fechaFin);

		     if(Integer.parseInt(anioInicio)>= 2000 && Integer.parseInt(anioFin)>= 2000 &&  Integer.parseInt(anioFin)>= Integer.parseInt(anioInicio)
		    		 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesInicio) != 8 && Integer.parseInt(mesFin) != 8 && Integer.parseInt(mesFin) != 7
		    		 && Integer.parseInt(mesInicio)<= 12 && Integer.parseInt(mesFin)<=12){

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

	public int idCurso(CursoPropio curso) {
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		return cursoDAO.seleccinarID(curso);
	}
}