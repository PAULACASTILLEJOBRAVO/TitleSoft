package negocio.entities;

import java.util.*;
import persistencia.*;

public class CursoPropio {

	Collection<Matricula> matriculas;
	Profesor director;
	Profesor secretario;
	Collection<Materia> materias;
	EstadoCurso estado;
	TipoCurso tipo;
	CursoPropioDAO cursoPropioDao;
	private int idCursoPropio;
	private String nombre;
	private int eCTS;
	private Date fechaInicio;
	private Date fechaFin;
	private double tasaMatricula;
	private int edicion;
	String centro;
	
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public void setDirector(Profesor director) {
		this.director = director;
	}
	public void setSecretario(Profesor secretario) {
		this.secretario = secretario;
	}
	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	public Profesor getDirector() {
		return director;
	}
	public void setDirector(ProfesorUCLM director) {
		this.director = director;
	}
	public Profesor getSecretario() {
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
	public int getIdCursoPropio() {
		return idCursoPropio;
	}
	public void setIdCursoPropio(int idCursoPropio) {
		this.idCursoPropio = idCursoPropio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getECTS() {
		return eCTS;
	}
	public void setECTS(int eCTS) {
		this.eCTS = eCTS;
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
	public CursoPropio(Collection<Matricula> matriculas, Profesor director, Profesor secretario,
			Collection<Materia> materias, EstadoCurso estado, TipoCurso tipo, CursoPropioDAO cursoPropioDao,int idCursoPropio,
			String nombre, int eCTS, Date fechaInicio, Date fechaFin, double tasaMatricula, int edicion,String centro) {
		super();
		this.matriculas = matriculas;
		this.director = director;
		this.secretario = secretario;
		this.materias = materias;
		this.estado = estado;
		this.tipo = tipo;
		this.cursoPropioDao = cursoPropioDao;
		this.nombre = nombre;
		this.idCursoPropio=idCursoPropio;
		this.eCTS = eCTS;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
		this.centro=centro;
	}
	
	public CursoPropio(String nombre, Date fechaInicio, Date fechaFin, int eCTS, double tasaMatricula, int edicion, 
						Profesor director, Profesor secretario, EstadoCurso estado, TipoCurso tipo, String centro) {
		super();
		this.director = director;
		this.secretario = secretario;
		this.estado = estado;
		this.tipo = tipo;
		this.nombre = nombre;
		this.eCTS = eCTS;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
		this.centro = centro;
	}
}