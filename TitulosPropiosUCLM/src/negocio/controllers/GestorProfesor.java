package negocio.controllers;

import negocio.entities.*;
import persistencia.*;

public class GestorProfesor {


	public void introducirProfesor(String dni,String nombre,String apellidos,boolean doctor) {

		Profesor profesor=new Profesor(dni, nombre, apellidos, doctor);
		ProfesorDAO profesorDAO= new ProfesorDAO();

		try {
			profesorDAO.crearProfesor(profesor);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public Profesor seleccionarProfesor(String dni) {

		
		ProfesorDAO profesorDAO= new ProfesorDAO();

		try {
			return (Profesor) profesorDAO.seleccionarProfesor(dni);
			
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}







}
