package persistencia;

import java.util.List;

import negocio.entities.*;
import presentacion.MainTesting;
public class ProfesorDAO implements AbstractEntityDAO <Object>  {

	public int crearProfesor(Profesor profe) {
		return insert(profe);
	}

	public Profesor seleccionarProfesor(String id) {
		return (Profesor) get(id);
	}

	public Profesor editarProfesor(Profesor profe){
		return(Profesor)update(profe);
	}

	public int eliminarProfesor(Profesor profe) {
		return delete(profe);
	}

	@Override
	public Object get(String id) {
		List<Object> resultado;
		Profesor profesorEncontrado =null; 
		String selectSQL= "SELECT * FROM profesor WHERE dni = '"+id.trim()+"' ";

		resultado = GestorBD.select(selectSQL);

		if (!resultado.isEmpty()) {
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;

			boolean doctor=false;
			if(aux[3].trim().equals("true")) {
				doctor=true;
			}else if(aux[3].trim().equals("false")) {
				doctor=false;
			}else{
				MainTesting.escribirLog(MainTesting.ERROR, "Error en la entradad de la base de datos, valor para doctor no valido");
				return profesorEncontrado;
			}
			profesorEncontrado=new Profesor(aux[0],aux[1],aux[2],doctor);
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar profesor");
		return profesorEncontrado;
	}

	@Override
	public int insert(Object entity){
		int resultado=0;
		Profesor profesores=(Profesor)entity;
		String insertSQL = "INSERT INTO profesor (dni,nombre,apellidos,doctor,materia) " //materia aqui no, es materia quien tiene al responsable,es decir el profesor
				+ "VALUES ( '"+profesores.getDni()+"', '"+profesores.getNombre()+"' , '"+profesores.getApellidos()+"', '"+profesores.isDoctor()+"'  )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR,"Error creando profesor nuevo ");
		return resultado;
	}

	@Override
	public Object update(Object entity) {
		int resultado=0;
		Profesor profesor=(Profesor)entity;
		String updateSQL = "UPDATE profesor SET"
				+ " ";

		resultado = GestorBD.update(updateSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error modificando profesor ");
		return profesor;
	}

	@Override
	public int delete(Object entity) {
		int resultado=0;
		Profesor profesor=(Profesor)entity;
		String insertSQL = "DELETE FROM profesor WHERE dni= '"+profesor.getDni()+"'  )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR,"Error eliminando profesor ");
		return resultado;
	}
}