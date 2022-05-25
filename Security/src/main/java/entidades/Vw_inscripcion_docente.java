package entidades;

import java.util.Date;

public class Vw_inscripcion_docente {

	//Attributes
	
		private int id_inscripcion;
		private String nombre_completo;
		private String telefono;
		private String correo;
		private int id_usuario;
		private int id_oferta_detalle;
		private String capacitacion;
		private Date fecha_inicial;
		private Date fecha_final;
		private String descripcion_horaria;
		public String getCapacitacion() {
			return capacitacion;
		}
		public void setCapacitacion(String capacitacion) {
			this.capacitacion = capacitacion;
		}
		public Date getFecha_inicial() {
			return fecha_inicial;
		}
		public void setFecha_inicial(Date fecha_inicial) {
			this.fecha_inicial = fecha_inicial;
		}
		public Date getFecha_final() {
			return fecha_final;
		}
		public void setFecha_final(Date fecha_final) {
			this.fecha_final = fecha_final;
		}
		public String getDescripcion_horaria() {
			return descripcion_horaria;
		}
		public void setDescripcion_horaria(String descripcion_horaria) {
			this.descripcion_horaria = descripcion_horaria;
		}
		public String getDias() {
			return dias;
		}
		public void setDias(String dias) {
			this.dias = dias;
		}
		private String dias;
		private String valor;
		private String desc_valor;
		private int estado;
		private String otras_dependencias;
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
		public String getOtras_dependencias() {
			return otras_dependencias;
		}
		public void setOtras_dependencias(String otras_dependencias) {
			this.otras_dependencias = otras_dependencias;
		}
		
		
		
	//Methods
		
		
		
	
}
