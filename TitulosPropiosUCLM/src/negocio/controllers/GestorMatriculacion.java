package negocio.controllers;

import java.sql.Date;
import java.sql.SQLException;

import negocio.entities.*;
import persistencia.*;
import presentacion.MainTesting;

public class GestorMatriculacion {

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 * @throws Exception 
	 */
	public void realizarMatriculacion(String curso, String alumno, ModoPago tipo,Date fecha,boolean pagado) throws ClassNotFoundException, SQLException {
		
		
		Matricula matriculaNuevoIngreso = new Matricula(curso, alumno, tipo, fecha, pagado);
		MatriculaDAO matriculaDAO= new MatriculaDAO();
		
		try {
			matriculaDAO.crearMatricula(matriculaNuevoIngreso);
		} catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al realizar matricula");
		}catch (ClassNotFoundException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al no encontrar la clase en el sistema");
		}
	}

	public static Matricula seleccionarMatricula(String id) {

		MatriculaDAO matriculaDAO=new MatriculaDAO();

		try {
			int n = Integer.parseInt(id);
			if(n <0) {
				System.out.println("id no valido");
			}
			
			else {
				System.out.println("entra por el if");
				return matriculaDAO.seleccionarMatricula(id);
			}
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al seleccionar matricula");
			return null;
		}
		return null;
		
	}
}