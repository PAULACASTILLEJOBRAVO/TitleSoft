package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.controllers.GestorUsuarios;
import negocio.entities.TipoUsuario;
import negocio.entities.Usuario;
import persistencia.*;


public class Main_testing extends JFrame{

	
	private JPanel contentPane;
	
	public final static String error ="Logs//Errores.log";
	
	public static void main(String[] args) throws Exception {
		
		
		Main_testing frame =new Main_testing();
		frame.setVisible(true);

		
		GestorBD.conectarBD();	
		

	}

	
	public Main_testing() {

		

		setTitle("Gestion Titulaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnNewButton = new JButton("Consultar Curso");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PantallaLogin frame =new PantallaLogin();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(89, 84, 223, 21);
		add(btnNewButton);
		
		
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
}
