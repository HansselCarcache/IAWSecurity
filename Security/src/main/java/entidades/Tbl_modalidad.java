package entidades;

public class Tbl_modalidad {
	
	//atributos
	private int id_modalidad;
	private String nombre;
	private String descripcion;
	private int certificada;
	private int estado;
	
	
	public int getId_modalidad() {
		return id_modalidad;
	}
	public void setId_modalidad(int id_modalidad) {
		this.id_modalidad = id_modalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCertificada() {
		return certificada;
	}
	public void setCertificada(int certificada) {
		this.certificada = certificada;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	

}
