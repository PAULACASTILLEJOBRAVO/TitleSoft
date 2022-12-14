package presentacion;

import java.sql.Date;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField textFieldFecha;
	private JTextField textFieldCurso;
	private JTextField textFieldId;
	private JLabel lblError;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JPanel contentPane;

	public PantallaMatriculacion() throws SQLException, ClassNotFoundException, NumberFormatException{
		setTitle("Sesion: Estudiante");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 820, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(416, 224, 76, 19);
		add(textFieldFecha);
		textFieldFecha.setColumns(10);

		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(90, 320, 76, 19);
		add(textFieldCurso);
		textFieldCurso.setColumns(10);

		textFieldId = new JTextField();
		textFieldId.setBounds(90, 224, 76, 19);
		add(textFieldId);
		textFieldId.setColumns(10);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(90, 281, 62, 13);
		add(lblCurso);

		JLabel lblTipoPago = new JLabel("Tipo de pago:");
		lblTipoPago.setBounds(416, 281, 105, 13);
		add(lblTipoPago);

		JLabel lblFecha = new JLabel("Fecha de matriculacion (yyyy-mm-dd):");
		lblFecha.setBounds(416, 169, 287, 40);
		add(lblFecha);

		JLabel lblestudiante = new JLabel("Id Estudiante:");
		lblestudiante.setBounds(90, 189, 96, 13);
		add(lblestudiante);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validarDatosMatriculacion();
				} catch (SQLException | NumberFormatException | ClassNotFoundException e1) {
					Main_testing.escribirLog(Main_testing.error,"Error a realizar matricula");
				}
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

		JLabel lblNewLabel = new JLabel("Matriculacion:");
		lblNewLabel.setBounds(350, 100, 100, 13);
		add(lblNewLabel);

		ButtonGroup group = new ButtonGroup();

		rdbtnNewRadioButton = new JRadioButton("Transferencia");
		rdbtnNewRadioButton.setBounds(516, 300, 199, 40);
		rdbtnNewRadioButton.setSelected(true);
		group.add(rdbtnNewRadioButton);
		add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Trajeta de Credito");
		rdbtnNewRadioButton_1.setBounds(516, 340, 150, 40);
		group.add(rdbtnNewRadioButton_1);
		add(rdbtnNewRadioButton_1);

		lblError = new JLabel("Error");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(90, 43, 378, 13);
		add(lblError);
		lblError.setText("");
	}

	private void validarDatosMatriculacion() throws NumberFormatException, SQLException, ClassNotFoundException {
			if (validarDatos()) {
				lblError.setText("");
				ModoPago modoPago = rdbtnNewRadioButton.isSelected() ? ModoPago.TRANSFERENCIA : ModoPago.TARJETA_CREDITO;
				GestorMatriculacion gm = new GestorMatriculacion();
				String fecha=textFieldFecha.getText();
				Date fechaSQL = Date.valueOf(fecha);



				
				gm.realizarMatriculacion(textFieldCurso.getText(), textFieldId.getText(), modoPago,  fechaSQL, true);

			} else {
				lblError.setText("No se ha podido completar la matricula. Rellena todos los campos.");
			}
		}

	private boolean validarDatos() {
		return !(textFieldFecha.getText().isEmpty() || textFieldCurso.getText().isEmpty() || textFieldId.getText().isEmpty());
	}

	private void limpiarFormulario() {
		textFieldFecha.setText("");
		textFieldCurso.setText("");
		textFieldId.setText("");
	}
}