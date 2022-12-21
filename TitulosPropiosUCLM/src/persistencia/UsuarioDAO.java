package persistencia;

import java.util.List;

import negocio.entities.*;
import presentacion.MainTesting;

public class UsuarioDAO implements AbstractEntityDAO  <Object> {

	public Object get(String id){
		Usuario usuarioReturn = null;
		List<Object> resultado;
		String selectSQL = "SELECT * FROM usuario WHERE idusuario = '"+id+"' ";
		resultado = GestorBD.select(selectSQL);
		
		if (!resultado.isEmpty()) {
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",")   ;
			if(aux[1].trim().equals("estudiante")) {
				usuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.ESTUDIANTE);
			}else if(aux[1].trim().equals("profesor")) {
				usuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.PROFESOR);
			}else if (aux[1].trim().equals("vicerector")) {
				usuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.VICERECTOR);
			}else if (aux[2].trim().equals("jefe")) {
				usuarioReturn= new Usuario (aux[0],aux[1],TipoUsuario.JEFE);
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar usuario");
		return usuarioReturn;
	}

	@Override
	public int insert(Object entity) {
		int resultado=0;
		Usuario usuario =(Usuario) entity;
		String insertSQL = "INSERT INTO usuario (idusuario,password,tipo) "
				+ "VALUES ( '"+usuario.getIdUsuario()+"', '"+usuario.getPassword()+"','"+usuario.getTipo()+"')";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado < 0)
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar usuario");
		return resultado;
	}

	@Override
	public Object update(Object entity) {
		int resultado=0;
		Usuario usuario =(Usuario) entity;
		String updateSQL = "UPDATE usuario SET "
				+  "idusuario='"+usuario.getIdUsuario()+"',"
				+ " password='"+usuario.getPassword()+"',"
				+ "tipo='"+usuario.getTipo()+"' ";
		resultado = GestorBD.update(updateSQL);
		
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error modificando usuario ");
		return usuario;
	}

	@Override
	public int delete(Object entity)  {
		int resultado=0;
		Usuario usuario =(Usuario) entity;
		String insertSQL = " DELETE FROM usuario WHERE idusuario='"+usuario.getIdUsuario()+"' ";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR,"Error eliminando usuario  ");
		return resultado;
	}
}
