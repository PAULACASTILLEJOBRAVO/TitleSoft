package persistencia;

import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import negocio.controllers.GestorCentro;
import negocio.controllers.GestorMateria;
import negocio.controllers.GestorMatriculacion;
import negocio.controllers.GestorProfesor;
import negocio.controllers.GestorProfesorUCLM;
import negocio.entities.*;
//el bueno
public class CursoPropioDAO extends AbstractEntityDAO {

	/**
	 * 
	 * @param curso
	 */
	public int crearNuevoCurso(CursoPropio curso) throws Exception {
		return insert(curso);

	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio seleccionarCurso(String id) throws Exception {
		return (CursoPropio)get(id);
	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio editarCurso(CursoPropio curso) throws Exception {
		return (CursoPropio) update(curso);
	}

	public int eliminarCurso(CursoPropio curso) throws Exception {
		return delete(curso);
	}

	/**
	 * 
	 * @param estado
	 */
	public Collection<CursoPropio> listarCursosEstadoPropuesto(EstadoCurso estado) throws Exception {

		/*
		 * Se puede poner en el metodo Date fechainicial,Date fechafinal para poner prioridad y para que se pueda buscar en un rango de fecha en concreto
		 */
		Vector<Object> resultado;
		Collection<CursoPropio> cursosEncontrados = new ArrayList<CursoPropio>();
		String SelectSQLEdicion="";

		if(estado.toString().trim().equals("PROPUESTO")) {

			SelectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'propuesto' ";

		}else if (estado.toString().trim().equals("VALIDADO")) {

			SelectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'validado' ";

		}else if (estado.toString().trim().equals("PROPUESTA_RECHAZADA")) {

			SelectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'propuesta_rechazada' ";

		}else if (estado.toString().trim().equals("EN_MATRICULACION")) {

			SelectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'en_matriculacion' ";

		}else if (estado.toString().trim().equals("EN_IMPARTIZICION")) {

			SelectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'en_imparticion' ";

		}else if (estado.toString().trim().equals("TERMINADO")) {

			SelectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'terminado' ";
		}


		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Cursos encontrados");



			for (int i = 0; i < resultado.size(); i++) {


				CursoPropio cursoAUX=crearObjetoCursoPropio(resultado.get(i).toString());
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
		String SelectSQLEdicion="";

		if(tipo.toString().equals("MASTER")) {

			SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
					+ " WHERE tipoCurso = 'master' and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		}else if(tipo.toString().equals("EXPERTO")) {

			SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
					+ " WHERE tipoCurso = 'experto' and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		}else if(tipo.toString().equals("ESPECIALISTA")) {

			SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
					+ " WHERE tipoCurso = 'especialista' and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		}else if(tipo.toString().equals("FORMACION_AVANZADA")) {

			SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
					+ " WHERE tipoCurso = 'formacion_avanzada' and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		}else if(tipo.toString().equals("FORMACION_CONTINUA")) {

			SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
					+ " WHERE tipoCurso = 'formacion_continua' and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		}else if(tipo.toString().equals("MICROCREDENCIALES")) {

			SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
					+ " WHERE tipoCurso = 'microcredenciales' and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";

		}else if(tipo.toString().equals("CORTA_DURACION")) {

			SelectSQLEdicion= "SELECT sum(tasaMatricula) as Ingresos FROM cursopropio"
					+ " WHERE tipoCurso = 'corta_duracion' and fechaInicio= '"+fechaInicio+"'and fechaFin= '"+fechaFin+"' ";
		}


		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Ingresos Calculados");
			ingresos=Double.parseDouble(resultado.get(0).toString().trim().replace("[", "").replace("]", ""));

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
		Collection<CursoPropio> cursosEncontrados=new ArrayList<CursoPropio>();
		String SelectSQLEdicion= "SELECT * FROM cursopropio"
				+ " WHERE  fechaInicio = '"+fechaInicio+"'and fechaFin = '"+fechaFin+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Ediciones encotradas");



			for (int i = 0; i < resultado.size(); i++) {


				CursoPropio cursoAUX=crearObjetoCursoPropio(resultado.get(i).toString());
				cursosEncontrados.add(cursoAUX);
			}

		}else
			System.err.println("Error encotrando ediciones");
		return cursosEncontrados;



	}


	public Vector<Object> listarIdCursoPropio(String idCursoPropio) throws Exception{


		Vector<Object> resultado;
		String SelectSQLEdicion= "SELECT * FROM cursopropio WHERE idCursoPropio = "+idCursoPropio+" ";
		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Cursos encotradas");

		}else
			System.err.println("Error encontrando cursos");

		return resultado;
	}


	@Override
	public Object get(String id) throws Exception {
		Vector<Object> resultado;
		CursoPropio cursoReturn=null;
		String SelectSQL= "SELECT * FROM cursopropio WHERE idCursoPropio = "+id+" " ;


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Curso seleccionado");

			cursoReturn= crearObjetoCursoPropio(resultado.toString());

		}else
			System.err.println("Error al seleccionar curso");

		return cursoReturn ;

	}

	@Override
	public int insert(Object entity) throws Exception {
		int resultado=0;
		CursoPropio curso =(CursoPropio) entity;
		String insertSQL = "INSERT INTO cursopropio (nombre,ETCS,fechaInicio,fechaFin,tasaMatricula,edicion,estado,centro,secretario,director,tipoCurso) "
				+ "VALUES ( '"+curso.getNombre()+"' , "+curso.getECTS()+" ," + " '"+curso.getFechaInicio()+"' , '"+curso.getFechaFin()+"' , "
				+ curso.getTasaMatricula()+" , "+curso.getEdicion()+" , '"+curso.getEstado()+"', '"+curso.getCentro()+"' , '"
				+ curso.getSecretario().getDni()+"' , '"+curso.getDirector().getDni()+"' , '"+curso.getTipo()+"' )";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado > 0) {
			System.out.println("Curso nuevo creado");
		}else
			System.err.println("Error creando curso nuevo ");

		return resultado;
	}

	@Override
	public Object update(Object entity) throws Exception {
		// TODO - implement CursoPropioDAO.editarCurso
		int resultado=0;
		CursoPropio curso=(CursoPropio)entity;
		String updateSQL = "UPDATE cursopropio SET "
				+ "nombre=  '"+curso.getNombre()+"' ,"
				+ "ETCS= "+curso.getECTS()+", "
				+ "fechaInicio= '"+curso.getFechaInicio()+"' , "
				+ "fechaFin='"+curso.getFechaFin()+"',"
				+ "tasaMatricula="+curso.getTasaMatricula()+","
				+ "edicion= "+curso.getEdicion()+","
				+ "estado= '"+curso.getEstado().toString().toLowerCase()+"',"
				+ "tipoCurso='"+curso.getTipo().toString().toLowerCase()+"',"
				+ "secretario='"+curso.getSecretario().getDni()+"',"
				+ "director= '"+curso.getDirector().getDni()+"'"
				+ " WHERE idCursoPropio= "+curso.getIdCursoPropio()+" ";

		resultado = GestorBD.update(updateSQL);
		if (resultado > 0) {
			System.out.println("Curso modificado");
		}else
			System.err.println("Error modificando curso ");

		return curso;
	}

	@Override
	public int delete(Object entity) throws Exception {
		int resultado=0;
		CursoPropio curso =(CursoPropio) entity;
		String insertSQL = "DELETE FROM cursopropio WHERE id= '"+curso.getIdCursoPropio()+"' ";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado > 0) {
			System.out.println("Curso eleminado");
		}else
			System.err.println("Error eleminando curso ");

		return resultado;
	}

	public int seleccinarID(CursoPropio curso) throws SQLException {
		int idCurso=0;
		Vector<Object> resultado;

		String insertSQL = "SELECT IdCursoPropio FROM cursopropio WHERE estado = '"+curso.getEstado()+"' AND nombre = '"+curso.getNombre()
		+"' AND fechaInicio = '"+curso.getFechaInicio()+"'  AND fechaFin = '"+curso.getFechaFin()+"' AND tasaMatricula = "+curso.getTasaMatricula()
		+" AND edicion = "+curso.getEdicion()+" AND centro = '"+curso.getCentro()+"' AND secretario = '"+curso.getSecretario().getDni()+"' AND director = '"+curso.getDirector().getDni()
		+"'AND tipoCurso = '"+curso.getTipo()+"' AND ETCS = "+curso.getECTS()+" ";

		resultado = GestorBD.select(insertSQL); 
		if (resultado.isEmpty()==false) {
			System.out.println("Identificador de curso encontrado");
			String[] aux =  (resultado.toString().trim().replace("[", "").replace("]", "")).split(",") ;

			idCurso=Integer.parseInt(aux[0]);
		}else
			System.err.println("Error al buscar el identificador del curso");

		return idCurso;
	}

	public CursoPropio crearObjetoCursoPropio(String cursoSplit) throws Exception {
		CursoPropio cursoReturn=null;
		CursoPropioDAO cursoDAO=new CursoPropioDAO();


		String[] aux =  (cursoSplit.trim().replace("[", "").replace("]", "")).split(",") ;
		//Coleccion de matriculas y materias
		Vector<Object> listaCursosIdCursoPropio= listarIdCursoPropio(aux[0].trim());
		Collection<Matricula> matriculas = new ArrayList<Matricula>();
		Collection<Materia> materias= new ArrayList<Materia>();
		GestorMatriculacion gMatriculas=new GestorMatriculacion();
		GestorMateria gMateria=new GestorMateria();


		//ProfesorUCLM Director y secretario
		GestorProfesor gProfesor= new GestorProfesor();
		Profesor director=gProfesor.seleccionarProfesor(aux[10]);
		Profesor secretario=gProfesor.seleccionarProfesor(aux[9]);





		//fecha
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicialAux=(Date) formato.parse(aux[3]);
		Date fechFinalAux=(Date) formato.parse(aux[4]);
		java.sql.Date fechaInicial = new java.sql.Date(fechaInicialAux.getTime());
		java.sql.Date fechaFinal = new java.sql.Date(fechFinalAux.getTime());




		//Creacion de Collection<Matriculas> y //Collection<Materia>
		for(int i=0;i<listaCursosIdCursoPropio.size();i++) {

			String[] auxMatriculas =  (listaCursosIdCursoPropio.get(i).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			Matricula matriculaAux=gMatriculas.seleccionarMatricula(auxMatriculas[0]);
			matriculas.add(matriculaAux);
			String curso = aux[0];
			materias.add(gMateria.seleccionarMaterias(aux[0]));
		}


		EstadoCurso estado=null;
		TipoCurso tipo=null;
		//estado
		if(aux[7].trim().equals("imparticion")) {
			estado=EstadoCurso.EN_IMPARTIZICION;
		}else if (aux[7].trim().equals("matriculacion")) {
			estado=EstadoCurso.EN_MATRICULACION;
		}else if (aux[7].trim().equals("propuesta_rechazada")) {
			estado=EstadoCurso.PROPUESTA_RECHAZADA;
		}else if (aux[7].trim().equals("propuesto")) {
			estado=EstadoCurso.PROPUESTO;
		}else if (aux[7].trim().equals("terminado")) {
			estado=EstadoCurso.TERMINADO;
		}else if (aux[7].trim().equals("validado")) {
			estado=EstadoCurso.VALIDADO;
		}

		//tipoCurso
		if(aux[11].trim().equals("corta_duracion")) {
			tipo=TipoCurso.CORTA_DURACION;
		}else if (aux[11].trim().equals("especialista")) {
			tipo=TipoCurso.ESPECIALISTA;
		}else if (aux[11].trim().equals("experto")) {
			tipo=TipoCurso.EXPERTO;
		}else if (aux[11].trim().equals("formacion_avanzada")) {
			tipo=TipoCurso.FORMACION_AVANZADA;
		}else if (aux[11].trim().equals("formacion_continua")) {
			tipo=TipoCurso.FORMACION_CONTINUA;
		}else if (aux[11].trim().equals("master")) {
			tipo=TipoCurso.MASTER;
		}else if (aux[11].trim().equals("microcredenciles")) {
			tipo=TipoCurso.MICROCREDENCIALES;
		}


		return cursoReturn= new CursoPropio(matriculas, director, secretario, materias, 
				estado, tipo, cursoDAO, Integer.parseInt(aux[0]), aux[1],Integer.parseInt(aux[2].trim()), 
				fechaInicial, fechaFinal, Double.parseDouble(aux[5].trim()), Integer.parseInt(aux[6].trim()));


		//		
	}

	public Collection<CursoPropio> cursosPorCentro(String id) throws Exception{

		Collection<Object> resultado=null;
		Collection<CursoPropio> cursosCentroReturn=null;
		CursoPropio cursoReturn=null;
		String SelectSQL= "SELECT * FROM cursopropio WHERE idCursoPropio = '"+Integer.getInteger(id)+"' " ;


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Curso seleccionado");
			Iterator<Object> it=resultado.iterator();
			while(it.hasNext())
				System.out.println(it.next().toString());
			cursoReturn= crearObjetoCursoPropio(it.next().toString());
			cursosCentroReturn.add(cursoReturn);

			//			
		}else
			System.err.println("Error al seleccionar curso");

		return cursosCentroReturn ;

	}

	public Collection<CursoPropio> listarCursosEstados(Date fechaInicio, Date fechaFin) throws SQLException, Exception {



		Vector<Object> resultado;
		Collection<CursoPropio> cursosEncontrados=new ArrayList<CursoPropio>();
		String SelectSQLEdicion= "SELECT * FROM cursopropio"
				+ " WHERE  fechaInicio = '"+fechaInicio+"'and fechaFin = '"+fechaFin+"' and (estado = 'validado' or estado= 'propuesta_rechazada') ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Ediciones encotradas");



			for (int i = 0; i < resultado.size(); i++) {


				CursoPropio cursoAUX=crearObjetoCursoPropio(resultado.get(i).toString());
				cursosEncontrados.add(cursoAUX);
			}

		}else
			System.err.println("Error encotrando ediciones");
		return cursosEncontrados;

	}

}