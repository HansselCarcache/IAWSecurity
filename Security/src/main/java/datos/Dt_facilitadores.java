package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_facilitadores;

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
				ps = c.prepareStatement("SELECT * FROM dbfdocente.facilitador;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsFacilitador = ps.executeQuery();
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
				e.printStackTrace();
			}
		}
	
		
		//Metodo para visualizar usuarios registrados y activos
		public ArrayList<Tbl_facilitadores> listarFacActivos(){
			ArrayList<Tbl_facilitadores> listFac = new ArrayList<Tbl_facilitadores>();
			try{
				c = poolConexion.getConnection(); //obtenemos una conexion del pool
				ps = c.prepareStatement("SELECT * FROM dbfdocente.facilitador;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()){
					Tbl_facilitadores trol = new Tbl_facilitadores(); //instanciamos a rol
					trol.setId_facilitador(rs.getInt("id_facilitador"));
					trol.setId_uca(rs.getString("id_uca"));
					trol.setNombres(rs.getString("nombres"));
					trol.setApellidos(rs.getString("apellidos"));
					trol.setTelefono(rs.getString("telefono"));
					trol.setEmail(rs.getString("email"));
					trol.setGrado_academico(rs.getString("grado_academico"));
					listFac.add(trol);
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
			return listFac;
		}
}

