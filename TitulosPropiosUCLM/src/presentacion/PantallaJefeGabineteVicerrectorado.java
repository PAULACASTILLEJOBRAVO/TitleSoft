package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
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
import negocio.entities.CursoPropio;
import negocio.entities.TipoCurso;
import persistencia.*;


public class PantallaJefeGabineteVicerrectorado extends JFrame{
	//private static final long serialVersionUID = 1L;  no se que es

	private JPanel contentPane;


	public PantallaJefeGabineteVicerrectorado() {


		setTitle("Sesion: Jefe Gabinete");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		//consultar ingresos
		//listar ediciones
		//aprobacion de cursos




		JButton btnConsultarIngresos = new JButton("Consultar Ingresos");
		btnConsultarIngresos.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				JTextField textFieldTipo= new JTextField();
				JTextField textFieldFechaInicio= new JTextField();
				JTextField textFieldFechaFinal= new JTextField();


				setTitle("Sesion: Jefe Gabinete-------Consultar Ingresos");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(300, 300, 520, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				JLabel lblcurso = new JLabel("Tipo Curso:");
				lblcurso.setBounds(100, 90, 79, 20);
				add(lblcurso);


				textFieldTipo.setBounds(250, 94, 132, 20);
				add(textFieldTipo);
				textFieldTipo.setColumns(10);

				JLabel lblFechaInicio = new JLabel("Fecha inicio(yyyy-mm-dd):");
				lblFechaInicio.setBounds(100, 150, 79, 20);
				add(lblFechaInicio);


				textFieldFechaInicio.setBounds(250, 154, 132, 20);
				add(textFieldFechaInicio);
				textFieldFechaInicio.setColumns(10);

				JLabel lblFechaFinal = new JLabel("Fecha final(yyyy-mm-dd):");
				lblFechaFinal.setBounds(100, 210, 79, 20);
				add(lblFechaFinal);


				textFieldFechaFinal.setBounds(250, 214, 132, 20);
				add(textFieldFechaFinal);
				textFieldFechaFinal.setColumns(10);

				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						botonConfirmarIngresos(textFieldFechaFinal,textFieldFechaInicio,textFieldTipo);

					}
				});
				btnConfirmar.setBounds(201, 274, 100, 20);
				add(btnConfirmar);







			}
		});
		btnConsultarIngresos.setBounds(200, 100, 150, 20);
		add(btnConsultarIngresos);



		JButton btnListarEdiciones = new JButton("Listar Ediciones");
		btnListarEdiciones.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				JTextField textFieldFechaInicioEdiciones = new JTextField();
				JTextField textFieldFechaFinalEdiciones = new JTextField();

				setTitle("Sesion: Jefe Gabinete-------Listar Ediciones");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(300, 300, 520, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);


				JLabel lblFechaInicioEdiciones = new JLabel("Fecha inicio(yyyy-mm-dd):");
				lblFechaInicioEdiciones.setBounds(100, 90, 79, 20);
				add(lblFechaInicioEdiciones);


				textFieldFechaInicioEdiciones.setBounds(250, 94, 132, 20);
				add(textFieldFechaInicioEdiciones);
				textFieldFechaInicioEdiciones.setColumns(10);

				JLabel lblFechaFinalEdicion = new JLabel("Fecha final(yyyy-mm-dd):");
				lblFechaFinalEdicion.setBounds(100, 150, 79, 20);
				add(lblFechaFinalEdicion);


				textFieldFechaFinalEdiciones.setBounds(250, 154, 132, 20);
				add(textFieldFechaFinalEdiciones);
				textFieldFechaFinalEdiciones.setColumns(10);

				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						botonConfirmarEdiciones(textFieldFechaFinalEdiciones,textFieldFechaInicioEdiciones);

					}
				});
				btnConfirmar.setBounds(201, 274, 100, 20);
				add(btnConfirmar);







			}
		});
		btnListarEdiciones.setBounds(200, 150, 150, 20);
		add(btnListarEdiciones);




	}


	public void botonConfirmarIngresos(JTextField textFieldFechaFinal, JTextField textFieldFechaInicio, JTextField textFieldTipo) {
		GestorConsultas gConsultas=new GestorConsultas();

		double ingresos=0;

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");

		try {
			java.sql.Date fechaInicioAux =new java.sql.Date( ((formato.parse(textFieldFechaInicio.getText()).getTime())));
			Date fechaFinalAux=(Date) formato.parse(textFieldFechaFinal.getText());
			System.out.println(fechaInicioAux);
			CursoPropio curso=gConsultas.seleccionarCurso(textFieldTipo.getText().trim());

			if(curso.getTipo().equals("Corta Duracion")) {

				ingresos=gConsultas.consultarIngresos(TipoCurso.CORTA_DURACION, fechaInicioAux, fechaFinalAux);

				JLabel lblIngresos = new JLabel(""+ingresos+"");
				lblIngresos.setBounds(80, 274, 79, 13);
				add(lblIngresos);

			}else if(curso.getTipo().equals("Master")) {
				ingresos=gConsultas.consultarIngresos(TipoCurso.MASTER, fechaInicioAux, fechaFinalAux);

				JLabel lblIngresos = new JLabel(""+ingresos+"");
				lblIngresos.setBounds(80, 274, 79, 13);
				add(lblIngresos);


			}else if(curso.getTipo().equals("Experto")) {
				ingresos=gConsultas.consultarIngresos(TipoCurso.EXPERTO, fechaInicioAux, fechaFinalAux);

				JLabel lblIngresos = new JLabel(""+ingresos+"");
				lblIngresos.setBounds(80, 274, 79, 13);
				add(lblIngresos);


			}else if(curso.getTipo().equals("Especialista")) {
				ingresos=gConsultas.consultarIngresos(TipoCurso.ESPECIALISTA, fechaInicioAux, fechaFinalAux);

				JLabel lblIngresos = new JLabel(""+ingresos+"");
				lblIngresos.setBounds(80, 274, 79, 13);
				add(lblIngresos);


			}else if(curso.getTipo().equals("Formacion avanzada")) {
				ingresos=gConsultas.consultarIngresos(TipoCurso.FORMACION_AVANZADA, fechaInicioAux, fechaFinalAux);

				JLabel lblIngresos = new JLabel(""+ingresos+"");
				lblIngresos.setBounds(80, 274, 79, 13);
				add(lblIngresos);


			}else if(curso.getTipo().equals("Formacion Continua")) {
				ingresos=gConsultas.consultarIngresos(TipoCurso.FORMACION_CONTINUA, fechaInicioAux, fechaFinalAux);

				JLabel lblIngresos = new JLabel(""+ingresos+"");
				lblIngresos.setBounds(80, 274, 79, 13);
				add(lblIngresos);


			}else if(curso.getTipo().equals("Microcredenciales")) {
				ingresos=gConsultas.consultarIngresos(TipoCurso.MICROCREDENCIALES, fechaInicioAux, fechaFinalAux);

				JLabel lblIngresos = new JLabel(""+ingresos+"");
				lblIngresos.setBounds(80, 274, 79, 13);
				add(lblIngresos);


			}

		} catch (Exception e1) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar ingresos");

		}


	}

	public void botonConfirmarEdiciones(JTextField textFieldFechaFinalEdiciones, JTextField textFieldFechaInicioEdiciones) {

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fechaInicioAux = (Date) formato.parse(textFieldFechaInicioEdiciones.getText());
			Date fechaFinalAux=(Date) formato.parse(textFieldFechaFinalEdiciones.getText());

			java.sql.Date fechaInicioSQL= new java.sql.Date(fechaInicioAux.getTime());
			java.sql.Date fechaFinalSQL= new java.sql.Date(fechaFinalAux.getTime());
			
			System.out.println(fechaInicioSQL);
			GestorConsultas gConsultas=new GestorConsultas();

			Collection<CursoPropio> cursosEncontrados=gConsultas.listarEdicionesCursos(fechaInicioSQL, fechaFinalSQL);

			Object []aux= cursosEncontrados.toArray();				




			JFrame jFrame=new JFrame();
			jFrame.setTitle("Ediciones: Fecha inicial "+fechaInicioSQL+" .Fecha final "+fechaFinalSQL);
			DefaultTableModel tabla=new DefaultTableModel();
			JTable jTabla = new JTable();
			jTabla.setBounds(30,10,230,280);
			tabla.addColumn("Id");
			tabla.addColumn("Nombre del Curso");
			tabla.addColumn("ECTS");
			tabla.addColumn("Tasa Matricula");
			tabla.addColumn("Edicion");
			tabla.addColumn("Estado");
			tabla.addColumn("Tipo Curso");
			tabla.addColumn("Centro");
			tabla.addColumn("Secretario");
			tabla.addColumn("Director");
			tabla.addColumn("Materia");


			for (int i=0; i< aux.length;i++) {
				String[] auxVariables=aux[i].toString().trim().replace("[", "").replace("]", "").split(",");

				tabla.addRow(new Object[] {auxVariables[0],auxVariables[1],auxVariables[2],auxVariables[3],
						auxVariables[4],auxVariables[5],auxVariables[6],auxVariables[7],
						auxVariables[8],auxVariables[9],auxVariables[10]

				});
			}

			JScrollPane jScrollPane = new JScrollPane(jTabla);
			jFrame.add(jScrollPane);
			jFrame.setSize(350, 300);
			jFrame.setVisible(true);



		}catch (Exception e1) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar cursos por ediciones");


		}


	}

}
