package negocio.controllers;
import org.apache.derby.iapi.store.raw.Transaction;

import negocio.entities.*;
import persistencia.*;

public class GestorMatriculacion {

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public void realizarMatriculacion(CursoPropio curso, Estudiante estudiante) {
		
		Matricula matriculaNuevoIngreso = new Matricula(estudiante, curso, null, null, false, 0);
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
	public void realizarPagoMatricula(CursoPropio curso, Estudiante estudiante) {
		
		if(.setModoPago()) {
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