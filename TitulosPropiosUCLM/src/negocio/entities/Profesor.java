package negocio.entities;

public class Profesor {

	private String dni;
	private String nombre;
	private String apellidos;
	private boolean doctor;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public boolean isDoctor() {
		return doctor;
	}
	public void setDoctor(boolean doctor) {
		this.doctor = doctor;
	}
	public Profesor(String dni, String nombre, String apellidos, boolean doctor) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.doctor = doctor;
	}

}