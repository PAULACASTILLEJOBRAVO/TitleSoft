package negocio.controllers;

import negocio.entities.*;
import persistencia.UsuarioDAO;
import presentacion.MainTesting;

public class GestorUsuarios {

	public boolean comprobarUsuario(String usuario,String password) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			Usuario usuarioAux=(Usuario) usuarioDAO.get(usuario);
			if(contraseñaCorrectaLoging(usuarioAux, password)){
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al encontrar usuario");
			return false;
		}
	}

	public Usuario seleccionarUsuario(String usuario) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			return (Usuario) usuarioDAO.get(usuario);
		} catch (Exception e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al encontrar usuario");
			return null;
		}
	}

	public boolean contraseñaCorrectaLoging(Usuario usuarioAux, String password) {
		return password.trim().equals(usuarioAux.getPassword().trim());
	}	
}
