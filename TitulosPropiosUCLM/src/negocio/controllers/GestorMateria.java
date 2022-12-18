package negocio.controllers;

import java.util.Date;

import negocio.entities.CursoPropio;
import negocio.entities.Materia;
import negocio.entities.Profesor;
import persistencia.MateriaDAO;
import presentacion.MainTesting;

public class GestorMateria {

	public Materia seleccionarMaterias(String id) {
		MateriaDAO materiaDAO=new MateriaDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			MainTesting.escribirLog(MainTesting.ERROR,"id introducido no válido para la selección del curso");
		}
		return materiaDAO.seleccionarMateria(id);
	}
	
	public Materia realizarMateria(String dniProfesorResponsable, String nombre, double horas, Date fechaInicio, Date fechaFin, CursoPropio curso) {
		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor profesorResponsable  = gestorProfesor.seleccionarProfesor(dniProfesorResponsable);
		GestorConsultas gestorConsultas = new GestorConsultas();
		
		Materia materiaNueva = new Materia(profesorResponsable, nombre, horas, fechaInicio, fechaFin);
		MateriaDAO materiaDAO = new MateriaDAO();
		
		materiaDAO.crearMateria(materiaNueva);
		int idcurso = gestorConsultas.idCurso(curso);
		int idMateria = idMateria(materiaNueva);
		materiaDAO.vincularCursoMateria(idMateria, idcurso);
		return materiaNueva;
	}

	public int idMateria(Materia materia) {
		MateriaDAO materiaDAO = new MateriaDAO();
		return materiaDAO.seleccionarId(materia);
	}
}
