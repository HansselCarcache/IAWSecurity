package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Vw_rolopcion;


public class Dt_rolopciones {
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsUsuario(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_rol_opciones;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vw_rolopcion> listarolopcion(){
		ArrayList<Vw_rolopcion> listRolop = new ArrayList<Vw_rolopcion>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM dbfdocente.vw_rol_opciones;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_rolopcion rolop = new Vw_rolopcion();
				rolop.setId_rol_opciones(rs.getInt("id_rol_opciones"));
				rolop.setId_rol(rs.getInt("id_rol"));
				rolop.setRol(rs.getString("rol_descripcion"));
				rolop.setId_opcion(rs.getInt("id_opcion"));
				rolop.setOpcion(rs.getString("opcion_descripcion"));
				
				listRolop.add(rolop);
				
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
		return listRolop;
	}
}
