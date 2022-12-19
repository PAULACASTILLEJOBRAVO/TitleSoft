package negocio.controllers;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import negocio.entities.*;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	@SuppressWarnings("deprecation")
	public CursoPropio realizarPropuestaCurso(String nombre, Date fechaInicio, Date fechaFin, double tasaMatricula, int edicion,  String dniDirector, String dniSecretario, EstadoCurso estado, TipoCurso tipo, String centro) {

		/*
		 * no se que controlador mete para las fechas y para el enunm
		 */
		
		//hacer los credenciales
		int eCTS=0;
		
		SecureRandom random = new SecureRandom();
		int numeroAleatorioMaster = random.nextInt(3);
		int numeroAleatorioEspecialista = random.nextInt(2);
		int numeroAleatorioExperto = random.nextInt(15,29);
		int numeroAleatorioFormacioAvanzada = random.nextInt(15,30);
		int numeroAleatorioFormacioContinua = random.nextInt(3,14);
		int numeroAleatorioMicrocredenciales = random.nextInt(2,14);
		
		if(tipo == TipoCurso.MASTER && numeroAleatorioMaster == 0) {
			eCTS = 60;
		}else if(tipo == TipoCurso.MASTER && numeroAleatorioMaster == 1) {
			eCTS = 90;
		}else if(tipo == TipoCurso.MASTER && numeroAleatorioMaster == 2) {
			eCTS = 120;
		}else if(tipo == TipoCurso.ESPECIALISTA) {
			if(0==numeroAleatorioEspecialista ) {
				eCTS=30;
			}else if(numeroAleatorioEspecialista==1) {
				eCTS=59;
			}
		}else if(tipo == TipoCurso.EXPERTO && 15<=numeroAleatorioExperto && numeroAleatorioExperto<=29) {
			eCTS=numeroAleatorioExperto;
		}else if(tipo == TipoCurso.FORMACION_AVANZADA && 15<=numeroAleatorioFormacioAvanzada && numeroAleatorioFormacioAvanzada<=30) {
			eCTS=numeroAleatorioFormacioAvanzada;
		}else if(tipo == TipoCurso.FORMACION_CONTINUA && 3<=numeroAleatorioFormacioContinua && numeroAleatorioFormacioContinua<=14) {
			eCTS=numeroAleatorioFormacioContinua;
		}else if(tipo == TipoCurso.MICROCREDENCIALES && 2<=numeroAleatorioMicrocredenciales && numeroAleatorioMicrocredenciales<=14) {
			eCTS=numeroAleatorioMicrocredenciales;
		}else if(tipo == TipoCurso.CORTA_DURACION && 2<=numeroAleatorioExperto) {
			eCTS=numeroAleatorioExperto;
		}
		
		if(  (nombre.equals("")) ||
				(tasaMatricula<0) ||
				(edicion<0) ||
				(dniDirector.equals("") || dniDirector.length()>9) ||
				(dniSecretario.equals("") || dniSecretario.length()>9 ) ||
				(centro.equals(""))) {

			return null;
		}


		GestorProfesor gestorProfesor = new GestorProfesor();
		Profesor director = gestorProfesor.seleccionarProfesor(dniDirector);
		Profesor secretario = gestorProfesor.seleccionarProfesor(dniSecretario);

		CursoPropio nuevoCurso = new CursoPropio(nombre, fechaInicio, fechaFin, eCTS, tasaMatricula, edicion, director, secretario, estado, tipo, centro);
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();	

		cursoPropioDAO.crearNuevoCurso(nuevoCurso);
		return nuevoCurso;

	}

	public void editarPropuestaCurso(CursoPropio curso) {

		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		cursoPropioDAO.editarCurso(curso);		

	}
	
}