package persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



import org.apache.derby.jdbc.EmbeddedDriver;

public class GestorBD {
	// instancia del agente
	protected static GestorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "jdbc:mysql://localhost:3307/practicabd?user=alumno&password=alumno";
	// Driven para conectar con bases de datos MySQL
	private static String driver = "com.mysql.jdbc.Driver";

	// Constructor
	private GestorBD() throws Exception {
		conectar();

	}

	// Implementacion del patron singleton
	// Este patron de diseño permite implementar clases de las cuales
	// solo existir una instancia
	// http://es.wikipedia.org/wiki/Singleton
	public static GestorBD getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new GestorBD();
		}
		return mInstancia;
	}

	// Metodo para realizar la conexion a la base de datos
	public static void conectar() throws Exception {
		PreparedStatement pstmt;
		Statement stmt;
		ResultSet rs = null;
		boolean resultado;
		String createSQL = "create table usuario (idusuario varchar(30) not null, contrasenia varchar(30) not null, constraint primary_key primary key (idusuario))";

		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			mBD = DriverManager.getConnection(ConstantesBD.CONNECTION_STRING, ConstantesBD.DBUSER, ConstantesBD.DBPASS);
			//conexion = DriverManager.getConnection(BDConstantes.CONNECTION_STRING, BDConstantes.DBUSER, BDConstantes.DBPASS);
			mBD.setAutoCommit(false);
			stmt = mBD.createStatement();
			stmt.execute(createSQL);
			
			pstmt = mBD.prepareStatement("insert into usuario (idusuario, contrasenia) values(?,?)");
			pstmt.setString(1, "alumno");
			pstmt.setString(2, "alumno");
			pstmt.executeUpdate();
			
			
//			try {
//				resultado = sentencia.execute(introducirUsuario);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			//stmt.execute(introducirUsuario);
			rs = stmt.executeQuery("select * from usuario");
			//resultado =sentencia.executeQuery(introducirUsuario);
			
			
			
//			sentencia = conn.createStatement();
//			sentencia.close();
			

			while (rs.next()) {
				System.out.printf("%s - pass: %s\n", rs.getString(1), rs.getString(2));
			}

			//stmt.execute("drop table usuario");

			mBD.commit();

		} catch (SQLException ex) {
			System.out.println("in connection" + ex);
		}

		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException ex) {
			if (((ex.getErrorCode() == 50000) && ("XJ015".equals(ex.getSQLState())))) {
				System.out.println("Derby shut down normally");
			} else {
				System.err.println("Derby did not shut down normally");
				System.err.println(ex.getMessage());
			}
		}
		}
//		Connection conn = null;
//		PreparedStatement pstmt;
//		Statement stmt;
//		ResultSet rs = null;
//		boolean resultado;
//		String createSQL = "create table usuario (login varchar(30) not null, pass varchar(30) not null, constraint primary_key primary key (login))";
//		
//		try {
//			Driver derbyEmbeddedDriver = new EmbeddedDriver();
//			DriverManager.registerDriver(derbyEmbeddedDriver);
//			conn = DriverManager.getConnection(ConstantesBD.CONNECTION_STRING, ConstantesBD.DBUSER, ConstantesBD.DBPASS);
//			//conexion = DriverManager.getConnection(BDConstantes.CONNECTION_STRING, BDConstantes.DBUSER, BDConstantes.DBPASS);
//			conn.setAutoCommit(false);
//			stmt = conn.createStatement();
//			stmt.execute(createSQL);
//			
//			pstmt = conn.prepareStatement("insert into usuario (login, pass) values(?,?)");
//			pstmt.setString(1, "alumno");
//			pstmt.setString(2, "alumno");
//			pstmt.executeUpdate();
//		} catch (SQLException ex) {
//			System.out.println("in connection" + ex);
//		}
//	}
//
	// Metodo para desconectar de la base de datos
	public static void desconectar() throws Exception {
		mBD.close();
	}

	// Metodo para realizar una insercion en la base de datos
	public static int insert(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int delete(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public static int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public static Vector<Object> select(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El mŽtodo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */

		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		DriverManager.registerDriver(derbyEmbeddedDriver);
		Connection mBD = DriverManager.getConnection(""+ConstantesBD.DRIVER+":"+ConstantesBD.DBNAME+";create=false", ConstantesBD.DBUSER, ConstantesBD.DBPASS);
		String SQL_Consulta = "SELECT idusuario, contrasenia FROM Usuario WHERE idusuario = '"+SQL+"'";

		Vector<Object> vectoradevolver = new Vector<Object>();
		//conectar();
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(SQL);
		while (res.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(res.getObject(1));
			v.add(res.getObject(2));
			vectoradevolver.add(v);
		}
		stmt.close();
		//desconectar();
		
		
		return vectoradevolver;
		
	}
}