package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_tipo_capacitacion;

public class Dt_tipo_capacitacion {
	
	
	//Atributos
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsTipoCapacitacion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llenar_rsTipoCapacitacion(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.tipo_capacitacion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsTipoCapacitacion = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR TIPO DE CAPACITACIÓN "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//Metodo para visualizar tipo capacitacion registrados y activos
	public ArrayList<Tbl_tipo_capacitacion> listaTipCapActivos(){
		ArrayList<Tbl_tipo_capacitacion> listTipCap = new ArrayList<Tbl_tipo_capacitacion>();
		try {
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.tipo_capacitacion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tbl_tipo_capacitacion tipcap = new Tbl_tipo_capacitacion(); //instanciamos a tipo capacitación
				tipcap.setId_tipo_capacitacion(rs.getInt("id_tipo_capacitacion"));
				tipcap.setTipo_capacitacion(rs.getString("tipo_capacitacion"));
				tipcap.setCertificada(rs.getInt("certificada"));
				tipcap.setDescripcion(rs.getString("descripcion"));
				tipcap.setEstado(rs.getInt("estado"));
				listTipCap.add(tipcap);
				
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR TIPO CAPACITACION: "+ e.getMessage());
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
		return listTipCap;
	}
	
	
	public boolean addTipoCapacitacion(Tbl_tipo_capacitacion tipcap){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llenar_rsTipoCapacitacion(c);
			this.rsTipoCapacitacion.moveToInsertRow();
			rsTipoCapacitacion.updateString("tipo_capacitacion", tipcap.getTipo_capacitacion());
			rsTipoCapacitacion.updateInt("certificada", tipcap.getCertificada());
			rsTipoCapacitacion.updateString("descripcion", tipcap.getDescripcion());
			rsTipoCapacitacion.updateInt("estado", 1);
			rsTipoCapacitacion.insertRow();
			rsTipoCapacitacion.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR TIPO DE CAPACITACION: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsTipoCapacitacion != null){
					rsTipoCapacitacion.close();
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
	
	
	public Tbl_tipo_capacitacion getTipoCapacitacionbyID(int id) {
		Tbl_tipo_capacitacion tipcap = new Tbl_tipo_capacitacion();
		try {
			c = poolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM gestion_docente.tipo_capacitacion where id_tipo_capacitacion = " +id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//ps.setInt(1, idTC);
			rs = ps.executeQuery();
			if(rs.next()) {
				tipcap.setId_tipo_capacitacion(rs.getInt("id_tipo_capacitacion"));
				tipcap.setTipo_capacitacion(rs.getString("tipo_capacitacion"));
				tipcap.setCertificada(rs.getInt("certificada"));
				tipcap.setDescripcion(rs.getString("descripcion"));
				tipcap.setEstado(rs.getInt("estado"));
			}
		}catch (Exception e)
		{
			System.out.println("DATOS ERROR getTipoCapacitacionbyID(): "+ e.getMessage());
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
		
		return tipcap;
	}
	
	
	// Metodo para modificar tipo capacitacion
		public boolean updateTipoCapacitacion(Tbl_tipo_capacitacion tc)
		{
			boolean modificado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenar_rsTipoCapacitacion(c);
				rsTipoCapacitacion.beforeFirst();
				while (rsTipoCapacitacion.next())
				{
					if(rsTipoCapacitacion.getInt(1)==tc.getId_tipo_capacitacion())
					{
						rsTipoCapacitacion.updateString("tipo_capacitacion", tc.getTipo_capacitacion());
						rsTipoCapacitacion.updateInt("certificada", tc.getCertificada());
						rsTipoCapacitacion.updateString("descripcion", tc.getDescripcion());
						rsTipoCapacitacion.updateInt("estado", 2);
						rsTipoCapacitacion.updateRow();
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
					if(rsTipoCapacitacion != null){
						rsTipoCapacitacion.close();
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
		
		
		// Metodo para eliminar tipo capacitacion
		public boolean deleteTipoCapacitacion(Tbl_tipo_capacitacion tc)
		{
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenar_rsTipoCapacitacion(c);
				rsTipoCapacitacion.beforeFirst();
				while (rsTipoCapacitacion.next()){
					if(rsTipoCapacitacion.getInt(1)==tc.getId_tipo_capacitacion()){
						rsTipoCapacitacion.updateString("tipo_capacitacion", tc.getTipo_capacitacion());
						rsTipoCapacitacion.updateInt("certificada", tc.getCertificada());
						rsTipoCapacitacion.updateString("descripcion", tc.getDescripcion());
						rsTipoCapacitacion.updateInt("estado", 3);
						rsTipoCapacitacion.updateRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e){
				System.err.println("ERROR AL deleteTipoCapacitacion() "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsTipoCapacitacion != null){
						rsTipoCapacitacion.close();
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
