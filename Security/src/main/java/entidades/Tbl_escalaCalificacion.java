package entidades;

public class Tbl_escalaCalificacion {

	//Attributes
	
	private int id_escala;
	private String tipo_calificacion;
	private String descripcion;
	private int estado;
	
	//Methods
	
	public int getId_escala() {
		return id_escala;
	}
	public void setId_escala(int id_escala) {
		this.id_escala = id_escala;
	
	
	}
	public String getTipo_calificacion() {
		return tipo_calificacion;
	}
	public void setTipo_calificacion(String tipo_calificacion) {
		this.tipo_calificacion = tipo_calificacion;
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
