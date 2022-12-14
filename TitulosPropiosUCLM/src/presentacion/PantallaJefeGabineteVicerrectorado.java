package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
				contentPane.revalidate();



				JLabel lblFechaInicio = new JLabel("Fecha inicio(yyyy-mm-dd):");
				lblFechaInicio.setBounds(100, 100, 200, 20);
				add(lblFechaInicio);


				textFieldFechaInicio.setBounds(250, 100, 132, 20);
				add(textFieldFechaInicio);
				textFieldFechaInicio.setColumns(10);

				JLabel lblFechaFinal = new JLabel("Fecha final(yyyy-mm-dd):");
				lblFechaFinal.setBounds(100, 150, 200, 20);
				add(lblFechaFinal);


				textFieldFechaFinal.setBounds(250, 150, 132, 20);
				add(textFieldFechaFinal);
				textFieldFechaFinal.setColumns(10);


				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						Collection<CursoPropio> resultado;
						try {
							resultado = botonConfirmarCursos(textFieldFechaFinal,textFieldFechaInicio);
							crearTabla(resultado);
							
							setTitle("Sesion: Jefe Gabinete-------Ingresos");
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


							textFieldTipo.setBounds(250, 94, 132, 20);
							add(textFieldTipo);
							textFieldTipo.setColumns(10);
							contentPane.revalidate();


							
						
							
							
							JButton btnConfirmarId = new JButton("Confirmar");
							btnConfirmarId.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									double ingresos=botonConfirmarIngresos(textFieldFechaFinal,textFieldFechaInicio,textFieldTipo);

									JLabel lblingresos = new JLabel("Ingresos: "+ingresos+"");
									lblingresos.setBounds(100, 150, 200,70);
									add(lblingresos);
									lblingresos.updateUI();
									
								}});
							btnConfirmarId.setBounds(201, 120, 100, 20);
							add(btnConfirmarId);

						} catch (ParseException e1) {

							e1.printStackTrace();
						}





					}
				});
				btnConfirmar.setBounds(201, 200, 100, 20);
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
				lblFechaInicioEdiciones.setBounds(100, 90, 200, 20);
				add(lblFechaInicioEdiciones);


				textFieldFechaInicioEdiciones.setBounds(250, 94, 132, 20);
				add(textFieldFechaInicioEdiciones);
				textFieldFechaInicioEdiciones.setColumns(10);

				JLabel lblFechaFinalEdicion = new JLabel("Fecha final(yyyy-mm-dd):");
				lblFechaFinalEdicion.setBounds(100, 150, 200, 20);
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
				btnConfirmar.setBounds(201, 200, 100, 20);
				add(btnConfirmar);







			}
		});
		btnListarEdiciones.setBounds(200, 150, 150, 20);
		add(btnListarEdiciones);

		JButton btnAprobarCursos = new JButton("Consular Cursos");
		btnAprobarCursos.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				JTextField TextIDcurso = new JTextField();
				JTextField textFieldFechaInicioEdiciones = new JTextField();
				JTextField textFieldFechaFinalEdiciones = new JTextField();

				setTitle("Sesion: Jefe Gabinete-------Consultar Cursos");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(300, 300, 520, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				contentPane.revalidate();


				JLabel lblFechaInicioEdiciones = new JLabel("Fecha inicio(yyyy-mm-dd):");
				lblFechaInicioEdiciones.setBounds(100, 90, 200, 20);
				add(lblFechaInicioEdiciones);


				textFieldFechaInicioEdiciones.setBounds(250, 94, 132, 20);
				add(textFieldFechaInicioEdiciones);
				textFieldFechaInicioEdiciones.setColumns(10);

				JLabel lblFechaFinalEdicion = new JLabel("Fecha final(yyyy-mm-dd):");
				lblFechaFinalEdicion.setBounds(100, 150, 200, 20);
				add(lblFechaFinalEdicion);


				textFieldFechaFinalEdiciones.setBounds(250, 154, 132, 20);
				add(textFieldFechaFinalEdiciones);
				textFieldFechaFinalEdiciones.setColumns(10);




				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							Collection<CursoPropio> resultado=botonConfirmarCursos(textFieldFechaFinalEdiciones,textFieldFechaInicioEdiciones);
							crearTabla(resultado);
							//fin de la informacion de los cursos


						} catch (ParseException e1) {
							e1.printStackTrace();
						}


					}
				});
				btnConfirmar.setBounds(201, 200, 100, 20);
				add(btnConfirmar);
				//mostrar informacion de los cursos propuestos

			}
		});
		btnAprobarCursos.setBounds(200, 200, 150, 20);
		add(btnAprobarCursos);


	}


	public double botonConfirmarIngresos(JTextField textFieldFechaFinal, JTextField textFieldFechaInicio, JTextField textFieldTipo) {
		GestorConsultas gConsultas=new GestorConsultas();



		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fechaAux1 =(Date)formato.parse(textFieldFechaInicio.getText());
			Date fechaAux2=(Date) formato.parse(textFieldFechaFinal.getText());

			Date fechaInicioAux=new java.sql.Date(fechaAux1.getTime());
			Date fechaFinalAux=new java.sql.Date(fechaAux2.getTime());

			System.out.println(fechaInicioAux);
			CursoPropio curso=gConsultas.seleccionarCurso(textFieldTipo.getText().trim());


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

			crearTabla(cursosEncontrados);


		}catch (Exception e1) {
			Main_testing.escribirLog(Main_testing.error,"Error al consultar cursos por ediciones");


		}


	}

	public Collection<CursoPropio>  botonConfirmarCursos(JTextField textFieldFechaFinalEdiciones,JTextField textFieldFechaInicioEdiciones ) throws ParseException {

		Collection<CursoPropio> resultado=new ArrayList<CursoPropio>();

		GestorConsultas gConsultas=new GestorConsultas();

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicioAux = (Date) formato.parse(textFieldFechaInicioEdiciones.getText());
		Date fechaFinalAux=(Date) formato.parse(textFieldFechaFinalEdiciones.getText());

		java.sql.Date fechaInicioSQL= new java.sql.Date(fechaInicioAux.getTime());
		java.sql.Date fechaFinalSQL= new java.sql.Date(fechaFinalAux.getTime());


		resultado=gConsultas.listarCursosEstados( fechaInicioSQL,fechaFinalSQL );

		return resultado;
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

	public void crearTabla(Collection<CursoPropio> resultado) {




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
			String datosMateriaNombres="Materias: ";

			for(int j=0;j<materiasCurso.length;j++) {

				Materia materiaAux=(Materia)materiasCurso[j];
				datosMateriaNombres=datosMateriaNombres+", "+materiaAux.getNombre();
			}



			tabla.addRow(new Object[] {
					cursoAux.getIdCursoPropio(),cursoAux.getNombre(),cursoAux.getECTS(),cursoAux.getTasaMatricula(),
					cursoAux.getEdicion(),cursoAux.getEstado(),cursoAux.getTipo(),
					cursoAux.getSecretario().getDni(),cursoAux.getDirector().getDni(),cursoAux.getMaterias()

			});
		}

		JScrollPane jScrollPane = new JScrollPane(jTabla);
		jFrame.add(jScrollPane);
		jFrame.setSize(350, 300);
		jFrame.setVisible(true);
		contentPane.revalidate();




	}

}
