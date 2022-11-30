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
	public void realizarMatriculacion(String curso, String alumno, ModoPago tipo,Date fecha,boolean pagado) throws Exception {
		
		
		Matricula matriculaNuevoIngreso = new Matricula(curso, alumno, tipo, fecha, pagado);
		MatriculaDAO matriculaDAO= new MatriculaDAO();
		
		try {
			matriculaDAO.crearMatricula(matriculaNuevoIngreso);
		} catch (SQLException e) {
			Main_testing.escribirLog(Main_testing.error,"Error a realizar matricula");
		}catch (ClassNotFoundException e) {
			Main_testing.escribirLog(Main_testing.error,"Error a realizar matricula");
		}
	}

	public Matricula seleccionarMatricula(String id) {

		MatriculaDAO matriculaDAO=new MatriculaDAO();

		try {
			return (Matricula) matriculaDAO.seleccionarMatricula(id);

		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al seleccionar matricula");
			return null;
		}
		

	}

	
	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public void realizarPagoMatricula(CursoPropio curso, Estudiante estudiante, int id) {
		
		Matricula matricula = new Matricula(id,null, null, null, null, false);
		
		if(matricula.isPagado()) {
			realizarPagoTarjeta(curso, estudiante);
		
			realizarPagoTransferencia(curso, estudiante);
		
			
		}
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	private String realizarPagoTarjeta(CursoPropio curso, Estudiante estudiante) {
		ModoPago targetaCredito = ModoPago.TARJETA_CREDITO;
		return targetaCredito.name();
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	private String realizarPagoTransferencia(CursoPropio curso, Estudiante estudiante) {
		ModoPago trasferencia = ModoPago.TRANSFERENCIA;
		return trasferencia.name();
	}

}