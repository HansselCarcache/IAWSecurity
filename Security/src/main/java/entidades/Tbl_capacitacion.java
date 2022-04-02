package entidades;

public class Tbl_capacitacion {
	
	//atributos
	
	private int id_capacitacion;
	private String nombre;
	private int estado;
	private int id_tipo_capacitacion;
	private int evaluada;
	//private int tipo_evaluacion;
	
	public int getId_tipo_capacitacion() {
		return id_tipo_capacitacion;
	}
	public void setId_tipo_capacitacion(int id_tipo_capacitacion) {
		this.id_tipo_capacitacion = id_tipo_capacitacion;
	}
	public int getEvaluada() {
		return evaluada;
	}
	public void setEvaluada(int evaluada) {
		this.evaluada = evaluada;
	}
	//public int getTipo_evaluacion() {
	///	return tipo_evaluacion;
	//}
	//public void setTipo_evaluacion(int tipo_evaluacion) {
	//	this.tipo_evaluacion = tipo_evaluacion;
	//}
	public int getId_capacitacion() {
		return id_capacitacion;
	}
	public void setId_capacitacion(int id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
	

}
