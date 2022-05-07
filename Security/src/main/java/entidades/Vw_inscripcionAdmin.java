package entidades;

public class Vw_inscripcionAdmin {

	private String nombre_completo;
	private String telefono;
	private String correo;
	private int estado;
	private String otras_dependencias;
	private int id_usuario;
	private int id_oferta_detalle;
	
	private int id_inscripcion;
	public int getId_inscripcion() {
		return id_inscripcion;
	}
	public void setId_inscripcion(int id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getOtras_dependencias() {
		return otras_dependencias;
	}
	public void setOtras_dependencias(String otras_dependencias) {
		this.otras_dependencias = otras_dependencias;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_oferta_detalle() {
		return id_oferta_detalle;
	}
	public void setId_oferta_detalle(int id_oferta_detalle) {
		this.id_oferta_detalle = id_oferta_detalle;
	}
	
	
}
