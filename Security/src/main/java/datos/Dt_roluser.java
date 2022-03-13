package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Vw_userrol;

public class Dt_roluser {
	
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsUsuario(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_rol_usuarios;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vw_userrol> listarolusuario(){
		ArrayList<Vw_userrol> listRolusr = new ArrayList<Vw_userrol>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_rol_usuarios;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_userrol rolusr = new Vw_userrol();
				rolusr.setId_rol_usuario(rs.getInt("id_rol_usuario"));
				rolusr.setId_usuario(rs.getInt("id_usuario"));
				rolusr.setUsuario(rs.getString("nombreC"));
				rolusr.setId_rol(rs.getInt("id_rol"));
				rolusr.setRol(rs.getString("rol_descripcion"));
				
				
				listRolusr.add(rolusr);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS"+ e.getMessage());
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
		return listRolusr;
	}
}
