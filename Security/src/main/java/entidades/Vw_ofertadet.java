package entidades;

import java.sql.Date;

public class Vw_ofertadet {

	private int id_oferta_detalle;
	private int id_oferta;
	private String periodo;
	private Date fecha_inicio;
	private Date fecha_final;
	private String descripcion_horaria;
	private String dias;
	private int publico;
	private int id_capacitacion;
	private String capacitacion;
	private String tipo_capacitacion;
	private int id_modalidad;
	private String modalidad;
	private int id_facilitador;
	private String facilitador;
	
	//metodos
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
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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
	public String getCapacitacion() {
		return capacitacion;
	}
	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public int getId_facilitador() {
		return id_facilitador;
	}
	public void setId_facilitador(int id_facilitador) {
		this.id_facilitador = id_facilitador;
	}
	public String getDescripcion_horaria() {
		return descripcion_horaria;
	}
	public void setDescripcion_horaria(String descripcion_horaria) {
		this.descripcion_horaria = descripcion_horaria;
	}
	public String getTipo_capacitacion() {
		return tipo_capacitacion;
	}
	public void setTipo_capacitacion(String tipo_capacitacion) {
		this.tipo_capacitacion = tipo_capacitacion;
	}
	public int getId_modalidad() {
		return id_modalidad;
	}
	public void setId_modalidad(int id_modalidad) {
		this.id_modalidad = id_modalidad;
	}
	public String getFacilitador() {
		return facilitador;
	}
	public void setFacilitador(String facilitador) {
		this.facilitador = facilitador;
	}
	
	
	
	
}
