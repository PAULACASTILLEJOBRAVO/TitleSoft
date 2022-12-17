package persistencia;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Vector;

import negocio.controllers.GestorProfesor;
import negocio.entities.*;
import presentacion.MainTesting;

public class MateriaDAO extends AbstractEntityDAO {

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
	
	@Override
	public Object get(String id) {
		Vector<Object> resultado;
		Materia materiaEncontrada=null;
		String SelectSQL= "SELECT m.IDMATERIA, m.NOMBRE, m.HORAS, m.FECHAINICIO, m.FECHAFIN, m.DNIPROFESOR FROM MATERIA m, "
		+ "RELACIONMATERIASCURSO r, CURSOPROPIO c WHERE c.IDCURSOPROPIO=r.CURSO AND m.IDMATERIA=r.MATERIA AND c.IDCURSOPROPIO="
				+id;

		resultado = GestorBD.select(SelectSQL);

		if (resultado.isEmpty()==false) {
			System.out.println("Materia seleccionado");
			
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			
			GestorProfesor gProfesor=new GestorProfesor();
			
			Profesor responsable=gProfesor.seleccionarProfesor(aux[5]);
			
			try {
				Date fecha1=(Date) formato.parse(aux[3]);
				java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
				
				Date fecha2 = (Date) formato.parse(aux[3]);
				java.sql.Date sqlDate2 = new java.sql.Date(fecha2.getTime());
			
				materiaEncontrada=new Materia(responsable, Integer.parseInt(aux[0]), aux[1], Double.parseDouble(aux[2]), sqlDate1, sqlDate2);
			}catch (ParseException e) {
				MainTesting.escribirLog(MainTesting.ERROR,"Error en la conversión de fecha SQL a fecha java");
			}
		}else
			System.err.println("Error al seleccionar materia");
		return materiaEncontrada ;
	}


	@Override
	public int insert(Object entity){
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
		if (resultado > 0) {
			System.out.println("Materia modificado");
		}else
			System.err.println("Error modificando materia ");
		return materia;
	}


	@Override
	public int delete(Object entity) {
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
	
	public int vincularCursoMateria(int idMateria, int IdCurso) {
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

	public int seleccionarId(Materia materia) {
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