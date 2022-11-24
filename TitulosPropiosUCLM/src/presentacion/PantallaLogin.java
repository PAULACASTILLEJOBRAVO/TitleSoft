package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorUsuarios;
import negocio.entities.TipoUsuario;
import negocio.entities.Usuario;
import persistencia.GestorBD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PantallaLogin extends JFrame {
	private JTextField textFieldUsuario= new JTextField();;
	private JTextField textFieldPassword= new JTextField();
	private JPanel contentPane;

	/**
	 * Create the panel.
	 */
	public PantallaLogin(int id) {



		setTitle("Log in");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 527, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);




		JLabel lblusuario = new JLabel("Usuario:");
		lblusuario.setBounds(80, 94, 79, 13);
		getContentPane().add(lblusuario);


		JLabel lblcontrasena1 = new JLabel("Contrase\u00F1a:");
		lblcontrasena1.setBounds(80, 157, 76, 13);
		getContentPane().add(lblcontrasena1);



		textFieldUsuario.setBounds(145, 91, 132, 19);
		getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);


		textFieldPassword.setBounds(145, 154, 132, 19);
		getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				GestorUsuarios gUsuario=new GestorUsuarios();

				if(gUsuario.ComprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {

					System.out.println("Sesion iniciada");

					Usuario usuario=gUsuario.seleccionarUsuario(textFieldUsuario.getText().trim());

					if(id==1) {
						accionesEstudiante(gUsuario,usuario);
					}else if (id==2) {
						accionesVicerector(gUsuario,usuario);
					}else if(id==3) {
						accionesProfesores(gUsuario,usuario);
					}else if(id==0) {
						accionesJefe(gUsuario,usuario);
					}



				}else {
					System.out.println("Error iniciando sesion");
				}

			}
		});
		btnNewButton.setBounds(89, 224, 83, 21);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(201, 224, 83, 21);
		getContentPane().add(btnNewButton_1);

		JLabel lblbienvenida = new JLabel("Bienvenido");
		lblbienvenida.setBounds(154, 40, 68, 13);
		getContentPane().add(lblbienvenida);

	}

	public void accionesProfesores(GestorUsuarios gUsuario,Usuario usuario) {
		if(gUsuario.ComprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {

			System.out.println("Sesion iniciada");


			usuario=gUsuario.seleccionarUsuario(textFieldUsuario.getText().trim());

			if(usuario.getTipo()==TipoUsuario.PROFESOR) {
				PantallaDireccionCursos frame =new PantallaDireccionCursos();
				frame.setVisible(true);
			}



		}else {
			System.out.println("Ususario no permitido");
		}








	}

	public void accionesVicerector(GestorUsuarios gUsuario,Usuario usuario) {


		if(gUsuario.ComprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {

			System.out.println("Sesion iniciada");


			usuario=gUsuario.seleccionarUsuario(textFieldUsuario.getText().trim());

			if(usuario.getTipo()==TipoUsuario.VICERECTOR) {
				PantallaEmpleadosVicerrectorado frame =new PantallaEmpleadosVicerrectorado();
				frame.setVisible(true);
			}



		}else {
			System.out.println("Ususario no permitido");
		}



		

	}

	public void accionesEstudiante(GestorUsuarios gUsuario,Usuario usuario) {
		
		

		if(gUsuario.ComprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {

			System.out.println("Sesion iniciada");


			usuario=gUsuario.seleccionarUsuario(textFieldUsuario.getText().trim());

			if(usuario.getTipo()==TipoUsuario.ESTUDIANTE) {
				PantallaMatriculacion frame =new PantallaMatriculacion();
				frame.setVisible(true);
			}



		}else {
			System.out.println("Ususario no permitido");
		}




	}

	public void accionesJefe(GestorUsuarios gUsuario,Usuario usuario) {
		
		if(gUsuario.ComprobarUsuario(textFieldUsuario.getText(), textFieldPassword.getText())) {

			System.out.println("Sesion iniciada");


			usuario=gUsuario.seleccionarUsuario(textFieldUsuario.getText().trim());

			if(usuario.getTipo()==TipoUsuario.JEFE) {
				PantallaJefeGabineteVicerrectorado frame =new PantallaJefeGabineteVicerrectorado();
				frame.setVisible(true);
			}



		}else {
			System.out.println("Ususario no permitido");
		}


		

	}

}
