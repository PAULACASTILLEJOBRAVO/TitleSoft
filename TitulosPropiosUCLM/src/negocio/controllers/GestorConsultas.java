package negocio.controllers;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import negocio.entities.*;
import persistencia.CursoPropioDAO;
import presentacion.Main_testing;
import negocio.entities.*;
public class GestorConsultas {
	private CursoPropioDAO cursoPropioDAO;
	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	class Ejercicio {
//		 public static void main (String [] args){
//			 Connection conexion = null;
//			 Statement sentencia = null;
//			 ResultSet resultado;
//			 try {
//				 Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
//				 }
//				 catch (Exception e) {
//				 System.out.println("No se pudo cargar el puente JDBC-ODBC");
//				 return;
//				 }
//			 try {
//				conexion=DriverManager.getConnection ("jdbc:odbc:prueba");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 try {
//				sentencia = (Statement) conexion.createStatement();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 try {
//				resultado =((java.sql.Statement) sentencia).executeQuery("SELECT * FROM nombre");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 while (resultado.next()) {
//				 String nombre = resultado.getString ("Nombre");
//				 String apellido = resultado.getString ("Apellidos");
//				 System.out.println( "Los datos son: "+ nombre+“"+apellido);
//				 }
//
//		}
		}
	
	public double consultarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		double ingresos = 0;
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		 try {
			ingresos = cursoPropioDAO.listarIngresos(tipo, fechaInicio, fechaFin);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al consulatar ingresos");

		}
		return ingresos;
	}

	/**
	 * 
	 * @param estadoCurso
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<CursoPropio> consultarEstadoCursos(EstadoCurso estadoCurso) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> estados = null;
		try {
			estados = cursoPropioDAO.listarCursosPorEstado(estadoCurso);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al consular por estados");

		}
		return estados; 
		
	}
	
	
	
	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		CursoPropioDAO cursoPropioDAO = new CursoPropioDAO();
		Collection<CursoPropio> ediciones = null;
		try {
			ediciones = cursoPropioDAO.listarEdicionesCursos(fechaInicio, fechaFin);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar por ediciones");

		}
		return ediciones;
	}

	
	public CursoPropio seleccionarCurso(String id) throws Exception {
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		return cursoDAO.seleccionarCurso(id);
	}
	
	public CursoPropio actualizarCurso(CursoPropio curso) throws Exception {
		
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		return cursoDAO.editarCurso(curso);
	}
	
	public Collection<CursoPropio> cursosPorCentro(String id) throws Exception{
		CursoPropioDAO cursoDAO=new CursoPropioDAO();
		return cursoDAO.cursosPorCentro(id);
		
	}

	
}