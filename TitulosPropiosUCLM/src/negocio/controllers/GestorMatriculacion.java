package negocio.controllers;

import negocio.entities.*;
import persistencia.*;

public class GestorMatriculacion {

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public void realizarMatriculacion(CursoPropio curso, String id) {
		
		
		Matricula matriculaNuevoIngreso = new Matricula(id, null, null, false);
		MatriculaDAO matriculaDAO= new MatriculaDAO();
		
		try {
			matriculaDAO.crearMatricula(matriculaNuevoIngreso);
		} catch (Exception e) {
			throw new UnsupportedOperationException();
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