package negocio.controllers;

import java.util.Date;

import negocio.entities.*;
import persistencia.CursoPropioDAO;
import presentacion.MainTesting;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso(String nombre, Date fechaInicio, Date fechaFin, int eCTS, double tasaMatricula, int edicion,  String dniDirector, String dniSecretario, EstadoCurso estado, TipoCurso tipo, String centro) {

		/*
		 * no se que controlador mete para las fechas y para el enunm
		 */
		if(  (nombre.equals("")) ||
				( eCTS<0) ||
				(tasaMatricula<0) ||
				(edicion<0) ||
				(dniDirector.equals("") || dniDirector.length()>9) ||
				(dniSecretario.equals("") || dniSecretario.length()>9 ) ||
				(centro.equals(""))) {

			return null;
		}


		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor director = gestorProfesor.seleccionarProfesor(dniDirector);
		Profesor secretario = gestorProfesor.seleccionarProfesor(dniSecretario);

		CursoPropio nuevoCurso = new CursoPropio(nombre, fechaInicio, fechaFin, eCTS, tasaMatricula, edicion, director, secretario, estado, tipo, centro);
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();	

		cursoPropioDAO.crearNuevoCurso(nuevoCurso);
		return nuevoCurso;

	}

	public void editarPropuestaCurso(CursoPropio curso) {

		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		cursoPropioDAO.editarCurso(curso);		

	}
	
}