package presentacion;

import java.io.IOException;
import java.lang.*;
import java.util.*;
import java.util.logging.*;

import persistencia.*;


public class Main_testing {

	public final static String error ="Logs//Errores.log";
	
	public static void main(String[] args) throws Exception {
		
		PantallaLogin frame =new PantallaLogin();
		frame.setVisible(true);
		GestorBD.conectarBD();	
		

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
