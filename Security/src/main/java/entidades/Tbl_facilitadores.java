package entidades;

public class Tbl_facilitadores {

	//Attributes
	
		private int id_facilitador;
		private String id_uca;
		private String nombres;
		private String apellidos;
		private String telefono;
		private String email;
		private String grado_academico;
		
		
		//Methods
		
		public int getId_facilitador() {
			return id_facilitador;
		}
		public void setId_facilitador(int id_facilitador) {
			this.id_facilitador = id_facilitador;
		}
		public String getId_uca() {
			return id_uca;
		}
		public void setId_uca(String id_uca) {
			this.id_uca = id_uca;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGrado_academico() {
			return grado_academico;
		}
		public void setGrado_academico(String grado_academico) {
			this.grado_academico = grado_academico;
		}
		
		
}
