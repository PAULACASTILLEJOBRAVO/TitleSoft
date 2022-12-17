package negocio.entities;

import java.util.*;

public class Centro {
	Collection<CursoPropio> cursoPropios;
	Collection<Profesor> plantilla;
	private String nombre;
	private String localizacion;
	private int idReal;
	public Collection<CursoPropio> getCursoPropios() {
		return cursoPropios;
	}
	public void setCursoPropios(Collection<CursoPropio> cursoPropios) {
		this.cursoPropios = cursoPropios;
	}
	public Collection<Profesor> getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(Collection<Profesor> plantilla) {
		this.plantilla = plantilla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public int getAttribute() {
		return idReal;
	}
	public void setAttribute(int attribute) {
		this.idReal = attribute;
	}
	public Centro(Collection<CursoPropio> cursoPropios, Collection<Profesor> plantilla, String nombre,
			String localizacion, int idReal) {
		super();
		this.cursoPropios = cursoPropios;
		this.plantilla = plantilla;
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.idReal = idReal;
	}

}