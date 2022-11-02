package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import negocio.controllers.GestorConsultas;
import negocio.entities.TipoCurso;
import persistencia.*;


public class PantallaJefeGabineteVicerrectorado extends JFrame{
	//private static final long serialVersionUID = 1L;  no se que es
	private JTextField textFieldTipoCurso= new JTextField();;
	private JTextField textFieldFechaInicio= new JTextField();
	private JTextField textFieldFechaFinal= new JTextField();
	private JPanel contentPane;


	public PantallaJefeGabineteVicerrectorado() {


		setTitle("Sesion: Jefe Gabinete");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Consultar Ingresos

		JTextField textFieldTipoCurso= new JTextField();;
		JTextField textFieldFechaInicio= new JTextField();
		JTextField textFieldFechaFinal= new JTextField();



		JButton btnConsultarIngresos = new JButton("Consultar Ingresos");
		btnConsultarIngresos.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				setTitle("Sesion: Jefe Gabinete-------Consultar Ingresos");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(300, 300, 520, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				JLabel lblcurso = new JLabel("Curso:");
				lblcurso.setBounds(80, 90, 79, 13);
				add(lblcurso);


				textFieldTipoCurso.setBounds(145, 94, 132, 19);
				add(textFieldTipoCurso);
				textFieldTipoCurso.setColumns(10);

				JLabel lblFechaInicio = new JLabel("Fecha inicio(yyyy-mm-dd):");
				lblFechaInicio.setBounds(80, 150, 79, 13);
				add(lblFechaInicio);


				textFieldFechaInicio.setBounds(145, 154, 132, 19);
				add(textFieldFechaInicio);
				textFieldFechaInicio.setColumns(10);

				JLabel lblFechaFinal = new JLabel("Fecha final(yyyy-mm-dd):");
				lblFechaFinal.setBounds(80, 210, 79, 13);
				add(lblFechaFinal);


				textFieldFechaFinal.setBounds(145, 214, 132, 19);
				add(textFieldFechaFinal);
				textFieldFechaFinal.setColumns(10);

				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						botonConfirmar();
						
					}
				});
				btnConfirmar.setBounds(201, 274, 83, 21);
				add(btnConfirmar);
				


				//boton consultar ingresos

				//consultar curso
				//consultar ingresos
				//listar ediciones
				//aprobacion de cursos




			}
		});
		btnConsultarIngresos.setBounds(80, 157, 76, 13);
		add(btnConsultarIngresos);
	
	}//constructor
		
		
		public void botonConfirmar() {
			GestorConsultas gConsultas=new GestorConsultas();

			double ingresos=0;

			SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

			try {
				Date fechaInicioAux = (Date) formato.parse(textFieldFechaInicio.getText());
				Date fechaFinalAux=(Date) formato.parse(textFieldFechaFinal.getText());

				
				
				if(textFieldTipoCurso.getText().equals("Corta Duracion")) {

					ingresos=gConsultas.consultarIngresos(TipoCurso.CORTA_DURACION, fechaInicioAux, fechaFinalAux);

					JLabel lblIngresos = new JLabel(""+ingresos+"");
					lblIngresos.setBounds(80, 274, 79, 13);
					add(lblIngresos);

				}else if(textFieldTipoCurso.equals("Master")) {
					ingresos=gConsultas.consultarIngresos(TipoCurso.MASTER, fechaInicioAux, fechaFinalAux);

					JLabel lblIngresos = new JLabel(""+ingresos+"");
					lblIngresos.setBounds(80, 274, 79, 13);
					add(lblIngresos);


				}else if(textFieldTipoCurso.equals("Experto")) {
					ingresos=gConsultas.consultarIngresos(TipoCurso.EXPERTO, fechaInicioAux, fechaFinalAux);

					JLabel lblIngresos = new JLabel(""+ingresos+"");
					lblIngresos.setBounds(80, 274, 79, 13);
					add(lblIngresos);


				}else if(textFieldTipoCurso.equals("Especialista")) {
					ingresos=gConsultas.consultarIngresos(TipoCurso.ESPECIALISTA, fechaInicioAux, fechaFinalAux);

					JLabel lblIngresos = new JLabel(""+ingresos+"");
					lblIngresos.setBounds(80, 274, 79, 13);
					add(lblIngresos);


				}else if(textFieldTipoCurso.equals("Formacion avanzada")) {
					ingresos=gConsultas.consultarIngresos(TipoCurso.FORMACION_AVANZADA, fechaInicioAux, fechaFinalAux);

					JLabel lblIngresos = new JLabel(""+ingresos+"");
					lblIngresos.setBounds(80, 274, 79, 13);
					add(lblIngresos);


				}else if(textFieldTipoCurso.equals("Formacion Continua")) {
					ingresos=gConsultas.consultarIngresos(TipoCurso.FORMACION_CONTINUA, fechaInicioAux, fechaFinalAux);

					JLabel lblIngresos = new JLabel(""+ingresos+"");
					lblIngresos.setBounds(80, 274, 79, 13);
					add(lblIngresos);


				}else if(textFieldTipoCurso.equals("Microcredenciales")) {
					ingresos=gConsultas.consultarIngresos(TipoCurso.MICROCREDENCIALES, fechaInicioAux, fechaFinalAux);

					JLabel lblIngresos = new JLabel(""+ingresos+"");
					lblIngresos.setBounds(80, 274, 79, 13);
					add(lblIngresos);


				}

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}
		
		
		
}//clase

