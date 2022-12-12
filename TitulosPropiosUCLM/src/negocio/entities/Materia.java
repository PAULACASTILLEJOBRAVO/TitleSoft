package negocio.entities;

import java.util.*;

public class Materia {
	int idMateria;
	Profesor responsable;
	private String nombre;
	private double horas;
	private Date fechaInicio;
	private Date fechaFin;
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public Profesor getResponsable() {
		return responsable;
	}
	public void setResponsable(Profesor responsable) {
		this.responsable = responsable;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getHoras() {
		return horas;
	}
	public void setHoras(double horas) {
		this.horas = horas;
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
	public Materia(Profesor responsable, int idMateria, String nombre, double horas, Date fechaInicio, Date fechaFin) {
		super();
		this.responsable = responsable;
		this.idMateria=idMateria;
		this.nombre = nombre;
		this.horas = horas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public Materia(Profesor responsable, String nombre, double horas, Date fechaInicio, Date fechaFin) {
		super();
		this.responsable = responsable;
		this.nombre = nombre;
		this.horas = horas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
}