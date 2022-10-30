package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaLogin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PantallaLogin() {
		setLayout(null);
		
		JLabel lblusuario = new JLabel("Usuario:");
		lblusuario.setBounds(80, 94, 79, 13);
		add(lblusuario);
		
		JLabel lblcontraseña = new JLabel("Contrase\u00F1a:");
		lblcontraseña.setBounds(80, 157, 76, 13);
		add(lblcontraseña);
		
		textField = new JTextField();
		textField.setBounds(145, 91, 132, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 154, 132, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(89, 224, 83, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(201, 224, 83, 21);
		add(btnNewButton_1);
		
		JLabel lblbienvenida = new JLabel("Bienvenido");
		lblbienvenida.setBounds(154, 40, 68, 13);
		add(lblbienvenida);

	}
}
