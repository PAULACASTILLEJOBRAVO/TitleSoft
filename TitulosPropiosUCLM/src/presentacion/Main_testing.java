package presentacion;

import persistencia.*;


public class Main_testing {

	public static void main(String[] args) throws Exception {
		
		PantallaLogin frame =new PantallaLogin();
		frame.setVisible(true);
		GestorBD.conectarBD();	
		

	}

}
