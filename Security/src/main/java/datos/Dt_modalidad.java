package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_facilitadores;
import entidades.Tbl_facultad;
import entidades.Tbl_modalidad;

public class Dt_modalidad {

	//Atributos
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsModalidad = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsModalidad(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.modalidad;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsModalidad = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR MODALIDADES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Tbl_modalidad> listaModalidadesActivas(){
		ArrayList<Tbl_modalidad> listMod = new ArrayList<Tbl_modalidad>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.modalidad WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tbl_modalidad tmod = new Tbl_modalidad(); //instanciamos a rol
				tmod.setId_modalidad(rs.getInt("id_modalidad"));
				tmod.setNombre_modalidad(rs.getString("nombre_modalidad"));
				tmod.setEstado(rs.getInt("estado"));
				listMod.add(tmod);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR MODALIDAD "+ e.getMessage());
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listMod;
		
	} 
	public boolean addModalidad (Tbl_modalidad mod){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsModalidad(c);
			this.rsModalidad.moveToInsertRow();
			rsModalidad.updateString("nombre_modalidad", mod.getNombre_modalidad());
			rsModalidad.updateInt("estado", 1);
			rsModalidad.insertRow();
			rsModalidad.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR modalidad: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsModalidad != null){
					rsModalidad.close();
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
	
	public Tbl_modalidad getModalidadbyID(int idC) {
		Tbl_modalidad tmod = new Tbl_modalidad();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.modalidad where id_modalidad = "+ idC, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if(rs.next()) {
				
				tmod.setId_modalidad(rs.getInt("id_modalidad"));
				tmod.setNombre_modalidad(rs.getString("nombre_modalidad"));
				tmod.setEstado(rs.getInt("estado"));
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
		
		return tmod;
	}
	public boolean updateModalidad(Tbl_modalidad tmod)
	{
		boolean modificado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsModalidad(c);
			rsModalidad.beforeFirst();
			while (rsModalidad.next())
			{
				if(rsModalidad.getInt(1)==tmod.getId_modalidad())
					
				{
					rsModalidad.updateInt("estado", 2);
					rsModalidad.updateString("nombre_modalidad", tmod.getNombre_modalidad());
					rsModalidad.updateRow();
					rsModalidad.moveToCurrentRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL updateTipoCapacitacion() "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsModalidad != null){
					rsModalidad.close();
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
	public boolean DeleteModalidad(Tbl_modalidad tmod)
	{
		boolean eliminado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsModalidad(c);
			rsModalidad.beforeFirst();
			while (rsModalidad.next())
			{
				if(rsModalidad.getInt(1)==tmod.getId_modalidad())
				{
					rsModalidad.updateInt("estado", 3);
					
					rsModalidad.updateRow();
					rsModalidad.moveToCurrentRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL updateTipoCapacitacion() "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsModalidad != null){
					rsModalidad.close();
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