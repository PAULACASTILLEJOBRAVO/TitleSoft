package negocio.controllers;

import java.sql.SQLException;
import java.util.Date;

import negocio.entities.CursoPropio;
import negocio.entities.Materia;
import negocio.entities.Profesor;
import persistencia.MateriaDAO;
import presentacion.MainTesting;

public class GestorMateria {

	public Materia seleccionarMaterias(String id) throws Exception {
		
		MateriaDAO materiaDAO=new MateriaDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			System.out.println("id introducido no válido para la selección del curso");
		}
		
		return materiaDAO.seleccionarMateria(id);
		
	}
	
	public Materia realizarMateria(String dniProfesorResponsable, String nombre, double horas, Date fechaInicio, Date fechaFin, CursoPropio curso) {
		
		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor profesorResponsable  = gestorProfesor.seleccionarProfesor(dniProfesorResponsable);
		GestorConsultas gestorConsultas = new GestorConsultas();
		
		Materia materiaNueva = new Materia(profesorResponsable, nombre, horas, fechaInicio, fechaFin);
		MateriaDAO materiaDAO = new MateriaDAO();
		
		try {
			materiaDAO.crearMateria(materiaNueva);
			int idcurso = gestorConsultas.idCurso(curso);
			int idMateria = idMateria(materiaNueva);
			materiaDAO.vincularCursoMateria(idMateria, idcurso);
		}catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al realizar propuesta");
		}	
		
		return materiaNueva;
		
	}

	public int idMateria(Materia materia) throws SQLException {
		
		MateriaDAO materiaDAO = new MateriaDAO();
		return materiaDAO.seleccionarId(materia);
	}
}
