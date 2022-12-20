package negocio.controllers;

import java.text.SimpleDateFormat;
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
			MainTesting.escribirLog(MainTesting.ERROR,"id introducido no valido para la seleccion del curso");
			return null;
		}

		return materiaDAO.seleccionarMateria(id);
	}

	public Materia realizarMateria(String dniProfesorResponsable, String nombre, double horas, Date fechaInicio, Date fechaFin, CursoPropio curso) {

		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor profesorResponsable  = gestorProfesor.seleccionarProfesor(dniProfesorResponsable);
		GestorConsultas gestorConsultas = new GestorConsultas();

		Materia materiaNueva = null;
		MateriaDAO materiaDAO = new MateriaDAO();


		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM");

		String anioInicio = getYearFormat.format(fechaInicio);
		String mesInicio = getMonthFormat.format(fechaInicio);


		String anioFin = getYearFormat.format(fechaFin);
		String mesFin = getMonthFormat.format(fechaFin);

		Date fechaActual = new Date();
		String anioActual = getYearFormat.format(fechaActual);

		
		if(dniProfesorResponsable.length()<= 9 && nombre.length() < 20 && Integer.parseInt(anioInicio)>= 2000 && Integer.parseInt(anioFin)>= 2000 && Integer.parseInt(anioFin)>= Integer.parseInt(anioInicio)
				&& Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesInicio) != 8 && Integer.parseInt(mesFin) != 8 && Integer.parseInt(mesFin) != 7
				&& Integer.parseInt(mesInicio)<= 12 && Integer.parseInt(mesFin)<=12){
			materiaNueva = new Materia(profesorResponsable, nombre, horas, fechaInicio, fechaFin);
			materiaDAO.crearMateria(materiaNueva);
			int idcurso = gestorConsultas.idCurso(curso);
			int idMateria = idMateria(materiaNueva);
			materiaDAO.vincularCursoMateria(idMateria, idcurso);
			return materiaNueva;
		}


		return materiaNueva;
	}

	public int idMateria(Materia materia) {
		MateriaDAO materiaDAO = new MateriaDAO();
		return materiaDAO.seleccionarId(materia);
	}
}
