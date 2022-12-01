package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GestorBD {

	protected static GestorBD mInstancia = null; // Conexion con la base de datos
	protected static Connection mBD; // Identificador ODBC de la base de datos
	private static String url ="jdbc:mysql://localhost:3306/iso_ii"; // Driven para conectar con bases de datos MySQL

	private static String driver= "com.mysql.cj.jdbc.Driver"; 
	private static String user= "root"; 
	private static String password="root";

	public static void conectarBD() throws Exception { 
		Class.forName(driver); 
		mBD= DriverManager.getConnection(url, user, password); 
		mBD.setAutoCommit(true);

	}

	public static void desconectarBD() throws Exception{ // TODO - implement
		mBD.close(); 
	}

	/**
	 * 
	 * @param sql
	 */

	public static Vector<Object> select(String sql) throws Exception{
		Vector<Object> vectoradevolver = new Vector<Object>(); conectarBD();
		Statement stmt = mBD.createStatement(); 
		ResultSet res = stmt.executeQuery(sql); 
		while (res.next()) { Vector<Object> v = new
				Vector<Object>(); 
		for(int i=1; i<20; i++) {
			try	{ 
				v.add(res.getObject(i)); 
			} catch(SQLException ex) { 
				continue; 
			} 
		} 
		vectoradevolver.add(v); 
		}
		stmt.close(); 
		conectarBD(); 
		return vectoradevolver;
	}

	/**
	 * 
	 * @param sql
	 */

	public static int insert(String sql)throws Exception { 
		conectarBD();
		PreparedStatement stmt = mBD.prepareStatement(sql); 
		int res = stmt.executeUpdate(sql); 
		stmt.close(); 
		desconectarBD(); 
		return res; 
	}

	/**
	 * 
	 * @param sql
	 */

	public static int update(String sql) throws Exception{ // TODO - implement
		conectarBD(); 
		PreparedStatement stmt =
				mBD.prepareStatement(sql); 
		int res = stmt.executeUpdate(sql); stmt.close();
		desconectarBD(); 
		return res; 
	}

	/**
	 * 
	 * @param sql
	 */
	public static int delete(String sql) throws Exception{ // TODO - implement
		conectarBD(); 
		PreparedStatement stmt =
				mBD.prepareStatement(sql); 
		int res = stmt.executeUpdate(sql); stmt.close();
		desconectarBD(); 
		return res; 
	}


}