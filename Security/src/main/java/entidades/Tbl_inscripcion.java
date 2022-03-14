package entidades;

public class Tbl_inscripcion {

	//Attributes
	
	
	private int id_inscripcion;
	private int id_usuario;
	private int id_facultad;
	private int id_departamento;
	private int id_carrera;
	private String fecha_inscripcion;
	private int id_oferta_detalle;
	private int id_escala;
	
	//Methods
	
	public int getId_inscripcion() {
		return id_inscripcion;
	}
	public void setId_inscripcion(int id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_facultad() {
		return id_facultad;
	}
	public void setId_facultad(int id_facultad) {
		this.id_facultad = id_facultad;
	}
	public int getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	public int getId_carrera() {
		return id_carrera;
	}
	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}
	public String getFecha_inscripcion() {
		return fecha_inscripcion;
	}
	public void setFecha_inscripcion(String fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
	public int getId_oferta_detalle() {
		return id_oferta_detalle;
	}
	public void setId_oferta_detalle(int id_oferta_detalle) {
		this.id_oferta_detalle = id_oferta_detalle;
	}
	public int getId_escala() {
		return id_escala;
	}
	public void setId_escala(int id_escala) {
		this.id_escala = id_escala;
	}
	
}
