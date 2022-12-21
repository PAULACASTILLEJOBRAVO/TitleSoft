package negocio.entities;

import java.util.*;

public class Matricula {
	
	int idMatricula;
	String titulo;
	String dni;
	ModoPago tipoPago;
	private Date fecha;
	private boolean pagado;
	
	public int getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ModoPago getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(ModoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public Matricula(String titulo, String dni, ModoPago tipoPago, Date fecha, boolean pagado) {
		super();
		this.titulo = titulo;
		this.dni = dni;
		this.tipoPago = tipoPago;
		this.fecha = fecha;
		this.pagado = pagado;
	}
	public Matricula(int idMatricula,String titulo, String dni, ModoPago tipoPago, Date fecha, boolean pagado) {
		super();
		this.idMatricula=idMatricula;
		this.titulo = titulo;
		this.dni = dni;
		this.tipoPago = tipoPago;
		this.fecha = fecha;
		this.pagado = pagado;
	}
}