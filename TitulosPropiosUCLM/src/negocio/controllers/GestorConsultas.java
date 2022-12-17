package negocio.controllers;

import java.util.*;

import negocio.entities.*;
import persistencia.CursoPropioDAO;
import presentacion.MainTesting;
public class GestorConsultas {

	public double consultarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		double ingresos = 0;
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();

		ingresos = cursoPropioDAO.listarIngresos(tipo, fechaInicio, fechaFin);
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
		
		ediciones = cursoPropioDAO.listarCursosEstados(fechaInicio, fechaFin);
		return ediciones;
	}
	
	public Collection<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
		
		ediciones = cursoPropioDAO.listarEdicionesCursos(fechaInicio, fechaFin);
		return ediciones;
	}

	
	public CursoPropio seleccionarCurso(String id) {
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			System.out.println("id introducido no válido para la selección del curso");
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
			System.out.println("id introducido no válido para la selección del curso por centro");
		}
		return cursoDAO.cursosPorCentro(id);
	}

	public int idCurso(CursoPropio curso) {
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		return cursoDAO.seleccinarID(curso);
	}
}