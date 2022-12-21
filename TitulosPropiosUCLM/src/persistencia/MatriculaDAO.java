package persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import negocio.entities.*;
import presentacion.MainTesting;


public class MatriculaDAO implements AbstractEntityDAO  <Object> {

	public int crearMatricula(Matricula matricula) {
		return insert(matricula);
	}

	public Matricula seleccionarMatricula(String id){
		return (Matricula)get(id);
	}

	public Matricula editarMatricula(Matricula matricula) {
		return (Matricula)update(matricula);
	}

	public int eliminarrMatricula(Matricula matricula)  {
		return delete(matricula);
	}
	
	@Override
	public Object get(String id){
		List<Object> resultado;
		Matricula matriculaEncontrada=null;
		
		String selectSQL= "SELECT * FROM matricula WHERE idMatricula = "+id+" ";

		resultado = GestorBD.select(selectSQL);

		if (!resultado.isEmpty()) {
			String[] aux =  (resultado.get(0).toString().trim().replace("[", "").replace("]", "")).split(",") ;
			
			try {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date fecha= formato.parse(aux[3]);
				
				if(aux[5].equals("credito")) {
					matriculaEncontrada=new Matricula(Integer.getInteger(aux[0]), aux[1],aux[2], ModoPago.TARJETA_CREDITO, fecha,Boolean.parseBoolean(aux[4]));
				}else if(aux[5].equals("transferencia")){
					matriculaEncontrada=new Matricula(Integer.getInteger(aux[0]),aux[1],aux[2], ModoPago.TRANSFERENCIA, fecha, Boolean.parseBoolean(aux[4]));
				}
			}catch (ParseException e) {
				MainTesting.escribirLog(MainTesting.ERROR,"Error en la conversión de String a entero");
			}
		}else
			MainTesting.escribirLog(MainTesting.ERROR, "Error al seleccionar la matricula");
		return matriculaEncontrada;
	}

	@Override
	public int insert(Object entity){
		int resultado=0;
		Matricula matricula= (Matricula)entity;
		String insertSQL = "INSERT INTO admin.matricula (curso,dni,fecha,pagado,modo) " 
				+ "VALUES ( "+matricula.getTitulo()+" , '"+matricula.getDni()+"' , '"
				+matricula.getFecha()+"', '"+matricula.isPagado()+"' , '"+matricula.getTipoPago()+"' )";

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error creando matricula nueva.");
		return resultado;
	}

	@Override
	public Object update(Object entity) {
		int resultado=0;
		Matricula matricula=(Matricula)entity;
		String updateSQL = "UPDATE matricula SET"
				+ "titulacion= '"+matricula.getTitulo()+"',"
				+ "Fecha= '"+matricula.getFecha()+"',"
				+ "pagado= '"+matricula.isPagado()+"',"
				+ "Modo= '"+matricula.getTipoPago()+"',";
				
		resultado = GestorBD.update(updateSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error modificando matricula ");
		return matricula;
	}

	@Override
	public int delete(Object entity) {
		int resultado=0;
		Matricula matricula= (Matricula)entity;
		String insertSQL = "DELETE FROM matricula WHERE '"+matricula.getTitulo()+"' )";//faltan el pagado que es un boolean y el curso, el identificativo que lo enlaza, lo puse asi en la tabla

		resultado = GestorBD.insert(insertSQL);
		if (resultado < 0) 
			MainTesting.escribirLog(MainTesting.ERROR, "Error creando matricula nueva ");
		return resultado;
	}
}
