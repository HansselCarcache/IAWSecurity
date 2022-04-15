package entidades;
import java.sql.Timestamp;

public class Tbl_user {
	
	//atributos
	private int id_usuario;
	private String id_uca;
	private String nombre_real;
	private String nombre_usuario;
	private String pwd;
	private String correo_institucional;
	private String correo_personal;
	private int sexo;
	private String cargo;
	private String telefono_contacto;
	private int estado;
	private String cedula;
	
	private String urlFoto;
	private String codVerificacion;
	private int usuario_creacion;
	private Timestamp fecha_creacion;
	private int usuario_edicion;
	private Timestamp fecha_edicion;
	private int usuario_eliminacion;
	private Timestamp fecha_eliminacion;
	
	//metodos
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getId_uca() {
		return id_uca;
	}
	public void setId_uca(String id_uca) {
		this.id_uca = id_uca;
	}
	public String getNombre_real() {
		return nombre_real;
	}
	public void setNombre_real(String nombre_real) {
		this.nombre_real = nombre_real;
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
	public String getCorreo_institucional() {
		return correo_institucional;
	}
	public void setCorreo_institucional(String correo_institucional) {
		this.correo_institucional = correo_institucional;
	}
	public String getCorreo_personal() {
		return correo_personal;
	}
	public void setCorreo_personal(String correo_personal) {
		this.correo_personal = correo_personal;
	}
	
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTelefono_contacto() {
		return telefono_contacto;
	}
	public void setTelefono_contacto(String telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public String getCodVerificacion() {
		return codVerificacion;
	}
	public void setCodVerificacion(String codVerificacion) {
		this.codVerificacion = codVerificacion;
	}
	public int getUsuario_creacion() {
		return usuario_creacion;
	}
	public void setUsuario_creacion(int usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}
	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public int getUsuario_edicion() {
		return usuario_edicion;
	}
	public void setUsuario_edicion(int usuario_edicion) {
		this.usuario_edicion = usuario_edicion;
	}
	public Timestamp getFecha_edicion() {
		return fecha_edicion;
	}
	public void setFecha_edicion(Timestamp fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}
	public int getUsuario_eliminacion() {
		return usuario_eliminacion;
	}
	public void setUsuario_eliminacion(int usuario_eliminacion) {
		this.usuario_eliminacion = usuario_eliminacion;
	}
	public Timestamp getFecha_eliminacion() {
		return fecha_eliminacion;
	}
	public void setFecha_eliminacion(Timestamp fecha_eliminacion) {
		this.fecha_eliminacion = fecha_eliminacion;
	}
	
	
	
	
	
	
	
	
	
	

}
