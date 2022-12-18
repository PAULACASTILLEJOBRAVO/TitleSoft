package persistencia;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import negocio.controllers.GestorConsultas;
import negocio.controllers.GestorProfesor;
import negocio.entities.*;
import presentacion.MainTesting;

public class CentroDAO implements AbstractEntityDAO  <Object> {

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

	public List<Object> listarNombreCentro(String nombre){		
		LinkedList<Object> resultado;
		String selectSQLEdicion= "SELECT * FROM centro WHERE nombre = '"+nombre.trim()+"' ";
		resultado = GestorBD.select(selectSQLEdicion);

		if (resultado.isEmpty()) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error encontrando centro");
		return resultado;
	}
	
	
	@Override
	public Object get(String id) {
		LinkedList<Object> resultado;
		Centro centroEncontrado=null;
		
		String selectSQL= "SELECT * FROM centro WHERE nombre = '"+id.trim()+"' ";

		resultado = GestorBD.select(selectSQL);

		if (!resultado.isEmpty()) {
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			List<Object> resultadosNombreCentro= listarNombreCentro(aux[1]);
			
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
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar centro");
		return centroEncontrado ;
	}


	@Override
	public int insert(Object entity) {
		int resultado=0;
		Centro centro= (Centro) entity;
		String insertSQL = "INSERT INTO centro (nombre,localizacion)"
				+ "VALUES ('"+centro.getNombre()+"', '"+centro.getLocalizacion()+"')";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error creando centro nuevo ");
		return resultado;
	}


	@Override
	public Object update(Object entity) {
		Centro centroReturn=null;
		int resultado=0;
		Centro centro= (Centro) entity;
		String updateSQL = "UPDATE centro SET" + " nombre = '"+centro.getNombre()+"'," + "localizacion = '"+centro.getLocalizacion()+"' ";
		
		resultado = GestorBD.update(updateSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error modificando centro ");
		return centroReturn;
	}

	@Override
	public int delete(Object entity) {
		int resultado=0;
		Centro centro= (Centro) entity;
		String insertSQL = "DELETE FROM centro WHERE nombre= '"+centro.getNombre()+"' ";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error eliminando centro  ");
		return resultado;
	}
}