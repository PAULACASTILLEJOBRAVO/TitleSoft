package persistencia;

import java.util.Collection;
import java.util.Vector;

import negocio.entities.*;
public class ProfesorDAO extends AbstractEntityDAO {

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

	public Collection<Profesor> listarProfesorPorDoctor(boolean doctor) {
		Vector<Object> resultado;
		Collection<Profesor> profesorEncontrados=null;
		String SelectSQLEdicion= "SELECT * FROM profesor"
				+ "WHERE doctor = '"+doctor+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Cursos encontrados");
			for (int i = 0; i < resultado.size(); i++) {
				Profesor profeAux=(Profesor) resultado.get(i);
				profesorEncontrados.add(profeAux);
			}
		}else
			System.err.println("Error encontrando cursos");
		return profesorEncontrados;
	}

	@Override
	public Object get(String id) {
		Vector<Object> resultado;
		Profesor profesorEncontrado =null; 
		String SelectSQL= "SELECT * FROM profesor WHERE dni = '"+id.trim()+"' ";

		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Profesor seleccionado");

			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;

			boolean doctor=false;
			if(aux[3].trim().equals("true")) {
				doctor=true;
			}else if(aux[3].trim().equals("false")) {
				doctor=false;
			}else{
				System.out.println("Error en la entradad de la base de datos, valor para doctor no valido");
				return profesorEncontrado ;
			}
			profesorEncontrado=new Profesor(aux[0],aux[1],aux[2],doctor);
		}else
			System.err.println("Error al seleccionar profesor");
		return profesorEncontrado;
	}

	@Override
	public int insert(Object entity){
		int resultado=0;
		Profesor profesores=(Profesor)entity;
		String insertSQL = "INSERT INTO profesor (dni,nombre,apellidos,doctor,materia) " //materia aqui no, es materia quien tiene al responsable,es decir el profesor
				+ "VALUES ( '"+profesores.getDni()+"', '"+profesores.getNombre()+"' , '"+profesores.getApellidos()+"', '"+profesores.isDoctor()+"'  )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Profesor nuevo creado");
		}else
			System.err.println("Error creando profesor nuevo ");
		return resultado;
	}

	@Override
	public Object update(Object entity) {
		int resultado=0;
		Profesor profesor=(Profesor)entity;
		String updateSQL = "UPDATE profesor SET"
				+ " ";

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Profesor modificado");
		}else
			System.err.println("Error modificando profesor ");
		return profesor;
	}

	@Override
	public int delete(Object entity) {
		int resultado=0;
		Profesor profesor=(Profesor)entity;
		String insertSQL = "DELETE FROM profesor WHERE dni= '"+profesor.getDni()+"'  )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Profesor eliminado");
		}else
			System.err.println("Error eliminando profesor ");
		return resultado;
	}
}