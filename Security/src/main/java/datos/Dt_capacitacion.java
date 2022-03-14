package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_capacitacion;
import entidades.Tbl_modalidad;
import entidades.Tbl_user;
import entidades.Vw_capacitacion;

public class Dt_capacitacion {
	
	//Atributos
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsCapacitacion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsCapacitacion(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM dbfdocente.capacitacion", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCapacitacion = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR MODALIDAD "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Tbl_capacitacion> listacapacitacionesActivas(){
		ArrayList<Tbl_capacitacion> listCapacitacion = new ArrayList<Tbl_capacitacion>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM dbfdocente.capacitacion WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tbl_capacitacion capacitacion = new Tbl_capacitacion();
				capacitacion.setId_capacitacion(rs.getInt("id_capacitacion"));
				capacitacion.setNombre(rs.getString("nombre"));
				capacitacion.setEstado(rs.getInt("estado"));
				capacitacion.setId_modalidad(rs.getInt("id_modalidad"));
				listCapacitacion.add(capacitacion);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CAPACITACIÓN"+ e.getMessage());
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
		return listCapacitacion;
	}
	
	
	public ArrayList<Vw_capacitacion> listarcapacitacionesActivas(){
		ArrayList<Vw_capacitacion> listCapacitacion = new ArrayList<Vw_capacitacion>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT dbfdocente.capacitacion.id_capacitacion, dbfdocente.capacitacion.nombre, dbfdocente.capacitacion.estado, dbfdocente.modalidad.nombre as modalidad FROM dbfdocente.capacitacion inner join dbfdocente.modalidad on dbfdocente.capacitacion.id_modalidad=dbfdocente.modalidad.id_modalidad WHERE dbfdocente.capacitacion.estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_capacitacion capacitacion = new Vw_capacitacion();
				capacitacion.setId_capacitacion(rs.getInt("id_capacitacion"));
				capacitacion.setNombre(rs.getString("nombre"));
				capacitacion.setEstado(rs.getInt("estado"));
				capacitacion.setModalidad(rs.getString("modalidad"));
				listCapacitacion.add(capacitacion);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CAPACITACIÓN"+ e.getMessage());
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
		return listCapacitacion;
	}
	
}
