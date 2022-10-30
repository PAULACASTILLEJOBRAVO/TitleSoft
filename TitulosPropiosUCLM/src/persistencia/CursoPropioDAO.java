package persistencia;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


import negocio.entities.*;

public class CursoPropioDAO extends AbstractEntityDAO {

	/**
	 * 
	 * @param curso
	 */
	public int crearNuevoCurso(CursoPropio curso) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO cursopropio (id,nombre,ECTS,fechaInicio,fechaFin,tasaMatricula,edicion,estado,tipoCurso,Centro,secretario,director) "
				+ "VALUES ( '"+curso.getId()+"' , '"+curso.getNombre()+"' , '"+curso.getECTS()+"' ,"
						+ " '"+curso.getFechaInicio()+"' , '"+curso.getFechaFin()+"' , '"+curso.getTasaMatricula()+"' , "
						+ " '"+curso.getEdicion()+"' , '"+curso.getEstado()+"' , '"+curso.getTipo()+"', "
						+ " '"+curso.getCentro()+"' , '"+curso.getSecretario()+"' , '"+curso.getDirector()+"' )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Curso nuevo creado");
		}else
			System.err.println("Error creando curso nuevo ");

		return resultado;

	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio seleccionarCurso(CursoPropio curso) throws Exception {
		Vector<Object> resultado;
		CursoPropio cursoReturn=null;
		String SelectSQL= "SELECT * FROM cursopropio WHERE id LIKE '"+curso.getId()+"' " ;


		resultado = GestorBD.select(SelectSQL);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Curso seleccionado");
			cursoReturn=(CursoPropio)  resultado.get(0);
			
		}else
			System.err.println("Error al seleccionar curso");

		return cursoReturn ;
		
	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio editarCurso(CursoPropio curso) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		String updateSQL = "UPDATE cursopropio SET "
				+ "id= '"+curso.getId()+"',"
				+ "nombre=  '"+curso.getNombre()+"' ,"
				+ "ECTS= '"+curso.getECTS()+"' "
				+ "fechaInicio= '"+curso.getFechaInicio()+"' , "
				+ "fechaFin='"+curso.getFechaFin()+"',"
				+ "tasaMatricula='"+curso.getTasaMatricula()+"',"
				+ "edicion= '"+curso.getEdicion()+"',"
				+ "estado= '"+curso.getEstado()+"',"
				+ "tipoCurso='"+curso.getTipo()+"',"
				+ "Centro= '"+curso.getCentro()+"',"
				+ "secretario='"+curso.getSecretario()+"',"
				+ "director= '"+curso.getDirector()+"'";
		
		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Curso modificado");
		}else
			System.err.println("Error modificando curso ");

		return curso;
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<CursoPropio> listarCursosPorEstado(EstadoCurso estado, Date fechaInicio, Date fechaFin) throws Exception {
		Vector<Object> resultado;
		Collection<CursoPropio> cursosEncontrados = null;
		String SelectSQLEdicion= "SELECT * FROM cursopropio"
				+ "WHERE estado = '"+estado+"'and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Cursos encontrados");
			
			for (int i = 0; i < resultado.size(); i++) {
				CursoPropio cursoAUX= (CursoPropio) resultado.get(i);
				cursosEncontrados.add(cursoAUX);
			}

		}else
			System.err.println("Error encontrando cursos");

		return cursosEncontrados;
		
		//lo he hecho con vector<object> porque es como lo hice en base de datos, se puede cambiar
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) throws Exception {
		// TODO - implement CursoPropioDAO.listarIngresos
		Vector<Object> resultado;
		double ingresos=0.0;
		String SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
				+ "WHERE tipoCurso = '"+tipo+"'and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Ingresos Calculados");
			ingresos=Integer.parseInt(resultado.toString());

		}else
			System.err.println("Error calculando ingresos");

		return ingresos;
		
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) throws Exception { //he cambiado a que devuelva una colleccion, antes estaba como void, lo he cambiado porque pone listar
		Vector<Object> resultado;
		Collection cursosEncontrados=null;
		String SelectSQLEdicion= "SELECT edicion FROM cursopropio"
				+ "WHERE  fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);
		
		if (resultado.isEmpty()==false) {
			System.out.println("Ediciones encotradas");
			for (int i = 0; i < resultado.size(); i++) {
				CursoPropio cursoAUX=(CursoPropio)resultado.get(i);
				cursosEncontrados.add(cursoAUX);
			}

		}else
			System.err.println("Error encotrando ediciones");
		return cursosEncontrados;

	
		
	}

	@Override
	public Object get(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
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