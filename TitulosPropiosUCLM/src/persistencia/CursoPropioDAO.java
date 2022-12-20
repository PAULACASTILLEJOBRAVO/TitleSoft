package persistencia;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import negocio.controllers.GestorMateria;
import negocio.controllers.GestorMatriculacion;
import negocio.controllers.GestorProfesor;
import negocio.entities.*;
import presentacion.MainTesting;

public class CursoPropioDAO implements AbstractEntityDAO  <Object> {
	private static final String SQLCOMPARARFECHAFIN = "' AND FechaFin ='"; 
	private static final String SQLSEPARADORNUMERICO = ", ";
	private static final String SQLSEPARADORSTRING = "', '";
	
	public int crearNuevoCurso(CursoPropio curso) {
		return insert(curso);
	}

	public CursoPropio seleccionarCurso(String id) {
		return (CursoPropio)get(id);
	}

	public CursoPropio editarCurso(CursoPropio curso) {
		return (CursoPropio) update(curso);
	}

	public int eliminarCurso(CursoPropio curso) {
		return delete(curso);
	}

	public Collection<CursoPropio> listarCursosEstadoPropuesto(EstadoCurso estado) {
		List<Object> resultado;
		Collection<CursoPropio> cursosEncontrados = new ArrayList<>();
		String selectSQLEdicion="";
		
		if(estado.toString().trim().equals("PROPUESTO")) {
			selectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'PROPUESTO' ";
		}else if (estado.toString().trim().equals("VALIDADO")) {
			selectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'VALIDO' ";
		}else if (estado.toString().trim().equals("PROPUESTA_RECHAZADA")) {
			selectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'PROPUESTA_RECHAZADA' ";
		}else if (estado.toString().trim().equals("EN_MATRICULACION")) {
			selectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'EN_MATRICULACION' ";
		}else if (estado.toString().trim().equals("EN_IMPARTIZICION")) {
			selectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'EN_IMPARTIZICION' ";
		}else if (estado.toString().trim().equals("TERMINADO")) {
			selectSQLEdicion= "SELECT * FROM cursopropio WHERE estado = 'TERMINADO' ";
		}

		resultado = GestorBD.select(selectSQLEdicion);

		if (!resultado.isEmpty()) {
			for (int i = 0; i < resultado.size(); i++) {
				CursoPropio cursoAUX=crearObjetoCursoPropio(resultado.get(i).toString());
				cursosEncontrados.add(cursoAUX);
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error encontrando cursos");
		return cursosEncontrados;
	}

	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		List<Object> resultado;
		double ingresos=0.0;
		String selectSQLEdicion="";
//		TipoCurso tipoCurso = null;
//
//		if(tipo.toString().equals("MASTER")) {
//			tipoCurso = TipoCurso.MASTER;
//		}else if(tipo.toString().equals("EXPERTO")) {
//			tipoCurso = TipoCurso.EXPERTO;
//		}else if(tipo.toString().equals("ESPECIALISTA")) {
//			tipoCurso = TipoCurso.ESPECIALISTA;
//		}else if(tipo.toString().equals("FORMACION_AVANZADA")) {
//			tipoCurso = TipoCurso.FORMACION_AVANZADA;
//		}else if(tipo.toString().equals("FORMACION_CONTINUA")) {
//			tipoCurso = TipoCurso.FORMACION_CONTINUA;
//		}else if(tipo.toString().equals("MICROCREDENCIALES")) {
//			tipoCurso = TipoCurso.MICROCREDENCIALES;
//		}else if(tipo.toString().equals("CORTA_DURACION")) {
//			tipoCurso = TipoCurso.CORTA_DURACION;
//		}
		
		
		java.sql.Date fechaInicioSQL= new java.sql.Date(fechaInicio.getTime());
		java.sql.Date fechaFinalSQL= new java.sql.Date(fechaFin.getTime());
		
		selectSQLEdicion="SELECT sum(tasaMatricula) as Ingresos FROM cursopropio WHERE tipoCurso='"+tipo.toString()+"' and fechaInicio= '"+
		fechaInicioSQL+SQLCOMPARARFECHAFIN+fechaFinalSQL+"' ";

		resultado = GestorBD.select(selectSQLEdicion);

		if (!resultado.isEmpty()) {
			ingresos=Double.parseDouble(resultado.get(0).toString().trim().replace("[", "").replace("]", ""));
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error calculando ingresos");
		return ingresos;
	}

	public Collection<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		List<Object> resultado;
		Collection<CursoPropio> cursosEncontrados=new ArrayList<>();
		String selectSQLEdicion= "SELECT * FROM cursopropio"
				+ " WHERE  fechaInicio = '"+fechaInicio+SQLCOMPARARFECHAFIN+fechaFin+"' ";

		resultado = GestorBD.select(selectSQLEdicion);

		if (!resultado.isEmpty()) {
			for (int i = 0; i < resultado.size(); i++) {
				CursoPropio cursoAUX=crearObjetoCursoPropio(resultado.get(i).toString());
				cursosEncontrados.add(cursoAUX);
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error encotrando ediciones");
		return cursosEncontrados;
	}

	public List<Object> listarIdCursoPropio(String idCursoPropio) {
		List<Object> resultado;
		String selectSQLEdicion= "SELECT * FROM cursopropio WHERE idCursoPropio = "+idCursoPropio+" ";
		resultado = GestorBD.select(selectSQLEdicion);

		if (resultado.isEmpty()) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error encontrando cursos");
		return resultado;
	}

	public int seleccinarID(CursoPropio curso) {
		int idCurso=0;
		List<Object> resultado;

		String insertSQL = "SELECT IdCursoPropio FROM cursopropio WHERE estado = '"+curso.getEstado()+"' AND nombre = '"+curso.getNombre()
		+"' AND fechaInicio = '"+curso.getFechaInicio()+SQLCOMPARARFECHAFIN+curso.getFechaFin()+"' AND tasaMatricula = "+curso.getTasaMatricula()
		+" AND edicion = "+curso.getEdicion()+" AND centro = '"+curso.getCentro()+"' AND secretario = '"+curso.getSecretario().getDni()+"' AND director = '"+curso.getDirector().getDni()
		+"'AND tipoCurso = '"+curso.getTipo()+"' AND ETCS = "+curso.getECTS()+" ";

		resultado = GestorBD.select(insertSQL); 
		if (!resultado.isEmpty()) {
			String[] aux =  (resultado.toString().trim().replace("[", "").replace("]", "")).split(",") ;

			idCurso=Integer.parseInt(aux[0]);
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al buscar el identificador del curso");
		return idCurso;
	}

	public CursoPropio crearObjetoCursoPropio(String cursoSplit) {
		CursoPropio cursoReturn=null;
		CursoPropioDAO cursoDAO=new CursoPropioDAO();

		String[] aux =  (cursoSplit.trim().replace("[", "").replace("]", "")).split(",") ;
		//Coleccion de matriculas y materias
		List<Object> listaCursosIdCursoPropio= listarIdCursoPropio(aux[0].trim());
		Collection<Matricula> matriculas = new ArrayList<>();
		Collection<Materia> materias= new ArrayList<>();
		GestorMateria gMateria=new GestorMateria();

		//ProfesorUCLM Director y secretario
		GestorProfesor gProfesor= new GestorProfesor();
		Profesor director=gProfesor.seleccionarProfesor(aux[10]);
		Profesor secretario=gProfesor.seleccionarProfesor(aux[9]);

		//Creacion de Collection<Matriculas> y //Collection<Materia>
		for(int i=0;i<listaCursosIdCursoPropio.size();i++) {

			String[] auxMatriculas =  (listaCursosIdCursoPropio.get(i).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			Matricula matriculaAux=GestorMatriculacion.seleccionarMatricula(auxMatriculas[0]);
			matriculas.add(matriculaAux);
			materias.add(gMateria.seleccionarMaterias(aux[0]));
		}

		EstadoCurso estado=null;
		TipoCurso tipo=null;
		//estado
		if(aux[7].trim().toUpperCase().equals("IMPARTICION")) {
			estado=EstadoCurso.EN_IMPARTICION;
		}else if (aux[7].trim().toUpperCase().equals("MATRICULACION")) {
			estado=EstadoCurso.EN_MATRICULACION;
		}else if (aux[7].trim().toUpperCase().equals("PROPUESTA_RECHAZADA")) {
			estado=EstadoCurso.PROPUESTA_RECHAZADA;
		}else if (aux[7].trim().toUpperCase().equals("PROPUESTO")) {
			estado=EstadoCurso.PROPUESTO;
		}else if (aux[7].trim().toUpperCase().equals("TERMINADO")) {
			estado=EstadoCurso.TERMINADO;
		}else if (aux[7].trim().toUpperCase().equals("VALIDADO")) {
			estado=EstadoCurso.VALIDADO;
		}

		//tipoCurso
		if(aux[11].trim().toUpperCase().equals("CORTA_DURACION")) {
			tipo=TipoCurso.CORTA_DURACION;
		}else if (aux[11].toUpperCase().trim().equals("ESPECIALISTA")) {
			tipo=TipoCurso.ESPECIALISTA;
		}else if (aux[11].toUpperCase().trim().equals("EXPERTO")) {
			tipo=TipoCurso.EXPERTO;
		}else if (aux[11].toUpperCase().trim().equals("FORMACION_AVANZADA")) {
			tipo=TipoCurso.FORMACION_AVANZADA;
		}else if (aux[11].toUpperCase().trim().equals("FORMACION_CONTINUA")) {
			tipo=TipoCurso.FORMACION_CONTINUA;
		}else if (aux[11].toUpperCase().trim().equals("MASTER")) {
			tipo=TipoCurso.MASTER;
		}else if (aux[11].toUpperCase().trim().equals("MICROCREDENCIALES")) {
			tipo=TipoCurso.MICROCREDENCIALES;
		}

		try {
			//fecha
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaInicialAux= formato.parse(aux[3]);
			Date fechFinalAux= formato.parse(aux[4]);
			java.sql.Date fechaInicial = new java.sql.Date(fechaInicialAux.getTime());
			java.sql.Date fechaFinal = new java.sql.Date(fechFinalAux.getTime());
			
			cursoReturn= new CursoPropio(matriculas, director, secretario, materias, 
					estado, tipo, cursoDAO, Integer.parseInt(aux[0]), aux[1],Integer.parseInt(aux[2].trim()), 
					fechaInicial, fechaFinal, Double.parseDouble(aux[5].trim()), Integer.parseInt(aux[6].trim()));
			return cursoReturn;
		}catch (ParseException e) {
			MainTesting.escribirLog(MainTesting.ERROR,"Error en la conversión de fecha SQL a fecha java");
			return cursoReturn;
		}
	}

	public Collection<CursoPropio> listarCursosRechazadosYPropuestos(Date fechaInicio, Date fechaFin)  {
		List<Object> resultado;
		Collection<CursoPropio> cursosEncontrados=new ArrayList<>();
		
		
		java.sql.Date fechaInicioSQL= new java.sql.Date(fechaInicio.getTime());
		java.sql.Date fechaFinalSQL= new java.sql.Date(fechaFin.getTime());
		
		
		String selectSQLEdicion= "SELECT * FROM cursopropio"
				+ " WHERE  fechaInicio = '"+fechaInicioSQL+"'and fechaFin = '"+fechaFinalSQL+"' and (estado = 'validado' or estado= 'propuesta_rechazada') ";

		resultado = GestorBD.select(selectSQLEdicion);

		if (!resultado.isEmpty()) {
			for (int i = 0; i < resultado.size(); i++) {
				CursoPropio cursoAUX=crearObjetoCursoPropio(resultado.get(i).toString());
				cursosEncontrados.add(cursoAUX);
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error encotrando ediciones");
		return cursosEncontrados;
	}
	
	public Collection<CursoPropio> listarCursosEstados(Date fechaInicio, Date fechaFin)  {
		List<Object> resultado;
		Collection<CursoPropio> cursosEncontrados=new ArrayList<>();
		String selectSQLEdicion= "SELECT * FROM cursopropio"
				+ " WHERE  fechaInicio = '"+fechaInicio+"'and fechaFin = '"+fechaFin+"' ";

		resultado = GestorBD.select(selectSQLEdicion);

		if (resultado.isEmpty()) {
			for (int i = 0; i < resultado.size(); i++) {
				CursoPropio cursoAUX=crearObjetoCursoPropio(resultado.get(i).toString());
				cursosEncontrados.add(cursoAUX);
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error encotrando ediciones");
		return cursosEncontrados;
	}

	@Override
	public Object get(String id) {
		List<Object> resultado;
		CursoPropio cursoReturn=null;
		String selectSQL= "SELECT * FROM cursopropio WHERE idCursoPropio = "+id+" " ;

		resultado = GestorBD.select(selectSQL);

		if (!resultado.isEmpty()) {
			cursoReturn= crearObjetoCursoPropio(resultado.toString());
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar curso");
		return cursoReturn ;
	}

	@Override
	public int insert(Object entity) {
		int resultado=0;
		CursoPropio curso =(CursoPropio) entity;
		String insertSQL = "INSERT INTO cursopropio (nombre,ETCS,fechaInicio,fechaFin,tasaMatricula,edicion,estado,centro,secretario,director,tipoCurso) "
				+ "VALUES ( '"+curso.getNombre()+"' , "+curso.getECTS()+SQLSEPARADORNUMERICO+" '"+curso.getFechaInicio()+SQLSEPARADORSTRING+curso.getFechaFin()+"' , "
				+ curso.getTasaMatricula()+SQLSEPARADORNUMERICO+curso.getEdicion()+" , '"+curso.getEstado()+SQLSEPARADORSTRING+curso.getCentro()+"' , '"
				+ curso.getSecretario().getDni()+SQLSEPARADORSTRING+curso.getDirector().getDni()+SQLSEPARADORSTRING+curso.getTipo()+"' )";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error creando curso nuevo ");
		return resultado;
	}

	@Override
	public Object update(Object entity) {
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
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error modificando curso ");
		return curso;
	}

	@Override
	public int delete(Object entity) {
		int resultado=0;
		CursoPropio curso =(CursoPropio) entity;
		String insertSQL = "DELETE FROM cursopropio WHERE id= '"+curso.getIdCursoPropio()+"' ";

		resultado = GestorBD.insert(insertSQL); 
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error eleminando curso ");
		return resultado;
	}
}