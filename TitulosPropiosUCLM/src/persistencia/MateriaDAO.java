package persistencia;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import negocio.controllers.GestorProfesor;
import negocio.entities.*;

public class MateriaDAO extends AbstractEntityDAO {


	public int crearMateria(Materia materia) throws Exception {
		return insert(materia);

	}


	public Materia seleccionarMateria(String id) throws Exception {
		return (Materia)get(id);

	}

	/**
	 * 
	 * @param curso
	 */
	public Materia editarMateria(Materia materia) throws Exception {
		return (Materia)update(materia);
	}

	public int eliminarMateria(Materia materia) throws Exception{
		return delete(materia);
	}
	
	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
 	public Collection<Materia> listarMateriaHoras(int horas) throws Exception {
		Vector<Object> resultado;
		Collection materiaEncontradas=null;
		String SelectSQLEdicion= "SELECT * FROM materia"
				+ "WHERE horas >= '"+horas+"'";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Materias encontradas");
			for (int i = 0; i < resultado.size(); i++) {
				Materia materiaAux=(Materia)resultado.get(i);
				materiaEncontradas.add(materiaAux);
			}
		}else
			System.err.println("Error encontrando materias");

		return materiaEncontradas;

		//lo he hecho con vector<object> porque es como lo hice en base de datos, se puede cambiar
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Vector<Object> listarMateriaCurso(String curso) throws Exception {
		// TODO - implement CursoPropioDAO.listarIngresos
		Vector<Object> resultado;
		Vector<Object>  materiaEncontrada=null;
		String SelectSQLEdicion= "SELECT * FROM materia"
				+ "WHERE Curso = '"+curso+"'";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Materia encontrada");
//			materiaEncontrada= (Materia)resultado.get(0);
		}else
			System.err.println("Error encontrando materia");

		return materiaEncontrada;

	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<Materia> listarEdicionesCursos(Date fechaInicio, Date fechaFin) throws Exception {
		Vector<Object> resultado;
		Collection<Materia> materiaEncontrada=null;


		String SelectSQLEdicion= "SELECT * FROM materia"
				+ "WHERE  fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Materias encontradas");
			for (int i = 0; i < resultado.size(); i++) {
				Materia materiaAux=(Materia) resultado.get(i);
				materiaEncontrada.add(materiaAux);
			}

		}else
			System.err.println("Error encontrado materias");
		return materiaEncontrada;



	}


	@Override
	public Object get(String id) throws Exception {
		Vector<Object> resultado;
		Materia materiaEncontrada=null;
		String SelectSQL= "SELECT * FROM materia WHERE nombre = '"+id.trim()+"' ";


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Materia seleccionado");
			
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			
			Date fecha1=(Date) formato.parse(aux[2]);
			java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
			
			Date fecha2=(Date) formato.parse(aux[3]);
			java.sql.Date sqlDate2 = new java.sql.Date(fecha2.getTime());
			
			GestorProfesor gProfesor=new GestorProfesor();
			
			Profesor responsable=gProfesor.seleccionarProfesor(aux[4]);
			
			materiaEncontrada=new Materia(responsable, aux[0], Double.parseDouble(aux[1]), sqlDate1, sqlDate2);
			
			
			
		}else
			System.err.println("Error al seleccionar materia");

		return materiaEncontrada ;

	}


	@Override
	public int insert(Object entity) throws Exception {
		int resultado=0;
		Materia materia=(Materia)entity;
		String insertSQL = "INSERT INTO materia (nombre,horas,fechaInicio,fechaFin,dniProfesor) " 
				+ "VALUES ('"+materia.getNombre()+"' ,"+materia.getHoras()+" , '"+materia.getFechaInicio()+"', '"+materia.getFechaFin()+"', '"+materia.getResponsable().getDni()+"' )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Materia nuevo creado");
		}else
			System.err.println("Error creando materia nueva ");

		return resultado;
	}


	@Override
	public Object update(Object entity) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		Materia materia=(Materia)entity;
		String updateSQL = "UPDATE materia SET"
				+ "nombre= '"+materia.getNombre()+"' ,"
				+ "horas= '"+materia.getHoras()+"',"
				+ "fechaInicio= '"+materia.getFechaInicio()+"',"
				+ "fechaFin= '"+materia.getFechaFin()+"',"
				+ "Curso= '"+materia.getResponsable()+"',";

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Materia modificado");
		}else
			System.err.println("Error modificando materia ");

		return materia;
	}


	@Override
	public int delete(Object entity) throws Exception {
		int resultado=0;
		Materia materia=(Materia)entity;
		String insertSQL = "DELETE FROM materia WHERE nombre= '"+materia.getNombre()+"' ";
		

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Materia nuevo creado");
		}else
			System.err.println("Error creando materia nueva ");

		return resultado;
	}
	
	public int vincularCursoMateria(int idMateria, int IdCurso) throws ClassNotFoundException, SQLException {
		int resultado=0;
		String insertSQL = "INSERT INTO RELACIONMATERIASCURSO (materia,curso) "
				+ "VALUES ("+idMateria+" , "+IdCurso+") ";
		
		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Materia añadida a curso");
		}else
			System.err.println("Error añadiendo materia nueva a un curso ");

		return resultado;
	}

	public int seleccionarId(Materia materia) throws SQLException {
		
		int idMateria=0;
		Vector<Object> resultado;
		
		String insertSQL = "SELECT idmateria FROM materia WHERE nombre = '"+materia.getNombre()
				+"' AND fechaInicio = '"+materia.getFechaInicio()+"'  AND fechaFin = '"+materia.getFechaFin()
				+"' AND dniProfesor = '"+materia.getResponsable().getDni()+"' AND horas = "+materia.getHoras()+" ";
		
		resultado = GestorBD.select(insertSQL); 
		if (resultado.isEmpty()==false) {
			System.out.println("Identificador de materia encontrado");
			String[] aux =  (resultado.toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			idMateria=Integer.parseInt(aux[0]);
		}else
			System.err.println("Error al buscar el identificador de la materia");
		
		return idMateria;
	}
}