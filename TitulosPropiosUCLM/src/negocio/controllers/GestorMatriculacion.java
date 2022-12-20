package negocio.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import negocio.entities.*;
import persistencia.*;
import presentacion.MainTesting;

public class GestorMatriculacion {
	public static boolean realizarMatriculacion(String curso, String alumno, ModoPago tipo,Date fecha,boolean pagado){
		boolean test = false;
			Matricula matriculaNuevoIngreso = new Matricula(curso, alumno, tipo, fecha, pagado);
		MatriculaDAO matriculaDAO= new MatriculaDAO();
		 SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		 SimpleDateFormat getMonthFormat = new SimpleDateFormat("mm");

	     String anio = getYearFormat.format(fecha); 
	     String mes = getMonthFormat.format(fecha);

		if(curso.length() < 20 && curso.length() > 0 && alumno.length() < 20 && alumno.length() > 0 && Integer.parseInt(anio)>= 2000 
	    		 && Integer.parseInt(mes) != 7 && Integer.parseInt(mes) != 8
	    		 && Integer.parseInt(mes)<= 12) {
		matriculaDAO.crearMatricula(matriculaNuevoIngreso);
		test = true;
		}
		return test; 
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