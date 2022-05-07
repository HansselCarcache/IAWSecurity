package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_rol;
import entidades.Tbl_rolopcion;
import entidades.Tbl_userRol;
import entidades.Vw_rolopcion;


public class Dt_rolopciones {
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private ResultSet ro = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsUsuario(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_rol_opciones;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void llenaRO(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM gestion_docente.opcionrol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ro = ps.executeQuery();
			
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
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_rol_opciones;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_rolopcion rolop = new Vw_rolopcion();
				rolop.setId_rol_opciones(rs.getInt("id_opcion_rol"));
				rolop.setId_rol(rs.getInt("id_rol"));
				rolop.setRol(rs.getString("nombre_rol"));
				rolop.setId_opcion(rs.getInt("id_opcion"));
				rolop.setnombre_opcion(rs.getString("nombre_opcion"));
				
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
	
	
	//Metodo para almacenar Roles de usuario
	public boolean guardarRoluser(Tbl_rolopcion tusr) {
		boolean guardado = false;
		try {
			c = poolConexion.getConnection();
			this.llenaRO(c);
			ro.moveToInsertRow();
			ro.updateInt("id_rol", tusr.getId_rol());
			ro.updateInt("id_opcion", tusr.getId_opcion());
			ro.insertRow();
			ro.moveToCurrentRow();
			guardado = true;
		}catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Tbl_userRol"+e.getMessage());
			e.printStackTrace();
		}
		
		finally {
			try {
				if(ro != null){
					ro.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	public Vw_rolopcion getRolID(int idRol) {
		Vw_rolopcion tr = new Vw_rolopcion();
		try {
			c= poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_rol_opciones WHERE id_opcion_rol=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idRol);
			rs= ps.executeQuery();
			if(rs.next()) {
				tr.setId_rol_opciones(rs.getInt("id_opcion_rol"));
				tr.setId_rol(rs.getInt("id_rol"));
				tr.setId_opcion(rs.getInt("id_opcion"));
				tr.setRol(rs.getString("nombre_rol"));
				tr.setnombre_opcion(rs.getString("nombre_opcion"));
				
			}
		}catch(Exception e)
		{
			System.out.println("DATOS ERROR getRoluserbyID(): "+ e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(tr.getId_rol_opciones());
		return tr;
	}
	

	//Metodo para modificar Rol de usuario
		public boolean modificarRolOp(Tbl_rolopcion tusr) {
			boolean modificado=false;
			try {
				c = poolConexion.getConnection();
				this.llenaRO(c);
				ro.beforeFirst();
				while(ro.next())
				{
					if(ro.getInt(1)==tusr.getId_rol_opciones())
					{
						ro.updateInt("id_rol", tusr.getId_rol());
						ro.updateInt("id_opcion", tusr.getId_opcion());
						ro.updateRow();
						modificado=true;
						break;
					}
				}
			}
			catch(Exception e)
			{
				System.err.println("ERROR AL modificarRolUser() "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(ro != null){
						ro.close();
					}
					if(c != null){
						poolConexion.closeConnection(c);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return modificado;
		}
		
		//Metodo para eliminar usuario
		public boolean eliminarRolO(Tbl_rolopcion tusr) {
			boolean eliminado=false;
			try
			{
				c = poolConexion.getConnection();
				this.llenaRO(c);
				ro.beforeFirst();
				while(ro.next()) {
					if(ro.getInt(1)==tusr.getId_rol_opciones()) {
						ro.deleteRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e){
				System.err.println("ERROR AL eliminarRolUser() "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(ro != null){
						ro.close();
					}
					if(c != null){
						poolConexion.closeConnection(c);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return eliminado;
		}
}


	
