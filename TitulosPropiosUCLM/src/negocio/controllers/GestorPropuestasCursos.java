package negocio.controllers;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import negocio.entities.*;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {


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


		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat getMonthFormat = new SimpleDateFormat("MM");

		String anioInicio = getYearFormat.format(fechaInicio);
		String mesInicio = getMonthFormat.format(fechaInicio);


		String anioFin = getYearFormat.format(fechaFin);
		String mesFin = getMonthFormat.format(fechaFin);

		Date fechaActual = new Date();
		String anioActual = getYearFormat.format(fechaActual);

		if(  nombre.equals("") ||
				tasaMatricula<0 ||
				edicion<0 ||
				(dniDirector.equals("") || dniDirector.length()>9) ||
				(dniSecretario.equals("") || dniSecretario.length()>9 ) ||
				centro.equals("") ||
				(Integer.parseInt(anioInicio)>= 2000 && Integer.parseInt(anioFin)>= 2000 && Integer.parseInt(anioFin)>= Integer.parseInt(anioInicio)
	    		 && Integer.parseInt(mesInicio) != 7 && Integer.parseInt(mesInicio) != 8 && Integer.parseInt(mesFin) != 8 && Integer.parseInt(mesFin) != 7
	    		 && Integer.parseInt(mesInicio)<= 12 && Integer.parseInt(mesFin)<=12) ) {

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