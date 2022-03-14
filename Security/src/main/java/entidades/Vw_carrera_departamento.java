package entidades;

public class Vw_carrera_departamento {
	
	private int id_carrera;
	private String nombre_carrera;
	private int id_departamento;
	private String nombre_departamento;
	private int estado;
	
	public int getId_carrera() {
		return id_carrera;
	}
	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}
	public String getNombre_carrera() {
		return nombre_carrera;
	}
	public void setNombre_carrera(String nombre_carrera) {
		this.nombre_carrera = nombre_carrera;
	}
	public int getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	public String getNombre_departamento() {
		return nombre_departamento;
	}
	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
