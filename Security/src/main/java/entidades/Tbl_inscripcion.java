package entidades;

public class Tbl_inscripcion {

	//Attributes
	
	
	private int id_inscripcion;
	private int id_usuario;
	private String nombre_completo;
	private String telefono;
	private String correo;
	private String otras_dependencias;
	private String fecha_inscripcion;
	private int id_oferta_detalle;
	private int id_escala;
	private int id_escala_det;
	private String valor;
	private String desc_valor;
	private int estado;
	
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
	public String getOtras_dependencias() {
		return otras_dependencias;
	}
	public void setOtras_dependencias(String otras_dependencias) {
		this.otras_dependencias = otras_dependencias;
	}
	public int getId_escala_det() {
		return id_escala_det;
	}
	public void setId_escala_det(int id_escala_det) {
		this.id_escala_det = id_escala_det;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDesc_valor() {
		return desc_valor;
	}
	public void setDesc_valor(String desc_valor) {
		this.desc_valor = desc_valor;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
