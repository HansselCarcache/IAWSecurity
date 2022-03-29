package entidades;

public class Tbl_tipo_capacitacion {
	
	//atributos
	private int id_tipo_capacitacion;
	private String tipo_capacitacion;
	private int certificada;
	private String descripcion;
	private int estado;
	
	
	public int getId_tipo_capacitacion() {
		return id_tipo_capacitacion;
	}
	public void setId_tipo_capacitacion(int id_tipo_capacitacion) {
		this.id_tipo_capacitacion = id_tipo_capacitacion;
	}
	public String getTipo_capacitacion() {
		return tipo_capacitacion;
	}
	public void setTipo_capacitacion(String tipo_capacitacion) {
		this.tipo_capacitacion = tipo_capacitacion;
	}
	public int getCertificada() {
		return certificada;
	}
	public void setCertificada(int certificada) {
		this.certificada = certificada;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	

}
