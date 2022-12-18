package persistencia;

import java.util.Collection;
import java.util.Vector;

import negocio.controllers.GestorConsultas;
import negocio.controllers.GestorProfesor;
import negocio.entities.*;

public class CentroDAO extends AbstractEntityDAO {

	public int crearCentro(Centro centro) {
		return insert(centro);
	}

	public Centro seleccionarCentro(String id){
		return (Centro) get(id);
	}

	public Centro editarCentro(Centro centro) {
		return (Centro) update(centro);
	}

	public int eleminiarCentro(Centro centro){
		return delete (centro.getNombre()) ;
	}

	public Vector<Object> listarNombreCentro(String nombre){		
		Vector<Object> resultado;
		String SelectSQLEdicion= "SELECT * FROM centro WHERE nombre = '"+nombre.trim()+"' ";
		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Centro encotrado");
		}else
			System.err.println("Error encontrando centro");
		return resultado;
	}
	
	
	@Override
	public Object get(String id) {
		Vector<Object> resultado;
		Centro centroEncontrado=null;
		
		String SelectSQL= "SELECT * FROM centro WHERE nombre = '"+id.trim()+"' ";

		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Centro seleccionado");
			
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			Vector<Object> resultadosNombreCentro= listarNombreCentro(aux[1]);
			
			//collecion de Profesores
			Collection<Profesor> profesoresCollection=null;
			GestorProfesor gProfesor= new GestorProfesor();
			
			for(int i=0;i<resultadosNombreCentro.size();i++) {

				String[] auxProfesores =  (resultadosNombreCentro.get(i).toString().trim().replace("[", "").replace("]", "")).split(",") ;

				profesoresCollection.add(gProfesor.seleccionarProfesor(auxProfesores[4]));
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
	public int insert(Object entity) {
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
	public Object update(Object entity) {
		Centro centroReturn=null;
		int resultado=0;
		Centro centro= (Centro) entity;
		String updateSQL = "UPDATE centro SET" + " nombre = '"+centro.getNombre()+"'," + "localizacion = '"+centro.getLocalizacion()+"' ";
		
		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("centro modificado");
		}else
			System.err.println("Error modificando centro ");
		return centroReturn;
	}

	@Override
	public int delete(Object entity) {
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