package persistencia;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;

public class CentroDAO extends AbstractEntityDAO {


	public int crearCentro(Centro centro) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO centro (nomnre,localizacion)"
				+ "VALUES ()";//falta los get

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Centro nuevo creado");
		}else
			System.err.println("Error creando centro nuevo ");

		return resultado;

	}


	public Centro seleccionarCentro(Centro centro) throws Exception {
		Vector<Object> resultado;
		String SelectSQL= "SELECT * FROM centro WHERE id LIKE '"+centro.getNombre()+"' ";


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Centro seleccionado");
		}else
			System.err.println("Error al seleccionar centro");

		return resultado ;

		//error por el tipo de return
	}


	public Centro editarCentro(Centro centro) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		String updateSQL = "";//no se si el curso que se le pasa es el curso que se quiere modificar o es el curso ya modificado

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("centro modificado");
		}else
			System.err.println("Error modificando centro ");

		return resultado;//no se porque devuelve curso, como esta hecho devuelve un numero
	}






















}