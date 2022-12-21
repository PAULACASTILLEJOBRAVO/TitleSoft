package presentacion;

import java.sql.Date;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorMatriculacion;
import negocio.entities.ModoPago;

public class PantallaMatriculacion extends JFrame {
	private JTextField textFieldFecha;
	private JTextField textFieldCurso;
	private JTextField textFieldId;
	private JLabel lblError;
	private JRadioButton rdbtnTransferencia;
	private JRadioButton rdbtnTarjetaCredito;
	private JPanel contentPane;

	public PantallaMatriculacion() {
		setTitle("Sesion: Estudiante");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

		JButton botonAceptar= new JButton("Aceptar");
		botonAceptar.addActionListener((ActionEvent e) -> validarDatosMatriculacion());
		botonAceptar.setBounds(553, 432, 83, 21);
		add(botonAceptar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener((ActionEvent e) -> limpiarFormulario());
		botonCancelar.setBounds(658, 432, 83, 21);
		add(botonCancelar);

		JLabel lblMatriculacion = new JLabel("Matriculacion:");
		lblMatriculacion.setBounds(350, 100, 100, 13);
		add(lblMatriculacion);

		ButtonGroup group = new ButtonGroup();

		rdbtnTransferencia = new JRadioButton("Transferencia");
		rdbtnTransferencia.setBounds(516, 300, 199, 40);
		rdbtnTransferencia.setSelected(true);
		group.add(rdbtnTransferencia);
		add(rdbtnTransferencia);

		rdbtnTarjetaCredito = new JRadioButton("Trajeta de Credito");
		rdbtnTarjetaCredito.setBounds(516, 340, 150, 40);
		group.add(rdbtnTarjetaCredito);
		add(rdbtnTarjetaCredito);

		lblError = new JLabel("Error");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(90, 43, 378, 13);
		add(lblError);
		lblError.setText("");
	}

	private void validarDatosMatriculacion() {
			if (validarDatos()) {
				lblError.setText("");
				ModoPago modoPago = rdbtnTransferencia.isSelected() ? ModoPago.TRANSFERENCIA : ModoPago.TARJETA_CREDITO;
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