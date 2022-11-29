package persistencia;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import negocio.controllers.GestorConsultas;
import negocio.controllers.GestorProfesorUCLM;
import negocio.entities.*;

public class CentroDAO extends AbstractEntityDAO {


	public int crearCentro(Centro centro) throws Exception {
		return insert(centro);
	}


	public Centro seleccionarCentro(String id) throws Exception {
		return (Centro) get(id);

	}


	public Centro editarCentro(Centro centro) throws Exception { 
		// TODO - implement CursoPropioDAO.editarCurso
		return (Centro) update(centro);
	}

	public int eleminiarCentro(Centro centro) throws Exception{
		return delete (centro.getNombre()) ;
		
	}

	
	public Vector<Object> listarNombreCentro(String nombre) throws Exception{
		
		Vector<Object> resultado;
		String SelectSQLEdicion= "SELECT * FROM centro WHERE nombre LIKE '"+nombre.trim()+"' ";
		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Centro encotrados");

		}else
			System.err.println("Error encontrando centros");
		
		return resultado;
		
	}
	
	
	@Override
	public Object get(String id) throws Exception {
		Vector<Object> resultado;
		Centro centroEncontrado=null;
		
		String SelectSQL= "SELECT * FROM centro WHERE nombre LIKE '"+id.trim()+"' ";


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Centro seleccionado");
			
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			Vector<Object> resultadosNombreCentro= listarNombreCentro(aux[1]);
			
			//collecion de ProfesoresUCLM
			Collection<ProfesorUCLM> profesoresCollection=null;
			GestorProfesorUCLM gProfesorUCLM= new GestorProfesorUCLM();
			
			for(int i=0;i<resultadosNombreCentro.size();i++) {

				String[] auxProfesores =  (resultadosNombreCentro.get(i).toString().trim().replace("[", "").replace("]", "")).split(",") ;

				profesoresCollection.add(gProfesorUCLM.seleccionarProfesor(auxProfesores[4]));
			}
			
			//collection de cursosPropios 
			
			
			GestorConsultas gConsultas=new GestorConsultas();
			Collection<CursoPropio> cursosCentro=gConsultas.cursosPorCentro(aux[0]);
			
	
				centroEncontrado = new Centro(cursosCentro, profesoresCollection, aux[1], aux[2], Integer.parseInt(aux[0]));
			
		}else
			System.err.println("Error al seleccionar centro");

		
		return centroEncontrado ;
	}


	@Override
	public int insert(Object entity) throws Exception {
		int resultado=0;
		Centro centro= (Centro) entity;
		String insertSQL = "INSERT INTO centro (nombre,localizacion)"
				+ "VALUES ('"+centro.getNombre()+"', '"+centro.getLocalizacion()+"')";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Centro nuevo creado");
		}else
			System.err.println("Error creando centro nuevo ");

		return resultado;
	}


	@Override
	public Object update(Object entity) throws Exception {
		Centro centroReturn=null;
		int resultado=0;
		Centro centro= (Centro) entity;
		String updateSQL = "UPDATE centro SET"
				+ " nombre = '"+centro.getNombre()+"',"
						+ "localizacion = '"+centro.getLocalizacion()+"' ";
		
		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("centro modificado");
		}else
			System.err.println("Error modificando centro ");

		return centroReturn;
	}


	@Override
	public int delete(Object entity) throws Exception {
		int resultado=0;
		Centro centro= (Centro) entity;
		String insertSQL = "DELETE FROM centro WHERE nombre= '"+centro.getNombre()+"' ";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Centro eliminiado");
		}else
			System.err.println("Error eliminando centro  ");

		return resultado;
	}


	




}