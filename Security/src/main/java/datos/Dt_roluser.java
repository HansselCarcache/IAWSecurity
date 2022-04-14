package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import entidades.Vw_userrol;
import entidades.Tbl_userRol;

public class Dt_roluser {
	
	poolConexion pc = poolConexion.getInstance();
	Connection c = null;
	private ResultSet rsRoluser = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el ResultSet para insert, update y delete
	public void llenaRsRolusuario(Connection c) {
		try {
			ps = c.prepareStatement("SELECT * FROM gestion_docente.usuariorol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsRoluser = ps.executeQuery();
			
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
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_rol_usuarios;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_userrol rolusr = new Vw_userrol();
				rolusr.setId_rol_usuario(rs.getInt("id_UsuarioRol"));
				rolusr.setId_usuario(rs.getInt("id_usuario"));
				rolusr.setUsuario(rs.getString("nombre_real"));
				rolusr.setId_rol(rs.getInt("id_rol"));
				rolusr.setRol(rs.getString("rol_descripcion"));
				rolusr.setEstado(rs.getInt("estado"));
				
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
	
	//Metodo para almacenar Roles de usuario
	public boolean guardarRoluser(Tbl_userRol tusr) {
		boolean guardado = false;
		try {
			c = poolConexion.getConnection();
			this.llenaRsRolusuario(c);
			rsRoluser.moveToInsertRow();
			rsRoluser.updateInt("id_rol", tusr.getId_rol());
			rsRoluser.updateInt("id_usuario", tusr.getId_user());
			rsRoluser.insertRow();
			rsRoluser.moveToCurrentRow();
			guardado = true;
		}catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Tbl_userRol"+e.getMessage());
			e.printStackTrace();
		}
		
		finally {
			try {
				if(rsRoluser != null){
					rsRoluser.close();
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
	
	public Vw_userrol getRoluserbyID(int idRoluser) {
		Vw_userrol tusr = new Vw_userrol();
		try {
			c= poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_rol_usuarios WHERE id_UsuarioRol=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idRoluser);
			rs= ps.executeQuery();
			if(rs.next()) {
				tusr.setId_rol_usuario(rs.getInt("id_UsuarioRol"));
				tusr.setId_usuario(rs.getInt("id_usuario"));
				tusr.setUsuario(rs.getString("nombre_real"));
				tusr.setId_rol(rs.getInt("id_rol"));
				tusr.setRol(rs.getString("rol_descripcion"));
				tusr.setEstado(rs.getInt("estado"));
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
		return tusr;
	}
	
	//Metodo para modificar Rol de usuario
	public boolean modificarRolUser(Tbl_userRol tusr) {
		boolean modificado=false;
		try {
			c = poolConexion.getConnection();
			this.llenaRsRolusuario(c);
			rsRoluser.beforeFirst();
			while(rsRoluser.next())
			{
				if(rsRoluser.getInt(1)==tusr.getId_userRol())
				{
					rsRoluser.updateInt("id_rol", tusr.getId_rol());
					rsRoluser.updateRow();
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
				if(rsRoluser != null){
					rsRoluser.close();
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
	public boolean eliminarRolUser(Tbl_userRol tusr) {
		boolean eliminado=false;
		try
		{
			c = poolConexion.getConnection();
			this.llenaRsRolusuario(c);
			rsRoluser.beforeFirst();
			while(rsRoluser.next()) {
				if(rsRoluser.getInt(1)==tusr.getId_userRol()) {
					rsRoluser.deleteRow();
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
				if(rsRoluser != null){
					rsRoluser.close();
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
