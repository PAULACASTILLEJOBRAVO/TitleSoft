package negocio.controllers;

import negocio.entities.*;
import persistencia.*;
import presentacion.Main_testing;

public class GestorProfesor {

public Profesor seleccionarProfesor(String dni) {	
		ProfesorDAO profesorDAO= new ProfesorDAO();

		try {
			return profesorDAO.seleccionarProfesor(dni);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.ERROR,"Error al seleccionar Profesor");
			return null;
		}
	}
}
