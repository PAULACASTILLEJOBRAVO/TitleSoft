package negocio.controllers;

import java.sql.Date;
import java.sql.SQLException;

import negocio.entities.*;
import persistencia.*;
import presentacion.Main_testing;

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
			Main_testing.escribirLog(Main_testing.error,"Error al realizar matricula");
		}catch (ClassNotFoundException e) {
			Main_testing.escribirLog(Main_testing.error,"Error al no encontrar la clase en el sistema");
		}
	}

	public Matricula seleccionarMatricula(String id) {

		MatriculaDAO matriculaDAO=new MatriculaDAO();

		try {
			return matriculaDAO.seleccionarMatricula(id);

		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al seleccionar matricula");
			return null;
		}
		
	}
}