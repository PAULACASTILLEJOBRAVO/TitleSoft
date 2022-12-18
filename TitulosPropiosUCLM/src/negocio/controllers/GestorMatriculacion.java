package negocio.controllers;

import java.sql.Date;

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
			MainTesting.escribirLog(MainTesting.ERROR,"id no valido");
		}
		return matriculaDAO.seleccionarMatricula(id);
	}
}