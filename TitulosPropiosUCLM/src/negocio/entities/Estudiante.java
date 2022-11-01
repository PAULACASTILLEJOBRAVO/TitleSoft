package negocio.entities;

import java.util.*;

public class Estudiante {

	Collection<Matricula> matriculas;
	private int idEstudiante;
	private String dni;
	private String nombre;
	private String apellidos;
	private String titulacion;
	private String cualificacion;
	
	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public String getCualificacion() {
		return cualificacion;
	}
	public void setCualificacion(String cualificacion) {
		this.cualificacion = cualificacion;
	}
	public Estudiante(Collection<Matricula> matriculas,int idEstudiante, String dni, String nombre, String apellidos, String titulacion,
			String cualificacion) {
		super();
		this.idEstudiante=idEstudiante;
		this.matriculas = matriculas;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.titulacion = titulacion;
		this.cualificacion = cualificacion;
	}

}