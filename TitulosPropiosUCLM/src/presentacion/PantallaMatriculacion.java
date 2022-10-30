package presentacion;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaMatriculacion extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public PantallaMatriculacion() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(90, 143, 76, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(516, 72, 76, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 227, 76, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(516, 143, 76, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(90, 72, 76, 19);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFormaPago = new JLabel("Forma de pago");
		lblFormaPago.setBounds(516, 49, 76, 13);
		add(lblFormaPago);
		
		JLabel lblCurso = new JLabel("Curso ");
		lblCurso.setBounds(90, 195, 42, 13);
		add(lblCurso);
		
		JLabel lblTipoPago = new JLabel("Tipo de pago");
		lblTipoPago.setBounds(516, 116, 65, 13);
		add(lblTipoPago);
		
		JLabel lblFecha = new JLabel("Fecha de matriculacion");
		lblFecha.setBounds(90, 116, 109, 13);
		add(lblFecha);
		
		JLabel lblestudiante = new JLabel("Id Estudiante");
		lblestudiante.setBounds(90, 49, 76, 13);
		add(lblestudiante);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(553, 432, 83, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(658, 432, 83, 21);
		add(btnNewButton_1);
	}

	public void realizarMatriculacion() {
		// TODO - implement PantallaMatriculaci�n.realizarMatriculacion
		throw new UnsupportedOperationException();
	}

}