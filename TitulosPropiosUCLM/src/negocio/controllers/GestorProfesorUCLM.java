package negocio.controllers;

import negocio.entities.ProfesorUCLM;
import persistencia.ProfesorUCLMDAO;

public class GestorProfesorUCLM {

	
	public ProfesorUCLM seleccionarProfesor(String dni) throws Exception {
		
		ProfesorUCLMDAO profesorDAO= new ProfesorUCLMDAO();
		return (ProfesorUCLM) profesorDAO.get(dni);
		
	}
	
	
}
