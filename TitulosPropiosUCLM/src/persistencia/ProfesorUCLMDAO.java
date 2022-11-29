package persistencia;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import negocio.controllers.*;
import negocio.entities.*;

public class ProfesorUCLMDAO extends AbstractEntityDAO{

	@Override
	public Object get(String id) throws Exception {

		Vector<Object> resultado;
		ProfesorUCLM profesorReturn=null;
		String SelectSQL= "SELECT * FROM profesoruclm WHERE dni LIKE '"+id.trim()+"' " ;


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("ProfesorUCLM seleccionado");

			String[] auxUCLM =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;

			//datos del profesor padre
			GestorProfesor gProfesor=new GestorProfesor();
			Profesor profesorPadre=gProfesor.seleccionarProfesor(auxUCLM[0]);

			

			//categorias
			if(auxUCLM[3].trim().equals("asociado")) {
				profesorReturn=new ProfesorUCLM(profesorPadre.getDni(), profesorPadre.getNombre(), profesorPadre.getApellidos(), profesorPadre.isDoctor(), CategoriaProfesor.ASOCIADO);

			}else if (auxUCLM[3].trim().equals("ayudante")) {
				profesorReturn=new ProfesorUCLM(profesorPadre.getDni(), profesorPadre.getNombre(), profesorPadre.getApellidos(), profesorPadre.isDoctor(), CategoriaProfesor.AYUDANTE);
			
			}else if (auxUCLM[3].trim().equals("ayudante doctor")) {
				profesorReturn=new ProfesorUCLM(profesorPadre.getDni(), profesorPadre.getNombre(), profesorPadre.getApellidos(), profesorPadre.isDoctor(), CategoriaProfesor.AYUDANTE_DOCTOR);
			
			}else if (auxUCLM[3].trim().equals("catedratico")) {
				profesorReturn=new ProfesorUCLM(profesorPadre.getDni(), profesorPadre.getNombre(), profesorPadre.getApellidos(), profesorPadre.isDoctor(), CategoriaProfesor.CATEDRATICO);
			
			}else if (auxUCLM[3].trim().equals("contratado doctor")) {
				profesorReturn=new ProfesorUCLM(profesorPadre.getDni(), profesorPadre.getNombre(), profesorPadre.getApellidos(), profesorPadre.isDoctor(), CategoriaProfesor.CONTRATADO_DOCTOR);
			
			}else if (auxUCLM[3].trim().equals("titular universidad")) {
				profesorReturn=new ProfesorUCLM(profesorPadre.getDni(), profesorPadre.getNombre(), profesorPadre.getApellidos(), profesorPadre.isDoctor(), CategoriaProfesor.TITULAR_UNIVERSIDAD);
			
			}
			
		}else
			System.err.println("Error al seleccionar curso");

		return profesorReturn ;


	}

	@Override
	public int insert(Object entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object update(Object entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Object entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
