package presentacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorMatriculacion;
import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.EstadoCurso;
import negocio.entities.ModoPago;
import negocio.entities.TipoCurso;
public class PantallaDireccionCursos extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldFechaInicio;
	private JTextField textFieldCurso;
	private JTextField textFieldFechaFin;
	private JTextField textFieldEtcs;
	private JTextField textFieldTasaMatricula;
	private JTextField textFieldEdicion;
	private JTextField textFieldCentro;
	private JTextField textFieldSecretario;
	private JTextField textFieldDirector;
	private JLabel lblError;
	private JRadioButton rdbtnNewRadioButtonMaster;
	private JRadioButton rdbtnNewRadioButtonExperto;
	private JRadioButton rdbtnNewRadioButtonEspecialista;
	private JRadioButton rdbtnNewRadioButtonCortaDuracion;
	private JRadioButton rdbtnNewRadioButtonMicrocredenciales;
	private JRadioButton rdbtnNewRadioButtonFormacionContinua;
	private JRadioButton rdbtnNewRadioButtonFormacionAvanzada;
	
	public PantallaDireccionCursos() {
		
		setTitle("Sesion:Direccion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio del curso (yyyy-mm-dd):");
		lblFechaInicio.setBounds(416, 170, 287, 40);
		add(lblFechaInicio);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setBounds(416, 205, 76, 19);
		add(textFieldFechaInicio);
		textFieldFechaInicio.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha de finalizacion del curso (yyyy-mm-dd):");
		lblFechaFin.setBounds(416, 225, 287, 40);
		add(lblFechaFin);
		
		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setBounds(416, 255, 76, 19);
		add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		
		JLabel lblCurso = new JLabel("Nombre del curso:");
		lblCurso.setBounds(90, 190, 125, 13);
		add(lblCurso);

		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(90, 205, 76, 19);
		add(textFieldCurso);
		textFieldCurso.setColumns(10);
		
		JLabel lblTipoCurso = new JLabel("Tipo de curso:");
		lblTipoCurso.setBounds(900, 180, 105, 13);
		add(lblTipoCurso);
		
		JLabel lblETC = new JLabel("Número de ETCS:");
		lblETC.setBounds(90, 240, 105, 13);
		add(lblETC);
		
		textFieldEtcs = new JTextField();
		textFieldEtcs.setBounds(90, 255, 76, 19);
		add(textFieldEtcs);
		textFieldEtcs.setColumns(10);
		
		JLabel lblEdicion = new JLabel("Edición:");
		lblEdicion.setBounds(90, 280, 105, 13);
		add(lblEdicion);
		
		textFieldEdicion = new JTextField();
		textFieldEdicion.setBounds(90, 295, 76, 19);
		add(textFieldEdicion);
		textFieldEdicion.setColumns(10);
		
		JLabel lblTasaMatricula = new JLabel("Tasa de la matricula:");
		lblTasaMatricula.setBounds(90, 320, 135, 13);
		add(lblTasaMatricula);
		
		textFieldTasaMatricula = new JTextField();
		textFieldTasaMatricula.setBounds(90, 335, 76, 19);
		add(textFieldTasaMatricula);
		textFieldTasaMatricula.setColumns(10);
		
		JLabel lblCentro = new JLabel("Nombre del centro:");
		lblCentro.setBounds(90, 360, 125, 13);
		add(lblCentro);
		
		textFieldCentro = new JTextField();
		textFieldCentro.setBounds(90, 375, 76, 19);
		add(textFieldCentro);
		textFieldCentro.setColumns(10);
		
		JLabel lblDirector = new JLabel("DNI del director del curso:");
		lblDirector.setBounds(416, 300, 190, 13);
		add(lblDirector);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setBounds(416, 320, 76, 19);
		add(textFieldDirector);
		textFieldDirector.setColumns(10);
		
		JLabel lblSecretario = new JLabel("DNI del secretario del curso:");
		lblSecretario.setBounds(416, 350, 190, 13);
		add(lblSecretario);
		
		textFieldSecretario = new JTextField();
		textFieldSecretario.setBounds(416, 370, 76, 19);
		add(textFieldSecretario);
		textFieldSecretario.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validarDatosPropuestaCurso();
				} catch (SQLException | NumberFormatException | ClassNotFoundException e1) {
					Main_testing.escribirLog(Main_testing.error,"Error a realizar propuesta del curso");
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

		JLabel lblNewLabel = new JLabel("Solicitud de curso:");
		lblNewLabel.setBounds(550, 100, 120, 13);
		add(lblNewLabel);

		ButtonGroup group = new ButtonGroup();

		rdbtnNewRadioButtonMaster = new JRadioButton("Master");
		rdbtnNewRadioButtonMaster.setBounds(900, 200, 199, 40);
		rdbtnNewRadioButtonMaster.setSelected(true);
		group.add(rdbtnNewRadioButtonMaster);
		add(rdbtnNewRadioButtonMaster);

		rdbtnNewRadioButtonExperto = new JRadioButton("Experto");
		rdbtnNewRadioButtonExperto.setBounds(900, 230, 150, 40);
		group.add(rdbtnNewRadioButtonExperto);
		add(rdbtnNewRadioButtonExperto);
		
		rdbtnNewRadioButtonEspecialista= new JRadioButton("Especialista");
		rdbtnNewRadioButtonEspecialista.setBounds(900, 260, 150, 40);
		group.add(rdbtnNewRadioButtonEspecialista);
		add(rdbtnNewRadioButtonEspecialista);

		rdbtnNewRadioButtonFormacionAvanzada = new JRadioButton("Formación avanzada");
		rdbtnNewRadioButtonFormacionAvanzada.setBounds(900, 290, 150, 40);
		group.add(rdbtnNewRadioButtonFormacionAvanzada);
		add(rdbtnNewRadioButtonFormacionAvanzada);
		
		rdbtnNewRadioButtonFormacionContinua = new JRadioButton("Formación continua");
		rdbtnNewRadioButtonFormacionContinua.setBounds(900, 320, 150, 40);
		group.add(rdbtnNewRadioButtonFormacionContinua);
		add(rdbtnNewRadioButtonFormacionContinua);
		
		rdbtnNewRadioButtonMicrocredenciales = new JRadioButton("Microcredenciales");
		rdbtnNewRadioButtonMicrocredenciales.setBounds(900, 350, 150, 40);
		group.add(rdbtnNewRadioButtonMicrocredenciales);
		add(rdbtnNewRadioButtonMicrocredenciales);
		
		rdbtnNewRadioButtonCortaDuracion = new JRadioButton("Corta duración");
		rdbtnNewRadioButtonCortaDuracion.setBounds(900, 380, 150, 40);
		group.add(rdbtnNewRadioButtonCortaDuracion);
		add(rdbtnNewRadioButtonCortaDuracion);
		
		lblError = new JLabel("Error");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(90, 43, 378, 13);
		add(lblError);
		lblError.setText("");
	}


	public void edicionCurso() {
		throw new UnsupportedOperationException();
	}
	
	private void validarDatosPropuestaCurso() throws NumberFormatException, SQLException, ClassNotFoundException {
			if (validarDatosCurso()) {
				lblError.setText("");
				TipoCurso tipoCurso = rdbtnNewRadioButtonMaster.isSelected() ? TipoCurso.MASTER : TipoCurso.EXPERTO;
				tipoCurso = rdbtnNewRadioButtonExperto.isSelected() ? TipoCurso.EXPERTO : TipoCurso.ESPECIALISTA;
				tipoCurso = rdbtnNewRadioButtonEspecialista.isSelected() ? TipoCurso.ESPECIALISTA : TipoCurso.MICROCREDENCIALES;
				tipoCurso = rdbtnNewRadioButtonMicrocredenciales.isSelected() ? TipoCurso.MICROCREDENCIALES : TipoCurso.CORTA_DURACION;
				tipoCurso = rdbtnNewRadioButtonCortaDuracion.isSelected() ? TipoCurso.CORTA_DURACION : TipoCurso.FORMACION_AVANZADA;
				tipoCurso = rdbtnNewRadioButtonFormacionAvanzada.isSelected() ? TipoCurso.FORMACION_AVANZADA : TipoCurso.FORMACION_CONTINUA;
				tipoCurso = rdbtnNewRadioButtonFormacionContinua.isSelected() ? TipoCurso.FORMACION_CONTINUA : TipoCurso.MASTER;
				
				GestorPropuestasCursos gestorPropuestaCurso = new GestorPropuestasCursos();
				String fechaInicio=textFieldFechaInicio.getText();
				Date fechaSQLInicio = Date.valueOf(fechaInicio);
				
				String fechaFin=textFieldFechaFin.getText();
				Date fechaSQLFin = Date.valueOf(fechaFin);
				
				double tasaMatricula = Integer.parseInt(textFieldTasaMatricula.getText()) + 0.0;
				
				gestorPropuestaCurso.realizarPropuestaCurso(textFieldCurso.getText(), fechaSQLInicio, fechaSQLFin, Integer.parseInt(textFieldEtcs.getText()), tasaMatricula, Integer.parseInt(textFieldEdicion.getText()), textFieldDirector.getText(), textFieldSecretario.getText(), EstadoCurso.PROPUESTO, tipoCurso, textFieldCentro.getText());
			} else {
				lblError.setText("No se ha podido completar la matricula. Rellena todos los campos.");
			}
	}

	private boolean validarDatosCurso() {
		return !(textFieldFechaInicio.getText().isEmpty() || textFieldCurso.getText().isEmpty() || textFieldFechaFin.getText().isEmpty()
				|| textFieldCurso.getText().isEmpty() || textFieldEtcs.getText().isEmpty() || textFieldDirector.getText().isEmpty()
				|| textFieldEdicion.getText().isEmpty() || textFieldSecretario.getText().isEmpty() || textFieldTasaMatricula.getText().isEmpty());
	}
	
	private boolean validarDatosMateria() {
		return !(textFieldMateria.getText().isEmpty() || textFieldHora.getText().isEmpty() || textFieldFechaFinMateria.getText().isEmpty()
				|| textFieldFechaInicioMateria.getText().isEmpty() || textFieldDniProfesor.getText().isEmpty());
	}

	private void limpiarFormulario() {
		textFieldFechaInicio.setText("");
		textFieldCurso.setText("");
		textFieldFechaFin.setText("");
		textFieldEdicion.setText("");
		textFieldCentro.setText("");
		textFieldEtcs.setText("");
		textFieldSecretario.setText("");
		textFieldTasaMatricula.setText("");
	}
}