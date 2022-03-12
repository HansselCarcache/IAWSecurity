package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_opcion;

public class Dt_Opciones {
	
	
	//Atributos
		poolConexion pc = poolConexion.getInstance(); 
		Connection c = null;
		private ResultSet rsRol = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		//Metodo para llenar el RusultSet //para insert, update and delete
		public void llena_rsRol(Connection c){
			try{
				ps = c.prepareStatement("SELECT * FROM dbfdocente.opciones;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsRol = ps.executeQuery();
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		//Metodo para visualizar usuarios registrados y activos
		public ArrayList<Tbl_opcion> listaOpcionesActivos(){
			ArrayList<Tbl_opcion> listOpc = new ArrayList<Tbl_opcion>();
			try{
				c = poolConexion.getConnection(); //obtenemos una conexion del pool
				ps = c.prepareStatement("SELECT * FROM dbfdocente.opciones WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()){
					Tbl_opcion topc = new Tbl_opcion(); //instanciamos a rol
					topc.setId_opcion(rs.getInt("id_opcion"));
					topc.setOpcion(rs.getString("descripcion"));
					topc.setEstado(rs.getInt("estado"));
					listOpc.add(topc);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return listOpc;
		}

	}


