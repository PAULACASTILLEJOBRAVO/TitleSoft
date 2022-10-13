package negocio.entities;

import java.util.*;
import persistencia.*;

public class CursoPropio {

	Collection<Matricula> matriculas;
	Centro centro;
	ProfesorUCLM director;
	ProfesorUCLM secretario;
	Collection<Materia> materias;
	EstadoCurso estado;
	TipoCurso tipo;
	CursoPropioDAO cursoPropioDao;
	private String id;
	private String nombre;
	private int ECTS;
	private Date fechaInicio;
	private Date fechaFin;
	private double tasaMatricula;
	private int edicion;
	
	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public ProfesorUCLM getDirector() {
		return director;
	}
	public void setDirector(ProfesorUCLM director) {
		this.director = director;
	}
	public ProfesorUCLM getSecretario() {
		return secretario;
	}
	public void setSecretario(ProfesorUCLM secretario) {
		this.secretario = secretario;
	}
	public Collection<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(Collection<Materia> materias) {
		this.materias = materias;
	}
	public EstadoCurso getEstado() {
		return estado;
	}
	public void setEstado(EstadoCurso estado) {
		this.estado = estado;
	}
	public TipoCurso getTipo() {
		return tipo;
	}
	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}
	public CursoPropioDAO getCursoPropioDao() {
		return cursoPropioDao;
	}
	public void setCursoPropioDao(CursoPropioDAO cursoPropioDao) {
		this.cursoPropioDao = cursoPropioDao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getECTS() {
		return ECTS;
	}
	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public double getTasaMatricula() {
		return tasaMatricula;
	}
	public void setTasaMatricula(double tasaMatricula) {
		this.tasaMatricula = tasaMatricula;
	}
	public int getEdicion() {
		return edicion;
	}
	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
	public CursoPropio(Collection<Matricula> matriculas, Centro centro, ProfesorUCLM director, ProfesorUCLM secretario,
			Collection<Materia> materias, EstadoCurso estado, TipoCurso tipo, CursoPropioDAO cursoPropioDao, String id,
			String nombre, int eCTS, Date fechaInicio, Date fechaFin, double tasaMatricula, int edicion) {
		super();
		this.matriculas = matriculas;
		this.centro = centro;
		this.director = director;
		this.secretario = secretario;
		this.materias = materias;
		this.estado = estado;
		this.tipo = tipo;
		this.cursoPropioDao = cursoPropioDao;
		this.id = id;
		this.nombre = nombre;
		ECTS = eCTS;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
	}

}