package entidades;

public class Tbl_opcion {
	
	//atributos
	private int id_opcion;
	private String nombre_opcion;
	private String descripcion;
	private int estado;
	
	//metodos
	public int getId_opcion() {
		return id_opcion;
	}
	public void setId_opcion(int id_opcion) {
		this.id_opcion = id_opcion;
	}
	public String getNombre_opcion() {
		return nombre_opcion;
	}
	public void setNombre_opcion(String nombre_opcion) {
		this.nombre_opcion = nombre_opcion;
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
