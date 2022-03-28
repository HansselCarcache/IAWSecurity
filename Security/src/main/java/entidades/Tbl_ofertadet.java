package entidades;

import java.sql.Date;

public class Tbl_ofertadet {
	
	private int id_oferta_detalle;
	private int id_oferta;
	private Date fecha_inicio;
	private Date fecha_final;
	private String dias;
	private String descripcion_horaria;
	private int publico;
	private int id_capacitacion;
	private int id_facilitador;
	
	
	private int usuario_creacion;
	private String fecha_creacion;
	private int usuario_edicion;
	private String fecha_edicion;
	private int usuario_eliminacion;
	private String fecha_eliminacion;
	
	
	public int getId_oferta_detalle() {
		return id_oferta_detalle;
	}
	public void setId_oferta_detalle(int id_oferta_detalle) {
		this.id_oferta_detalle = id_oferta_detalle;
	}
	public int getId_oferta() {
		return id_oferta;
	}
	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public int getPublico() {
		return publico;
	}
	public void setPublico(int publico) {
		this.publico = publico;
	}
	public int getId_capacitacion() {
		return id_capacitacion;
	}
	public void setId_capacitacion(int id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}
	public int getId_facilitador() {
		return id_facilitador;
	}
	public void setId_facilitador(int id_facilitador) {
		this.id_facilitador = id_facilitador;
	}
	public int getUsuario_creacion() {
		return usuario_creacion;
	}
	public void setUsuario_creacion(int usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public int getUsuario_edicion() {
		return usuario_edicion;
	}
	public void setUsuario_edicion(int usuario_edicion) {
		this.usuario_edicion = usuario_edicion;
	}
	public String getFecha_edicion() {
		return fecha_edicion;
	}
	public void setFecha_edicion(String fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}
	public int getUsuario_eliminacion() {
		return usuario_eliminacion;
	}
	public void setUsuario_eliminacion(int usuario_eliminacion) {
		this.usuario_eliminacion = usuario_eliminacion;
	}
	public String getFecha_eliminacion() {
		return fecha_eliminacion;
	}
	public void setFecha_eliminacion(String fecha_eliminacion) {
		this.fecha_eliminacion = fecha_eliminacion;
	}
	public String getDescripcion_horaria() {
		return descripcion_horaria;
	}
	public void setDescripcion_horaria(String descripcion_horaria) {
		this.descripcion_horaria = descripcion_horaria;
	}
	
	
}
