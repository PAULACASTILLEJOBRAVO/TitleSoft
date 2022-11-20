package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GestorBaseDeDatos {
	// instancia del gestor base de datos
		protected static GestorBaseDeDatos mInstancia = null;
		// Conexion con la base de datos
		protected static Connection mBD;
		// Identificador ODBC de la base de datos
		private static String url = "jdbc:mysql://localhost:3307/practicabd?user=alumno&password=alumno; create = true";
		// Driven para conectar con bases de datos MySQL
		private static String driver = "com.mysql.jdbc.Driver";

		// Constructor
		private GestorBaseDeDatos() throws Exception {
			conectar();
		}
		public static GestorBaseDeDatos getGestorBaseDeDatos() throws Exception {
			if (mInstancia == null) {
				mInstancia = new GestorBaseDeDatos();
			}
			return mInstancia;
		}

		// Metodo para realizar la conexion a la base de datos
		private void conectar() throws Exception {
			Class.forName(driver);
			mBD = DriverManager.getConnection(url);
		}
		public void desconectar() throws Exception {
			mBD.close();
		}

		// Metodo para realizar una insercion en la base de datos
		public int insert(String SQL) throws SQLException, Exception {
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
		public int update(String SQL) throws SQLException, Exception {
			conectar();
			PreparedStatement stmt = mBD.prepareStatement(SQL);
			int res = stmt.executeUpdate();
			stmt.close();
			desconectar();
			return res;
		}

		public Vector<Object> select(String SQL) throws SQLException, Exception {

			Vector<Object> vectoradevolver = new Vector<Object>();
			conectar();
			Statement stmt = mBD.createStatement();
			ResultSet res = stmt.executeQuery(SQL);
			while (res.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(res.getObject(1));
				v.add(res.getObject(2));
				vectoradevolver.add(v);
			}
			stmt.close();
			desconectar();
			return vectoradevolver;

		}
}