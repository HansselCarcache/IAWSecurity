package entidades;

public class Vw_userrol {
	
	//atributos
	private int id_rol_usuario;
	private int id_usuario;
	private String nombre_usuario;
	private String usuario;
	private String pwd;
	private String key;
	private String codVerificacion;
	private int id_rol;
	private String rol;
	private int estado;
	private String UrlFoto;
	
	public String getUrlFoto() {
		return UrlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.UrlFoto = urlFoto;
	}
	//metodos
	public int getId_rol_usuario() {
		return id_rol_usuario;
	}
	public void setId_rol_usuario(int id_rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCodVerificacion() {
		return codVerificacion;
	}
	public void setCodVerificacion(String codVerificacion) {
		this.codVerificacion = codVerificacion;
	}
	
	
	
	
	
	
	
}
