package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_facultad;
import entidades.Tbl_opcion;
import entidades.Tbl_user;

public class Dt_Opciones {
	
	
	//Atributos
		poolConexion pc = poolConexion.getInstance(); 
		Connection c = null;
		private ResultSet rsOpc = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		//Metodo para llenar el RusultSet //para insert, update and delete
		public void llena_rsOpc(Connection c){
			try{
				ps = c.prepareStatement("SELECT * FROM gestion_docente.opciones;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsOpc = ps.executeQuery();
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR OPCIONES "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		//Metodo para visualizar opciones registrados y activas
		public ArrayList<Tbl_opcion> listaOpcionesActivos(){
			ArrayList<Tbl_opcion> listOpc = new ArrayList<Tbl_opcion>();
			try{
				c = poolConexion.getConnection(); //obtenemos una conexion del pool
				ps = c.prepareStatement("SELECT * FROM gestion_docente.opciones WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()){
					Tbl_opcion topc = new Tbl_opcion(); //instanciamos a opcion
					topc.setId_opcion(rs.getInt("id_opcion"));
					topc.setNombre_opcion(rs.getString("nombre_opcion"));
					topc.setDescripcion(rs.getString("descripcion"));
					topc.setEstado(rs.getInt("estado"));
					listOpc.add(topc);
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR OPCIONES "+ e.getMessage());
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
			return listOpc;
		}

		
		//Metodo para almacenar nueva opcion
		public boolean guardarOpcion(Tbl_opcion top) {
			boolean guardado = false;
			//int guardado = 0;
			try {
				c = poolConexion.getConnection();
				this.llena_rsOpc(c);
				rsOpc.moveToInsertRow();
				rsOpc.updateString("nombre_opcion", top.getNombre_opcion());
				rsOpc.updateString("descripcion", top.getDescripcion());
				rsOpc.updateInt("estado", 1);
				rsOpc.insertRow();
				rsOpc.moveToCurrentRow();
				this.llena_rsOpc(c);
				rsOpc.last();
				//guardado = rsOpc.getInt("id_opcion");
				guardado = true;
				
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR Tbl_Opciones "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsOpc != null){
						rsOpc.close();
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
		
		// Metodo para visualizar opcion
		public Tbl_opcion getOpcionbyID(int idOpcion) {
			Tbl_opcion to = new Tbl_opcion();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM gestion_docente.opciones where id_opcion=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1,  idOpcion);
				rs = ps.executeQuery();
				if(rs.next()) {
					to.setId_opcion(rs.getInt("id_opcion"));
					to.setNombre_opcion(rs.getString("nombre_opcion"));
					to.setDescripcion(rs.getString("descripcion"));
					to.setEstado(rs.getInt("estado"));
					
				}
			}catch (Exception e)
			{
				System.out.println("DATOS ERROR getOpcionbyID(): "+ e.getMessage());
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
			return to;
		}
				
				
				// Metodo para modificar facultad
				public boolean modificarOpcion(Tbl_opcion topc)
				{
					boolean modificado=false;	
					try
					{
						c = poolConexion.getConnection();
						this.llena_rsOpc(c);
						rsOpc.beforeFirst();
						while (rsOpc.next())
						{
							if(rsOpc.getInt(1)==topc.getId_opcion())
							{
								rsOpc.updateString("nombre_opcion", topc.getNombre_opcion());
								rsOpc.updateString("descripcion", topc.getDescripcion());
								rsOpc.updateInt("estado", 2);
								rsOpc.updateRow();
								modificado=true;
								break;
							}
						}
					}
					catch (Exception e)
					{
						System.err.println("ERROR al modificar opcion"+e.getMessage());
						e.printStackTrace();
					}
					finally
					{
						try {
							if(rsOpc != null){
								rsOpc.close();
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
				
			
				// Metodo para eliminar opcion
				public boolean eliminarOpcion (Tbl_opcion topc)
				{
					boolean eliminado=false;	
					try
					{
						c = poolConexion.getConnection();
						this.llena_rsOpc(c);
						rsOpc.beforeFirst();
						while (rsOpc.next()){
							if(rsOpc.getInt(1)==topc.getId_opcion())
							{
								rsOpc.updateInt("estado", 3);
								rsOpc.updateRow();
								eliminado=true;
								break;
							}
						}
					}
					catch (Exception e){
						System.err.println("ERROR al eliminar opcion) "+e.getMessage());
						e.printStackTrace();
					}
					finally{
						try {
							if(rsOpc != null){
								rsOpc.close();
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


