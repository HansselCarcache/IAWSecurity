package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_facilitadores;
import entidades.Tbl_tipo_capacitacion;
import entidades.Vw_capacitacion;

public class Dt_facilitadores {
	
	//Atributos
		poolConexion pc = poolConexion.getInstance(); 
		Connection c = null;
		private ResultSet rsFacilitador = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		
		//Metodo para llenar el RusultSet //para insert, update and delete
		public void llena_rsFac(Connection c){
			try{
				ps = c.prepareStatement("SELECT * FROM gestion_docente.facilitador;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsFacilitador = ps.executeQuery();
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
				e.printStackTrace();
			}
		}
	
		
		//Metodo para visualizar usuarios registrados y activos
		public ArrayList<Tbl_facilitadores> listaFaciActivos(){
			ArrayList<Tbl_facilitadores> listFaci = new ArrayList<Tbl_facilitadores>();
			try{
				c = poolConexion.getConnection(); //obtenemos una PoolConexion del pool
				ps = c.prepareStatement("SELECT * FROM gestion_docente.facilitador where estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()){
					Tbl_facilitadores Faci = new Tbl_facilitadores (); //instanciamos a Tbl_facilitadores
					Faci.setId_facilitador(rs.getInt("id_facilitador"));
					Faci.setEmail(rs.getString("email"));
					Faci.setGrado_academico(rs.getString("grado_academico"));
					Faci.setId_uca(rs.getString("id_uca"));
					Faci.setNombres(rs.getString("nombre_completo"));
					Faci.setTelefono(rs.getString("telefono_contacto"));
					Faci.setCedula(rs.getString("cedula"));

					listFaci.add(Faci);
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR Facilitadores: "+ e.getMessage());
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
			return listFaci;
		}
		
		public boolean addFacilitador(Tbl_facilitadores Faci){
			boolean guardado = false;
			
			try{
				c = poolConexion.getConnection();
				this.llena_rsFac(c);
				this.rsFacilitador.moveToInsertRow();
				rsFacilitador.updateString("email", Faci.getEmail());
				rsFacilitador.updateString("grado_academico", Faci.getGrado_academico());
				rsFacilitador.updateString("id_uca", Faci.getId_uca());
				rsFacilitador.updateString("nombre_completo", Faci.getNombres());
				rsFacilitador.updateString("telefono_contacto", Faci.getTelefono());
				rsFacilitador.updateString("cedula", Faci.getCedula());
				rsFacilitador.updateInt("estado", 1);
				rsFacilitador.insertRow();
				rsFacilitador.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR Tbl_facilitadores: "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsFacilitador != null){
						rsFacilitador.close();
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
		public Tbl_facilitadores getFacilitadoresbyID(int idC) {
			Tbl_facilitadores Faci = new Tbl_facilitadores();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.facilitador where id_facilitador = "+ idC, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				if(rs.next()) {
					Faci.setId_facilitador(rs.getInt("id_facilitador"));
					Faci.setEmail(rs.getString("email"));
					Faci.setGrado_academico(rs.getString("grado_academico"));
					Faci.setId_uca(rs.getString("id_uca"));
					Faci.setNombres(rs.getString("nombre_completo"));
					Faci.setTelefono(rs.getString("telefono_contacto"));
					Faci.setCedula(rs.getString("cedula"));
					
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
			
			return Faci;
		}
		public boolean updateFacilitador(Tbl_facilitadores Faci)
		{
			boolean modificado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llena_rsFac(c);
				rsFacilitador.beforeFirst();
				while (rsFacilitador.next())
				{
					if(rsFacilitador.getInt(1)==Faci.getId_facilitador())
						
					{
						rsFacilitador.updateInt("estado", 2);
						rsFacilitador.updateString("email", Faci.getEmail());
						rsFacilitador.updateString("grado_academico", Faci.getGrado_academico());
						rsFacilitador.updateString("id_uca", Faci.getId_uca());
						rsFacilitador.updateString("nombre_completo", Faci.getNombres());
						rsFacilitador.updateString("telefono_contacto", Faci.getTelefono());
						rsFacilitador.updateString("cedula", Faci.getCedula());
						rsFacilitador.updateRow();
						rsFacilitador.moveToCurrentRow();
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
					if(rsFacilitador != null){
						rsFacilitador.close();
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
		public boolean DeleteFacilitador(Tbl_facilitadores Faci)
		{
			boolean eliminado=false;	
			try
			{
				c = poolConexion.getConnection();
				this.llena_rsFac(c);
				rsFacilitador.beforeFirst();
				while (rsFacilitador.next())
				{
					if(rsFacilitador.getInt(1)==Faci.getId_facilitador())
					{
						rsFacilitador.updateInt("estado", 3);
						
						rsFacilitador.updateRow();
						rsFacilitador.moveToCurrentRow();
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
					if(rsFacilitador != null){
						rsFacilitador.close();
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

