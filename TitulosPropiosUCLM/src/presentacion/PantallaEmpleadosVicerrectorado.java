package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import negocio.controllers.GestorConsultas;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Materia;

public class PantallaEmpleadosVicerrectorado extends JFrame {

	private JTextField textFieldUsuario= new JTextField();;
	private JTextField textFieldPassword= new JTextField();
	private JPanel contentPane;

	public PantallaEmpleadosVicerrectorado() {

		setTitle("Sesion:Vicerrector");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


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


				JLabel lblIDcurso = new JLabel("Id del curso:");
				lblIDcurso.setBounds(100, 90, 79, 20);
				add(lblIDcurso);


				TextIDcurso.setBounds(250, 94, 132, 20);
				add(TextIDcurso);
				TextIDcurso.setColumns(10);


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
				contentPane.revalidate();
				//fin de la informacion de los cursos


				JButton btnConfirmar = new JButton("Aprobar");
				btnConfirmar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							botonAprobarCurso(TextIDcurso);
							JLabel lblCursoAprobado = new JLabel("Curso Aprobado correctamente");
							lblCursoAprobado.setBounds(100, 120, 150, 20);
							add(lblCursoAprobado);
							lblCursoAprobado.updateUI();

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
							lblCursoRechazado.updateUI();

						} catch (Exception e1) {

							e1.printStackTrace();
						}

					}
				});
				btnRechazar.setBounds(201, 170, 100, 20);
				add(btnRechazar);





			}
		});
		btnAprobarCursos.setBounds(200, 100, 150, 20);
		add(btnAprobarCursos);


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