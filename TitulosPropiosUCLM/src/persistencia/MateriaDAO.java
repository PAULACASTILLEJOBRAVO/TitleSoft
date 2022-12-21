package persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import negocio.controllers.GestorProfesor;
import negocio.entities.*;
import presentacion.MainTesting;

public class MateriaDAO implements AbstractEntityDAO <Object>  {

	public int crearMateria(Materia materia) {
		return insert(materia);
	}

	public Materia seleccionarMateria(String id) {
		return (Materia) get(id);
	}

	public Materia editarMateria(Materia materia)  {
		return (Materia)update(materia);
	}

	public int eliminarMateria(Materia materia){
		return delete(materia);
	}
	
	public int vincularCursoMateria(int idMateria, int idCurso) {
		int resultado=0;
		String insertSQL = "INSERT INTO RELACIONMATERIASCURSO (materia,curso) "
				+ "VALUES ("+idMateria+" , "+idCurso+") ";
		
		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0)
			MainTesting.escribirLog(MainTesting.ERROR, "Error al vincular materia con su curso correspondiente");
		return resultado;
	}

	public int seleccionarId(Materia materia) {
		int idMateria=0;
		
		List<Object> resultado;
		
		String insertSQL = "SELECT idmateria FROM materia WHERE nombre = '"+materia.getNombre()
				+"' AND fechaInicio = '"+materia.getFechaInicio()+"'  AND fechaFin = '"+materia.getFechaFin()
				+"' AND dniProfesor = '"+materia.getResponsable().getDni()+"' AND horas = "+materia.getHoras()+" ";
		
		resultado = GestorBD.select(insertSQL); 
		if (!resultado.isEmpty()) {
			String[] aux =  (resultado.toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			idMateria=Integer.parseInt(aux[0]);
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar materia");
		return idMateria;
	}
	
	@Override
	public Object get(String id) {
		List<Object> resultado;
		Materia materiaEncontrada=null;
		String selectSQL= "SELECT m.IDMATERIA, m.NOMBRE, m.HORAS, m.FECHAINICIO, m.FECHAFIN, m.DNIPROFESOR FROM MATERIA m, "
		+ "RELACIONMATERIASCURSO r, CURSOPROPIO c WHERE c.IDCURSOPROPIO=r.CURSO AND m.IDMATERIA=r.MATERIA AND c.IDCURSOPROPIO="
				+id;

		resultado = GestorBD.select(selectSQL);

		if (!resultado.isEmpty()) {
			String[] aux = (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			
			GestorProfesor gProfesor=new GestorProfesor();
			
			Profesor responsable=gProfesor.seleccionarProfesor(aux[5]);
			
			try {
				Date fecha1= formato.parse(aux[3]);
				java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
				
				Date fecha2 = formato.parse(aux[3]);
				java.sql.Date sqlDate2 = new java.sql.Date(fecha2.getTime());
			
				materiaEncontrada=new Materia(responsable, Integer.parseInt(aux[0]), aux[1], Double.parseDouble(aux[2]), sqlDate1, sqlDate2);
			}catch (ParseException e) {
				MainTesting.escribirLog(MainTesting.ERROR,"Error en la conversión de fecha SQL a fecha java");
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar materia");
		return materiaEncontrada ;
	}


	@Override
	public int insert(Object entity){
		int resultado=0;
		Materia materia=(Materia)entity;
		String insertSQL = "INSERT INTO materia (nombre,horas,fechaInicio,fechaFin,dniProfesor) " 
				+ "VALUES ('"+materia.getNombre()+"' ,"+materia.getHoras()+" , '"+materia.getFechaInicio()+"', '"+materia.getFechaFin()+"', '"+materia.getResponsable().getDni()+"' )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0)
			MainTesting.escribirLog(MainTesting.ERROR, "Error al insertar materia");
		return resultado;
	}


	@Override
	public Object update(Object entity){
		int resultado=0;
		Materia materia=(Materia)entity;
		String updateSQL = "UPDATE materia SET"
				+ "nombre= '"+materia.getNombre()+"' ,"
				+ "horas= '"+materia.getHoras()+"',"
				+ "fechaInicio= '"+materia.getFechaInicio()+"',"
				+ "fechaFin= '"+materia.getFechaFin()+"',"
				+ "Curso= '"+materia.getResponsable()+"',";

		resultado = GestorBD.update(updateSQL);
		if (resultado < 0)
			MainTesting.escribirLog(MainTesting.ERROR, "Error al actualizar materia");
		return materia;
	}


	@Override
	public int delete(Object entity) {
		int resultado=0;
		Materia materia=(Materia)entity;
		String insertSQL = "DELETE FROM materia WHERE nombre= '"+materia.getNombre()+"' ";
		
		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0)
			MainTesting.escribirLog(MainTesting.ERROR, "Error al eliminar materia");
		return resultado;
	}
}