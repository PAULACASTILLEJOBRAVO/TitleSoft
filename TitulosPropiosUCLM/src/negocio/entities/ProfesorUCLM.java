package negocio.entities;

public class ProfesorUCLM extends Profesor {

	
	CategoriaProfesor categoria;
	private String nombre;
	private String apellidos;
	private String dni;
	
	public CategoriaProfesor getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProfesor categoria) {
		this.categoria = categoria;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public ProfesorUCLM(String dni, String nombre, String apellidos, boolean doctor,CategoriaProfesor categoria) {
		super(dni, nombre, apellidos, doctor);
		this.categoria=categoria;

	}

}