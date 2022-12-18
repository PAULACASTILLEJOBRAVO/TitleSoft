package presentacion;

import java.io.IOException;

import java.util.logging.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import persistencia.*;

public class MainTesting extends JFrame{
	private JPanel contentPane;
	public static final String ERROR ="Logs//Errores.log";
	
	public static void main(String[] args)  {
		MainTesting frame =new MainTesting();
		frame.setVisible(true);
		GestorBD.conectar();	 
	}

	public MainTesting() {
		setTitle("Gestion Titulaciones");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 670, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar Curso");
		btnConsultar.addActionListener(e -> {

			PantallaLogin frame =new PantallaLogin(0);
			frame.setVisible(true);
			
		});
		btnConsultar.setBounds(89, 84, 223, 21);
		add(btnConsultar);
		
		JButton btnMatriculas = new JButton("Realizar Matriculas");
				
		btnMatriculas.addActionListener(e -> {
			
			PantallaLogin frame = new PantallaLogin(1);
			frame.setVisible(true);
			
		});
		btnMatriculas.setBounds(89, 144, 223, 21);
		add(btnMatriculas);
		
		JButton btnEvaluar = new JButton("Evaluar Cursos");
		btnEvaluar.addActionListener(e -> {
		
			PantallaLogin frame =new PantallaLogin(2);
			frame.setVisible(true);

		});
		btnEvaluar.setBounds(89, 204, 223, 21);
		add( btnEvaluar);
		
		JButton btnCursos = new JButton("Gestionar Cursos");
		btnCursos.addActionListener(e -> {

			PantallaLogin frame =new PantallaLogin(3);
			frame.setVisible(true);

		});
		btnCursos.setBounds(400, 84, 223, 21);
		add( btnCursos);
	}
	
	public static void escribirLog(String rutaArchivo, String mensaje) {
        Logger logger = Logger.getLogger("errores");
        FileHandler fh;

        try {
            fh = new FileHandler(rutaArchivo, true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info(mensaje);
            fh.close();
        } catch (SecurityException e) {
           escribirLog(MainTesting.ERROR, "Error de seguridad");
        } catch(IOException e) {
           escribirLog(MainTesting.ERROR, "Error de entrada/salida");
        }
    }
}