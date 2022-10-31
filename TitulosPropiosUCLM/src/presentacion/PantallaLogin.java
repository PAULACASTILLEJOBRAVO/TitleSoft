package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorUsuarios;
import persistencia.GestorBD;


public class PantallaLogin extends JFrame {
	private JPanel contentPane;
	JTextField textField = new JTextField();;
	JTextField textField_1 = new JTextField();;

	
	/**
	 * Create the panel.
	 */
	public PantallaLogin() {

		
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		JLabel lblusuario = new JLabel("Usuario:");
		lblusuario.setBounds(80, 94, 79, 13);
		contentPane.add(lblusuario);

		JLabel lblcontraseña = new JLabel("Contrase\u00F1a:");
		lblcontraseña.setBounds(80, 157, 76, 13);
		contentPane.add(lblcontraseña);

		textField.setColumns(10);
		textField.setBounds(145, 91, 132, 19);
		contentPane.add(textField);
		

		textField_1.setColumns(10);
		textField_1.setBounds(145, 154, 132, 19);
		contentPane.add(textField_1);
		

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(89, 224, 83, 21);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorUsuarios gUsuario=new GestorUsuarios();
				
				if(gUsuario.ComprobarUsuario(textField.getText(), textField_1.getText()  )) {
					System.out.println("Usuario en la base de datos");
				}else {
					System.out.println("Usuario no encontrado en la base de datos");
				}
				
			}
		});
			
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(201, 224, 83, 21);
		add(btnNewButton_1);

		JLabel lblbienvenida = new JLabel("Bienvenido");
		lblbienvenida.setBounds(154, 40, 68, 13);
		add(lblbienvenida);

	}
	
	
}
