package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_modalidad;
import entidades.Tbl_user;

public class Dt_modalidad {
	
	//Atributos
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsModalidad = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsModalidad(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM dbfdocente.modalidad;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsModalidad = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR MODALIDAD "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Tbl_modalidad> listaModalidadesActivas(){
		ArrayList<Tbl_modalidad> listModalidad = new ArrayList<Tbl_modalidad>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM dbfdocente.modalidad WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tbl_modalidad modalidad = new Tbl_modalidad();
				modalidad.setId_modalidad(rs.getInt("id_modalidad"));
				modalidad.setNombre(rs.getString("nombre"));
				modalidad.setDescripcion(rs.getString("Descripción"));
				modalidad.setCertificada(rs.getInt("Certificada"));
				modalidad.setEstado(rs.getInt("estado"));
				listModalidad.add(modalidad);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR MODALIDAD"+ e.getMessage());
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
		return listModalidad;
	}
	
}
