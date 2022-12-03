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
import negocio.entities.EstadoCurso;
import negocio.entities.Materia;
import negocio.entities.Profesor;
import negocio.entities.ProfesorUCLM;
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

				JTextField textFieldId= new JTextField();
				JTextField textFieldFechaInicio= new JTextField();
				JTextField textFieldFechaFinal= new JTextField();


				setTitle("Sesion: Jefe Gabinete-------Consultar Ingresos");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(300, 300, 520, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				contentPane.revalidate();

				JLabel lblcurso = new JLabel("Id Curso:");
				lblcurso.setBounds(100, 90, 200, 20);
				add(lblcurso);


				textFieldId.setBounds(250, 94, 132, 20);
				add(textFieldId);
				textFieldId.setColumns(10);

				JLabel lblFechaInicio = new JLabel("Fecha inicio(yyyy-mm-dd):");
				lblFechaInicio.setBounds(100, 150, 200, 20);
				add(lblFechaInicio);


				textFieldFechaInicio.setBounds(250, 154, 132, 20);
				add(textFieldFechaInicio);
				textFieldFechaInicio.setColumns(10);

				JLabel lblFechaFinal = new JLabel("Fecha final(yyyy-mm-dd):");
				lblFechaFinal.setBounds(100, 210, 200, 20);
				add(lblFechaFinal);


				textFieldFechaFinal.setBounds(250, 214, 132, 20);
				add(textFieldFechaFinal);
				textFieldFechaFinal.setColumns(10);

				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						double ingresos=botonConfirmarIngresos(textFieldFechaFinal,textFieldFechaInicio,textFieldId);
						
						JLabel lblingresos = new JLabel("Ingresos: "+ingresos+"");
						lblingresos.setBounds(100, 300, 200,70);
						add(lblingresos);
									
						
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
				contentPane.revalidate();


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

		JButton btnAprobarCursos = new JButton("Aprobar Cursos");
		btnAprobarCursos.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				JTextField TextIDcurso = new JTextField();

				setTitle("Sesion: Jefe Gabinete-------Aprobar Cursos");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(300, 300, 520, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				contentPane.revalidate();



				//mostrar informacion de los cursos propuestos
				GestorConsultas gConsultas=new GestorConsultas();
				Collection<CursoPropio> resultado=gConsultas.consultarEstadoCursos(EstadoCurso.PROPUESTO);

				JFrame jFrame=new JFrame();
				jFrame.setTitle("Propuestas Cursos");
				DefaultTableModel tabla=new DefaultTableModel();
				JTable jTabla = new JTable(tabla);
				jTabla.setBounds(30,10,230,280);
				tabla.addColumn("Id");
				tabla.addColumn("Nombre del Curso");
				tabla.addColumn("ECTS");
				tabla.addColumn("Tasa Matricula");
				tabla.addColumn("Edicion");
				tabla.addColumn("Estado");
				tabla.addColumn("Tipo Curso");
				tabla.addColumn("Secretario");
				tabla.addColumn("Director");
				tabla.addColumn("Materia");

				Iterator<CursoPropio> it=resultado.iterator();
				while(it.hasNext()) {
					CursoPropio cursoAux=it.next();
					Object[] materiasCurso=cursoAux.getMaterias().toArray();
					String datosMateriaNombres=" ";

					for(int j=0;j<materiasCurso.length;j++) {

						Materia materiaAux=(Materia)materiasCurso[j];
						datosMateriaNombres=materiaAux.getNombre()+" ,"+datosMateriaNombres;
					}
					
					
					
					tabla.addRow(new Object[] {
							cursoAux.getIdCursoPropio(),cursoAux.getNombre(),cursoAux.getECTS(),cursoAux.getTasaMatricula(),
							cursoAux.getEdicion(),cursoAux.getEstado(),cursoAux.getTipo(),
							cursoAux.getSecretario().getNombre(),cursoAux.getDirector().getNombre(),datosMateriaNombres

					});
				}

				JScrollPane jScrollPane = new JScrollPane(jTabla);
				jFrame.add(jScrollPane);
				jFrame.setSize(350, 300);
				jFrame.setVisible(true);

				//fin de la informacion de los cursos

				JLabel lblIDcurso = new JLabel("Id del curso:");
				lblIDcurso.setBounds(100, 90, 79, 20);
				add(lblIDcurso);


				TextIDcurso.setBounds(250, 94, 132, 20);
				add(TextIDcurso);
				TextIDcurso.setColumns(10);


				JButton btnConfirmar = new JButton("Aprobar");
				btnConfirmar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							botonAprobarCurso(TextIDcurso);
							JLabel lblCursoAprobado = new JLabel("Curso Aprobado correctamente");
							lblCursoAprobado.setBounds(100, 120, 150, 20);
							add(lblCursoAprobado);
							
							
						} catch (Exception e1) {

							e1.printStackTrace();
						}

					}
				});
				btnConfirmar.setBounds(201, 150, 100, 20);
				add(btnConfirmar);

				JButton btnRechazar = new JButton("Rechazar");
				btnRechazar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							botonRechazarCurso(TextIDcurso);
							
							JLabel lblCursoRechazado = new JLabel("Curso rechazado correctamente");
							lblCursoRechazado.setBounds(100, 120, 180, 20);
							add(lblCursoRechazado);
							
							
						} catch (Exception e1) {

							e1.printStackTrace();
						}

					}
				});
				btnRechazar.setBounds(201, 170, 100, 20);
				add(btnRechazar);





			}
		});
		btnAprobarCursos.setBounds(200, 200, 150, 20);
		add(btnAprobarCursos);


	}


	public double botonConfirmarIngresos(JTextField textFieldFechaFinal, JTextField textFieldFechaInicio, JTextField textFieldId) {
		GestorConsultas gConsultas=new GestorConsultas();

		

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fechaAux1 =(Date)formato.parse(textFieldFechaInicio.getText());
			Date fechaAux2=(Date) formato.parse(textFieldFechaFinal.getText());

			Date fechaInicioAux=new java.sql.Date(fechaAux1.getTime());
			Date fechaFinalAux=new java.sql.Date(fechaAux2.getTime());

			System.out.println(fechaInicioAux);
			CursoPropio curso=gConsultas.seleccionarCurso(textFieldId.getText().trim());


			return gConsultas.consultarIngresos(curso.getTipo(), fechaInicioAux, fechaFinalAux);

			


		} catch (Exception e1) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar ingresos");
			return 0;

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
			JTable jTabla = new JTable(tabla);
			jTabla.setBounds(30,10,230,280);
			tabla.addColumn("Id");
			tabla.addColumn("Nombre del Curso");
			tabla.addColumn("ECTS");
			tabla.addColumn("Tasa Matricula");
			tabla.addColumn("Edicion");
			tabla.addColumn("Estado");
			tabla.addColumn("Tipo Curso");
			tabla.addColumn("Secretario");
			tabla.addColumn("Director");
			tabla.addColumn("Materia");


			for (int i=0; i< aux.length;i++) {
				CursoPropio cursoAux=(CursoPropio)aux[i];
				Profesor director=cursoAux.getDirector();
				Profesor secretario=cursoAux.getSecretario();
				Object[] materiasCurso=cursoAux.getMaterias().toArray();
				String datosMateriaNombres="";

				for(int j=0;j<materiasCurso.length;j++) {

					Materia materiaAux=(Materia)materiasCurso[j];
					datosMateriaNombres=materiaAux.getNombre()+","+datosMateriaNombres;
				}


				tabla.addRow(new Object[] {cursoAux.getIdCursoPropio(),cursoAux.getNombre(),cursoAux.getECTS(),cursoAux.getTasaMatricula(),
						cursoAux.getEdicion(),cursoAux.getEstado().toString(),cursoAux.getTipo().toString(),secretario.getNombre(),
						director.getNombre(),datosMateriaNombres

				});
			}

			JScrollPane jScrollPane = new JScrollPane(jTabla);
			jFrame.add(jScrollPane);
			jFrame.setSize(550, 500);
			jFrame.setVisible(true);



		}catch (Exception e1) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar cursos por ediciones");


		}


	}

	public void botonAprobarCurso(JTextField textIDcurso) throws Exception {

		GestorConsultas gConsultas= new GestorConsultas();
		CursoPropio cursoAprobado= gConsultas.seleccionarCurso(textIDcurso.getText());

		cursoAprobado.setEstado(EstadoCurso.VALIDADO);

		cursoAprobado=gConsultas.actualizarCurso(cursoAprobado);



	}	

	public void botonRechazarCurso(JTextField textIDcurso) throws Exception {

		GestorConsultas gConsultas= new GestorConsultas();
		CursoPropio cursoRechazado= gConsultas.seleccionarCurso(textIDcurso.getText());

		cursoRechazado.setEstado(EstadoCurso.PROPUESTA_RECHAZADA);

		cursoRechazado=gConsultas.actualizarCurso(cursoRechazado);

	}
}
