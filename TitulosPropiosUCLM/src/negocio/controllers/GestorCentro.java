package negocio.controllers;

import negocio.entities.Centro;
import persistencia.CentroDAO;

public class GestorCentro {

	public Centro seleccionarCentro(String id) throws Exception {	
		CentroDAO centroDAO= new CentroDAO();	
		return centroDAO.seleccionarCentro(id);
	}
}
