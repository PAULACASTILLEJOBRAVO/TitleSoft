package negocio.controllers;

import java.sql.Date;

import negocio.entities.*;
import persistencia.*;
import presentacion.Main_testing;

public class GestorMatriculacion {

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public void realizarMatriculacion(String curso, ModoPago tipo,Date fecha,boolean pagado) {
		
		
		Matricula matriculaNuevoIngreso = new Matricula(curso, tipo, fecha, pagado);
		MatriculaDAO matriculaDAO= new MatriculaDAO();
		
		try {
			matriculaDAO.crearMatricula(matriculaNuevoIngreso);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

	public Matricula seleccionarUsuario(String id) {

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
	public void realizarPagoMatricula(CursoPropio curso, Estudiante estudiante, String id) {
		
		Matricula matricula = new Matricula(id, null, null, false);
		
		if(matricula.isPagado()) {
			realizarPagoTarjeta(curso, estudiante);
		
			realizarPagoTransferencia(curso, estudiante);
		
			throw new UnsupportedOperationException();
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