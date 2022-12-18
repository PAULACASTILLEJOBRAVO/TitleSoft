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

import presentacion.MainTesting;

public class GestorBD {
	// instancia del agente
	protected static GestorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	private static ResultSet rs;

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
	public static void conectar()  {
		PreparedStatement pstmt;
		Statement stmt;
		String createSQL = "create table usuario (idusuario varchar(30) not null, contrasenia varchar(30) not null, constraint primary_key primary key (idusuario))";

		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			mBD = DriverManager.getConnection(ConstantesBD.CONNECTION_STRING, ConstantesBD.DBUSER, ConstantesBD.DBPASS);
			mBD.setAutoCommit(false);
			stmt = mBD.createStatement();
			stmt.execute(createSQL);

			pstmt = mBD.prepareStatement("insert into usuario (idusuario, contrasenia) values(?,?)");
			pstmt.setString(1, "alumno");
			pstmt.setString(2, "alumno");
			pstmt.executeUpdate();

			while (rs.next()) {
				System.out.printf("%s - pass: %s\n", rs.getString(1), rs.getString(2));
			}

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

	// Metodo para desconectar de la base de datos
	public static void desconectar() {
		try {
			mBD.close();
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al conectar con la base de datos");
		}
	}

	// Metodo para realizar una insercion en la base de datos
	public static int insert(String SQL) {
		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			Connection mBD = DriverManager.getConnection(""+ConstantesBD.DRIVER+":"+ConstantesBD.DBNAME+";create=false", ConstantesBD.DBUSER, ConstantesBD.DBPASS);
			
			PreparedStatement stmt = mBD.prepareStatement(SQL);
			int res = stmt.executeUpdate();
			stmt.close();
			
			desconectar();
			return res;
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al conectar con la base de datos");
			return -1;
		}
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int delete(String SQL) {
		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			Connection mBD = DriverManager.getConnection(""+ConstantesBD.DRIVER+":"+ConstantesBD.DBNAME+";create=false", ConstantesBD.DBUSER, ConstantesBD.DBPASS);


			PreparedStatement stmt = mBD.prepareStatement(SQL);
			int res = stmt.executeUpdate();
			stmt.close();
			desconectar();
			return res;
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al conectar con la base de datos");
			return -1;
		}
	}

	// Metodo para realizar una eliminacion en la base de datos
	public static int update(String SQL) {
		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			Connection mBD = DriverManager.getConnection(""+ConstantesBD.DRIVER+":"+ConstantesBD.DBNAME+";create=false", ConstantesBD.DBUSER, ConstantesBD.DBPASS);

			PreparedStatement stmt = mBD.prepareStatement(SQL);
			int res = stmt.executeUpdate();
			stmt.close();
			desconectar();
			return res;
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al conectar con la base de datos");
			return -1;
		}
	}

	public static Vector<Object> select(String SQL) {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El mŽtodo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */

		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			Connection mBD = DriverManager.getConnection(""+ConstantesBD.DRIVER+":"+ConstantesBD.DBNAME+";create=false", ConstantesBD.DBUSER, ConstantesBD.DBPASS);
			
			Vector<Object> vectoradevolver = new Vector<Object>();
			Statement stmt = mBD.createStatement();
			ResultSet res = stmt.executeQuery(SQL);

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

			return vectoradevolver;	
		}catch (SQLException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al conectar con la base de datos");
			return null;
		}
	}
}