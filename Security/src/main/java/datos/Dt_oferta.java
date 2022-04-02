package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import entidades.Tbl_oferta;
import entidades.Vw_oferta;

public class Dt_oferta {

	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOferta = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsOferta(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestion_docente.oferta;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOferta = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Vw_oferta> listaOfActivos(){
		ArrayList<Vw_oferta> listFac = new ArrayList<Vw_oferta>();
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestion_docente.vw_oferta WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_oferta of = new Vw_oferta(); //instanciamos a rol
				of.setId_oferta(rs.getInt("id_oferta"));
				of.setNombre(rs.getString("nombre"));
				of.setDescripcion(rs.getString("descripcion"));
				of.setYear(rs.getString("year"));
				of.setFecha_inicio(rs.getDate("fecha_inicial"));
				of.setFecha_final(rs.getDate("fecha_final"));
				of.setCantidad(rs.getInt("cantidad"));
				of.setEstado(rs.getInt("estado"));
				listFac.add(of);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Facultades: "+ e.getMessage());
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
		return listFac;
	}

	public Tbl_oferta getoferta(int id){
		Tbl_oferta of = new Tbl_oferta(); //instanciamos a rol
		try{
			c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT *  from gestion_docente.oferta where id_oferta = "+id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			
			of.setId_oferta(rs.getInt("id_oferta"));
			of.setNombre(rs.getString("nombre"));
			of.setDescripcion(rs.getString("descripcion"));
			of.setYear(rs.getString("year"));
			of.setFecha_inicial(rs.getDate("fecha_inicial"));
			of.setFecha_final(rs.getDate("fecha_final"));
			of.setEstado(rs.getInt("estado"));
			
			
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR OFERTA: "+ e.getMessage());
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
		return of;
	}
	
	public boolean setEstado(int id,int user){
		boolean modificado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsOferta(c);
			rsOferta.beforeFirst();
			Date fechaSistema = new Date();
			Timestamp fecha = new java.sql.Timestamp(fechaSistema.getTime());
			
			
			while (rsOferta.next())
			{
				if(rsOferta.getInt(1)==id)
				{
					rsOferta.updateInt("estado", 2);
					rsOferta.updateTimestamp("fecha_modificacion", fecha);
					rsOferta.updateInt("usuario_modificacion", user);
					rsOferta.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL ACTUALIZAR USUARIO "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsOferta != null){
					rsOferta.close();
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

	
	public int addOferta(Tbl_oferta fc){
		int guardado = 0;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsOferta(c);
			this.rsOferta.moveToInsertRow();
			rsOferta.updateString("nombre", fc.getNombre());
			rsOferta.updateInt("estado", 1);
			rsOferta.updateDate("fecha_inicial", fc.getFecha_inicial());
			rsOferta.updateDate("fecha_final", fc.getFecha_final());
			rsOferta.updateString("year", fc.getYear());
			rsOferta.updateString("descripcion", fc.getDescripcion());
			rsOferta.updateTimestamp("fecha_ingreso", fc.getFecha_creacion());
			rsOferta.updateInt("usuario_ingreso", fc.getUsuario_creacion());
			rsOferta.insertRow();
			rsOferta.moveToCurrentRow();
			this.llena_rsOferta(c);
			rsOferta.last();
			guardado = rsOferta.getInt("id_oferta");
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR OFERTA: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsOferta != null){
					rsOferta.close();
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

	public boolean editOferta(Tbl_oferta to) {
		boolean modificado=false;	
		try
		{
			c = poolConexion.getConnection();
			this.llena_rsOferta(c);
			rsOferta.beforeFirst();
			
			while (rsOferta.next())
			{
				if(rsOferta.getInt(1)==to.getId_oferta())
				{
					
					rsOferta.updateString("nombre", to.getNombre());
					rsOferta.updateString("descripcion", to.getDescripcion());
					rsOferta.updateDate("fecha_inicial", to.getFecha_inicial());
					rsOferta.updateDate("fecha_final", to.getFecha_final());
					rsOferta.updateString("year", to.getYear());
					rsOferta.updateTimestamp("fecha_modificacion", to.getFecha_modificacion());
					rsOferta.updateInt("usuario_modificacion", to.getUsuario_modificacion());
					rsOferta.updateInt("estado", 2);
					
					rsOferta.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL ACTUALIZAR USUARIO "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsOferta != null){
					rsOferta.close();
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
}
