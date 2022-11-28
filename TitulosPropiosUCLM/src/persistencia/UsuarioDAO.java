package persistencia;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import negocio.controllers.GestorConsultas;
import negocio.controllers.GestorProfesorUCLM;
import negocio.entities.*;
import org.apache.derby.jdbc.EmbeddedDriver;

public class UsuarioDAO extends AbstractEntityDAO{

	
	public Object get(String id) throws Exception {
		Usuario UsuarioReturn = null;
		Vector<Object> resultado;
		//Vector<Object> aux = null;
		String SelectSQL = "SELECT * FROM usuarios WHERE idusuarios LIKE '"+id+"' ";
		//Vector<Object> vectoradevolver=new Vector<Object>();
		resultado = GestorBD.select(SelectSQL);
		if (resultado.isEmpty()==false) {
			System.out.println("usuario seleccionado");
			
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",")   ;
			
			if(aux[2].trim().equals("estudiante")) {
				UsuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.ESTUDIANTE);
			}else if(aux[2].trim().equals("profesor")) {
				UsuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.PROFESOR);
			}else if (aux[2].trim().equals("vicerector")) {
				UsuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.VICERECTOR);
			}else if (aux[2].trim().equals("jefe")) {
				UsuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.JEFE);
			
			}
			
		}else
			System.err.println("Error al seleccionar usuario");
		
		return UsuarioReturn;
	}

	@Override
	public int insert(Object entity) throws Exception {
		int resultado=0;
		Usuario usuario =(Usuario) entity;
		String insertSQL = "INSERT INTO usuarios (idusuarios,password,tipo) "
				+ "VALUES ( '"+usuario.getIdUsuario()+"', '"+usuario.getPassword()+"','"+usuario.getTipo()+"')";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado > 0) {
			System.out.println("Usuario nuevo creado");
		}else
			System.err.println("Error creando usuario nuevo ");

		return resultado;
	}

	@Override
	public Object update(Object entity) throws Exception {
		int resultado=0;
		Usuario usuario =(Usuario) entity;
		String updateSQL = "UPDATE usuarios SET "
				+  "idusuario='"+usuario.getIdUsuario()+"',"
				+ " password='"+usuario.getPassword()+"',"
				+ "tipo='"+usuario.getTipo()+"' ";
		resultado = GestorBD.update(updateSQL);
		
		
		if (resultado > 0) {
			System.out.println("usuario modificado");
		}else
			System.err.println("Error modificando usuario ");

		return usuario;
	}

	@Override
	public int delete(Object entity) throws Exception {
		int resultado=0;
		Usuario usuario =(Usuario) entity;
		String insertSQL = " DELETE FROM usuarios WHERE idusuario='"+usuario.getIdUsuario()+"' ";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado > 0) {
			System.out.println("Eliminado usuario");
		}else
			System.err.println("Error eliminando usuario  ");

		return resultado;
	}




}
