package negocio.controllers;

import negocio.entities.*;
import persistencia.UsuarioDAO;
import presentacion.Main_testing;

public class GestorUsuarios {

	public boolean comprobarUsuario(String usuario,String password) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			Usuario usuarioAux=(Usuario) usuarioDAO.get(usuario);
			if(contrasenCorrectaLoging(usuarioAux, password)){
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.ERROR,"Error al encontrar usuario");
			return false;
		}
	}

	public Usuario seleccionarUsuario(String usuario) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			return (Usuario) usuarioDAO.get(usuario);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.ERROR,"Error al encontrar usuario");
			return null;
		}
	}

	public boolean contrasenCorrectaLoging(Usuario usuarioAux, String password) {
		return password.trim().equals(usuarioAux.getPassword().trim());
	}	
}
