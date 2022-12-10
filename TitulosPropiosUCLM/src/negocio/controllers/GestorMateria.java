package negocio.controllers;

import java.util.Collection;

import negocio.entities.Materia;
import persistencia.MateriaDAO;

public class GestorMateria {

	public Materia seleccionarMaterias(String id) throws Exception {
		
		MateriaDAO materiaDAO=new MateriaDAO();
		
		return materiaDAO.seleccionarMateria(id);
		
	}

	
}
