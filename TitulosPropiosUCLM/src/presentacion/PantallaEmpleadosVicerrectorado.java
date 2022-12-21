package presentacion;

import java.awt.event.ActionEvent;

import java.util.Collection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorConsultas;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;

public class PantallaEmpleadosVicerrectorado extends JFrame {
	private JPanel contentPane;

	public PantallaEmpleadosVicerrectorado() {
		setTitle("Sesion:Vicerrector");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAprobarCursos = new JButton("Aprobar Cursos");
		btnAprobarCursos.addActionListener((ActionEvent e) -> {
			JTextField textIDcurso = new JTextField();

			setTitle("Sesion: Jefe Gabinete-------Aprobar Cursos");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setBounds(300, 300, 520, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			contentPane.revalidate();

			JLabel lblIDcurso = new JLabel("Id del curso:");
			lblIDcurso.setBounds(100, 90, 79, 20);
			add(lblIDcurso);

			textIDcurso.setBounds(250, 94, 132, 20);
			add(textIDcurso);
			textIDcurso.setColumns(10);

			GestorConsultas gConsultas=new GestorConsultas();
			Collection<CursoPropio> resultado=gConsultas.consultarCursosPropuestos(EstadoCurso.PROPUESTO);

			PantallaJefeGabineteVicerrectorado.crearTabla(resultado);
			contentPane.revalidate();

			JButton btnConfirmar = new JButton("Aprobar");
			btnConfirmar.addActionListener((ActionEvent e1) -> {
				botonAprobarCurso(textIDcurso);
				JLabel lblCursoAprobado = new JLabel("Curso Aprobado correctamente");
				lblCursoAprobado.setBounds(100, 120, 150, 20);
				add(lblCursoAprobado);
				lblCursoAprobado.updateUI();
			});
			btnConfirmar.setBounds(201, 150, 100, 20);
			add(btnConfirmar);

			JButton btnRechazar = new JButton("Rechazar");
			btnRechazar.addActionListener((ActionEvent e1) -> {

				botonRechazarCurso(textIDcurso);

				JLabel lblCursoRechazado = new JLabel("Curso rechazado correctamente");
				lblCursoRechazado.setBounds(100, 120, 180, 20);
				add(lblCursoRechazado);
				lblCursoRechazado.updateUI();
			});
			btnRechazar.setBounds(201, 170, 100, 20);
			add(btnRechazar);
		});
		btnAprobarCursos.setBounds(200, 100, 150, 20);
		add(btnAprobarCursos);
	}

	public void botonAprobarCurso(JTextField textIDcurso) {
		GestorConsultas gConsultas= new GestorConsultas();
		CursoPropio cursoAprobado= gConsultas.seleccionarCurso(textIDcurso.getText());

		cursoAprobado.setEstado(EstadoCurso.VALIDADO);
		gConsultas.actualizarCurso(cursoAprobado);
	}	

	public void botonRechazarCurso(JTextField textIDcurso){
		GestorConsultas gConsultas= new GestorConsultas();
		CursoPropio cursoRechazado= gConsultas.seleccionarCurso(textIDcurso.getText());

		cursoRechazado.setEstado(EstadoCurso.PROPUESTA_RECHAZADA);
		gConsultas.actualizarCurso(cursoRechazado);
	}
}