package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Vw_inscripcion_docente;
import entidades.Vw_userrol;

public class Dt_inscripcionDocente {

	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsInscripcion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsInscripcion(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_inscripcion_docente;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsInscripcion = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCION "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vw_inscripcion_docente> listainscripcion(){
		ArrayList<Vw_inscripcion_docente> listInsc = new ArrayList<Vw_inscripcion_docente>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_inscripcion_docente;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_inscripcion_docente insc = new Vw_inscripcion_docente();
				insc.setId_inscripcion(rs.getInt("id_inscripcion"));
				insc.setNombres(rs.getString("Nombre"));
				insc.setNombre_facultad(rs.getString("nombre_facultad"));
				insc.setNombre_departamento(rs.getString("nombre_departamento"));
				insc.setNombre_carrera(rs.getString("nombre_carrera"));
				insc.setFecha_inscripcion(rs.getString("fecha_inscripcion"));
				insc.setNombre_oferta(rs.getString("Oferta"));
				insc.setId_escala(rs.getInt("id_escala"));
				insc.setId_uca(rs.getInt("id_uca"));
				insc.setCorreo_electronico(rs.getString("correo_electronico"));
				
				
				listInsc.add(insc);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR INSCRIPCION"+ e.getMessage());
			e.printStackTrace();
			
		}
		finally {
			try {
				if(rs!= null) {
					rs.close();
				}
				if(ps!= null) {
					ps.close();
				}
				if(c != null) {
					poolConexion.closeConnection(c);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listInsc;
	}
	
}
