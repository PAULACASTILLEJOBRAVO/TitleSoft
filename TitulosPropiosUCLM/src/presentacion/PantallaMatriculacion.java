package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorMatriculacion;
import negocio.entities.ModoPago;

public class PantallaMatriculacion extends JFrame {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblError;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JPanel contentPane;

	public PantallaMatriculacion() {
		setTitle("Sesion: Estudiante");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 820, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(516, 224, 76, 19);
		add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(90, 320, 76, 19);
		add(textField_2);
		textField_2.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(90, 224, 76, 19);
		add(textField_4);
		textField_4.setColumns(10);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(90, 281, 42, 13);
		add(lblCurso);

		JLabel lblTipoPago = new JLabel("Tipo de pago:");
		lblTipoPago.setBounds(516, 281, 65, 13);
		add(lblTipoPago);

		JLabel lblFecha = new JLabel("Fecha de matriculacion (yyyy-mm-dd):");
		lblFecha.setBounds(516, 189, 187, 40);
		add(lblFecha);

		JLabel lblestudiante = new JLabel("Id Estudiante: ");
		lblestudiante.setBounds(90, 189, 76, 13);
		add(lblestudiante);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarMatriculacion();
			}
		});
		btnNewButton.setBounds(553, 432, 83, 21);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnNewButton_1.setBounds(658, 432, 83, 21);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Matriculacion ");
		lblNewLabel.setBounds(314, 102, 70, 13);
		add(lblNewLabel);

		ButtonGroup group = new ButtonGroup();

		rdbtnNewRadioButton = new JRadioButton("Transferencia");
		rdbtnNewRadioButton.setBounds(516, 300, 99, 40);
		rdbtnNewRadioButton.setSelected(true);
		group.add(rdbtnNewRadioButton);
		add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Trajeta de Credito");
		rdbtnNewRadioButton_1.setBounds(516, 340, 120, 40);
		group.add(rdbtnNewRadioButton_1);
		add(rdbtnNewRadioButton_1);

		lblError = new JLabel("Error");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(90, 43, 378, 13);
		add(lblError);
		lblError.setText("");
	}

	private void realizarMatriculacion() {
		try {
			if (validarDatos()) {
				lblError.setText("");
				ModoPago modoPago = rdbtnNewRadioButton.isSelected() ? ModoPago.TRANSFERENCIA : ModoPago.TARJETA_CREDITO;
				GestorMatriculacion gm = new GestorMatriculacion();
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				String fechaAux=textField_4.getText();
				Date fecha=(Date) formato.parse(fechaAux);

				gm.realizarMatriculacion(textField.getText(), modoPago, fecha, true);
			} else {
				lblError.setText("No se ha podido completar la matricula. Rellena todos los campos.");
			}
		}catch (Exception e) {
			Main_testing.escribirLog(Main_testing.error,"Error al realizar matricula");

		}
	}

	private boolean validarDatos() {
		return !(textField.getText().isEmpty() || textField_2.getText().isEmpty() || textField_4.getText().isEmpty());
	}

	private void limpiarFormulario() {
		textField.setText("");
		textField_2.setText("");
		textField_4.setText("");
	}
}