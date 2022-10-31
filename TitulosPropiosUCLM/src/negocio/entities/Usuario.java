package negocio.entities;

public class Usuario {
	private String idUsuario;
	private String password;
	TipoUsuario tipo;
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TipoUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	public Usuario(String idUsuario, String password, TipoUsuario tipo) {
		super();
		this.idUsuario = idUsuario;
		this.password = password;
		this.tipo = tipo;
	}


}
