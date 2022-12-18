package negocio.controllers;

import negocio.entities.*;
import persistencia.*;
import presentacion.MainTesting;

public class GestorProfesor {

public Profesor seleccionarProfesor(String dni) {	
		ProfesorDAO profesorDAO= new ProfesorDAO();
		return profesorDAO.seleccionarProfesor(dni);
	}
}
