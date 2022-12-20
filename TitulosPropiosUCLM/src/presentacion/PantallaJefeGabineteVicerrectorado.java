package presentacion;
import java.awt.event.ActionEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import negocio.controllers.GestorConsultas;
import negocio.entities.CursoPropio;
import negocio.entities.Materia;

public class PantallaJefeGabineteVicerrectorado extends JFrame{
	private JPanel contentPane;
	private static final String FORMATOFECHAINICIO = "Fecha inicio(yyyy-mm-dd):";
	private static final String FORMATOFECHAFIN = "Fecha final(yyyy-mm-dd):";
	private static final String CONFIRMAR = "Confirmar";
	private static final String FORMATOFECHASIMPLE = "yyyy-MM-dd";

	public PantallaJefeGabineteVicerrectorado() {
		setTitle("Sesion: Jefe Gabinete");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnConsultarIngresos = new JButton("Consultar Ingresos");
		btnConsultarIngresos.addActionListener((ActionEvent e) -> {
				JTextField textFieldIdCurso= new JTextField();
				JTextField textFieldFechaInicio= new JTextField();
				JTextField textFieldFechaFinal= new JTextField();

				setTitle("Sesion: Jefe Gabinete-------Consultar Ingresos");
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				setBounds(300, 300, 520, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				contentPane.revalidate();

				JLabel lblFechaInicio = new JLabel(FORMATOFECHAINICIO);
				lblFechaInicio.setBounds(100, 100, 200, 20);
				add(lblFechaInicio);

				textFieldFechaInicio.setBounds(250, 100, 132, 20);
				add(textFieldFechaInicio);
				textFieldFechaInicio.setColumns(10);

				JLabel lblFechaFinal = new JLabel(FORMATOFECHAFIN);
				lblFechaFinal.setBounds(100, 150, 200, 20);
				add(lblFechaFinal);

				textFieldFechaFinal.setBounds(250, 150, 132, 20);
				add(textFieldFechaFinal);
				textFieldFechaFinal.setColumns(10);

				JButton btnConfirmar = new JButton(CONFIRMAR);
				btnConfirmar.addActionListener((ActionEvent e1) -> {
						Collection<CursoPropio> resultado;
						resultado = botonConfirmarCursos(textFieldFechaFinal,textFieldFechaInicio);
						crearTabla(resultado);
						contentPane.revalidate();

						setTitle("Sesion: Jefe Gabinete-------Ingresos");
						setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						setBounds(300, 300, 520, 300);
						contentPane = new JPanel();
						contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						setContentPane(contentPane);
						contentPane.setLayout(null);
						contentPane.revalidate();

						JLabel lblcurso = new JLabel("Id Curso:");
						lblcurso.setBounds(100, 90, 200, 20);
						add(lblcurso);

						textFieldIdCurso.setBounds(250, 94, 132, 20);
						add(textFieldIdCurso);
						textFieldIdCurso.setColumns(10);
						contentPane.revalidate();							

						JButton btnConfirmarId = new JButton(CONFIRMAR);
						btnConfirmarId.addActionListener((ActionEvent e2) -> {
								double ingresos=botonConfirmarIngresos(textFieldFechaFinal,textFieldFechaInicio,textFieldIdCurso);

								JLabel lblingresos = new JLabel("Ingresos: "+ingresos+"");
								lblingresos.setBounds(100, 150, 200,70);
								add(lblingresos);
								lblingresos.updateUI();
							});
						btnConfirmarId.setBounds(201, 120, 100, 20);
						add(btnConfirmarId);
				});
				btnConfirmar.setBounds(201, 200, 100, 20);
				add(btnConfirmar);
		});
		btnConsultarIngresos.setBounds(200, 100, 150, 20);
		add(btnConsultarIngresos);

		JButton btnListarEdiciones = new JButton("Listar Ediciones");
		btnListarEdiciones.addActionListener((ActionEvent e) -> 
				recogidaParametros("Sesion: Jefe Gabinete-------Listar Ediciones"));
		btnListarEdiciones.setBounds(200, 150, 150, 20);
		add(btnListarEdiciones);

		JButton btnAprobarCursos = new JButton("Consular Cursos");
		btnAprobarCursos.addActionListener((ActionEvent e) ->
				recogidaParametros("Sesion: Jefe Gabinete-------Consultar Cursos"));
		btnAprobarCursos.setBounds(200, 200, 150, 20);
		add(btnAprobarCursos);
	}

	public double botonConfirmarIngresos(JTextField textFieldFechaFinal, JTextField textFieldFechaInicio, JTextField textFieldTipo) {
		GestorConsultas gConsultas=new GestorConsultas();
		SimpleDateFormat formato = new SimpleDateFormat(FORMATOFECHASIMPLE);

		try {
			Date fechaAux1 = formato.parse(textFieldFechaInicio.getText());
			Date fechaAux2= formato.parse(textFieldFechaFinal.getText());
			Date fechaInicioAux=new java.sql.Date(fechaAux1.getTime());
			Date fechaFinalAux=new java.sql.Date(fechaAux2.getTime());

			CursoPropio curso=gConsultas.seleccionarCurso(textFieldTipo.getText().trim());

			return gConsultas.consultarIngresos(curso.getTipo(), fechaInicioAux, fechaFinalAux);
		} catch (ParseException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al consultar ingresos");
			return 0;
		}
	}

	public void botonConfirmarEdiciones(JTextField textFieldFechaFinalEdiciones, JTextField textFieldFechaInicioEdiciones) {
		SimpleDateFormat formato = new SimpleDateFormat(FORMATOFECHASIMPLE);

		try {
			Date fechaInicioAux = formato.parse(textFieldFechaInicioEdiciones.getText());
			Date fechaFinalAux= formato.parse(textFieldFechaFinalEdiciones.getText());
			java.sql.Date fechaInicioSQL= new java.sql.Date(fechaInicioAux.getTime());
			java.sql.Date fechaFinalSQL= new java.sql.Date(fechaFinalAux.getTime());

			GestorConsultas gConsultas=new GestorConsultas();
			Collection<CursoPropio> cursosEncontrados=gConsultas.listarEdicionesCursos(fechaInicioSQL, fechaFinalSQL);
			crearTabla(cursosEncontrados);
		}catch (ParseException es) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error al consultar cursos por ediciones");
		}
	}

	public Collection<CursoPropio>  botonConfirmarCursos(JTextField textFieldFechaFinalEdiciones,JTextField textFieldFechaInicioEdiciones )  {
		Collection<CursoPropio> resultado=new ArrayList<>();

		GestorConsultas gConsultas=new GestorConsultas();

		SimpleDateFormat formato = new SimpleDateFormat(FORMATOFECHASIMPLE);
		
		try {
			Date fechaInicioAux = formato.parse(textFieldFechaInicioEdiciones.getText());
			Date fechaFinalAux= formato.parse(textFieldFechaFinalEdiciones.getText());
			java.sql.Date fechaInicioSQL= new java.sql.Date(fechaInicioAux.getTime());
			java.sql.Date fechaFinalSQL= new java.sql.Date(fechaFinalAux.getTime());

			resultado=gConsultas.listarCursosRechazadosYPropuestos( fechaInicioSQL,fechaFinalSQL );
		}catch (ParseException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error en la conversión de String a entero");
		}
		return resultado;
	}

	public static void crearTabla(Collection<CursoPropio> resultado) {

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
			StringBuilder datosMateriaNombres= new StringBuilder();

			for(int j=0;j<materiasCurso.length;j++) {
				Materia materiaAux=(Materia)materiasCurso[j];
				datosMateriaNombres.append(materiaAux.getNombre());
			}

			String datosMaterias = datosMateriaNombres.toString();

			tabla.addRow(new Object[] {
					cursoAux.getIdCursoPropio(),cursoAux.getNombre(),cursoAux.getECTS(),cursoAux.getTasaMatricula(),
					cursoAux.getEdicion(),cursoAux.getEstado(),cursoAux.getTipo(),
					cursoAux.getSecretario().getNombre(),cursoAux.getDirector().getNombre(),datosMaterias
			});
		}

		JScrollPane jScrollPane = new JScrollPane(jTabla);
		jFrame.add(jScrollPane);
		jFrame.setSize(350, 300);
		jFrame.setVisible(true);
	}
	
	public void recogidaParametros(String nombreSesion) {
		JTextField textFieldFechaInicioEdiciones = new JTextField();
		JTextField textFieldFechaFinalEdiciones = new JTextField();

		setTitle(nombreSesion);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.revalidate();

		JLabel lblFechaInicioEdiciones = new JLabel(FORMATOFECHAINICIO);
		lblFechaInicioEdiciones.setBounds(100, 90, 200, 20);
		add(lblFechaInicioEdiciones);

		textFieldFechaInicioEdiciones.setBounds(250, 94, 132, 20);
		add(textFieldFechaInicioEdiciones);
		textFieldFechaInicioEdiciones.setColumns(10);

		JLabel lblFechaFinalEdicion = new JLabel(FORMATOFECHAFIN);
		lblFechaFinalEdicion.setBounds(100, 150, 200, 20);
		add(lblFechaFinalEdicion);

		textFieldFechaFinalEdiciones.setBounds(250, 154, 132, 20);
		add(textFieldFechaFinalEdiciones);
		textFieldFechaFinalEdiciones.setColumns(10);
		
		JButton btnConfirmar = new JButton(CONFIRMAR);
		btnConfirmar.addActionListener((ActionEvent e1) -> {
			if(nombreSesion.equals("Sesion: Jefe Gabinete-------Listar Ediciones")) {
				botonConfirmarEdiciones(textFieldFechaFinalEdiciones,textFieldFechaInicioEdiciones);
			}else if(nombreSesion.equals("Sesion: Jefe Gabinete-------Consultar Cursos")){
				Collection<CursoPropio> resultado=botonConfirmarCursos(textFieldFechaFinalEdiciones,textFieldFechaInicioEdiciones);
				crearTabla(resultado);
			}
		});
		btnConfirmar.setBounds(201, 200, 100, 20);
		add(btnConfirmar);
	}
}