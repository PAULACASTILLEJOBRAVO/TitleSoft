package persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import org.apache.derby.jdbc.EmbeddedDriver;

import presentacion.MainTesting;

public class GestorBD {
	// instancia del agente
	protected static GestorBD mInstancia = null;
	
	private static final String MENSAJEERROR="Error al conectar con la base de datos";

	// Constructor
	private GestorBD() {
		conectar();
	}

	// Implementacion del patron singleton
	// Este patron de diseño permite implementar clases de las cuales
	// solo existir una instancia
	// http://es.wikipedia.org/wiki/Singleton
	public static GestorBD getAgente() {
		if (mInstancia == null) {
			mInstancia = new GestorBD();
		}
		return mInstancia;
	}

	// Metodo para realizar la conexion a la base de datos
	public static Connection conectar()  {
		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			return DriverManager.getConnection(""+ConstantesBD.DRIVER+":"+ConstantesBD.DBNAME+";create=true", ConstantesBD.DBUSER, ConstantesBD.DBPASS);
		} catch (SQLException ex) {
			MainTesting.escribirLog(MainTesting.ERROR, "in connection" + ex);
		}
		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException ex) {
			MainTesting.escribirLog(MainTesting.ERROR, MENSAJEERROR);
			if (((ex.getErrorCode() == 50000) && ("XJ015".equals(ex.getSQLState())))) {
				MainTesting.escribirLog(MainTesting.ERROR,"Derby shut down normally");
			} else {
				MainTesting.escribirLog(MainTesting.ERROR,"Derby did not shut down normally");
				MainTesting.escribirLog(MainTesting.ERROR,ex.getMessage());
			}
		}
		return null;
	}

	// Metodo para desconectar de la base de datos
	public static void desconectar(Connection mBD) {
		try {
			mBD.close();
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,MENSAJEERROR);
		}
	}

	// Metodo para realizar una insercion en la base de datos
	public static int insert(String sql) {
		try {
			Connection mBD=conectar();

			PreparedStatement stmt = mBD.prepareStatement(sql);
			int res = stmt.executeUpdate();
			stmt.close();

			desconectar(mBD);
			return res;
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,MENSAJEERROR);
			return -1;
		}
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int delete(String sql) {
		try {
			Connection mBD=conectar();

			PreparedStatement stmt = mBD.prepareStatement(sql);
			int res = stmt.executeUpdate();
			stmt.close();
			desconectar(mBD);
			return res;
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,MENSAJEERROR);
			return -1;
		}
	}

	// Metodo para realizar una eliminacion en la base de datos
	public static int update(String sql) {
		try {
			Connection mBD=conectar();

			PreparedStatement stmt = mBD.prepareStatement(sql);
			int res = stmt.executeUpdate();
			stmt.close();
			desconectar(mBD);
			return res;
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,MENSAJEERROR);
			return -1;
		}
	}

	public static List<Object> select(String sql) {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El mŽtodo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		LinkedList<Object> vectoradevolver = new LinkedList<>();
		try {
			Connection mBD=conectar();

			Statement stmt = mBD.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) { 
				LinkedList<Object> v = new	LinkedList<>();
				
				for(int i = 1; i<20; i++) {
					try	{ 
						v.add(res.getObject(i)); 
					} catch(SQLException ex) { 
						continue; 
					} 
				}
				vectoradevolver.add(v); 
			}
			stmt.close();

			return vectoradevolver;	
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,MENSAJEERROR);
			return vectoradevolver;
		}
	}
}