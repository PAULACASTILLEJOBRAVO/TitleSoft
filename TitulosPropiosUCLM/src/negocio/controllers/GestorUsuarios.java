package negocio.controllers;

import java.util.*;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.UsuarioDAO;

public class GestorUsuarios {


	public boolean ComprobarUsuario(String usuario,String password) {

		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			Usuario usuarioAux=(Usuario) usuarioDAO.get(usuario);

			if(password.equals(usuarioAux.getPassword() )){
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}

	}

	public Usuario seleccionarUsuario(String usuario) {

		UsuarioDAO usuarioDAO=new UsuarioDAO();

		try {
			return (Usuario) usuarioDAO.get(usuario);

		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}

	}


}