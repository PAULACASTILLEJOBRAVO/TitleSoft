package negocio.controllers;

import negocio.entities.*;
import persistencia.UsuarioDAO;

public class GestorUsuarios {

	public boolean comprobarUsuario(String usuario,String password) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();


		if(usuario.equals("") || password.equals("") ) {
			return false;
		}
		Usuario usuarioAux=(Usuario) usuarioDAO.get(usuario);
		return contrasenaCorrectaLoging(usuarioAux, password);
	}

	public Usuario seleccionarUsuario(String usuario) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		if(usuario.equals("")) {
			return null;
		}

		return (Usuario) usuarioDAO.get(usuario);

	}

	public boolean contrasenaCorrectaLoging(Usuario usuarioAux, String password) {

		
		if(usuarioAux.getPassword().equals("") || password.equals("")) {
			return false;
		}
		return password.trim().equals(usuarioAux.getPassword().trim());


	}	
}
