package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Tbl_rol;
import entidades.Tbl_userRol;
import entidades.Vw_userrol;

public class Dt_rol {
	
	//Atributos
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsRol(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.rol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsRol = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Tbl_rol> listaRolActivos(){
		ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.rol WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tbl_rol trol = new Tbl_rol(); //instanciamos a rol
				trol.setId_rol(rs.getInt("id_rol"));
				trol.setNombre_rol(rs.getString("nombre_rol"));
				trol.setEstado(rs.getInt("estado"));
				trol.setDescripcion(rs.getString("descripcion"));
				listRol.add(trol);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
		finally{
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
				e.printStackTrace();
			}
			
		}
		return listRol;
	}
	
	//Metodo para almacenar Roles
	public boolean guardarRol(Tbl_rol tusr) {
		boolean guardado = false;
		try {
			c = poolConexion.getConnection();
			this.llena_rsRol(c);
			rsRol.moveToInsertRow();
			rsRol.updateInt("id_rol", tusr.getId_rol());
			rsRol.updateString("nombre_rol", tusr.getNombre_rol());
			rsRol.updateInt("estado", 1);
			rsRol.updateString("descripcion", tusr.getDescripcion());
			rsRol.insertRow();
			rsRol.moveToCurrentRow();
			guardado = true;
		}catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Tbl_rol"+e.getMessage());
			e.printStackTrace();
		}
		
		finally {
			try {
				if(rsRol != null){
					rsRol.close();
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
	
	public Tbl_rol getRolID(int idRol) {
		Tbl_rol tr = new Tbl_rol();
		try {
			c= poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.rol WHERE id_rol=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idRol);
			rs= ps.executeQuery();
			if(rs.next()) {
				tr.setId_rol(rs.getInt("id_rol"));
				tr.setNombre_rol(rs.getString("nombre_rol"));
				tr.setEstado(rs.getInt("estado"));
				tr.setDescripcion(rs.getString("descripcion"));
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
		return tr;
	}
	
	public boolean modificarRol(Tbl_rol tusr) {
		boolean modificado=false;
		try {
			c = poolConexion.getConnection();
			this.llena_rsRol(c);
			rsRol.beforeFirst();
			while(rsRol.next())
			{
				if(rsRol.getInt(1)==tusr.getId_rol())
				{
					rsRol.updateString("nombre_rol", tusr.getNombre_rol());
					rsRol.updateString("descripcion", tusr.getDescripcion());
					rsRol.updateInt("estado", 2);
					rsRol.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("ERROR AL modificarRol() "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsRol != null){
					rsRol.close();
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
	public boolean eliminarRol(Tbl_rol tusr) {
		boolean eliminado=false;
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsRol(c);
			rsRol.beforeFirst();
			while(rsRol.next()) {
				if(rsRol.getInt(1)==tusr.getId_rol()) {
					rsRol.deleteRow();
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
				if(rsRol != null){
					rsRol.close();
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
