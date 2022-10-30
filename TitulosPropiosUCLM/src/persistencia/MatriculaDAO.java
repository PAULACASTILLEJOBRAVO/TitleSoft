package persistencia;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;


public class MatriculaDAO extends AbstractEntityDAO {

	public int crearMatricula(Matricula matricula) throws Exception {
		int resultado=0;
		String insertSQL = "INSERT INTO matricula (titulacion,Fecha,pagado,Modo,Curso) " //quitar curso de la base de datos
				+ "VALUES ( '"+matricula.getTitulo()+"' , '"+matricula.getFecha()+"', '"+matricula.isPagado()+"' , '"+matricula.getTipoPago()+"' , '"+matricula.getCurso()+"' )";//faltan el pagado que es un boolean y el curso, el identificativo que lo enlaza, lo puse asi en la tabla

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Matricula nueva creado");
		}else
			System.err.println("Error creando matricula nueva ");

		return resultado;

	}

	/**
	 * 
	 * @param curso
	 */
	public Matricula seleccionarMatricula(Matricula matricula) throws Exception {
		Vector<Object> resultado;
		Matricula matriculaEncontrada=null;
		String SelectSQL= "SELECT * FROM matricula WHERE id LIKE '"+matricula.getTitulo()+"' ";


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Matricula seleccionada");
			matriculaEncontrada=(Matricula)resultado.get(0);
		}else
			System.err.println("Error al seleccionar la matricula");

		return matriculaEncontrada ;

		//error por el tipo de return
	}

	/**
	 * 
	 * @param curso
	 */
	public Matricula editarMatricula(Matricula matricula) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		String updateSQL = "UPDATE matricula SET"
				+ "titulacion= '"+matricula.getTitulo()+"',"
				+ "Fecha= '"+matricula.getFecha()+"',"
				+ "pagado= '"+matricula.getPagado()+"',"
				+ "Modo= '"+matricula.getTipoPago()+"',"
				+ "Curso= '"+matricula.getCurso()+"'";//no se si el curso que se le pasa es el curso que se quiere modificar o es el curso ya modificado

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Matricula modificado");
		}else
			System.err.println("Error modificando matricula ");

		return matricula;
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Collection<Matricula> listarMatriculaTitulacion(String titulacion) throws Exception {
		Vector<Object> resultado;
		Collection<Matricula> matriculasEncontradas=null;
		String SelectSQLEdicion= "SELECT * FROM matricula"
				+ "WHERE titulacion = '"+titulacion+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Matricula encontrados");
			for (int i = 0; i < resultado.size(); i++) {
				Matricula matriculaAux=(Matricula)resultado.get(i);
				matriculasEncontradas.add(matriculaAux);
			}
		}else
			System.err.println("Error encontrando matricula");

		return matriculasEncontradas;

		
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */

	public Collection<Matricula> listarMatriculaCurso(int curso) throws Exception {
		Vector<Object> resultado;
		Collection<Matricula> matriculasEncontradas=null;

		String SelectSQLEdicion= "SELECT * FROM matricula"
				+ "WHERE Curso = '"+curso+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Matricula encontradas");
			for (int i = 0; i < resultado.size(); i++) {
				Matricula matriculaAux=(Matricula)resultado.get(i);
				matriculasEncontradas.add(matriculaAux);
			}

		}else
			System.err.println("Error encontrando matriculas");

		return matriculasEncontradas;

		
	}






}
