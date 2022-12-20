package negocio.controllers;

import negocio.entities.Centro;
import persistencia.CentroDAO;

public class GestorCentro {


	public static Centro seleccionarCentro(String id){
		Centro centro = null;
		if(id == "UCLM" || id == "UCM") {
			CentroDAO centroDAO= new CentroDAO();
			centro = centroDAO.seleccionarCentro(id);
			System.out.println(centro);
			return centro;
		}
		return null;  
	}
}
