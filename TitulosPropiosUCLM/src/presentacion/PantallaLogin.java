package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.util.logging.Logger;
import java.util.logging.Level;

import negocio.controllers.GestorUsuarios;
import negocio.entities.TipoUsuario;
import negocio.entities.Usuario;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PantallaLogin extends JFrame {
	private static final String ERRORINICIOSESION =  "Error iniciando sesion";
	private static final String ERRORUSUARIOSINPERMISOS =  "Ususario no permitido";
	
	private JTextField textFieldUsuario= new JTextField();
	private JTextField textFieldPassword= new JTextField();
	private JPanel contentPane;

	public PantallaLogin(int id) {
		setTitle("Log in");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 527, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblusuario = new JLabel("Usuario:");
		lblusuario.setBounds(80, 94, 79, 13);
		getContentPane().add(lblusuario);

		textFieldUsuario.setBounds(145, 91, 132, 19);
		getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(80, 157, 76, 13);
		getContentPane().add(lblPassword);

		textFieldPassword.setBounds(145, 154, 132, 19);
		getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);

		JButton botonLogin = new JButton("Login");
		botonLogin.addActionListener((ActionEvent e) -> {
			GestorUsuarios gUsuario=new GestorUsuarios();
			if(gUsuario.comprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {
				Logger loger = Logger.getLogger(PantallaLogin.class.getName());
				loger.log(Level.INFO,"Sesicon iniciada");
				Usuario usuario=gUsuario.seleccionarUsuario(textFieldUsuario.getText().trim());

				if(id==1) {
					accionesEstudiante(gUsuario, usuario);
				}else if (id==2) {
					accionesVicerector(gUsuario, usuario);
				}else if(id==3) {
					accionesProfesores(gUsuario, usuario);
				}else if(id==0) {
					accionesJefe(gUsuario, usuario);
				}
			}else {
				MainTesting.escribirLog(MainTesting.ERROR, ERRORINICIOSESION);
			}
		});
		botonLogin.setBounds(89, 224, 83, 21);
		getContentPane().add(botonLogin);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(201, 224, 83, 21);
		getContentPane().add(botonCancelar);

		JLabel lblbienvenida = new JLabel("Bienvenido");
		lblbienvenida.setBounds(154, 40, 68, 13);
		getContentPane().add(lblbienvenida);
	}

	public void accionesProfesores(GestorUsuarios gUsuario, Usuario usuario) {
		if(gUsuario.comprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {
			if(usuario.getTipo()==TipoUsuario.PROFESOR) {
				PantallaDireccionCursos frame =new PantallaDireccionCursos();
				frame.setVisible(true);
			}
		}else {
			MainTesting.escribirLog(MainTesting.ERROR,ERRORINICIOSESION);
		}
	}

	public void accionesVicerector(GestorUsuarios gUsuario, Usuario usuario) {
		if(gUsuario.comprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {
			if(usuario.getTipo()==TipoUsuario.VICERECTOR) {
				PantallaEmpleadosVicerrectorado frame =new PantallaEmpleadosVicerrectorado();
				frame.setVisible(true);
			}
		}else {
			MainTesting.escribirLog(MainTesting.ERROR,ERRORUSUARIOSINPERMISOS);
		}
	}

	public void accionesEstudiante(GestorUsuarios gUsuario, Usuario usuario) {		
		if(gUsuario.comprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {
			if(usuario.getTipo()==TipoUsuario.ESTUDIANTE) {
				PantallaMatriculacion frame =new PantallaMatriculacion();
				frame.setVisible(true);
			}
		}else {
			MainTesting.escribirLog(MainTesting.ERROR,ERRORUSUARIOSINPERMISOS);
		}
	}

	public void accionesJefe(GestorUsuarios gUsuario, Usuario usuario) {
		if(gUsuario.comprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {
			if(usuario.getTipo()==TipoUsuario.JEFE) {
				PantallaJefeGabineteVicerrectorado frame =new PantallaJefeGabineteVicerrectorado();
				frame.setVisible(true);
			}
		}else {
			MainTesting.escribirLog(MainTesting.ERROR, ERRORUSUARIOSINPERMISOS);
		}
	}
}