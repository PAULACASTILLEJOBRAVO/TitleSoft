package negocio.controllers;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import negocio.entities.CursoPropio;
import negocio.entities.Materia;
import negocio.entities.Profesor;
import persistencia.CursoPropioDAO;
import persistencia.MateriaDAO;
import presentacion.Main_testing;

public class GestorMateria {

	public Materia seleccionarMaterias(String id) throws Exception {
		
		MateriaDAO materiaDAO=new MateriaDAO();
		
		return materiaDAO.seleccionarMateria(id);
		
	}

	
	public Vector<Object> seleccionarMateriaCurso(String id) throws Exception{
		
		MateriaDAO materiaDAO=new MateriaDAO();
		return materiaDAO.listarMateriaCurso(id);
		
	}
	
	public Materia realizarMateria(String dniProfesorResponsable, String nombre, double horas, Date fechaInicio, Date fechaFin, CursoPropio curso) {
		
		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor profesorResponsable  = gestorProfesor.seleccionarProfesor(dniProfesorResponsable);
		GestorConsultas gestorConsultas = new GestorConsultas();
		
		Materia materiaNueva = new Materia(profesorResponsable, nombre, horas, fechaInicio, fechaFin);
		MateriaDAO materiaDAO = new MateriaDAO();
		
		try {
			materiaDAO.crearMateria(materiaNueva);
			int Idcurso = gestorConsultas.idCurso(curso);
			int IdMateria = idMateria(materiaNueva);
			materiaDAO.vincularCursoMateria(IdMateria, Idcurso);
		}catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al realizar propuesta");
		}	
		
		return materiaNueva;
		
	}

	public int idMateria(Materia materia) throws SQLException {
		
		MateriaDAO materiaDAO = new MateriaDAO();
		return materiaDAO.seleccionarId(materia);
	}
}
