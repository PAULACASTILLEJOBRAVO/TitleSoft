package negocio.controllers;

import java.util.Collection;

import negocio.entities.Materia;
import persistencia.MateriaDAO;

public class GestorMateria {

	
	
	public Materia seleccionarMaterias(String id) throws Exception {
		
		MateriaDAO materiaDAO=new MateriaDAO();
		int n = Integer.parseInt(id);
		if(n<0) {
			System.out.println("id introducido no válido para la selección del curso");
		}
		
		return materiaDAO.seleccionarMateria(id);
		
	}
//	
//	public Collection<Materia> seleccionarMateriaCurso(String id){
//		
//		MateriaDAO materiaDAO=new MateriaDAO();
//		return materiaDAO.listarMateriaCurso(id);
//		
//	}
	
}
