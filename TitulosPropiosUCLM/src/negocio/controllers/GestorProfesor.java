package negocio.controllers;

import negocio.entities.*;
import persistencia.*;

public class GestorProfesor {

	public Profesor seleccionarProfesor(String dni) {	

		if(dni.equals("") || dni.length()>9 ) {
			return null;
		}
		ProfesorDAO profesorDAO= new ProfesorDAO();
		return profesorDAO.seleccionarProfesor(dni);

	}
}
