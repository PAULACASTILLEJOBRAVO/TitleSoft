package negocio.controllers;
import negocio.entities.*;
import persistencia.*;

public class GestorMatriculacion {

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public void realizarMatriculacion(CursoPropio curso, Estudiante estudiante) {
		
		Matricula matriculaNuevoIngreso = new Matricula(estudiante, curso, null, null, false);
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
		
		realizarPagoTarjeta(curso, estudiante);
		
		realizarPagoTransferencia(curso, estudiante);
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	private void realizarPagoTarjeta(CursoPropio curso, Estudiante estudiante) {
		ModoPago TargetaCredito = ModoPago.TARJETA_CREDITO;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	private void realizarPagoTransferencia(CursoPropio curso, Estudiante estudiante) {
		ModoPago Trasferencia = ModoPago.TRANSFERENCIA;
		throw new UnsupportedOperationException();
	}



}