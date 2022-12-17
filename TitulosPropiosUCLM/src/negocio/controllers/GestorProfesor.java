package negocio.controllers;

import negocio.entities.*;
import persistencia.*;
import presentacion.MainTesting;

public class GestorProfesor {

public Profesor seleccionarProfesor(String dni) {	
		ProfesorDAO profesorDAO= new ProfesorDAO();

		try {
			return profesorDAO.seleccionarProfesor(dni);
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al seleccionar Profesor");
			return null;
		}
	}
}
