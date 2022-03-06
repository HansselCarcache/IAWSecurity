package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Tbl_rol;


public class Dt_rol {
	
	//Atributos
		poolConexion pc = poolConexion.getInstance();
		Connection c = null;
		private ResultSet rsRol = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		//Metodo para llenar el ResultSet para insert, update y delete
		public void llenaRsRol(Connection c) {
			try {
				ps = c.prepareStatement("SELECT * FROM seguridad.tbl_rol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsRol = ps.executeQuery();
				
			}
			catch(Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		public ArrayList<Tbl_rol> listaRolActivos(){
			ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>();
			try {
				c = poolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM seguridad.tbl_rol WHERE estado <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()) {
					Tbl_rol trol = new Tbl_rol();
					trol.setId_rol(rs.getInt("id_rol"));
					trol.setRol(rs.getString("rol"));
					trol.setEstado(rs.getInt("estado"));
					
					listRol.add(trol);
					
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ROLES"+ e.getMessage());
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
			return listRol;
		}
		
		
	

}
