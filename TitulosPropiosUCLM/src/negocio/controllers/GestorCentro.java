package negocio.controllers;

import negocio.entities.Centro;
import persistencia.CentroDAO;

public class GestorCentro {

	public Centro seleccionarCentro(String id){
		int n = Integer.parseInt(id);
		if(n >=0) {
			CentroDAO centroDAO= new CentroDAO();	
			return centroDAO.seleccionarCentro(id);
		}
		return null;
	}
}
