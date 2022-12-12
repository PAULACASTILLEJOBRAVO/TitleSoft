package persistencia;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;


public class MatriculaDAO extends AbstractEntityDAO {

	public int crearMatricula(Matricula matricula) throws ClassNotFoundException, SQLException {
		return insert(matricula);

	}

	/**
	 * 
	 * @param curso
	 */
	public Matricula seleccionarMatricula(String id) throws Exception {
		return (Matricula)get(id);
		//error por el tipo de return
	}

	/**
	 * 
	 * @param curso
	 */
	public Matricula editarMatricula(Matricula matricula) throws Exception {
		return (Matricula)update(matricula);
	}

	public int eliminarrMatricula(Matricula matricula) throws Exception {
		return delete(matricula);
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

	@Override
	public Object get(String id) throws Exception {
		Vector<Object> resultado;
		Matricula matriculaEncontrada=null;
		
		String SelectSQL= "SELECT * FROM matricula WHERE idMatricula = "+id+" ";


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Matricula seleccionada");
			
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date fecha= formato.parse(aux[3]);

			
			if(aux[3].trim().equals("credito")) {
				matriculaEncontrada=new Matricula( aux[0], ModoPago.TARJETA_CREDITO, sqlDate,Boolean.parseBoolean(aux[2]));
			}else if(aux[3].trim().equals("transferencia")){
				matriculaEncontrada=new Matricula( aux[0], ModoPago.TRANSFERENCIA, sqlDate, Boolean.parseBoolean(aux[2]));
			}
			
			
			
		}else
			System.err.println("Error al seleccionar la matricula");

		return matriculaEncontrada ;

	}

	@Override

	public int insert(Object entity) throws ClassNotFoundException, SQLException {
		int resultado=0;
		Matricula matricula= (Matricula)entity;

		String insertSQL = "INSERT INTO matricula (curso,dni,fecha,pagado,modo) " 
				+ "VALUES ( "+matricula.getTitulo()+" , '"+matricula.getDni()+"' , '"
				+matricula.getFecha()+"', '"+matricula.isPagado()+"' , '"+matricula.getTipoPago()+"' )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Matricula nueva creada.");
		}else
			System.err.println("Error creando matricula nueva.");

		return resultado;
	}

	@Override
	public Object update(Object entity) throws Exception {
		
		int resultado=0;
		Matricula matricula=(Matricula)entity;
		String updateSQL = "UPDATE matricula SET"
				+ "titulacion= '"+matricula.getTitulo()+"',"
				+ "Fecha= '"+matricula.getFecha()+"',"
				+ "pagado= '"+matricula.isPagado()+"',"
				+ "Modo= '"+matricula.getTipoPago()+"',";
				
		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Matricula modificado");
		}else
			System.err.println("Error modificando matricula ");

		return matricula;
	}

	@Override
	public int delete(Object entity) throws Exception {
		int resultado=0;
		Matricula matricula= (Matricula)entity;
		String insertSQL = "DELETE FROM matricula WHERE idMatricula='"+matricula.getTitulo()+"' )";//faltan el pagado que es un boolean y el curso, el identificativo que lo enlaza, lo puse asi en la tabla

		resultado = GestorBD.insert(insertSQL);
		if (resultado > 0) {
			System.out.println("Matricula nueva creado");
		}else
			System.err.println("Error creando matricula nueva ");

		return resultado;
	}






}
