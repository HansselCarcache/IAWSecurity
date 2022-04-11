package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_escalaCalificacion;
import entidades.Tbl_oferta;
import entidades.Tbl_user;

public class Dt_escalacalificacion {
	
	//Atributos
		poolConexion pc = poolConexion.getInstance();
		Connection c = null;
		private ResultSet rsEscala = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		//Metodo para llenar el ResultSet para insert, update y delete
		public void llenaRsEscala(Connection c) {
			try {
				ps = c.prepareStatement("SELECT * FROM gestion_docente.escala_calificacion", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsEscala = ps.executeQuery();
				
			}
			catch(Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ESCALA DE CALIFICACION "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		public ArrayList<Tbl_escalaCalificacion> listaEscalaActivo(){
			ArrayList<Tbl_escalaCalificacion> listEscala = new ArrayList<Tbl_escalaCalificacion>();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.escala_calificacion WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()) {
					Tbl_escalaCalificacion escala = new Tbl_escalaCalificacion();
					escala.setId_escala(rs.getInt("id_escala"));
					escala.setTipo_calificacion(rs.getString("tipo_calificacion"));
					escala.setDescripcion(rs.getString("descripcion"));
					escala.setEstado(rs.getInt("estado"));
					listEscala.add(escala);
					
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ESCALA DE CALIFICACION"+ e.getMessage());
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
			return listEscala;
		}
		
//////////////////////////////////////AGREGAR///////////////////////////////////////////////////////////////////////////		
		
		public int addEscalaCalificacion(Tbl_escalaCalificacion fc){
			int guardado = 0;
			
			try{
				c = poolConexion.getConnection();
				this.llenaRsEscala(c);
				this.rsEscala.moveToInsertRow();
				rsEscala.updateString("tipo_calificacion", fc.getTipo_calificacion());
				rsEscala.updateString("descripcion", fc.getDescripcion());
				rsEscala.updateInt("estado", 1);
				
				
				rsEscala.insertRow();
				rsEscala.moveToCurrentRow();
				this.llenaRsEscala(c);
				rsEscala.last();
				guardado = rsEscala.getInt("id_escala");
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR OFERTA: "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsEscala != null){
						rsEscala.close();
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
		
		public Tbl_escalaCalificacion getEscala(int id){
			Tbl_escalaCalificacion gsc = new Tbl_escalaCalificacion(); //instanciamos a rol
			try{
				c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
				ps = c.prepareStatement("SELECT *  from gestion_docente.escala_calificacion where id_escala = "+id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				rs.next();
				
				
				gsc.setId_escala (id);
				gsc.setTipo_calificacion(rs.getString("tipo_calificacion"));
				gsc.setDescripcion(rs.getString("descripcion"));
				
				gsc.setEstado(rs.getInt("estado"));
				
				
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
			return gsc;
		}
		
	//////////////////////////////EDITAR////////////////////////////////////////////////////////////////////////////	
		public boolean editEscala(Tbl_escalaCalificacion de) {
			boolean modificado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsEscala(c);
				rsEscala.beforeFirst();
				
				while (rsEscala.next())
				{
					if(rsEscala.getInt(1)==de. getId_escala())
					{
						
						rsEscala.updateString("tipo_calificacion", de.getTipo_calificacion());
						rsEscala.updateString("descripcion", de.getDescripcion());
						rsEscala.updateInt("estado", 2);
						
						rsEscala.updateRow();
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
					if(rsEscala != null){
						rsEscala.close();
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
		
		public boolean setEstado(int id){
			boolean modificado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsEscala(c);
				rsEscala.beforeFirst();
				
				
				
				
				while (rsEscala.next())
				{
					if(rsEscala.getInt(1)==id)
					{
						rsEscala.updateInt("estado", 2);
						rsEscala.updateRow();
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
					if(rsEscala != null){
						rsEscala.close();
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
		

		
		public boolean deleteEscala(Tbl_escalaCalificacion to)
		{
			Dt_escalaCalificacionDet dtod = new Dt_escalaCalificacionDet();
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llenaRsEscala(c);
				rsEscala.beforeFirst();
				while (rsEscala.next()){
					if(rsEscala.getInt(1)==to.getId_escala()){
						rsEscala.updateInt("estado", 3);
					
						rsEscala.updateRow();
						eliminado=true;
						break;
					}
				}
				
				dtod.deleteEscalaDetByID(to.getId_escala());
			}
			catch (Exception e){
				System.err.println("ERROR AL delete() "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsEscala != null){
						rsEscala.close();
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


		
	
