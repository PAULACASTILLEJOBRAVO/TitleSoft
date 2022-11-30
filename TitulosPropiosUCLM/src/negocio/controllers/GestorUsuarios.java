package negocio.controllers;

import java.util.*;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.UsuarioDAO;
import presentacion.Main_testing;

public class GestorUsuarios {
	public boolean ComprobarUsuario(String usuario,String password) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			Usuario usuarioAux=(Usuario) usuarioDAO.get(usuario);
			if(password.trim().equals(usuarioAux.getPassword().trim() )){
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
<<<<<<< HEAD
=======
			e.printStackTrace();
>>>>>>> branch 'Feature3' of git@github.com:PAULACASTILLEJOBRAVO/TitleSoft.git
			Main_testing.escribirLog(Main_testing.error,"Error al encontrar usuario");
			return false;
		}
	}

	public Usuario seleccionarUsuario(String usuario) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			return (Usuario) usuarioDAO.get(usuario);
		} catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al encontrar usuario");
			return null;
		}
	}
}
