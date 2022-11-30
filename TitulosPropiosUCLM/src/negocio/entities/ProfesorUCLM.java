package negocio.entities;

public class ProfesorUCLM extends Profesor {

	
	CategoriaProfesor categoria;


	public CategoriaProfesor getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProfesor categoria) {
		this.categoria = categoria;
	}

	public ProfesorUCLM(String dni, String nombre, String apellidos, boolean doctor,CategoriaProfesor categoria) {
		super(dni, nombre, apellidos, doctor);
		this.categoria=categoria;

	}

}