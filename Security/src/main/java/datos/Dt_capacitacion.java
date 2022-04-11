package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entidades.Tbl_capacitacion;
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
			ps = c.prepareStatement("SELECT * FROM gestion_docente.capacitacion", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCapacitacion = ps.executeQuery();
			
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CAPACITACION"+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Tbl_capacitacion> listacapacitacionesActivas(){
		ArrayList<Tbl_capacitacion> listCapacitacion = new ArrayList<Tbl_capacitacion>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.capacitacion WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tbl_capacitacion capacitacion = new Tbl_capacitacion();
				capacitacion.setId_capacitacion(rs.getInt("id_capacitacion"));
				capacitacion.setNombre(rs.getString("nombre"));
				capacitacion.setEstado(rs.getInt("estado"));
				capacitacion.setId_tipo_capacitacion(rs.getInt("id_tipo_capacitacion"));
				capacitacion.setEvaluada(rs.getInt("evaluada"));
				//capacitacion.setTipo_evaluacion(rs.getInt("tipo_evaluacion"));
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
	
	
	public ArrayList<Vw_capacitacion> listarcapacitacionesV(){
		ArrayList<Vw_capacitacion> listCapacitacion = new ArrayList<Vw_capacitacion>();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_capacitacion WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Vw_capacitacion capacitacion = new Vw_capacitacion();
				capacitacion.setId_capacitacion(rs.getInt("id_capacitacion"));
				capacitacion.setNombre(rs.getString("nombre"));
				capacitacion.setEstado(rs.getInt("estado"));
				capacitacion.setEvaluada(rs.getInt("evaluada"));
				//capacitacion.setTipo_evaluacion(rs.getInt("tipo_evaluacion"));
				capacitacion.setId_tipo_capacitacion(rs.getInt("id_tipo_capacitacion"));
				capacitacion.setTipo_capacitacion(rs.getString("tipo_capacitacion"));
				capacitacion.setEstado(rs.getInt("estado"));
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
	
	
	public boolean addCapacitacion(Tbl_capacitacion ca){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llenaRsCapacitacion(c);
			this.rsCapacitacion.moveToInsertRow();
			rsCapacitacion.updateString("nombre", ca.getNombre());
			rsCapacitacion.updateInt("estado", 1);
			rsCapacitacion.updateInt("id_tipo_capacitacion", ca.getId_tipo_capacitacion());
			rsCapacitacion.updateInt("evaluada", ca.getEvaluada());
			//rsCapacitacion.updateInt("tipo_evaluacion", ca.getTipo_evaluacion());
			rsCapacitacion.insertRow();
			rsCapacitacion.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR facultad: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsCapacitacion != null){
					rsCapacitacion.close();
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
	public Vw_capacitacion getCapacitacionbyID(int idC) {
		Vw_capacitacion tc = new Vw_capacitacion();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_capacitacion where id_capacitacion = "+ idC, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if(rs.next()) {
				tc.setId_capacitacion(rs.getInt("id_capacitacion"));
				tc.setNombre(rs.getString("nombre"));
				tc.setEstado(rs.getInt("estado"));
				tc.setEvaluada(rs.getInt("evaluada"));
				//capacitacion.setTipo_evaluacion(rs.getInt("tipo_evaluacion"));
				tc.setId_tipo_capacitacion(rs.getInt("id_tipo_capacitacion"));
				tc.setTipo_capacitacion(rs.getString("tipo_capacitacion"));
				tc.setEstado(rs.getInt("estado"));
			}
		}catch (Exception e)
		{
			System.out.println("DATOS ERROR getCapacitacionbyID(): "+ e.getMessage());
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
		
		return tc;
	}
	
	public boolean modificarCapacitacion(Tbl_capacitacion tus)
	{
		boolean modificado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llenaRsCapacitacion(c);
			rsCapacitacion.beforeFirst();
			while (rsCapacitacion.next())
			{
				if(rsCapacitacion.getInt(1)==tus.getId_capacitacion())
				{
					rsCapacitacion.updateString("nombre", tus.getNombre());
					rsCapacitacion.updateInt("id_tipo_capacitacion", tus.getId_tipo_capacitacion());
					rsCapacitacion.updateInt("evaluada", tus.getEvaluada());
					rsCapacitacion.updateInt("estado", 2);
					rsCapacitacion.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL modificarCapacitacion() "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsCapacitacion != null){
					rsCapacitacion.close();
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
	
	public boolean eliminarCapacitacion(Tbl_capacitacion tus)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llenaRsCapacitacion(c);
			rsCapacitacion.beforeFirst();
			while (rsCapacitacion.next()){
				if(rsCapacitacion.getInt(1)==tus.getId_capacitacion())
				{										
					rsCapacitacion.updateInt("estado", 3);
					rsCapacitacion.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e){
			System.err.println("ERROR AL eliminarCapacitacion() "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsCapacitacion != null){
					rsCapacitacion.close();
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
