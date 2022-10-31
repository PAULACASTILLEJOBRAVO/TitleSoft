package persistencia;

import java.util.Vector;

import negocio.entities.CursoPropio;
import negocio.entities.Usuario;

public class UsuarioDAO extends AbstractEntityDAO{

	
	@Override
	public Object get(String id) throws Exception {
		Vector<Object> resultado;
		CursoPropio UsuarioReturn=null;
		String SelectSQL= "SELECT * FROM usuarios WHERE idusuarios LIKE '"+id+"' " ;


		resultado = GestorBD.select(SelectSQL);
		String[] aux =resultado.get(0).toString().split(",");
		System.out.println(aux[2]);
		if (resultado.isEmpty()==false) {
			System.out.println("usuario seleccionado");
			
			//UsuarioReturn=(Usuario)  resultado.get(0);

		}else
			System.err.println("Error al seleccionar usuario");

		return UsuarioReturn ;

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
