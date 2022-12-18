package negocio.controllers;

import negocio.entities.*;
import persistencia.UsuarioDAO;

public class GestorUsuarios {

	public boolean comprobarUsuario(String usuario,String password) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		Usuario usuarioAux=(Usuario) usuarioDAO.get(usuario);

		return contraseñaCorrectaLoging(usuarioAux, password);
	}

	public Usuario seleccionarUsuario(String usuario) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		return (Usuario) usuarioDAO.get(usuario);
	}

	public boolean contraseñaCorrectaLoging(Usuario usuarioAux, String password) {
		return password.trim().equals(usuarioAux.getPassword().trim());
	}	
}
