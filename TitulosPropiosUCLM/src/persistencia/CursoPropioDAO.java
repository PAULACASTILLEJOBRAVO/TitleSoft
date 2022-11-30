package persistencia;

import java.util.Date;
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
	public Collection<CursoPropio> listarCursosPorEstado(EstadoCurso estado) throws Exception {

		/*
		 * Se puede poner en el metodo Date fechainicial,Date fechafinal para poner prioridad y para que se pueda buscar en un rango de fecha en concreto
		 */
		Vector<Object> resultado;
		Collection<CursoPropio> cursosEncontrados = null;


		String SelectSQLEdicion= "SELECT * FROM cursopropio"
				+ "WHERE estado = '"+estado.toString()+"' ";

		resultado = GestorBD.select(SelectSQLEdicion);

		if (resultado.isEmpty()==false) {
			System.out.println("Cursos encontrados");



			for (int i = 0; i < resultado.size(); i++) {

				String[] cursoSplit=(resultado.get(i).toString().trim().replace("[", "").replace("]", "")).split(",") ;


				CursoPropio cursoAUX=crearObjetoCursoPropio(cursoSplit[i]);
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
			ingresos=Double.parseDouble(resultado.toString());

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


	public Vector<Object> listarIdControlador(String idControlador) throws Exception{


		Vector<Object> resultado;
		String SelectSQLEdicion= "SELECT * FROM cursopropio WHERE idcontrolador = "+idControlador+" ";
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
		String SelectSQL= "SELECT * FROM cursopropio WHERE idReal = "+id+" " ;


		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Curso seleccionado");


			cursoReturn= crearObjetoCursoPropio(resultado.toString());

			//			
		}else
			System.err.println("Error al seleccionar curso");

		return cursoReturn ;

	}

	@Override
	public int insert(Object entity) throws Exception {
		int resultado=0;
		CursoPropio curso =(CursoPropio) entity;
		String insertSQL = "INSERT INTO cursopropio (idReal,idControlador,nombre,ECTS,fechaInicio,fechaFin,tasaMatricula,edicion,estado,tipoCurso,Centro,secretario,director) "
				+ "VALUES ( '"+curso.getIdReal()+"','"+curso.getIdControlador()+"' , '"+curso.getNombre()+"' , '"+curso.getECTS()+"' ,"
				+ " '"+curso.getFechaInicio()+"' , '"+curso.getFechaFin()+"' , '"+curso.getTasaMatricula()+"' , "
				+ " '"+curso.getEdicion()+"' , '"+curso.getEstado()+"' , '"+curso.getTipo()+"', "
				+ "  '"+curso.getSecretario()+"' , '"+curso.getDirector()+"' )";

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
				+ "idReal= '"+curso.getIdReal()+"',"
				+ "idControlador= '"+curso.getIdControlador()+"'"
				+ "nombre=  '"+curso.getNombre()+"' ,"
				+ "ECTS= '"+curso.getECTS()+"' "
				+ "fechaInicio= '"+curso.getFechaInicio()+"' , "
				+ "fechaFin='"+curso.getFechaFin()+"',"
				+ "tasaMatricula='"+curso.getTasaMatricula()+"',"
				+ "edicion= '"+curso.getEdicion()+"',"
				+ "estado= '"+curso.getEstado()+"',"
				+ "tipoCurso='"+curso.getTipo()+"',"
				+ "secretario='"+curso.getSecretario()+"',"
				+ "director= '"+curso.getDirector()+"'";

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
		String insertSQL = "DELETE FROM cursopropio WHERE id= '"+curso.getIdControlador()+"' ";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado > 0) {
			System.out.println("Curso eleminado");
		}else
			System.err.println("Error eleminando curso ");

		return resultado;
	}


	public CursoPropio crearObjetoCursoPropio(String cursoSplit) throws Exception {
		CursoPropio cursoReturn=null;
		CursoPropioDAO cursoDAO=new CursoPropioDAO();


		String[] aux =  (cursoSplit.trim().replace("[", "").replace("]", "")).split(",") ;
		//Coleccion de matriculas y materias
		Vector<Object> listaCursosIdControlador= listarIdControlador(aux[1].trim());
		Collection<Matricula> matriculas = new ArrayList<Matricula>();
		Collection<Materia> materias= new ArrayList<Materia>();
		GestorMatriculacion gMatriculas=new GestorMatriculacion();
		GestorMateria gMateria=new GestorMateria();


		//ProfesorUCLM Director y secretario
		GestorProfesorUCLM gProfesor= new GestorProfesorUCLM();
		ProfesorUCLM director=gProfesor.seleccionarProfesor(aux[11]);
		ProfesorUCLM secretario=gProfesor.seleccionarProfesor(aux[10]);



		

		//fecha
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicialAux=(Date) formato.parse(aux[4]);
		Date fechFinalAux=(Date) formato.parse(aux[5]);
		java.sql.Date fechaInicial = new java.sql.Date(fechaInicialAux.getTime());
		java.sql.Date fechaFinal = new java.sql.Date(fechFinalAux.getTime());




		//Creacion de Collection<Matriculas> y //Collection<Materia>
		for(int i=0;i<listaCursosIdControlador.size();i++) {

			String[] auxMatriculas =  (listaCursosIdControlador.get(i).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			Matricula matriculaAux=gMatriculas.seleccionarMatricula(auxMatriculas[2]);
			matriculas.add(matriculaAux);
			materias.add(gMateria.seleccionarMaterias(auxMatriculas[12]));
		}


		EstadoCurso estado=null;
		TipoCurso tipo=null;
		//estado
		if(aux[8].trim().equals("imparizicion")) {
			estado=EstadoCurso.EN_IMPARTIZICION;
		}else if (aux[8].trim().equals("matriculacion")) {
			estado=EstadoCurso.EN_MATRICULACION;
		}else if (aux[8].trim().equals("propuesta_rechazada")) {
			estado=EstadoCurso.PROPUESTA_RECHAZADA;
		}else if (aux[8].trim().equals("propuesto")) {
			estado=EstadoCurso.PROPUESTO;
		}else if (aux[8].trim().equals("terminado")) {
			estado=EstadoCurso.TERMINADO;
		}else if (aux[8].trim().equals("validado")) {
			estado=EstadoCurso.VALIDADO;
		}

		//tipoCurso
		if(aux[9].trim().equals("corta_duracion")) {
			tipo=TipoCurso.CORTA_DURACION;
		}else if (aux[9].trim().equals("especialista")) {
			tipo=TipoCurso.ESPECIALISTA;
		}else if (aux[9].trim().equals("experto")) {
			tipo=TipoCurso.EXPERTO;
		}else if (aux[9].trim().equals("formacion_avanzada")) {
			tipo=TipoCurso.FORMACION_AVANZADA;
		}else if (aux[9].trim().equals("formacion_continua")) {
			tipo=TipoCurso.FORMACION_CONTINUA;
		}else if (aux[9].trim().equals("master")) {
			tipo=TipoCurso.MASTER;
		}else if (aux[9].trim().equals("microcredenciles")) {
			tipo=TipoCurso.MICROCREDENCIALES;
		}


		return cursoReturn= new CursoPropio(matriculas, director, secretario, materias, 
				estado, tipo.CORTA_DURACION, cursoDAO, Integer.parseInt(aux[1].trim()), 
				Integer.parseInt(aux[0]), aux[2],Integer.parseInt( aux[3].trim()), fechaInicial, 
				fechaFinal, Double.parseDouble(aux[6].trim()), Integer.parseInt(aux[7].trim()));


		//		
	}

	public Collection<CursoPropio> cursosPorCentro(String id) throws Exception{

		Collection<Object> resultado=null;
		Collection<CursoPropio> cursosCentroReturn=null;
		CursoPropio cursoReturn=null;
		String SelectSQL= "SELECT * FROM cursopropio WHERE idReal = '"+id+"' " ;


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


}