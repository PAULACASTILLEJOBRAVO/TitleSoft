package presentacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorMateria;
import negocio.controllers.GestorPropuestasCursos;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;
public class PantallaDireccionCursos extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldFechaInicio;
	private JTextField textFieldCurso;
	private JTextField textFieldFechaFin;
	private JTextField textFieldTasaMatricula;
	private JTextField textFieldEdicion;
	private JTextField textFieldCentro;
	private JTextField textFieldSecretario;
	private JTextField textFieldDirector;
	private JTextField textFieldMateria;
	private JTextField textFieldHora;
	private JTextField textFieldFechaInicioMateria;
	private JTextField textFieldFechaFinMateria;
	private JTextField textFieldDniProfesor;
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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurso = new JLabel("Nombre del curso:");
		lblCurso.setBounds(90, 190, 125, 13);
		add(lblCurso);

		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(90, 205, 76, 19);
		add(textFieldCurso);
		textFieldCurso.setColumns(10);
		
		JLabel lblEdicion = new JLabel("Edición:");
		lblEdicion.setBounds(90, 235, 105, 13);
		add(lblEdicion);
		
		textFieldEdicion = new JTextField();
		textFieldEdicion.setBounds(90, 255, 76, 19);
		add(textFieldEdicion);
		textFieldEdicion.setColumns(10);
		
		JLabel lblTasaMatricula = new JLabel("Tasa de la matricula:");
		lblTasaMatricula.setBounds(90, 290, 135, 13);
		add(lblTasaMatricula);
		
		textFieldTasaMatricula = new JTextField();
		textFieldTasaMatricula.setBounds(90, 310, 76, 19);
		add(textFieldTasaMatricula);
		textFieldTasaMatricula.setColumns(10);
		
		JLabel lblCentro = new JLabel("Nombre del centro:");
		lblCentro.setBounds(90, 340, 125, 13);
		add(lblCentro);
		
		textFieldCentro = new JTextField();
		textFieldCentro.setBounds(90, 360, 76, 19);
		add(textFieldCentro);
		textFieldCentro.setColumns(10);
		
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
		
		JLabel lblTipoCurso = new JLabel("Tipo de curso:");
		lblTipoCurso.setBounds(900, 180, 105, 13);
		add(lblTipoCurso);
		
		JButton btnNewButtonAceptar = new JButton("Aceptar");
		btnNewButtonAceptar.addActionListener(e -> {
					CursoPropio curso=validarDatosPropuestaCurso();
					
					setTitle("Sesion:Direccion");
					setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					setBounds(300, 300, 520, 300);
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					contentPane.revalidate();
					
					JLabel lblFechaInicioMateria = new JLabel("Fecha de inicio de la materia (yyyy-mm-dd):");
					lblFechaInicioMateria.setBounds(416, 170, 300, 40);
					add(lblFechaInicioMateria);
					
					textFieldFechaInicioMateria = new JTextField();
					textFieldFechaInicioMateria.setBounds(416, 205, 76, 19);
					add(textFieldFechaInicioMateria);
					textFieldFechaInicioMateria.setColumns(10);
					
					JLabel lblFechaFinMateria = new JLabel("Fecha de finalizacion de la materia (yyyy-mm-dd):");
					lblFechaFinMateria.setBounds(416, 225, 300, 40);
					add(lblFechaFinMateria);
					
					textFieldFechaFinMateria = new JTextField();
					textFieldFechaFinMateria.setBounds(416, 255, 76, 19);
					add(textFieldFechaFinMateria);
					textFieldFechaFinMateria.setColumns(10);
					
					JLabel lblMateria = new JLabel("Nombre de la materia:");
					lblMateria.setBounds(90, 190, 125, 13);
					add(lblMateria);

					textFieldMateria = new JTextField();
					textFieldMateria.setBounds(90, 205, 76, 19);
					add(textFieldMateria);
					textFieldMateria.setColumns(10);
					
					JLabel lblHoras = new JLabel("Horas:");
					lblHoras.setBounds(90, 240, 105, 13);
					add(lblHoras);
					
					textFieldHora = new JTextField();
					textFieldHora.setBounds(90, 255, 76, 19);
					add(textFieldHora);
					textFieldHora.setColumns(10);
					
					JLabel lblDniProfesor = new JLabel("DNI del profesor responsabele de la materia:");
					lblDniProfesor.setBounds(416, 300, 450, 13);
					add(lblDniProfesor);
					
					textFieldDniProfesor = new JTextField();
					textFieldDniProfesor.setBounds(416, 330, 76, 19);
					add(textFieldDniProfesor);
					textFieldDniProfesor.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("Solicitud de la materia:");
					lblNewLabel.setBounds(550, 100, 120, 13);
					add(lblNewLabel);
					
					JButton btnAceptar = new JButton("Aceptar");
					btnAceptar.addActionListener((ActionEvent e1) -> validarDatosMateriaPorCurso(curso));
					btnAceptar.setBounds(200, 432, 100, 20);
					add(btnAceptar);
					
					JButton btnNewButtonCancelar = new JButton("Cancelar");
					btnNewButtonCancelar.addActionListener((ActionEvent e1) -> limpiarFormulario());
					btnNewButtonCancelar.setBounds(400, 432, 95, 21);
					add(btnNewButtonCancelar);
		});
		btnNewButtonAceptar.setBounds(553, 432, 83, 21);
		add(btnNewButtonAceptar);

		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener((ActionEvent e) -> limpiarFormulario());
		btnNewButtonCancelar.setBounds(658, 432, 83, 21);
		add(btnNewButtonCancelar);

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
	
	private CursoPropio validarDatosPropuestaCurso(){
		CursoPropio cursoPropuesto=null;	
		if (validarDatosCurso()) {
				TipoCurso tipoCurso = null;
				
				if(rdbtnNewRadioButtonCortaDuracion.isSelected()) {
					tipoCurso = TipoCurso.CORTA_DURACION;
				}else if(rdbtnNewRadioButtonMaster.isSelected()) {
					tipoCurso = TipoCurso.MASTER;
				}else if(rdbtnNewRadioButtonEspecialista.isSelected()) {
					tipoCurso = TipoCurso.ESPECIALISTA;
				}else if(rdbtnNewRadioButtonExperto.isSelected()) {
					tipoCurso = TipoCurso.EXPERTO;
				}else if(rdbtnNewRadioButtonFormacionAvanzada.isSelected()) {
					tipoCurso = TipoCurso.FORMACION_AVANZADA;
				}else if(rdbtnNewRadioButtonFormacionContinua.isSelected()) {
					tipoCurso = TipoCurso.FORMACION_CONTINUA;
				}else if(rdbtnNewRadioButtonMicrocredenciales.isSelected()) {
					tipoCurso = TipoCurso.MICROCREDENCIALES;
				}
				
				GestorPropuestasCursos gestorPropuestaCurso = new GestorPropuestasCursos();
				String fechaInicio=textFieldFechaInicio.getText();
				Date fechaSQLInicio = Date.valueOf(fechaInicio);
				
				String fechaFin=textFieldFechaFin.getText();
				Date fechaSQLFin = Date.valueOf(fechaFin);
				
				double tasaMatricula = Integer.parseInt(textFieldTasaMatricula.getText()) + 0.0;
				
				cursoPropuesto = gestorPropuestaCurso.realizarPropuestaCurso(textFieldCurso.getText(), fechaSQLInicio, fechaSQLFin, tasaMatricula,  Integer.parseInt(textFieldEdicion.getText()), textFieldDirector.getText(), textFieldSecretario.getText(), EstadoCurso.PROPUESTO, tipoCurso, textFieldCentro.getText());
			} else {
				lblError.setText("No se ha podido completar el curso. Rellena todos los campos.");
			}
			return cursoPropuesto;
	}
	
	public void validarDatosMateriaPorCurso(CursoPropio cursoNuevo) {
		if (validarDatosMateria()) {
			GestorMateria gestorMateria = new GestorMateria();
			String fechaInicio=textFieldFechaInicioMateria.getText();
			Date fechaSQLInicio = Date.valueOf(fechaInicio);
			
			String fechaFin=textFieldFechaFinMateria.getText();
			Date fechaSQLFin = Date.valueOf(fechaFin);
			
			int horas = Integer.parseInt(textFieldHora.getText());
			
			gestorMateria.realizarMateria(textFieldDniProfesor.getText(), textFieldMateria.getText(), horas, fechaSQLInicio, fechaSQLFin, cursoNuevo);
			} else {
			lblError.setText("No se ha podido completar la materia. Rellena todos los campos.");
		}
	}

	private boolean validarDatosCurso() {
		return !(textFieldFechaInicio.getText().isEmpty() || textFieldFechaFin.getText().isEmpty() || textFieldCentro.getText().isEmpty()
				|| textFieldCurso.getText().isEmpty() || textFieldDirector.getText().isEmpty() || textFieldSecretario.getText().isEmpty() 
				|| textFieldEdicion.getText().isEmpty() || textFieldTasaMatricula.getText().isEmpty());
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
		textFieldSecretario.setText("");
		textFieldTasaMatricula.setText("");
	}
}