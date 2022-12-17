package negocio.controllers;

import java.sql.Date;
import java.sql.SQLException;

import negocio.entities.*;
import persistencia.*;
import presentacion.MainTesting;

public class GestorMatriculacion {

	public void realizarMatriculacion(String curso, String alumno, ModoPago tipo,Date fecha,boolean pagado){
		Matricula matriculaNuevoIngreso = new Matricula(curso, alumno, tipo, fecha, pagado);
		MatriculaDAO matriculaDAO= new MatriculaDAO();
		
		matriculaDAO.crearMatricula(matriculaNuevoIngreso);
	}

	public static Matricula seleccionarMatricula(String id) {
		MatriculaDAO matriculaDAO=new MatriculaDAO();

		int n = Integer.parseInt(id);
		if(n <0) {
			System.out.println("id no valido");
		}else {
			System.out.println("entra por el if");
			return matriculaDAO.seleccionarMatricula(id);
		}
		return null;
	}
}